package practiseDsa;
//Given a signed 32-bit integer x, return x with its digits reversed.
//If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
//Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
//Example 1:
//
//Input: x = 123
//Output: 321
//Example 2:
//
//Input: x = -123
//Output: -321
//Example 3:
public class test14 {
	public static int reverseBits() {
		int x = 123;
		int rev = 0;
		while(x!=0) {
			int d = x%10;
			rev = rev *10 +d;
			x=x/10;
		}
		
		if(rev > (-Math.pow(2, 31)) && rev < Math.pow(2,31)) {
			return rev;
		}
		return 0;
	}
	public static void main(String args[]) {
		System.out.println(reverseBits());
	}
}
