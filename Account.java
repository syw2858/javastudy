
public class Account {

	String accountNo; // 계좌번호
	String ownerName; // 예금주 이름
	int balance; // 잔액
	
	Account() {}
	
	Account(String accountNo, String ownerName, int balance) { 
		this.accountNo = accountNo; 
		this.ownerName = ownerName; 
		this.balance = balance; 
	} 
	 
	void deposit(int amount) { 
		balance += amount;
	}
	int withdraw(int amount) throws Exception{
		if (balance < amount)
			throw new Exception("잔액이 부족합니다.");
		balance -= amount;
		return amount;
	}
}
