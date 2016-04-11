package account;

public class CheckingAccount extends Account{

    public CheckingAccount(String ownerName, double balance) {
        super.ownerName = ownerName;
        super.balance = balance;
    }
    
    @Override
    public void transfer(Account destinationAccount, double amount) {
        try{
            this.withdraw(amount);
            destinationAccount.deposit(amount);
        }
        catch(Exception e)
        {
            throw new IllegalArgumentException("Error transfering $" + Double.toString(amount)
                    + "from " + this.getOwnerName() + "'s account to " + destinationAccount.getOwnerName()
                    + "'s account");
        }
    }

    public void withdraw(double amount) {
        if (amount < 0) {
                throw new IllegalArgumentException("Cannot withdraw a negative amount");
        }
        super.balance -= amount;
    }
}