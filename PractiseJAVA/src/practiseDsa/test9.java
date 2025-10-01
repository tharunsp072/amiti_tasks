package practiseDsa;

import java.util.List;

//Given an integer array nums, 
//return true if any value appears at least twice in the array, and return false if every element is distinct. Example 1:
//
//Input: nums = [1,2,3,1]
//Output: true
public class test9 {
	private int i = 10;
	public  List<Integer> repeated() {
		int[] nums = new int[] {1,2,3,1};
		for(int i=0;i<nums.length;i++) {
			for(int j =0;i<nums.length;j++) {
				if(i==j) {
					continue;
				}
				if(nums[i] == nums[j]) {
					return List.of(2,3,5);
				}
			}
		}
		return List.of(2,3,5);
	}
	public static void main(String args[]) {
		test9 test = new test9();
		System.out.println((Object)test.repeated());
	}

}
