import java.util.Scanner;

public class BankAccount {
	int balance;
	int previousTransaction;
	String custName;
	String custID;
	
	public BankAccount(String cName, String cID)
	{
		custName = cName;
		custID = cID;
	}
	public void deposit(int amount)
	{
		if (amount!=0)
		{
			balance += amount;
			previousTransaction = amount;
		}
	}
	
	public void withdraw(int amount)
	{
		if (amount!=0 && amount <= balance)
		{
			balance -= amount;
			previousTransaction = -amount;
		}
	}
	
	public void getPreviousTransaction()
	{
		if (previousTransaction > 0)
		{
			System.out.println("Amount Deposited: "+previousTransaction);
		}
		else if(previousTransaction < 0)
		{
			System.out.println("Amount Withdrawn: "+ Math.abs(previousTransaction));
		}
		else
		{
			System.out.println("No transaction occured.");
		}
	}
	
	public void menu()
	{
		char option = '\0';
		Scanner scan1 = new Scanner(System.in);
		
		System.out.println("Welcome " + custName + "!");
		System.out.println("Your customer ID is " + custID + "\n");
		System.out.println("A. Check your balance");
		System.out.println("B. Make a deposit");
		System.out.println("C. Make a withdrawl");
		System.out.println("D. View previous transaction");
		System.out.println("E. Exit");
		
		do
		{
			System.out.println("===========================");
			System.out.println("Enter an option");
			System.out.println("===========================");
			option = scan1.next().charAt(0);
			System.out.println("\n");
			
			switch(option)
			{
			
			case 'A':
				System.out.println("-----------------------------");
				System.out.println("Balance = " +balance);
				System.out.println("-----------------------------");
				System.out.println("\n");
				break;
				
			case 'B':
				System.out.println("-----------------------------");
				System.out.println("Enter deposit amount: ");
				System.out.println("-----------------------------");
				int depAmnt = scan1.nextInt();
				deposit(depAmnt);
				System.out.println("\n");
				break;
				
			case 'C':
				System.out.println("-----------------------------");
				System.out.println("Enter withdrawl amount: ");
				System.out.println("-----------------------------");
				int withdAmnt = scan1.nextInt();
				withdraw(withdAmnt);
				System.out.println("\n");
				break;
			
			case 'D':
				System.out.println("-----------------------------");
				getPreviousTransaction();
				System.out.println("-----------------------------");
				System.out.println("\n");
				
			case 'E':
				System.out.println("**************************************");
				break;
				
			default:
				System.out.println("Invalid option, please try again.");
				
				
			}
		} while(option != 'E');
		
		System.out.println("Thank you for doing business with us today!");
	}
}
