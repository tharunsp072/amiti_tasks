package practiseDsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
//import java.util.Set;

//interface Car{
//	void start();
//	void stop();
//}
public class StringManipulation {
	
	public static String reverse(String original) {
		StringBuilder reversedString = new StringBuilder(original).reverse();
		return reversedString.toString();
	}
	
	public static boolean palindrome(String testingString) {
		String lowerCased = testingString.toLowerCase();
		String reversedString = new StringBuilder(lowerCased).reverse().toString();
		if(lowerCased.equals(reversedString)) {
			return true;
		}
		return false;
	}
	
	
	public static Map<Character,Integer> frequencyOfCharacter(String testString){
		Map<Character, Integer> frequencies = new HashMap<>();
		for(char c : testString.toCharArray()) {
			frequencies.put(c,frequencies.getOrDefault(c, 0) + 1);
		}
		return frequencies;
	}
	
	public static boolean isAnagram(String str1,String str2) {
		if(str1.length() != str2.length())return false;
		
		char[] arr1 = str1.toLowerCase().toCharArray();
		char[] arr2 = str2.toLowerCase().toCharArray();
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		return Arrays.equals(arr1,arr2);
		
	}
	
	
//	permutations using string
	public static void permute(String str , String ans){
		
			if(str.length() == 0) {
				System.out.println(ans);
				return ;
			}
			
			for(int i=0;i<str.length();i++) {
				char ch = str.charAt(i);
				
				String rest = str.substring(0,i) + str.substring(i+1);
				
				permute(rest,ans + ch);
			}
		
			
	}
	
//	public static String longestSubStringWithoutRepeatingCharacters() {
//		String str = "My name is emma";
//		char[] ch = str.toCharArray();
//		Set<Character> charSet = new HashSet<>();
//		for(char c : ch) {
//			if(!charSet.contains(c)) {
//				charSet.add(c);
//			}
//		}
//	}
	
	
	public static  String reverseWithoutBuiltin() {
		String str = "tharun";
		char ch[] = str.toCharArray();
		StringBuilder str1 = new StringBuilder();
		for(int  i = str.length()-1;i>=0;i--) {
			str1.append(String.valueOf(ch[i]));
		}
		return str1.toString();
	}
	
	public  static HashSet<String> findAnagrams(String s, String p) {
        HashSet<String> anagrams = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i+3<s.length();i++){
            String temp = s.substring(i,i+p.length());
            if(!anagrams.contains(temp) && temp.equals(p) ){
            	anagrams.add(temp);
                list.add(i);
            }
        }
//        return list;
        return (anagrams);
    }
	
	public static void main(String args[]) {
		System.out.println(findAnagrams("cbaebabacd", "abc"));
	}


}
