package practiseDsa;

import java.util.Arrays;

//Given an integer array nums, move all 0's to the end of 
//it while maintaining the relative order of the non-zero elements.
//Note that you must do this in-place without making a copy of the array.
//Example 1:
//Input: nums = [0,1,0,3,12]
//Output: [1,3,12,0,0]
//Example 2:
//Input: nums = [0]
//Output: [0]
public class test8 {
	public static int[] moveZeros() {
		int[] nums = new int[] {0,1,0,3,12};
		if(nums.length == 0) {
			return nums;
		}
		int k = nums.length-1;
		for(int j=0;j<nums.length-1;j++) {
		for(int i=0;i<nums.length-1;i++) {
			if(nums[i] == 0) {
				int temp = nums[i];
				nums[i] = nums[i+1];
				nums[i+1] = temp;
			} else {
				continue;
			}
		}
		}
		return nums;
	}
	public static void main(String args[]) {
		System.out.println(Arrays.toString(moveZeros()));
	}

}
