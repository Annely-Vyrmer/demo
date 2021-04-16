package ee.bcs.valiit.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BankController {
    public Map<String, Double> accountBalanceMap = new HashMap<>();

    //Lood Mapi põhja ja sinna salvestuvad kontod/summad
    //http://localhost:8080/accounts
    @GetMapping("accounts")
    public Map<String, Double> getAccounts() {
        return accountBalanceMap;
    }

    //http://localhost:8080/createAccount/EE1212/500               //Lisasin URLi real kontosid jurude
    @PostMapping("createAccount/{accountNo}/{balance}")
    public String createAccount(@PathVariable("accountNo") String accountNo, @PathVariable("balance") Double balance) {
        accountBalanceMap.put(accountNo, balance);
        return "Your new account number is: " + accountNo + ". \n" +        //Vastus Your new account number is: EE5656.
                "Current account balance is euro: " + balance + " euro.";           //Current account balance is euro: 300.0 euro.
    }

    //http://localhost:8080/getBalance/EE1212               //Vastus: Your account (EE1212) balance is 500.0 euro.
    @GetMapping("getBalance/{accountNo}")
    public String getBalance(@PathVariable("accountNo") String accountNo) {
        if (accountBalanceMap.get(accountNo) == null) {
            return "No account with this account number. Please create new account.";
        } else {
            return "Your account (" + accountNo + ") balance is " + accountBalanceMap.get(accountNo) + " euro.";
        }
    }

    //http://localhost:8080/depositMoney/EE1212/100             //Vastus: Your account (EE1212) new balance is 600.0 euro.
    @PutMapping("depositMoney/{accountNo}/{deposit}")
    public String depositMoney(@PathVariable("accountNo") String accountNo, @PathVariable("deposit") Double deposit) {
        if (accountBalanceMap.get(accountNo) == null) {
            return "No account found. Please create new account.";
        } else if (deposit > 0) {
            Double balance = accountBalanceMap.get(accountNo);
            balance = balance + deposit;
            accountBalanceMap.replace(accountNo, balance);
            return "Your account (" + accountNo + ") new balance is " + balance + " euro.";
        } else {
            return "Invalid amount. You can deposit positive amount.";
        }
    }

    //http://localhost:8080/withdrawMoney/EE3434/50                 //Vastus: You have withdrawn 50.0 euro. Your account remaining amount is: 350.0
    @GetMapping("withdrawMoney/{accountNo}/{withdraw}")
    public String withdrawMoney(@PathVariable("accountNo") String accountNo, @PathVariable Double withdraw) {
        Double balance = accountBalanceMap.get(accountNo);
        if (withdraw < accountBalanceMap.get(accountNo)) {
            balance = balance - withdraw;
            accountBalanceMap.replace(accountNo, balance);
            return "You have withdrawn " + withdraw + " euro. Your account remaining amount is: " + balance;
        } else if (withdraw > balance) {
            return "You don´t have sufficient funds.";
        } else {
            return "Invalid input.";
        }
    }

    //http://localhost:8080/transferMoney/EE1212/EE3434/100                 //Vastus: You have transferred: 100.0 euro from account EE1212. Your new balance is: 400.0 euro.
    @GetMapping("transferMoney/{fromAccountNo}/{toAccountNo}/{transfer}")    //Your account EE3434 balance is: 500.0 euro.
    public String transferMoney(@PathVariable("fromAccountNo") String fromAccountNo,
                                @PathVariable("toAccountNo") String toAccountNo,
                                @PathVariable double transfer) {
        Double balance = accountBalanceMap.get(fromAccountNo);
        if (transfer > accountBalanceMap.get(fromAccountNo)) {
            return "You don´t have sufficient funds to transfer.";
        } else if (transfer <= accountBalanceMap.get(fromAccountNo)) {
            balance = balance - transfer;
            double account2Balance = accountBalanceMap.get(toAccountNo);
            double deductedMoney = balance - transfer;
            double addedMoney = account2Balance + transfer;
            accountBalanceMap.put(fromAccountNo, deductedMoney);
            accountBalanceMap.put(toAccountNo, addedMoney);
            return "You have transferred: " + transfer + " euro from account " + fromAccountNo + ". Your new balance is: " + deductedMoney + " euro. \n" +
                    "Your account " + toAccountNo + " balance is: " + addedMoney + " euro.";
        } else {
            return "Invalid input.";
        }
    }
}