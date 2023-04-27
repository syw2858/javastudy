public interface PlaneObject {
	Location getLocation();
	void setLocation(int x, int y);
	static class Location { // 위치 클래스
		int x, y;
		Location(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
