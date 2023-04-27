package BubbleSort;

class Sort {
	public void selectionSort(int a[]) {
		int i, j, temp, size, flag;
		size = a.length;
		for(i=0; i<size-1; i++) {
			System.out.printf("\n버블 정렬 %d 단계 : ", i+1);
			flag = 0; //의미없는 과정을 반복하는 것을 막아주기 위한 용도
			for(j=0; j<size-1-i; j++) {
				if(a[j] > a[j+1]) { //오름차순(부등호만 바꾸면 내림차순)
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
					flag = 1; //값에 변화가 있다는 의미
				}
			}
			for(int k=0; k<size; k++)
				System.out.printf("%3d ", a[k]);
			if(flag == 0)
				break; //flag값의 변화 체크
		}
	}
}
public class ex9 {
	public static void main(String args[]) {
		int a[] = {69,10,30,2,16,8,31,22};
		Sort S = new Sort();
		System.out.printf("\n정렬할 원소 : ");
		for(int i=0; i<a.length; i++)
			System.out.printf(" %d", a[i]);
		System.out.println();
		S.selectionSort(a);
	}
}
