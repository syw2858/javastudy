
public abstract class MessageSender {
	String title;
	String senderName;
	
	MessageSender(String title, String senderName) {
		this.title = title;
		this.senderName = senderName;
	}
	abstract void sendMessage(String recipient); //추상메소드
	//이 메소드를 반드시 오버라이딩 해야함
}
