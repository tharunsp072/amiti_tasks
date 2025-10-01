package practiseDsa;

//Given an integer array nums and an integer k, 
//return true if there are two distinct indices i and j in the array 
//such that nums[i] == nums[j] and abs(i - j) <= k.
//Example 1:
//Input: nums = [1,2,3,1], k = 3
//Output: true
//Example 2:
//Input: nums = [1,0,1,1], k = 1
//Output: true
//Example 3:
//Input: nums = [1,2,3,1,2,3], k = 2
//Output: false
public class test7 {
	public static boolean disAbs() {
		int nums[] = new int[]{1,2,3,1};
		int k =3;
		for(int i=0;i<nums.length;i++) {
			for(int j=0;j<nums.length;j++) {
				if(j==i) {
					continue;
				}
				if(nums[i]==nums[j]) {
					int dif = nums[i]-nums[j];
					if(dif < k && Math.abs(dif)<k) {
						return true;
					}
				}
			}
		}
		return false;
	}
	public static void main(String args[]) {
		System.out.println(disAbs());
	}
	
}
