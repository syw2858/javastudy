
public class ObjectExample07 {
	public static void main(String args[]) {
		SungjukClass obj1 = new SungjukClass();
		obj1.input();
		obj1.process();
		SungjukClass obj2 = (SungjukClass)obj1.clone();
		if (obj1.equals(obj2))
			System.out.println("같음");
		else
			System.out.println("다름");
		
		System.out.println();
		System.out.println(obj1);
		System.out.println(obj2);
	}
}
