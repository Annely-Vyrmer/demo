package ee.bcs.valiit.Controller;

import ee.bcs.valiit.service.BankService;
import ee.bcs.valiit.solution.controller.SampleAccount2;
import ee.bcs.valiit.solution.controller.SampleAccount2RowMapper;
import ee.bcs.valiit.solution.exception.SampleApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BankController4 {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private BankService bankService;

    //CREATE ACCOUNT
    //http://localhost:8080/createAccount4/EE1555/Reino/500
    @CrossOrigin
    @PostMapping("createAccount4/{accNumber}/{name}/{initialAmount}")
    public void createAccount4(@PathVariable("accNumber") String accountNo,
                               @PathVariable("name") String accountName,
                               @PathVariable("initialAmount") Double balance) {
        bankService.createAccount4(accountNo, accountName, balance);
    }
    //LOCK ACCOUNT
    //http://localhost:8080/lock4/EE1212
    @CrossOrigin
    @PutMapping ("lock4/{accNumber}")
    public void lock4(@PathVariable("accNumber") String accountNo){
        bankService.lock4(accountNo);
    }
    //UNLOCK ACCOUNT
    //http://localhost:8080/unlock4/EE1212
    @CrossOrigin
    @PutMapping ("unlock4/{accNumber}")
    public void unlock4(@PathVariable("accNumber") String accountNo){
        bankService.unlock4(accountNo);
    }

    //GET BALANCE
    //http://localhost:8080/getBalance4/EE1555
    @CrossOrigin
    @GetMapping("getBalance4/{accNumber}")
    public String getBalance4(@PathVariable("accNumber") String accountNo) {
        return bankService.getBalance4(accountNo);
    }
    //DEPOSIT MONEY
    //http://localhost:8080/depositMoney4/EE1555/100
    @CrossOrigin
    @PutMapping("depositMoney4/{accNumber}/{depositAmount}")
    public String depositMoney4(@PathVariable("accNumber") String accountNo,
                              @PathVariable("depositAmount") Double deposit) {
        return bankService.depositMoney4(accountNo, deposit);
    }
    //WITHDRAW MONEY
    //http://localhost:8080/withdrawMoney4/EE1444/50
    @CrossOrigin
    @GetMapping("withdrawMoney4/{accNumber}/{withdraw}")
    public String withdrawMoney4(@PathVariable("accNumber") String accountNo,
                                 @PathVariable Double withdraw) {
        return bankService.withdrawMoney4(accountNo, withdraw);
    }

    //TRANSFER MONEY
    //http://localhost:8080/transferMoney4/EE9191/EE1222/100
    @CrossOrigin
    @GetMapping("transferMoney4/{fromAccountNo}/{toAccountNo}/{transfer}")
    public String transferMoney4(@PathVariable("fromAccountNo") String fromAccountNo,
                                 @PathVariable("toAccountNo") String toAccountNo,
                                 @PathVariable double transfer) {
        return bankService.transferMoney4(fromAccountNo, toAccountNo, transfer);
    }
    //All ACCOUNTS
    //http://localhost:8080/allAccounts
    @CrossOrigin
    @GetMapping("allAccounts")
    public List<AccountInfo> getAllAccounts(){
        return bankService.getAllAccounts();
    }
}