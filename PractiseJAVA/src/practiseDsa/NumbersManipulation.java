package practiseDsa;

import java.util.ArrayList;
//import java.util.Collections;
import java.util.List;

public class NumbersManipulation {
	
	public static boolean primeNumber(int num) {
		if(num == 1 || num ==  2 || num == 3) {
			return true;
		}
		for(int i = 2; i * i<= num; i++) {
			if(num % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public static int[] largeAndsmall(int[] num) {
		int small = num[0];
		int large = num[0];
		for(int i = 1;i <num.length;i++)
		{
			if(small > num[i]) {
				small = num[i];
			} else if(large < num[i]) {
				large = num[i];
			}
		}
		return new int[] {small,large};
	}
	
	public static void fibonacciSeries(int n) {
		int a = 0 ,b =1;
		for(int i =0;i<n;i++) {
			System.out.print(a + ", ");
			int next = a + b;
			a = b;
			b = next;
		}
		
	}
	
	public static int secondLargest(List<Integer> num) {
		List<Integer> nums = new ArrayList<>(num);
		nums.sort((s1,s2)-> s2.compareTo(s1));
		return nums.get(1);
	}

	public static int[] bubbleSort(int[] nums) {
		for(int i=0;i<nums.length-1;i++) {
			for(int j=0;j<nums.length-i-1;j++) {
				if(nums[j]>nums[j+1]) {
					int temp = nums[j];	
					nums[j] = nums[j+1];
					nums[j+1] = temp;
				}
			}
		}
		return nums;
	}
	
	
	public static List<List<Integer>> permute(int[]nums){
		List<List<Integer>> result = new ArrayList<>();
		backtrack(result,new ArrayList<>(),nums);
		return result;
	}
	
	private static void backtrack(List<List<Integer>> result,ArrayList<Integer> temp,int[]nums) {
		if(temp.size() == nums.length) {
			result.add(new ArrayList<>(temp));
			return;
		}
		for(int num :nums){
//			if(temp.contains(num))
//				continue;
			temp.add(num);
			backtrack(result,temp,nums);
			temp.remove(temp.size()-1);
			
		}
	}
	
	
	public static void generateSubsets(int[] nums) {
		List<List<Integer>> resultList = new ArrayList<>();
		backtrackSubsets(resultList,new ArrayList<>(),nums,0);
	}
	
	public static void backtrackSubsets(List<List<Integer>> result,ArrayList<Integer> temp,int[]nums,int start) {
		result.add(new ArrayList<>(temp));
		for(int i=start;i<nums.length-1;i++) {
			temp.add(i);
			backtrackSubsets(result, temp, nums, i+1);
			temp.remove(temp.size()-1);
		}
	}
	
	
	public static int factorialUsingRecursion(int n) {
		if(n==0 || n==1) {
			return 1;
		}
		
		return n * factorialUsingRecursion(n-1);
	}
	
//	
//	public static int[] twoSortedIntoSingleSorted() {
//		int arr[] = new int[] {1,3,4,6,7};
//		int arr1[] = new int[] {2,5,8};
//		for(int i = 0;i<)
//	}
	
	
	public static boolean mirrorInverseArray() {
		int arr[] = new int[] {3,4,2,0,1}; // this is a real mirror array
		for(int i = 0;i<arr.length;i++) {
			if(arr[arr[i]] != i) {
				return false;
			}
		}
		return true;
	}
	
	public static int[] sumOfArrayExceptSelf() {
		int arr[] = new int[]{1,2,3,4};
		int res[] = new int[] {arr.length};
		for(int i = 0;i<arr.length;i++) {
//			res[i] = 1;
			for(int j=0;j<arr.length;i++) {
				if(j==i) {
					continue;
				}
				res[i] += arr[j];
			}
		}
		return res;
		
	}
	
	public static int contiguosSubArrayWithLargestProduct() {
		int arr[] = new int[] {1,2,4,-3,6,1};
		int maxproduct = 1;
		int start = 0,end =0;
		int currmax = 1;
		while(end<arr.length) {
			currmax = Math.max( currmax,currmax * arr[end]);
			if(currmax > maxproduct) {
				end++;
				maxproduct = currmax;
			} else 
			{
				start++;
				currmax = 0;
			}
		}
		return maxproduct;
	}
	
//	Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
//
//			 
//
//			Example 1:
//
//			Input: nums = [1,2,3]
//			Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//			Example 2:
//
//			Input: nums = [0,1]
//			Output: [[0,1],[1,0]]
//			Example 3:
//
//			Input: nums = [1]
//			Output: [[1]]
	
	class Solution {
	    public List<List<Integer>> permute(int[] nums) {
	        List<List<Integer>> result = new ArrayList<>();
	        boolean[] used =  new boolean[nums.length];
	        backtrack(result,new ArrayList<>(),nums,used);
	        return result;
	    }

	    public void backtrack(List<List<Integer>> result,List<Integer> temp,int[] nums,boolean[] used){
	        if(temp.size() == nums.length ){
	            result.add(new ArrayList<>(temp));
	            return;
	        }

	        for(int i=0;i<nums.length;i++){
	            if(used[i]) continue;
	            temp.add(nums[i]);
	            used[i] = true;
	            backtrack(result,temp,nums,used);
	            used[i] = false;
	            temp.remove(temp.size()-1);
	        }
	    }
	}
}
