package practiseDsa;

import java.util.Arrays;

//Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
//If target is not found in the array, return [-1, -1].
//You must write an algorithm with O(log n) runtime complexity  Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]
public class test15 {
	public static int[] start() {
		int arr[] = {5,7,7,8,8,10};
		int start=0,k=0,end=0;
		int arrr1[]=new int[10];
		int target = 8;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;i<arr.length;j++) {
				if(i==j) {
					continue;
				}
				if(arr[j]==target && arr[j+1]==target) {
					start = j;
					end=j+1;
					return new int[] {start,end};
				}
			}
		}
		return new int[] {-1,-1};
	}
	public static void main(String args[]) {
		System.out.println(Arrays.toString(start()));
	}
}
