
public class PiggyBank {
	int total;
	Slot slot;
	PiggyBank() {
		total = 0;
		slot = new Slot();
	}
	class Slot { // 입구 클래스
		void put(int amount) {
			total += amount;
		}
	}
}
