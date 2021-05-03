package ee.bcs.valiit.Controller;

import ee.bcs.valiit.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin - vajalik, et HTMLis olev script töötaks ka mujhalt kui localhost:8080-st
@RequestMapping("api")
//kirjutab kõigi Post-, Put- ja GetMappingu ette ISEe api, aga ei tee seda Postmanis
@RestController                             //TOKENi saamiseks Postmanis URL: http://localhost:8080/api/public/login
public class BankController4 {              //Password: verySecretPassword, https://www.base64encode.org/ ENCODE "dmVyeVNlY3JldFBhc3N3b3Jk"
    //Lisa "dmVyeVNlY3JldFBhc3N3b3Jk" LoginController ja JwtTokenFilterisse
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private BankService bankService;

    //CREATE ACCOUNT
    //http://localhost:8080/createAccount4/EE1555/Reino/500 - kui ei ole LOGIN
    //http://localhost:8080/api/createAccount4/EE999/Rasmus/500 - kui ON LOGIN, vt SECURITY packaget ja LoginControllerit.
    @PostMapping("createAccount4/{accNumber}/{name}/{initialAmount}")
    public void createAccount4(@PathVariable("accNumber") String accountNo,
                               @PathVariable("name") String accountName,
                               @PathVariable("initialAmount") Double balance) {
        bankService.createAccount4(accountNo, accountName, balance);
    }

    //LOCK ACCOUNT
    //http://localhost:8080/lock4/EE1212
    @PutMapping("lock4/{accNumber}")
    public void lock4(@PathVariable("accNumber") String accountNo) {
        bankService.lock4(accountNo);
    }

    //UNLOCK ACCOUNT
    //http://localhost:8080/unlock4/EE1212
    @PutMapping("unlock4/{accNumber}")
    public void unlock4(@PathVariable("accNumber") String accountNo) {
        bankService.unlock4(accountNo);
    }

    //GET BALANCE
    //http://localhost:8080/getBalance4/EE1555
    @GetMapping("getBalance4/{accNumber}")
    public String getBalance4(@PathVariable("accNumber") String accountNo) {
        return bankService.getBalance4(accountNo);
    }

    //DEPOSIT MONEY
    //http://localhost:8080/depositMoney4/EE1555/100
    @PutMapping("depositMoney4/{accNumber}/{depositAmount}")
    public String depositMoney4(@PathVariable("accNumber") String accountNo,
                                @PathVariable("depositAmount") Double deposit) {
        return bankService.depositMoney4(accountNo, deposit);
    }

    //WITHDRAW MONEY
    //http://localhost:8080/withdrawMoney4/EE1444/50
    @GetMapping("withdrawMoney4/{accNumber}/{withdraw}")
    public String withdrawMoney4(@PathVariable("accNumber") String accountNo,
                                 @PathVariable Double withdraw) {
        return bankService.withdrawMoney4(accountNo, withdraw);
    }

    //TRANSFER MONEY
    //http://localhost:8080/transferMoney4/EE9191/EE1222/100
    @GetMapping("transferMoney4/{fromAccountNo}/{toAccountNo}/{transfer}")
    public String transferMoney4(@PathVariable("fromAccountNo") String fromAccountNo,
                                 @PathVariable("toAccountNo") String toAccountNo,
                                 @PathVariable double transfer) {
        return bankService.transferMoney4(fromAccountNo, toAccountNo, transfer);
    }

    //All ACCOUNTS
    //http://localhost:8080/allAccounts
    @GetMapping("allAccounts")
    public List<AccountInfo> getAllAccounts() {
        return bankService.getAllAccounts();
    }

    //LOGIN (RequestBody)
    //http://localhost:8080/api/public/login
    @PostMapping("public/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        return bankService.login(loginRequest);
    }

    //NEW USER (RequestBody)
    //http://localhost:8080/api/public/newUser
    @PostMapping("public/newUser")
    public void newUser(@RequestBody LoginRequest loginRequest){
        bankService.newUser(loginRequest);
    }

    //DELETE USER (RequestBody)
    //http://localhost:8080/api/public/deleteUser
    @PostMapping("public/deleteUser")
    public void deleteUser(@RequestBody LoginRequest loginRequest){
        bankService.deleteUser(loginRequest);
    }
}