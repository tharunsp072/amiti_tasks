package practiseDsa;

//Given a string, count the number of words ending in 'y' or 'z'-- so the 'y' in "heavy" and the 'z' in "fez" count,
//but not the 'y' in "yellow"
//exsmple: fez day --------> 2, yo fez--------> 1
public class test16 {
	public static int find() {
		String str = "fez day way nay";
		int count=0;
		String splits[] = str.split(" ");
		for(String word : splits) {
			if(word.charAt(word.length() -1) == 'z' || word.charAt(word.length() -1) == 'y') {
				count++;
			}
		}
		return count;
	}
public static void main(String args[]) {
	System.out.println(find());
}
}
