
import java.util.HashMap;
import java.util.Scanner;

public class BankingSystem {
	private HashMap<String, Account> accounts;

    public BankingSystem() {
        accounts = new HashMap<>();
    }
     public void createAccount(String accNo, String accHolderName, int acc_pin) {
    	 if(accounts.containsKey(accNo)) {
    		 System.out.println("Account with account number " +accNo+ " already exists");
    	 }
    	 else {
    		 accounts.put(accNo, new Account(accNo, accHolderName, acc_pin));
    		 System.out.println("Account successfully created for " +accHolderName);
    	 }
     }
     
     public Account getAccount(String accNo) {
         return accounts.get(accNo);
     }
     
     public void displayMenu() {
    	System.out.println("\n Banking System Menu: "); 
    	System.out.println("1. Create account");
    	System.out.println("2. Deposit Money");
    	System.out.println("3. Withdraw Money");
    	System.out.println("4. Check Account Balance");
    	System.out.println("5. View Account Transaction History");
    	System.out.println("6. Exit Banking System");
     }
     
     public void run() {
//    	 if(!validPin( )) {
//    		 System.out.println("Access denied. Existing System");
//    		 return;
//    	 }
    	 Scanner sc = new Scanner(System.in);
    	 while(true)
    	 {
    		 displayMenu();
    		 System.out.println("Enter your choice");
    		 if(!sc.hasNextInt()) {
    			 System.out.println("Invalid Input. Enter a number");
    			 sc.next();
    			 continue;
    		 }
    		 int ch = sc.nextInt();
    		 sc.nextLine();
    		 
    		 switch(ch) {
    		 case 1: 
    			 System.out.println("Enter the account number");
    			 String accNo = sc.nextLine();
    			 System.out.println("Enter account holder name");
    			 String accHolderName = sc.nextLine();
    			 System.out.println("Enter the account pin");
    			 int acc_pin = sc.nextInt();
    			 createAccount(accNo, accHolderName, acc_pin);
    			 break;
    			 
    		 case 2: 
    			 System.out.println("Enter the account number");
    			 accNo = sc.nextLine();
    			 Account account = getAccount(accNo);
    			 
    			 if(account != null && validPin(account)) {
    				 System.out.println("Enter amount to deposit");
    				 double amount = sc.nextDouble();
    				 sc.nextLine();
    				 account.deposit(amount);
    			 }
    			 else 
    				 System.out.println("Account not found");
    			 break;
    		 case 3: 
    			 System.out.println("Enter the account number");
    			 accNo = sc.nextLine();
    			 account = getAccount(accNo);
    			 
    			 if(account != null && validPin(account)) {
    				 System.out.println("Enter amount to withdraw");
    				 double amount = sc.nextDouble();
    				 sc.nextLine();
    				 account.withdraw(amount);
    			 }
    			 else 
    				 System.out.println("Account not found");
    			 break;
    		 case 4:
    			 System.out.println("Enter the account number");
    			 accNo = sc.nextLine();
    			 account = getAccount(accNo);
    			 if(account != null && validPin(account)) {
    				 System.out.println("Current Balance: $ " + account.getbalance());
    			 }
    			 else 
    				 System.out.println("Account not found");
    			 break;
    		 case 5:
    			 System.out.println("Enter the account number");
    			 accNo = sc.nextLine();
    			 account = getAccount(accNo);
    			 
    			 if(account != null && validPin(account)) {
    				 account.showTransactionHistory();
    			 }
    			 else 
    				 System.out.println("Account not found");
    			 break;
    		 case 6: 
    			 System.out.println("Exiting banking system.");
    			 sc.close();
    			 return;
    		 default:
    			 System.out.println("Enter valid Input");
    		 }
    	 }
     }
     public boolean validPin(Account account) {
    	    Scanner sc = new Scanner(System.in);
    	    int attempts = 0;
    	    while (attempts < 3) {
    	        System.out.println("Enter Account PIN:");
    	        int pin = sc.nextInt();
    	        if (account.getacc_pin() == pin) {
    	            System.out.println("Valid PIN. Proceed.");
    	            return true;
    	        } else {
    	            attempts++;
    	            System.out.println("Invalid PIN. Attempts left: " + (3 - attempts));
    	        }
    	    }
    	    return false;
    	}
     public static void main(String args[]) {
    	 BankingSystem b = new BankingSystem();
    	 b.run();
     }
}
