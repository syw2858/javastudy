package BinarySearch;

public class ex12 {
	//이진 검색은 정렬된 데이터 사용할 것
	static int[] arr = {1, 3, 5, 7, 8, 10, 20, 35, 99, 100};
	static int cnt = 0;
	public static void main(String args[]) {
		System.out.println("1. 순환 호출을 이용한 이진 탐색");
		System.out.println(binarySearch1(5, 0, arr.length-1));
		
		System.out.println("\n2. 반복을 이용한 이진 탐색");
		System.out.println(binarySearch2(5, 0, arr.length-1));
		
	}
	//재귀구조
	static int binarySearch1(int key, int low, int high) {
		int mid;
		if(low <= high) {
			mid = (low + high)/2;
			
			if(key == arr[mid]) { //탐색 성공
				System.out.println("검색 횟수 : " +ex12.cnt);
				return mid;
			}
			else if(key < arr[mid]) {
				return binarySearch1(key, low, mid-1); //왼쪽 부분 탐색
			}
			else {
				return binarySearch1(key, mid+1, high); //오른쪽 부분 탐색
			}
		}
		System.out.println("검색 횟수 : " +ex12.cnt);
		return -1; //탐색 실패
	}
	//반복구조
	static int binarySearch2(int key, int low, int high) {
		int mid;
		int cnt = 0;	
		
		while(low <= high) {
			cnt++;
			mid = (low + high)/2;
			
			if(key == arr[mid]) {
				System.out.println("검색 횟수 : " +cnt);
				return mid;
			}
			else if(key < arr[mid]) {
				high = mid - 1;
			}
			else {
				low = mid + 1;
			}
		}
		System.out.println("검색 횟수 : " +cnt);
		return -1; //탐색 실패
	}
}
