
/**
 * This class is an extension of the class BankAccount which
 * represents a saving account where interests at a constant 
 * rate is gained
 * 
 * @author Yiran Shao
 *
 */

public class SavingsAccount extends BankAccount{
	private static double interestRate; // The interest rate of the saving account

	/**
	 * The constructor of the class which contains the initial amount of the 
	 * account and initializes the interest rate
	 * 
	 * @param initialAmount initial amount of the account
	 * @param rate the interest rate
	 */
	public SavingsAccount(double initialAmount, double rate) {
		super(initialAmount);
		interestRate = rate;	
	}
	
	/**
	 * This method returns the interest rate
	 * 
	 * @return the interest rate
	 */
	public double getInterestRate() {
		return interestRate;
	}
	
	/**
	 * This method calculates the interest of one month and 
	 * add that amount to the bank account
	 */
	public void calculateInterest() {
		double oneMonthInterest = interestRate * super.getBalance();
		super.deposit(oneMonthInterest);
	}
	
	/**
	 * This method returns a string the contains the information 
	 * (i.e. current balance and interest rate) of the saving account
	 */
	public String toString() {
		String savingOutput = "SavingsAccount: balance $"+super.getBalance()+", interest rate "+interestRate;
		return savingOutput;
	}
	
	/**
	 * Main method of the class that creates a saving account with 
	 * initial balance of 100 and interest rate of 0.15, calculates
	 * the balance after one month and returns the information of the 
	 * account as a string
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
        SavingsAccount myAccount = new SavingsAccount(100.0,0.15);
	myAccount.calculateInterest();
	System.out.println(myAccount.toString());
	}

}
