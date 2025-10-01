package practiseDsa;

import java.util.List;
import java.util.Map;
//import java.util.Scanner;

public class CallerClass {
	public static void main(String args[]) {
		
		
		System.out.println(StringManipulation.reverse("Tharun"));
		System.out.println(NumbersManipulation.primeNumber(4));
		int numbers[] = NumbersManipulation.largeAndsmall(new int[] {4,2,3,1,5,6});
		
		System.out.println("Largest number in an array : " + numbers[1]);
		System.out.println("Smallest number in an array : " + numbers[0]);
		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter the String to perfrom check if palindrome or not ");
//		String userInput = sc.nextLine();
//		sc.close();
		System.out.println("The String " + "hel" + " is a " + (StringManipulation.palindrome("hel") ? "Palindrome" :  "Not a Palindrome"));
		
		System.out.print("Fibonacci Series: ");
		NumbersManipulation.fibonacciSeries(5);
		System.out.println();
		for(Map.Entry<Character, Integer> entry : StringManipulation.frequencyOfCharacter("Thrsssasunn").entrySet()) {
			System.out.print(entry.getKey() + ": "+entry.getValue()+" ");
			
		}
		System.out.println();
		
		System.out.println("Second larget: " + NumbersManipulation.secondLargest(List.of(1,2,3,4,5,7,64)));
		
		System.out.print("Numbers after sort: ");
		
		int numbers1[]  = NumbersManipulation.bubbleSort(new int[]{5,7,2,1,7});
		for(int num : numbers1) {
			System.out.print(num+" ");
		}
		
		System.out.println();
		System.out.println("is Anagram = Listen and silent : " + StringManipulation.isAnagram("listen","silent"));
		test9 test = new test9();
		System.out.println(test);
	}
	
	
}
