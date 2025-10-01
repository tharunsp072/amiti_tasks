	package practiseDsa;
	
	//Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.
	//A string is represented by an array if the array elements concatenated in order forms the string.
	//Example 1:
	//Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
	//Output: true
	//Explanation:
	//word1 represents string "ab" + "c" -> "abc"
	//word2 represents string "a" + "bc" -> "abc"
	//The strings are the same, so return true.
	public class test10 {
		
		public static boolean wordsManipulation() {
//			String[] str1 = new String[] {"ab", "c"};
//			String[] str2 =  new String[] {"a", "bc"};
//			StringBuilder result1 = new StringBuilder();
//			StringBuilder result2 = new StringBuilder();
//			if(str1.length != str2.length) {
//				return false;
//			}
//			for(int i=0;i<str1.length;i++) {
//				result1.append(str1[i]);
//			}
//			for(int i=0;i<str2.length;i++) {
//				result2.append(str2[i]);
//			}
//			if(result1.toString().contains(result2)) {
//				return true;
//			}
//			return false;
			String[] str1 ={"ab", "c"};
			String[] str2 = {"a", "bc"};
			String result1= String.join("", str1);
			String result2 = String.join("", str2);
			return result1.equals(result2);
			
		}
		public static void main(String args[]) {
			System.out.println(wordsManipulation());
		}
	}
