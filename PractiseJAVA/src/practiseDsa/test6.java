package practiseDsa;


//An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
//
//Given an integer n, return the nth ugly number.
//Example 1:
//
//Input: n = 10
//Output: 12
//Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.
//Example 2:
//
//Input: n = 1
//Output: 1
//Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
public class test6 {
	public static int uglyNumber() {
		int n =10;
		int nums[] = new int[20];
		int k = 1;
//		int j=0;
		nums[0]=1;
//		if(n == 1) {
//			return 1;
//		}
		for(int i=2;i<n+3;i++) {
			if(i% 2 == 0 || i %3 ==0 || i%5 ==0 ) {
				nums[k++] = i;
				
			} 		}
		return nums[n-1];
	}
	public static void main(String args[]) {
		System.out.println(uglyNumber());		
	}
	
}
