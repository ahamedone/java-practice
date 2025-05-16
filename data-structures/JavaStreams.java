import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreams {
    public static void main(String[] args){
        List<Double> list = Arrays.asList(98d, 74d, 23d, 129d, 100d);
        long count = list.stream().peek(System.out::println).filter(x -> x > 0).count();
        System.out.println("Total Count : " + count);

        Stream<Double> stream = Stream
                                    .generate(()-> { return Math.random() * 100; })
                                    .peek(System.out::println)
                                    .limit(10);
        stream.forEach(System.out::println);

        Stream<String> strStream = Stream.of("Car", "Bus", "Train", "Aeroplane");
        int length = strStream
                        .reduce(0, (n, str)-> n+str.length(), Integer::sum);
        System.out.println(length);

        String name = Stream.of("s", "t", "r", "e", "a", "m")
                        .reduce("", String::concat);
        System.out.println(name);

        Stream.of("s", "t", "r", "e", "a", "m","o").reduce(String::concat).ifPresent(System.out::println);

        List<String> numbers = Arrays.asList("Azhar", "Jasmin", "Fatima", "Azeem");
        String sum = numbers.parallelStream().reduce("a", (x, y) -> y.concat("-"), String::concat) ;
        System.out.println(sum);
    }
}
