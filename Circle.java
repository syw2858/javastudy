
public class Circle {
	double radius ; // 필드 
	
	Circle(double radius ) { // 생성자
	this.radius = radius;
	}
	public boolean equals(Object obj) {
		if (!(obj instanceof Circle)) //instanceof는 앞의 객체를 뒤의 클래스 타입으로 캐스트연산이 가능하면 true 반환
			 return false; 
			 Circle circle = (Circle) obj; 
			 if (radius == circle.radius) 
				 return true; 
			 else 
				 return false;
	}
	
	double getArea() { // 메소드
		double area ;
		area = radius * radius * 3.14;
		return area;
	}
}
