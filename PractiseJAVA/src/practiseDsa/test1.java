package practiseDsa;

import java.util.HashSet;
import java.util.Set;

public class test1 {

	public static int longestSubstring() {
		String str ="abcabcbb";
		Set<Character> longestsub = new HashSet<>();
		char[] ch = str.toCharArray();
		
		int startIndex = 0;
		int endIndex = 0;
		int max = 0;
		while(endIndex<str.length()) {
			char c = ch[endIndex];
			if(!longestsub.contains(c)) {
				longestsub.add(c);
				max = Math.max(max, longestsub.size());
			} else {
				endIndex = startIndex;
				startIndex++;
			}
			
		}
		return max;
	}
		public static void main(String args[]) {
			System.out.println("Longest:"+ longestSubstring());
		}
	
}
