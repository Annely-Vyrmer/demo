package ee.bcs.valiit.kodusedharjutused;

public class BankAccounts {
    private String accountNo;
    private String accountOwnerName;
    private Double balance;
    private boolean locked;

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountOwnerName() {
        return accountOwnerName;
    }

    public void setAccountOwnerName(String accountOwnerName) {
        this.accountOwnerName = accountOwnerName;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }
}
