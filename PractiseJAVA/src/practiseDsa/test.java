package practiseDsa;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class test {
	public static int consecutive(){
	List<Integer> list1 = new ArrayList<>(Arrays.asList(5,2,1,3));
		Collections.sort(list1);
		
		int count = 1;
		for(int i=0;i<list1.size()-1;i++) {
			if(list1.get(i) + 1 == list1.get(i+1)){
				count++;
			}
		}
		return count;
	}
	
	public static int missingNumber() {
		int sum=0,arrsum=0,n=5;
		int arr[] = new int[] {1,2,4,5,6};
		for(int i =1;i<=n;i++) {
			sum = sum + i;
			arrsum =arrsum + arr[i-1];
		}
		
		return arrsum - sum;
	}
	
	public static int duplicate() {
		int arr[] = new int[] {1,2,5,4,6,5};
//		Arrays.sort(arr);
//		int duplicateValue = 0;
//		for(int i=0;i<arr.length;i++) {
//			for(int j=0;j<arr.length;j++) {
//				if(j==i) {
//					continue;
//				}
//				if(arr[i] == arr[j]) {
//					duplicateValue =  arr[i];
//				}
//			}
//		}
//		return duplicateValue;
		
		Set<Integer> numset = new HashSet<>();
		for(int num : arr) {
			if(!numset.add(num)) {
				return num;
			}
		}
		return -1;
	}
	
	public static int secondLarget() {
		Integer arr[] = new Integer[]{1,2,5,4,6,5};
		Arrays.sort(arr,Collections.reverseOrder());
		return arr[1];
		
	}
	
	public static int largestWithoutSort() {
		int arr[] = new int[] {1,2,5,4,6,5};
		int max = arr[0];
		
		for(int i=1;i<arr.length-1;i++) {
			if(max<arr[i]) {
				max = arr[i];
			}
		}
		return max;
	}
	
	
	public static int[] vowelsConsonants() {
		int vowels=0,consonants=0;
		int arr[] = new int[5];
		String str = "Tharun";
		for(char ch : str.toLowerCase().toCharArray()) {
			if(ch =='a' || ch == 'e' || ch=='i' || ch=='o'||ch=='u') {
				vowels++;
			} else if(ch>'0' && ch<'9'){
				continue;
			}else {
			
				consonants++;
			}
		}
		arr[0] = vowels;
		arr[1] = consonants;
		return arr;
	}
	
	public static int reverseNumber() {
		int newNumber = 987,reversed=0;
		
		while(newNumber  > 0) {
			int d = newNumber % 10;
			reversed = reversed *10 + d;
			newNumber /= 10;
		}
		return reversed;
	}
	
	public static int secondLargest1() {
		List<Integer> arrlist = new ArrayList<>(Arrays.asList(1,2,5,4,6,5));
//		Collections.sort(arrlist);
		arrlist.sort((s1,s2)->s2.compareTo(s1));
		return arrlist.get(1);
	}
	
	public static int removeDuplicate() {
		Set<Integer> unique = new HashSet<>();
		int arr[] = new int[] {1,2,3,5,4,4,6,5};
		for(int ar : arr) {
			if(!unique.contains(ar)) {
				unique.add(ar);
			}
		}
		return unique.size();
	}
	
	public static char firstNonRepeatedCharacter() {
		String str = "THHARUNNN";
		str = str.toLowerCase();
		
		Map<Character,Integer> freq = new LinkedHashMap<>();
		
		for(char ch : str.toCharArray()) {
			freq.put(ch,freq.getOrDefault(ch, 0)+1);
		}
		
		for(Map.Entry<Character,Integer> entry : freq.entrySet()) {
			if(entry.getValue() == 1) {
				return entry.getKey();
			}
		}
		return 0;
	}
	
	
//	Rotate ARRAY
	
	public static int[] rotateArray() {
		int arr[] = new int[] {1,2,3,4,5};
		int k = 3;
		for(int i=0;i<k;i++) {
			int temp = arr[arr.length-1];
			for(int j=arr.length-1;j>0;j--) {
				arr[j] = arr[j-1];
			}
			arr[0] = temp;
		}
		return arr;
	}
//	Finding Frequnecy
	
	public static Map<Integer,Integer> frequency(){
		int arr[] = new int[]{1,2,3,5,4,4,6,5,3,3,3,3};
		Map<Integer,Integer> freq = new HashMap<>();
		
		for(int i : arr) {
			freq.put(i,freq.getOrDefault(i, 0) + 1);
		}
		
		return freq;
	}
	
	public static boolean anagrams() {
		String str1 = "listen";
		String str2 = "sient";
		char[] ch1 = str1.toCharArray();
		char[] ch2  = str2.toCharArray();
		Arrays.sort(ch1);
		Arrays.sort(ch2);
		
		return Arrays.equals(ch1,ch2);
	}
	
	public static int maximumSubArraySum() {
		int arr[] = new int[] {-2,7, -3, 4, -1, -2, 1, 5, -3};
		int max = arr[0];
		int currentSum = arr[0];
		for(int i = 0 ;i < arr.length; i++) {
			currentSum  = Math.max(arr[i],currentSum + arr[i]);
			max = Math.max(currentSum, max);	
		}
		return max;
		
	}
	
//	SLiding WInDoW	
	public static int maxSubArray() {
		int arr[] = new int[] {};
		int k =3;
		int sumarr = 0;
		
		for(int i =0 ; i<k;i++) {
			sumarr += arr[i];
		}
		
		int maxSum = sumarr;
		int startIndex = 0;
		int endIndex = k;
		while(endIndex<arr.length) {
			sumarr -= arr[startIndex];
			startIndex++;
			
			sumarr += arr[endIndex];
			endIndex++;
			
			maxSum = Math.max(maxSum,sumarr);
		}
		return maxSum;
		
	}
	public static List<List<String>> anagramsList(){
		String words[] = new String[]{"eat","tea","tan","ate","nat","bat"};
		HashMap<String,List<String>> anagrams = new HashMap<>();
		
		for(String word : words) {
			char[] chars = word.toCharArray();
			Arrays.sort(chars);
			String key = new String(chars);
			
			anagrams.putIfAbsent(key,new ArrayList<>());
			anagrams.get(key).add(word);
		}
		return new ArrayList<>(anagrams.values());
		
	}
	

	
	public static void main(String args[]) {
//		int counted = consecutive();
//		System.out.println(counted);
		System.out.println(missingNumber());
		System.out.println(duplicate());
		System.out.println(secondLarget());
		System.out.println("Max-without sort:"+largestWithoutSort());
		int newarr[] = vowelsConsonants();
		System.out.println("Vowels:"+newarr[0]);
		System.out.println("Consonants:"+newarr[1]);
		System.out.println("Reversed:"+reverseNumber());
		System.out.println("Second Largest:"+secondLargest1());
		System.out.println("Removed Duplicates 1,2,5,4,6,5 : " + removeDuplicate());
		System.out.println("First non repeated character:"+firstNonRepeatedCharacter());
		int rotated[] = rotateArray();
		System.out.print("Rotated:");
		for(int r:rotated) {
			System.out.print(r+" ");
		}
		Map<Integer,Integer> freq = frequency();
		System.out.println("Frequency of Each Element");
		for(Map.Entry<Integer,Integer> entry : freq.entrySet()) {
			System.out.println(entry.getKey() + "->" + entry.getValue());
		}
		System.out.println("Listen and sient is :"+ (anagrams() == true ? "Anagram" : "Not Anagram"));
		System.out.println("Maximum Sum of SubArray:"+maximumSubArraySum());
		System.out.println("Anagrams List:"+anagramsList());
	}

}
//Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
//You must write an algorithm that runs in O(n) time.
// 
//Example 1:Input: nums = [100,4,200,1,3,2]
//Output: 4
//Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
//
//Example 2:Input: nums = [0,3,7,2,5,8,4,6,0,1]
//Output: 9