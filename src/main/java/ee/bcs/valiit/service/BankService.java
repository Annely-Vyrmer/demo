package ee.bcs.valiit.service;

import ee.bcs.valiit.repository.AccountRepository;
import ee.bcs.valiit.solution.exception.SampleApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class BankService {

    @Autowired
    private AccountRepository accountRepository;

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
        Boolean isLocked = accountRepository.isLocked(accountNo);
        if (isLocked) {
            throw new SampleApplicationException("Account (" + accountNo + ") is blocked. Please contact bank service centre.");
        }                                                           //võtsin siit realt ära else{ ja peale returni }
        return "Your account (" + accountNo + ") balance is " + accountRepository.getBalance4(accountNo) + " euro.";
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
            throw new SampleApplicationException("You don´t have sufficient funds to transfer.");
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
}