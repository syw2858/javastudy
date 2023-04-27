public class PlaneLabel implements Movable{
	int x, y;
	String str;
	
	PlaneLabel(int x, int y, String str) {
		this.x = x;
		this.y = y;
		this.str = str;
	}
	@Override
	public void moveTo(int x, int y) { // 잘못된 메소드 movable의 기본 접근제한자가 public
		this.x = x; //여기는 기본 접근제한자가 default로 생성되어 있으니까 public으로 고쳐야 함
		this.y = y;
	}
}
