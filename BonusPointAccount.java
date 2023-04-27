
public class BonusPointAccount extends Account {
	int bonusPoint; // 누적 포인트 
	BonusPointAccount(String accountNo, String ownerName, int balance,
			int bonusPoint) {
		super(accountNo, ownerName, balance);
		this.bonusPoint = bonusPoint;
	} 
	@Override //어노테이션 deposit이 override된 메소드라는 걸 알려줌
	void deposit(int amount) { // 예금한다, 오버라이딩 된 메소드
		balance += amount; 
		bonusPoint += (int) (amount * 0.001);
	}
}
