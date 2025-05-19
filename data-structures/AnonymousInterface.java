import java.util.function.Predicate;
import java.util.function.BiPredicate;
import java.util.function.Supplier;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.BiFunction;
import java.util.function.UnaryOperator;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.Map;

import java.util.List;
import java.util.ArrayList;

class AnonymousInterface {
	public static void main(String[] args){
		I lambdaInstance = () -> System.out.println("Lambda");
		Predicate<String> predicate = s -> s.contains("City");
		BiPredicate<String, String> biPredicate = (x, y) -> x != null && x.equals(y);
		System.out.println("Predicate : " + predicate.test("Vatican City"));
		System.out.println("BiPredicate : " + biPredicate.test("a" , "a"));

		Supplier<String> supplier = () -> {return "Learning Java Anonymoud Class";};
		System.out.println(supplier.get());


		Consumer<String> consumer = (a) -> { System.out.println("Consumer Output : " + a); };
		consumer.accept("Azhar");
		lambdaInstance.m();

		List<String> map = new ArrayList<String>();
		map.add("Azhar 1"); map.add("Azhar 2");
		map.forEach(System.out::println);

		Function<String, Integer> function = x -> x.length();
		System.out.println("Function : " + function.apply("India"));

		BiFunction<String, String, String> biFunction = (x, y) -> x.concat(y);
		System.out.println("BiFunction : " + biFunction.apply("India ", "Bharath"));

		UnaryOperator<String> unaryOperator = x -> x.toUpperCase();
		System.out.println("Uniary Operator : " + unaryOperator.apply("Azhar"));

		BinaryOperator<String> binaryOperator = (x, y) -> x.concat(y);
		System.out.println("BiFunction : " + binaryOperator.apply("India ", "Bharath"));

		String testing = "Azhar";
		BiFunction<String, String, Boolean> testing1 = String::equals;

		System.out.println("Testing after the method reference : " + testing1.apply("Azhar", null));

		Supplier<Integer> supplierInt = Person::howMany;
		Function<Person, Integer> functionInt = Person::howMany;
		BiFunction<Person, Person, Integer> biFunctionInteger = Person::howMany;

		System.out.println(" supplierInt : " + supplierInt.get());
		System.out.println(" functionInt : " + functionInt.apply(new Person()));
		System.out.println(" biFunctionInteger : " + biFunctionInteger.apply(new Person(), new Person()));

		Stream<String> names = Stream.of("Joe", "Mark", "Issac", "Alan", "Randy", "Peter");
		Map<Integer, List<String>> lengthNameMaps = names
														.collect(Collectors.groupingBy(String::length));
		System.out.println(lengthNameMaps);



		// Partioning By
		Stream<String> names1 = Stream.of("Joe", "Mark", "Issac", "Alan", "Randy", "Peter", "Abhraham", "Aady");
		Map<Boolean, List<String>> partioningMap = names1.collect(Collectors.partitioningBy(s-> s.startsWith("A")));
		System.out.println(partioningMap);


	}
}

interface I{
	void m();
}

class Person {
	public static Integer howMany(Person people){
		return 1;
	}

	public static Integer howMany(Person people1, Person people2){
		return 2;
	}

	public static Integer howMany(){
		return 0;
	}


}