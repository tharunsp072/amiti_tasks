package practiseDsa;

import java.util.Optional;

public class OptionalManiupulation {
	
	public static void main(String args[]) {
		String email = "tharunp73@gmail.com";
		
		Optional<String> optionalEmail = Optional.of(email);
		System.out.println(optionalEmail);
		
		Optional<String> optionalEmpty = Optional.empty();
		System.out.println(optionalEmpty);
		
		Optional<String> optionalNullableOf = Optional.ofNullable(null);
//		System.out.println(optionalNullableOf.get());
		
		if(optionalEmail.isPresent()) {
			System.out.println(optionalEmail.get());
		} else {
			System.out.println("No value present");
		}
		
		String defaultOptional = optionalNullableOf.orElse("New value");
		System.out.println(defaultOptional);
		
		String orElseGEtMethod = optionalNullableOf.orElseGet(()->"orElseGet");
		System.out.println(orElseGEtMethod);
		
//		String orELseThrow = optionalNullableOf.orElseThrow(()->new IllegalArgumentException("Email does not exist"));
		
//		System.out.println(orELseThrow);
		
		
		Optional<String> gender = Optional.of("Male");
		
		Optional<String> emptyOptional = Optional.empty();
		gender.ifPresent((s)->System.out.println("value is present"));
		emptyOptional.ifPresent((s)->System.out.println("NO VALUE PRESENT"));
	}
}
