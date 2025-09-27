import java.util.Scanner;
import java.util.*;
class BankingSystem{
	static Map<Integer,Account>accounts=new HashMap<>();
    static List<Transaction> transactions = new ArrayList<>();
	
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		int choice;
		do{
			showMenu();
            choice=sc.nextInt();
              sc.nextLine();
              switch(choice){
              	 case 1: createaccount();
              	 	break;
              	 case 2: deposit();
              	 	break;
              	 case 3: withdraw();
              	 	break;
              	 case 4:ViewAccount();
              	 	break;
              	 case 5:Viewtranscations();
              	 	break;
              	 case 6: System.out.println("Exiting..."); 
              	 	break;
                default: System.out.println("Invalid choice!");
              }

		}while(choice!=6);
	}
	static void showMenu(){
		System.out.println("\n--- Banking System ---");
        System.out.println("1. Create Account");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. View Account Details");
        System.out.println("5. View Transaction History");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
	}
	static void createaccount(){
     System.out.println("Enter the account number");
     int accno=sc.nextInt();
     sc.nextLine();
     if(accounts.containsKey(accno)){
     	System.out.println("Account already exists!");
          return;
     }
     System.out.println("enter the name");
     String name=sc.nextLine();
     System.out.println("enter the balance number");
     double balance=sc.nextDouble();
     Account ac=new Account(accno,name,balance);
     accounts.put(accno,ac); //bcz its a hash map it will store this entry oka 
     transactions.add(new Transaction(accno,"account created",balance));
     System.out.println("it is printed successfully");

	}
	static void deposit(){
   //deposit money 
	   System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        Account acc = accounts.get(accNo);
        if(acc == null) { System.out.println("Account not found!"); return; }
        System.out.print("Enter Deposit Amount: ");
        double amount=sc.nextDouble();
        acc.deposit(amount);
       transactions.add(new Transaction(accNo, "Deposit", amount));
        System.out.println(" Deposit successful.");

	}
	static void withdraw(){
     //money withdrawal 
		  System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        Account acc = accounts.get(accNo);
         if(acc == null) { System.out.println("Account not found!"); return; }
        System.out.print("Enter Withdraw Amount: ");
        double amount = sc.nextDouble();
        if(acc.withdraw(amount)){
        	transactions.add(new Transaction(accNo, "Withdraw", amount));
            System.out.println("Withdraw successful.");
        }else{
         System.out.println("Insufficient balance!");
        }
	}
	static void ViewAccount(){
         System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        Account acc = accounts.get(accNo);
        if(acc != null) System.out.println(acc);  //calls acc.toString() of my account class to show details 
        else System.out.println("Account not found!");
	}
	static void Viewtranscations(){
		 System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        boolean found = false;
        for(Transaction t:transactions){
        	  if(t.toString().contains("AccNo: " + accNo)) {
                System.out.println(t);
                found = true;
            }
        }
        if(!found) System.out.println("No transactions found for this account.");
	}
}