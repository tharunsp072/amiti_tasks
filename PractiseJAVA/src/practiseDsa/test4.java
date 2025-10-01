package practiseDsa;

//Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
//Example:
//Input: nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
//Output: 6
//Explanation: The contiguous subarray [4, -1, 2, 1] has the largest sum = 6.
public class test4 {
	public static int contigousSubArray(){
		
		int nums[] = new int[] {-2,1,-3, 4, -1, 2, 1, -5, 4};
		int currentMax = nums[0];
		int max = nums[0];
		for(int i=0;i<nums.length-2;i++) {
			currentMax = Math.max(nums[i], currentMax + nums[i]);
			max = Math.max(currentMax, max);
		}
		return max;
	}
	public static void main(String args[]) {
		System.out.println(contigousSubArray());
	}
}
