package practiseDsa;

import java.util.ArrayList;
import java.util.List;

//Given an array nums of distinct integers, return all unique permutations of the array. The challenge is that you can only use each integer from the original array a maximum of twice in any given permutation.
//For example, if nums = [1, 2, 3], a valid permutation would be [1, 2, 1] but not [1, 1, 1]. The output should not contain duplicate permutations.
//Example 1: Input: nums = [1,2] Output: [[1,2],[2,1],[1,1],[2,2],[1,2,1],[1,2,2],[2,1,1],[2,1,2]]
//Example 2: Input: nums = [1] Output: [[1],[1,1]]
public class test2 {
	
	public static List<List<Integer>> permute(){
		List<List<Integer>> result = new ArrayList<>();
		int[] nums = new int[] {1,2};
		int[] count = new int[nums.length];
		backtrack(result,new ArrayList<>(),nums,count);
		return result;
	}
	
	public static void backtrack(List<List<Integer>> result,List<Integer> temp,int[]nums,int[] count) {
		
		
		if(!temp.isEmpty()) {
			result.add(new ArrayList<>(temp));
//			System.out.println(result);
//			return;
		}
		  if (temp.size() == nums.length +1) {
	            return;
	        }
//		result.add(temp);
		for(int i =0;i<nums.length;i++) {
//			if(temp.contains(i)) {
//				temp.add(i);
//				backtrack(result,temp,nums);
//			}
			
			if(count[i] < 2) {
				count[i]++;			
			temp.add(nums[i]);
			backtrack(result,temp,nums,count);
			temp.remove(temp.size()-1);
			count[i]--;
		}
		}
	}
	
	
	public static void main(String args[]) {
		List<List<Integer>> result1 = permute();
		System.out.println(result1);
	
	}
}

