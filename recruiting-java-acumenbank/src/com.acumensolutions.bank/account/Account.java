package account;

public abstract class Account {
    protected String ownerName;
    protected double balance;

    abstract public void transfer(Account destinationAccount, double amount);

        
    public void deposit(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Cannot deposit a negative amount");
		}
		this.balance += amount;
	}

    public String getOwnerName() {
        return this.ownerName;
    }

    public double getBalance() {
        return this.balance;
    }
}