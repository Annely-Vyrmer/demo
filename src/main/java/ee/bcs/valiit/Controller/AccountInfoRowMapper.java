package ee.bcs.valiit.Controller;

import ee.bcs.valiit.Controller.AccountInfo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountInfoRowMapper implements RowMapper<AccountInfo> {

    @Override
    public AccountInfo mapRow(ResultSet resultSet, int i) throws SQLException {
        AccountInfo response = new AccountInfo();
        response.setAccountNo(resultSet.getString("account_number"));
        response.setAccountName(resultSet.getString("customer_name"));
        response.setBalance(resultSet.getDouble("account_balance"));
        response.setLocked(resultSet.getBoolean("locked"));
        return response;
    }
}