public abstract class PlayerFactory { 
	abstract Player createPlayer();
	interface Player { //네스티드 인터페이스
	void play(String source);
	void stop();
	}
}
