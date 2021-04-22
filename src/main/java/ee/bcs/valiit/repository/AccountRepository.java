package ee.bcs.valiit.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Repository
public class AccountRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void createAccount4(String accountNo, String accountName, Double balance) {
        String sql = "INSERT INTO bank_account(account_number, customer_name, account_balance) VALUES(:dbNumber, :dbName, :dbBalance)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbNumber", accountNo);
        paramMap.put("dbName", accountName);
        paramMap.put("dbBalance", balance);
        jdbcTemplate.update(sql, paramMap);
    }

    public void lock4(String accountNo){
        String lockAccount = "UPDATE bank_account SET locked = true WHERE account_number = :dbNumber";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbNumber", accountNo);
        jdbcTemplate.update(lockAccount, paramMap);
    }

    public void unlock4(String accountNo){
        String unlockAccount = "UPDATE bank_account SET locked = false WHERE account_number = :dbNumber";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbNumber", accountNo);
        jdbcTemplate.update(unlockAccount, paramMap);
    }

    public Boolean isLocked(String accountNo) {
        String isLocked = "SELECT locked FROM bank_account WHERE account_number = :dbNumber";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbNumber", accountNo);
        return jdbcTemplate.queryForObject(isLocked, paramMap, Boolean.class);
    }

    public Double getBalance4(String accountNo) {
        String sql = "SELECT account_balance FROM bank_account WHERE account_number = :dbNumber";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbNumber", accountNo);
        return jdbcTemplate.queryForObject(sql, paramMap, Double.class);
    }

    public void updateBalance4(String accountNo, Double deposit) {
        String sql1 = "UPDATE bank_account SET account_balance = :newBalance WHERE account_number = :dbNumber";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbNumber", accountNo);
        paramMap.put("newBalance", deposit);
        jdbcTemplate.update(sql1, paramMap);        //UPDATE ei tagasta midagi, kasuta meetodi real VOID
    }
        //transactions_history tabelisse kõik deposit money transaktsioonid
    public void transactionsHistoryDeposit(String accountNo, LocalDateTime date, Double newBalance, Double deposit){
        String history = "INSERT INTO transactions_history(account_number, date, account_balance, deposit) VALUES(:dbNumber, :dbDate, :dbBalance, :dbDeposit)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbNumber", accountNo);
        paramMap.put("dbDate", date);
        paramMap.put("dbBalance", newBalance);
        paramMap.put("dbDeposit", deposit);
        jdbcTemplate.update(history, paramMap);
    }
    //transactions_history tabelisse kõik withdraw money transaktsioonid
    public void transactionsHistoryWithdraw(String accountNo, LocalDateTime date, Double newBalance, Double withdraw){
        String history = "INSERT INTO transactions_history(account_number, date, account_balance, withdraw) VALUES(:dbNumber, :dbDate, :dbBalance, :dbWithdraw)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbNumber", accountNo);
        paramMap.put("dbDate", date);
        paramMap.put("dbBalance", newBalance);
        paramMap.put("dbWithdraw", withdraw);
        jdbcTemplate.update(history, paramMap);
    }
}