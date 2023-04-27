public class TransferThread extends Thread {
	SharedAreaa sharedArea;
	TransferThread(SharedAreaa area) { // 생성자
		sharedArea = area;
	}
	public void run() {
		for (int cnt = 0; cnt < 12; cnt ++) {
			sharedArea.transfer(100);
		}
	}
}
