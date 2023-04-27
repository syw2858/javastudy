public class Point3D extends Point {
	int z;
	Point3D(int x, int y, int z) {
		super(x, y);
		this.z = z;
	}
	
	public int getX() { // 잘못된 메소드 부모 클래스인 point에서 접근제한자가 protected여서
		return x;
	}
	
	public int getY() { // 잘못된 메소드
		return y;
	}
	
	int getZ() {
		return y;
	}
}
