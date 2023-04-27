public class MP3PlayerFactory extends PlayerFactory {
	public Player createPlayer() {
		return new MP3Player();
	}
	class MP3Player implements Player { //상속받은 네스티드 인터페이스를 구현하는 이너 클래스
		public void play(String source) {
			System.out.println("플레이 시작: " + source);
		}
		public void stop() {
			System.out.println("플레이 종료");
		}
	}
}
