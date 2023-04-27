public class Rectangle implements PlaneObject {
	Location location;
	int width, height;
	Rectangle(int x, int y, int width, int height) {
		this.location = new Location(x, y); //상속받은 정적 네스티드 클래스의 생성자 호출
		this.width = width;
		this.height = height;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(int x, int y) {
		location.x = x; //정적 네스티드 클래스의 필드 사용
		location.y = y;
	}
}
