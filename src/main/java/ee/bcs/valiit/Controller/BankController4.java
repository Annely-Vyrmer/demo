package ee.bcs.valiit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BankController4 {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    //CREATE ACCOUNT
    //http://localhost:8080/createAccount3/EE1222/tiiu/500
    @PostMapping("createAccount3/{accNumber}/{name}/{initialAmount}")
    public String createAccount3(@PathVariable("accNumber") String accountNo,
                                 @PathVariable("name") String accountName,
                                 @PathVariable("initialAmount") Double balance) {
        String sql = "INSERT INTO bank_account(account_number, customer_name, account_balance) VALUES(:dbNumber, :dbName, :dbBalance)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbNumber", accountNo);
        paramMap.put("dbName", accountName);
        paramMap.put("dbBalance", balance);
        jdbcTemplate.update(sql, paramMap);         //update ei tagasta midagi!
        return "Your (" + accountName + ") new account number is: " + accountNo + ". \n" +
                "Current account balance is euro: " + balance + " euro.";
    }

    //GET BALANCE
    //http://localhost:8080/getBalance3/EE1222
    @GetMapping("getBalance3/{accNumber}")
    public String getBalance3(@PathVariable("accNumber") String accountNo) {
        String isLocked = "SELECT locked FROM bank_account WHERE account_number = :dbNumber";    //küsin DB-st konkreetse konto staatust
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbNumber", accountNo);
        Boolean dbLocked = jdbcTemplate.queryForObject(isLocked, paramMap, Boolean.class);
        if (accountNo == null) {
            return "No account with this account number found. Please check or create new account.";
        } else if (dbLocked) {
            return "Account (" + accountNo + ") is blocked. Please contact bank service centre.";
        } else {
            String sql = "SELECT account_balance FROM bank_account WHERE account_number = :dbNumber";
            paramMap.put("dbNumber", accountNo);
            Double balance = jdbcTemplate.queryForObject(sql, paramMap, Double.class);
            return "Your account (" + accountNo + ") balance is " + balance + " euro.";
        }
    }

    //DEPOSIT MONEY
    //http://localhost:8080/depositMoney3/EE7878/100
    @PutMapping("depositMoney3/{accNumber}/{depositAmount}")
    public String depositMoney3(@PathVariable("accNumber") String accountNo,
                                @PathVariable("depositAmount") Double deposit) {
        String isLocked = "SELECT locked FROM bank_account WHERE account_number = :dbNumber";    //küsin DB-st konkreetse konto staatust
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbNumber", accountNo);
        Boolean dbLocked = jdbcTemplate.queryForObject(isLocked, paramMap, Boolean.class);
        if (accountNo == null) {
            return "No account found. Please create new account.";
        } else if (dbLocked) {
            return "Account (" + accountNo + ") is blocked. Please contact bank service centre.";
        } else if (deposit > 0) {
            String sql = "SELECT account_balance FROM bank_account WHERE account_number = :dbNumber";
            //Map<String, Object> paramMap = new HashMap<>();   //MAP vajalik kui ei olnud blokeeringu vahekontrolli!
            paramMap.put("dbNumber", accountNo);
            Double currentBalance = jdbcTemplate.queryForObject(sql, paramMap, Double.class);
            Double newBalance = currentBalance + deposit;
            String sql1 = "UPDATE bank_account SET account_balance = :newBalance WHERE account_number = :dbNumber";
            paramMap.put("newBalance", newBalance);
            jdbcTemplate.update(sql1, paramMap);
            return "You have deposited " + deposit + " euro. Your account (" + accountNo + ") new balance is " + newBalance + " euro.";
        } else {
            return "Invalid amount. You can deposit positive amount.";
        }
    }

    //WITHDRAW MONEY
    //http://localhost:8080/withdrawMoney3/EE9191/50
    @GetMapping("withdrawMoney3/{accNumber}/{withdraw}")
    public String withdrawMoney3(@PathVariable("accNumber") String accountNo,
                                 @PathVariable Double withdraw) {
        String isLocked = "SELECT locked FROM bank_account WHERE account_number = :dbNumber";    //küsin DB-st konkreetse konto staatust
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbNumber", accountNo);
        Boolean dbLocked = jdbcTemplate.queryForObject(isLocked, paramMap, Boolean.class);
        String sql1 = "SELECT account_balance FROM bank_account WHERE account_number = :dbNumber";
        Map<String, Object> paramMap1 = new HashMap<>();
        paramMap1.put("dbNumber", accountNo);
        Double currentBalance = jdbcTemplate.queryForObject(sql1, paramMap1, Double.class);
        if (accountNo == null) {
            return "No account found. Please create new account.";
        } else if (dbLocked) {
            return "Account (" + accountNo + ") is blocked. Please contact bank service centre.";
        } else if (withdraw < currentBalance) {
            Double newBalance = currentBalance - withdraw;
            String sql2 = "UPDATE bank_account SET account_balance = :newBalance WHERE account_number = :dbNumber";
            paramMap.put("newBalance", newBalance);
            jdbcTemplate.update(sql2, paramMap);
            return "You have withdrawn " + withdraw + " euro. Your account remaining amount is: " + newBalance;
        } else if (withdraw > currentBalance) {
            return "You don´t have sufficient funds.";
        } else {
            return "Invalid input.";
        }
    }

    //http://localhost:8080/transferMoney3/EE1222/EE9191/50
    @GetMapping("transferMoney3/{fromAccountNo}/{toAccountNo}/{transfer}")
    public String transferMoney3(@PathVariable("fromAccountNo") String fromAccountNo,
                                 @PathVariable("toAccountNo") String toAccountNo,
                                 @PathVariable double transfer) {
        String isLocked1 = "SELECT locked FROM bank_account WHERE account_number = :dbFromNumber";  //küsin DB-st FROM konto staatust
        String isLocked2 = "SELECT locked FROM bank_account WHERE account_number = :dbToNumber";    //küsin DB-st TO konto staatust
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbFromNumber", fromAccountNo);
        paramMap.put("dbToNumber", toAccountNo);
        Boolean dbFromLocked = jdbcTemplate.queryForObject(isLocked1, paramMap, Boolean.class);
        Boolean dbToLocked = jdbcTemplate.queryForObject(isLocked2, paramMap, Boolean.class);
        String sql1 = "SELECT account_balance FROM bank_account WHERE account_number = :dbFromNumber";  //küsin FROM kontot ja balance
        Map<String, Object> paramMap1 = new HashMap<>();
        paramMap1.put("dbFromNumber", fromAccountNo);
        Double fromAccountBalance = jdbcTemplate.queryForObject(sql1, paramMap1, Double.class);
        String sql2 = "SELECT account_balance FROM bank_account WHERE account_number = :dbToNumber";    //küsin TO kontot ja balance
        Map<String, Object> paramMap2 = new HashMap<>();
        paramMap2.put("dbToNumber", toAccountNo);
        Double toAccountBalance = jdbcTemplate.queryForObject(sql2, paramMap2, Double.class);
        if (dbFromLocked) {
            return "Account (" + fromAccountNo + ") is blocked. Please contact bank service centre.";
        } else if (dbToLocked) {
            return "Account (" + toAccountNo + ") is blocked. Please contact bank service centre.";
        } else if (transfer > fromAccountBalance) {
            return "You don´t have sufficient funds to transfer.";
        } else {
            Double fromAccNewBalance = fromAccountBalance - transfer;
            String sql3 = "UPDATE bank_account SET account_balance = :fromAccNewBalance WHERE account_number = :dbFromNumber";  //uuendan FROM konto balance
            Map<String, Object> paramMap3 = new HashMap<>();
            paramMap3.put("fromAccNewBalance", fromAccNewBalance);
            paramMap3.put("dbFromNumber", fromAccountNo);
            jdbcTemplate.update(sql3, paramMap3);
            Double toAccNewBalance = toAccountBalance + transfer;
            String sql4 = "UPDATE bank_account SET account_balance = :toAccNewBalance WHERE account_number = :dbToNumber";  //uuendan TO konto balance
            Map<String, Object> paramMap4 = new HashMap<>();
            paramMap4.put("toAccNewBalance", toAccNewBalance);
            paramMap4.put("dbToNumber", toAccountNo);
            jdbcTemplate.update(sql4, paramMap4);
            return "You have transferred: " + transfer + " euro from account " + fromAccountNo + ". Your new balance is: " + fromAccNewBalance + " euro. \n" +
                    "Your account " + toAccountNo + " balance is: " + toAccNewBalance + " euro.";
        }
    }
}