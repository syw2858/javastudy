class Fraction {
	private int numerator; // 분자
	private int denominator; // 분모
	
	Fraction(int numerator, int denominator) { 
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	double getDouble() { //private이 붙은 상태로 두면 AccessControlExample에서 오류
		return (double) numerator / denominator;
	}
	
	int getInt() { 
		return (int) getDouble();
	}
}
