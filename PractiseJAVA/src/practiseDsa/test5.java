//package practiseDsa;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
////Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, 
////and return an array of the non-overlapping intervals that cover all the intervals in the input.
////Example 1:
////Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
////Output: [[1,6],[8,10],[15,18]]
////Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
//public class test5 {
//	public static int[][] mergeIntervals(){
//		int[][] nums = {{1,3},{2,6},{8,10},{15,18}};
//		List<List<Integer>> result = new ArrayList<>();
//		for(int i= 0; i<nums.length-2;i++) {
//				
//				if(nums[i][0] + 1 == nums[i][1]) {
//					nums[i][j+1] = nums[i+1][j];
////					result.add(new ArrayList<>(nums[i][j+1],nums[i+1][j]));
//				}
//		}
//		return nums;
//			
//	}
//	 public int[][] merge(int[][] intervals) {
//	        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
//	        List<int[]> result = new ArrayList<>();
//
//	        int[] current = intervals[0];
//	        for (int i = 1; i < intervals.length; i++) {
//	            if (intervals[i][0] <= current[1]) {
//	                current[1] = Math.max(current[1], intervals[i][1]);
//	            } else {
//	                result.add(current);
//	                current = intervals[i];
//	            }
//	        }
//	        result.add(current);
//
//	        return result.toArray(new int[result.size()][]);
//	    }
//	public static void main(String args[]) {
//		int[][] res = mergeIntervals();
////		List<List<Integer>>result = new ArrayList<>();
//		
//		System.out.println();
//		for(int i=0;i<res.length-2;i++) {
//			for(int j=0;j<res.length-2;j++) {
//				System.out.println(res[i][j]);
//			}
//		}
//	}
//}



package practiseDsa;

import java.util.*;

public class test5 {

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); 
        List<int[]> result = new ArrayList<>();

        int[] current = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= current[1]) { 
                
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                result.add(current);
                current = intervals[i];
            }
        }
        result.add(current);

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] nums = {{1,3},{2,6},{8,10},{15,18}};
        int[][] res = merge(nums);

        for (int[] interval : res) {
            System.out.println(Arrays.toString(interval));
        }
    }
}

