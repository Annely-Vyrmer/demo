package ee.bcs.valiit.Controller;

import ee.bcs.valiit.kodusedharjutused.BankAccounts;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BankController2 {
    public Map<String, BankAccounts> accountBalanceMap = new HashMap<>();

    //http://localhost:8080/accounts
    @GetMapping("accounts")
    public Map<String, BankAccounts> getAccounts() {
        return accountBalanceMap;
    }
    //Create Account
    //http://localhost:8080/createAccount2/EE1212/Tiiu/500
    @PostMapping("createAccount2/{accountNo}/{accountOwnerName}/{balance}")
    public String createAccount2(@PathVariable("accountNo") String accountNo,
                                @PathVariable("accountOwnerName") String accountOwnerName,
                                @PathVariable("balance") double balance) {
    BankAccounts account = new BankAccounts();
    account.setAccountNo(accountNo);
    account.setAccountOwnerName(accountOwnerName);
    account.setBalance(balance);
    account.setLocked(false);
    accountBalanceMap.put(accountNo, account);
        return "Your new account number is: " + accountNo + ". \n" +
                "Current account balance is euro: " + balance + " euro.";
    }
//    //BLOCK ACCOUNT
//    //http://
//    @PutMapping("blockAccount")
//    public String blockAccount(@PathVariable"accountNo" String accountNo){
//        acc
//    }

    //Get Balance
    //http://localhost:8080/getBalance2/EE1212
    @GetMapping("getBalance2/{accountNo}")
    public String getBalance2(@PathVariable("accountNo") String accountNo) {
        if (accountBalanceMap.get(accountNo) == null) {
            return "No account with this account number. Please create new account.";
        } else {
            return "Your account (" + accountNo + ") balance is " + accountBalanceMap.get(accountNo).getBalance() + " euro.";
        }
    }
    //Deposit Money
    //http://localhost:8080/depositMoney2/EE1212/100
    @PutMapping("depositMoney2/{accountNo}/{deposit}")
    public String depositMoney2(@PathVariable("accountNo") String accountNo,
                                @PathVariable("deposit") Double deposit) {
        if (accountBalanceMap.get(accountNo) == null) {
            return "No account found. Please create new account.";
        } else if (deposit > 0) {
            Double balance = accountBalanceMap.get(accountNo).getBalance();
            balance = balance + deposit;
            accountBalanceMap.get(accountNo).setBalance(balance);
            return "Your account (" + accountNo + ") new balance is " + balance + " euro.";
        } else {
            return "Invalid amount. You can deposit positive amount.";
        }
    }

//    //http://localhost:8080/withdrawMoney2/EE3434/50
//    @GetMapping("withdrawMoney2/{accountNo}/{withdraw}")
//    public String withdrawMoney2(@PathVariable("accountNo") String accountNo, @PathVariable Double withdraw) {
//        Double balance = accountBalanceMap.get(accountNo);
//        if (withdraw < accountBalanceMap.get(accountNo)) {
//            balance = balance - withdraw;
//            accountBalanceMap.replace(accountNo, balance);
//            return "You have withdrawn " + withdraw + " euro. Your account remaining amount is: " + balance;
//        } else if (withdraw > balance) {
//            return "You don´t have sufficient funds.";
//        } else {
//            return "Invalid input.";
//        }
//    }
//
//    //http://localhost:8080/transferMoney2/EE1212/EE3434/100                 //Vastus: You have transferred: 100.0 euro from account EE1212. Your new balance is: 400.0 euro.
//    @GetMapping("transferMoney2/{fromAccountNo}/{toAccountNo}/{transfer}")    //Your account EE3434 balance is: 500.0 euro.
//    public String transferMoney2(@PathVariable("fromAccountNo") String fromAccountNo, @PathVariable("toAccountNo") String toAccountNo, @PathVariable double transfer) {
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
    }
