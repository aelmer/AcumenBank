package account;

public class SavingsAccount extends Account{
    
    private final int NUM_TIMES_INTEREST_ACCRUED = 1;
    private double initialInvestment;
    private double interest;
    private double interestRate;

    public SavingsAccount(String ownerName, double balance, double interestRate) {
        super.ownerName = ownerName;
        super.balance = balance;
        this.initialInvestment = balance;
        this.interestRate = interestRate;
        this.interest = 0.00;
    }
    
    //transfer account to account
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

    //Check what interest will be after n years of not touching the account
    public void applyInterest(int years){
        if (years < 0){
            throw new IllegalArgumentException("Cannot calculate interest over a negative time period");
        }
        this.interest =  CalculateInterest(years);    
    }

    //Calculate interest using initial balance to account
    public double CalculateInterest(int years){

        double newInterest;

        double compoundingInterestFactor = 1 + ((interestRate) / NUM_TIMES_INTEREST_ACCRUED);
        double exponent = NUM_TIMES_INTEREST_ACCRUED * years;
        newInterest = (this.initialInvestment * Math.pow(compoundingInterestFactor, exponent)) - this.initialInvestment;

        return newInterest;
    }

    public double getInterest() {
            return this.interest;
    }

    public double getInterestRate(){
            return this.interestRate;
    }

    //private withdraw in SavingsAccount class to make inaccessible outside of the class
    private void withdraw (double amount) {
            if (amount < 0) {
                    throw new IllegalArgumentException("Cannot withdraw a negative amount");
            }
            super.balance -= amount;
    }
}