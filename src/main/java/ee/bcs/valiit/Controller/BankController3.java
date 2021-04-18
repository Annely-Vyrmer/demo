package ee.bcs.valiit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BankController3 {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    //CREATE ACCOUNT
    //http://localhost:8080/createAccount3/EE1212/tiiu/500
    @PostMapping("createAccount3/{accNumber}/{name}/{initialAmount}")
    public String createAccount3(@PathVariable("accNumber") String accountNo,
                                 @PathVariable("name") String accountName,
                                 @PathVariable("initialAmount") Double balance) {
        String sql = "INSERT INTO bank_account(account_number, customer_name, account_balance) VALUES(:dbNumber, :dbName, :dbBalance";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbNumber", accountNo);
        paramMap.put("dbName", accountName);
        paramMap.put("dbBalance", balance);
        jdbcTemplate.update(sql, paramMap);
        return "Your (" + accountName + ") new account number is: " + accountNo + ". \n" +
                "Current account balance is euro: " + balance + " euro.";
    }

    //GET BALANCE
    //http://localhost:8080/getBalance3/EE1212
    @GetMapping("getBalance3/{accNumber}")
    public String getBalance3(@PathVariable("accNumber") String accountNo) {
        String sql = "SELECT account_balance FROM bank_account WHERE account_number = :dbNumber";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbNumber", accountNo);                                     //kas ei peaks olema GET?
        Double balance = jdbcTemplate.queryForObject(sql, paramMap, Double.class);
        if (accountNo == null) {
            return "No account with this account number found. Please check or create new account.";
        } else {
            return "Your account (" + accountNo + ") balance is " + balance + " euro.";
        }
    }

    //DEPOSIT MONEY
    //http://localhost:8080/depositMoney3/EE1212/100
    @PutMapping("depositMoney3/{accNumber}/{depositAmount}")
    public String depositMoney3(@PathVariable("accNumber") String accountNo,
                                @PathVariable("depositAmount") Double deposit) {
        String sql = "SELECT account_balance FROM bank_account WHERE account_number = :dbNumber";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbNumber", accountNo);                                     //kas ei peaks olema GET?
        Double currentBalance = jdbcTemplate.queryForObject(sql, paramMap, Double.class);
        String sql1 = "INSERT INTO bank_account(account_number, account_balance) VALUES(:dbNumber, :dbBalance)";
        Map<String, Object> paramMap1 = new HashMap<>();
        paramMap1.put("dbNumber", accountNo);
        paramMap1.put("dbBalance", currentBalance);
        if (accountNo == null) {
            return "No account found. Please create new account.";
        } else if (deposit > 0) {
            //currentBalance = jdbcTemplate.queryForObject(sql, paramMap, Double.class);
            Double newBalance = currentBalance + deposit;
            jdbcTemplate.update(sql1, paramMap);
            return "Your account (" + accountNo + ") new balance is " + newBalance + " euro.";
        } else {
            return "Invalid amount. You can deposit positive amount.";
        }
    }

//    //http://localhost:8080/withdrawMoney3/EE3434/50
//    @GetMapping("withdrawMoney3/{accNumber}/{withdraw}")
//    public String withdrawMoney3(@PathVariable("accNumber") String accountNo, @PathVariable Double withdraw) {
//        String sql = "INSERT INTO bank_account(account_number, account_balance) VALUES(:dbNumber, :dbBalance)";
//        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("dbNumber", accountNo);
//        paramMap.put("dbBalance", withdraw);                                            //withdraw?
//        Double currentBalance = jdbcTemplate.queryForObject(sql, paramMap, Double.class);
//        if (withdraw < currentBalance) {
//            Double newBalance = currentBalance - withdraw;
//            jdbcTemplate.update(sql, paramMap);
//            return "You have withdrawn " + withdraw + " euro. Your account remaining amount is: " + newBalance;
//        } else if (withdraw > currentBalance) {
//            return "You don´t have sufficient funds.";
//        } else {
//            return "Invalid input.";
//        }
//    }

//    //http://localhost:8080/transferMoney3/EE1212/EE3434/100                 //Vastus: You have transferred: 100.0 euro from account EE1212. Your new balance is: 400.0 euro.
//    @GetMapping("transferMoney3/{fromAccountNo}/{toAccountNo}/{transfer}")
//    //Your account EE3434 balance is: 500.0 euro.
//    public String transferMoney3(@PathVariable("fromAccountNo") String fromAccountNo,
//                                 @PathVariable("toAccountNo") String toAccountNo,
//                                 @PathVariable double transfer) {
//        Double balance = accountBalanceMap.get(fromAccountNo);
//        if (transfer > accountBalanceMap.get(fromAccountNo)) {
//            return "You don´t have sufficient funds to transfer.";
//        } else if (transfer <= accountBalanceMap.get(fromAccountNo)) {
//            balance = balance - transfer;
//            double account2Balance = accountBalanceMap.get(toAccountNo);
//            double deductedMoney = balance - transfer;
//            double addedMoney = account2Balance + transfer;
//            accountBalanceMap.put(fromAccountNo, deductedMoney);
//            accountBalanceMap.put(toAccountNo, addedMoney);
//            return "You have transferred: " + transfer + " euro from account " + fromAccountNo + ". Your new balance is: " + deductedMoney + " euro. \n" +
//                    "Your account " + toAccountNo + " balance is: " + addedMoney + " euro.";
//        } else {
//            return "Invalid input.";
//        }
//    }
}

