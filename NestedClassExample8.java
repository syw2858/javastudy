public class NestedClassExample8 {
	public static void main(String args[]) {
		//class SatelliteSender extends MessageSender {
		MessageSender obj = new MessageSender() {
		void send(String message) {
			System.out.println("발신: 마이다스");
			System.out.println("수신: 빌 게이츠");
			System.out.println("메시지: " + message);
			System.out.println();
			}
		};
		//SatelliteSender obj = new SatelliteSender();
		obj.send("굿 모닝");
	}
}
