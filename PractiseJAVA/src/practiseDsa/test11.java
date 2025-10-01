package practiseDsa;
//Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.
//Example 1:
//Input: num = 38
//Output: 2
//Explanation: The process is
//38 --> 3 + 8 --> 11
//11 --> 1 + 1 --> 2 
//Since 2 has only one digit, return it.
public class test11 {
	public static int add() {
		int num = 38,n=num,sum = 0;
		while(n > 0) {
			sum +=n%10;
			n=n/10;
			if(sum >9 && n==0) {
				n = sum;
				sum = 0;
			}
		}
		return sum;
	}
	public static void main(String args[]) {
		System.out.println(add());
	}
}


