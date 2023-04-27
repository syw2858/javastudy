public class MultithreadExample5 {
	public static void main(String args[]) {
		SharedAreaa area = new SharedAreaa();
		area.account1 = new Account("111-111-1111", "이몽룡", 20000000);
		area.account2 = new Account("222-222-2222", "성춘향", 10000000);
		TransferThread thread1 = new TransferThread(area);
		PrintThreada thread2 = new PrintThreada(area);
		thread1.start();
		thread2.start();
	}
}
