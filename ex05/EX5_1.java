package ex05;

public class EX5_1 {
	public static void main(String args[]) {
		int sale [][] = {{63,84,140,130}, 
						{157,209,251,312}};
		for(int i=0; i<2; i++) {
			for(int j=0; j<4; j++)
			System.out.printf("%d/4분기 : sale[%d][%d]= %d %n", j+1, i, j, sale[i][j]);
			System.out.println();
		}
	}
}
