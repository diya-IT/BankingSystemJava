class Account{
	private int accNo;
	private String name;
	private double balance;
	public Account(int accno,String name,double  balance){
       this.accNo=accno;
       this.balance=balance;
       this.name=name;
	}
	public int getaccno(){
		return accNo;
	}
	public String getName() { return name; }
    public double getBalance() { return balance; }
	public void deposit(double amount){
		balance+=amount;
	}
	public boolean withdraw(double amount){
		 if(amount>balance){ //balance=2000 and amount niklana =3000 not possible 
		 	 return false;
		 }
		 balance=balance-amount;
		 return true;
	}
	 @Override
    public String toString() {
        return "AccNo: " + accNo + ", Name: " + name + ", Balance: " + balance;
    }
}