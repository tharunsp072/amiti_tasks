package practiseDsa;

import java.util.Arrays;

//Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
//The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
//You must write an algorithm that runs in O(n) time and without using the division operation.  Example 1:
//Input: nums = [1,2,3,4]
//Output: [24,12,8,6]
//Example 2:
//
//Input: nums = [-1,1,0,-3,3]
//Output: [0,0,9,0,0]
public class test3 {
	
	public static int[]  productArray() {
		int arr[] = new int[] {1,2,3,4};
		int product[] = new int[arr.length];
		for(int i=0;i<arr.length;i++) {
			product[i] = 1;
			for(int j =0;j<arr.length;j++) {
				if(j==i) {
					continue;
				}
				product[i] *= arr[j];
			}
		}
//		for( int i : product) {
//			System.out.println(i);
//		}
		return product;
	}

	public static void main(String args[]) {
		int[] finalArr = productArray();
		System.out.println(Arrays.toString(finalArr));
	}
}
