package geometry.polygon;

public class Square {
	public int sideLength; //필드
	
	public Square(int sideLength) {  //생성자
		this. sideLength = sideLength;
	}
	public double getArea() {   //메소드
		return sideLength * sideLength;
	}
}
