package SelectedSort;

class Sort {
	public void selectionSort(int a[]) {
		int i, j;
		for(i=0; i<a.length-1; i++) {
			for(j=i+1; j<a.length; j++) {
				if(a[i] > a[j]) { //오름차순(부등호만 바꾸면 내림차순)
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
			System.out.printf("\n선택 정렬 %d 단계 : ", i+1);
			for(j=0; j<a.length; j++)
				System.out.printf("%3d ", a[j]);
		}
	}
}

public class ex09 {
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
