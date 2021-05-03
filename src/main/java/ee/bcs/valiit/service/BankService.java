package ee.bcs.valiit.service;

import ee.bcs.valiit.Controller.AccountInfo;
import ee.bcs.valiit.Controller.LoginRequest;
import ee.bcs.valiit.hibernate.AccountHibernateRepository;
import ee.bcs.valiit.hibernate.HibernateAccount;
import ee.bcs.valiit.repository.AccountRepository;
import ee.bcs.valiit.solution.exception.SampleApplicationException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class BankService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountHibernateRepository accountHibernateRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    public void createAccount4(String accountNo, String accountName, Double balance) {
        if (balance < 0) {
            throw new SampleApplicationException("Balance cannot be negative. Please correct.");
        }
        accountRepository.createAccount4(accountNo, accountName, balance);
    }

    public void lock4(String accountNo) {
        accountRepository.lock4(accountNo);
    }

    public void unlock4(String accountNo) {
        accountRepository.unlock4(accountNo);
    }

    public String getBalance4(String accountNo) {
        HibernateAccount account = accountHibernateRepository.getOne(accountNo);    //Hibernate! Seotud hibernate>HibernateAccount Classiga
        return "Your account balance is: " + account.getAccountBalance();
//        Boolean isLocked = accountRepository.isLocked(accountNo);
//        if (isLocked) {
//            throw new SampleApplicationException("Account (" + accountNo + ") is blocked. Please contact bank service centre.");
//        }                                                           //võtsin siit realt ära else{ ja peale returni }
//        return "Your account (" + accountNo + ") balance is " + accountRepository.getBalance4(accountNo) + " euro.";
    }

    public String depositMoney4(String accountNo, Double deposit) {
        Boolean isLocked = accountRepository.isLocked(accountNo);
        if (isLocked) {
            throw new SampleApplicationException("Account (" + accountNo + ") is blocked. Please contact bank service centre.");
        } else if (deposit > 0) {
            Double currentBalance = accountRepository.getBalance4(accountNo);
            Double newBalance = currentBalance + deposit;
            accountRepository.updateBalance4(accountNo, newBalance);
            accountRepository.transactionsHistoryDeposit(accountNo, LocalDateTime.now(), newBalance, deposit);
            return "Your account (" + accountNo + ") new balance is " + newBalance + " euro.";
        } else {
            return "Invalid input.";
        }
    }

    public String withdrawMoney4(String accountNo, Double withdraw) {
        Boolean isLocked = accountRepository.isLocked(accountNo);
        Double currentBalance = accountRepository.getBalance4(accountNo);
        if (isLocked) {
            throw new SampleApplicationException("Account (" + accountNo + ") is blocked. Please contact bank service centre.");
        } else if (withdraw > currentBalance) {
            throw new SampleApplicationException("You don´t have sufficient funds to withdraw.");
        } else if (withdraw < currentBalance) {
            Double newBalance = currentBalance - withdraw;
            accountRepository.updateBalance4(accountNo, newBalance);
            accountRepository.transactionsHistoryWithdraw(accountNo, LocalDateTime.now(), newBalance, withdraw);
            return "You have withdrawn " + withdraw + " euro. Your account " + accountNo + " remaining amount is: " + newBalance;
        } else {
            return "Invalid input.";
        }
    }

    public String transferMoney4(String fromAccountNo, String toAccountNo, Double transfer) {
        Boolean isLockedFromAccount = accountRepository.isLocked(fromAccountNo);
        Boolean isLockedToAccount = accountRepository.isLocked(toAccountNo);
        Double fromAccountBalance = accountRepository.getBalance4(fromAccountNo);
        Double toAccountBalance = accountRepository.getBalance4(toAccountNo);
        if (isLockedFromAccount) {
            throw new SampleApplicationException("Account (" + fromAccountNo + ") is blocked. Please contact bank service centre.");
        } else if (isLockedToAccount) {
            throw new SampleApplicationException("Account (" + toAccountNo + ") is blocked. Please contact bank service centre.");
        } else if (transfer > fromAccountBalance) {
            throw new SampleApplicationException("You don´t have sufficient funds to transfer.");
        } else {
            Double fromAccNewBalance = fromAccountBalance - transfer;
            accountRepository.updateBalance4(fromAccountNo, fromAccNewBalance);
            Double toAccNewBalance = toAccountBalance + transfer;
            accountRepository.updateBalance4(toAccountNo, toAccNewBalance);
            return "You have transferred: " + transfer + " euro from account " + fromAccountNo + ". Your new balance is: " + fromAccNewBalance + " euro. \n" +
                    "Your account " + toAccountNo + " balance is: " + toAccNewBalance + " euro.";
        }
    }

    public List<AccountInfo> getAllAccounts() {
        return accountRepository.getAllAccounts();
    }

    public String login(LoginRequest loginRequest) {
        String password = accountRepository.getPasswordByUserName(loginRequest.getUsername());
        //if (loginRequest.getPassword().equals(password)) {
        if (passwordEncoder.matches(loginRequest.getPassword(), password)) {
            Date today = new Date();
            Date tokenExpirationDate = new Date(today.getTime() + 1000 * 60 * 60 * 24); //Login kehtib 24h; 1000mil/sek*60*60*24 =kokku 1 ööpäev
            JwtBuilder jwtBuilder = Jwts.builder()                                      //Tokeni genereerimine
                    .setExpiration(tokenExpirationDate)                                 //kehtivus
                    .setIssuedAt(new Date())                                            //issued täna ja praegu
                    .signWith(SignatureAlgorithm.HS256, "dmVyeVNlY3JldFBhc3N3b3Jk")  //allkirjastada parooliga HS256 algorütm+parool sama, mis TokenFiltris
                    .claim("username", loginRequest.getUsername());
            return jwtBuilder.compact();                                                //tagastab jwtBuilderi Tokeni
        } else {
            throw new SampleApplicationException("Wrong password");
        }
    }

    public void newUser(LoginRequest loginRequest) {
        if (accountRepository.userNameExists(loginRequest.getUsername())) {
            throw new SampleApplicationException("Username already exists");
        } else {

        }
        String encodedPassword = passwordEncoder.encode(loginRequest.getPassword());
        loginRequest.setPassword(encodedPassword);
        accountRepository.createUser(loginRequest.getUsername(), encodedPassword);
    }

    public void deleteUser(LoginRequest loginRequest) {
        if (accountRepository.userNameExists(loginRequest.getUsername())) {
            accountRepository.deleteUser(loginRequest.getUsername());
        } else {
            throw new SampleApplicationException("Username doesn´t exists");
        }
    }
}