package practiseDsa;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import java.util.*;
interface Car{
	void start();
	void stop();
} // now since I have defined two abstract methods in the interface ,if I implement this interface in this class
// even though it isnt necessary I have to implement both the methods compulsorily to compile the class

@FunctionalInterface
interface Operation {
//	void execute();//abstract method
//	void newExecute(); cannot define another abstract method once the interface is been annotated as functionalInterface
	int apply(int a,int b); // even this is an abstract method
	public default void display() { // these default methods belong to the objects and can be overridden
		System.out.println("This is a functional interface");
	}
	
	public static void info() { //these static methods cannot be overridden and belong to the interface not the instance and is called using the interface name
		System.out.println("This is a Operations Interface");
	}
}

@FunctionalInterface
interface Printable {
	void print(String msg);
}
public class JAVA8 {
	
//	Functional interface is a interface that contains exactly one abstract method. 
//	It can have any number of default, static methods but can have only one abstract method
	
	public static int addition(int a , int b) {
		return a + b;
	}
	
	public   void display(String msg) {
		System.out.println(msg);
	}
	
	public static void main(String args[]) {
		
		//lambda expression has no name
		//it has a parameter list
		//body is the main part of the function
		//no return type is specified-the java8 compiler infer the return type by checking the code
		Operation add = (a,b)->a+b;
		Operation subtract = (a,b)->a-b;
		Operation multiply = (a,b)->a*b;
		Operation divide = (a,b)->a/b;
		
		List<Operation> operations = List.of(add,subtract,multiply,divide);
		int x = 15,y=5;
		for(Operation  i : operations) {
			System.out.println(i.apply(x, y));
			i.display();
			Operation.info();
		}
		
//		PRE Defined functional Interface
//		Function can be accessed by importing the package java.util.function.Function
//		This function accepts one input and returns one output
//		And consists of apply abstract method where one can use .apply to access the method implementation which is defined under Function
		Function<String,Integer> strLength = (String s )->s.length();
		System.out.println("THARUN string length is: " + strLength.apply("THARUN"));
		
//		Consumer FI consists of abstract method called accept;
//		This FI accepts a single input and doesnt return anything;
		
		Consumer<String> consume = (String s)->System.out.println(s+" from Consumer FI");
		consume.accept("Hello");
		
		Supplier<Integer> supply  = ()->5;
		System.out.println(supply.get());
		
		
//		I. Convert a methodReference to a static method
//		1.Lambda Expression
		Function<Integer,Double> function = (Integer input)->Math.sqrt(input);
		System.out.println("Static Method:"+function.apply(4));
		
//		2.Method Reference
		
		Function<Integer,Double> functionMethodRef = Math::sqrt;
		System.out.println("Functional method Reference"+functionMethodRef.apply(4));
		
//		using method reference to call a static method
//		this is how you implement a functional interface  in a  method reference
//		way by making use of already defined static method 
		
		BiFunction<Integer,Integer,Integer> biFunction = JAVA8::addition;
		System.out.println("Addition using method reference:"+biFunction.apply(2,3));
		
		
//		II. Method reference to an instance method of an object
//		using lambda
		JAVA8 java = new JAVA8();
		Printable print = (msg)->java.display(msg);
		print.print("THARUn");
		
//		using method reference
		
		Printable print1 = java::display;
		print1.print("NEw TARHU");
	}


}
