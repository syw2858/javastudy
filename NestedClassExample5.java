public class NestedClassExample5 {
	public static void main(String args[]) {
		Line line = new Line(0, 0, 100, 100);
		line.move(10, 20);
		printPoint(line.point1);
		printPoint(line.point2);
		Line.Point point = new Line.Point(100,200);
		printPoint(point);
	}
	static void printPoint(Line.Point point) {
		System.out.printf("(%d, %d) %n", point.x, point.y);
	}
}
