package LC2043;

/**
 * Oct 26, 2025
 * LC 2043. Simple Bank System
 */
public class Bank {
    int n;
    long[] accounts;
    public Bank(long[] balance) {
        this.n = balance.length;
        this.accounts = new long[this.n + 1];
        for (int i = 0; i < n; i++) {
            accounts[i + 1] = balance[i];
        }
    }

    public boolean transfer(int account1, int account2, long money) {
        if (!isValidAccount(account1) || !isValidAccount(account2)) {
            return false;
        }
        if (this.accounts[account1] < money) {
            return false;
        }

        this.accounts[account1] -= money;
        this.accounts[account2] += money;

        return true;
    }

    public boolean deposit(int account, long money) {
        if (!isValidAccount(account)) {
            return false;
        }
        this.accounts[account] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (!isValidAccount(account)) {
            return false;
        }
        if (this.accounts[account] < money) {
            return false;
        }
        this.accounts[account] -= money;
        return true;
    }

    private boolean isValidAccount(int account) {
        return account >= 1 && account <= n;
    }
}
