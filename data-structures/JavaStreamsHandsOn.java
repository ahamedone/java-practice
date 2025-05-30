import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreamsHandsOn {
    public static void main(String[] args) {
        // Stream a list of int primitives between the range of 0 (inclusive) and 5 (exclusive). Calculate and output the average
        IntStream numbers = IntStream.range(1,5);
        OptionalDouble avg = numbers.average();
        avg.ifPresent(System.out::println);

        /*
            Given the Item class (in the zip file), declare a List typed for Item with the following Item’s:
                a. id=1 name=”Screw”
                b. id=2 name=”Nail”
                c. id=3 name=”Bolt”
                Stream the list and sort it so that it outputs “BoltNailScrew” i.e. alphabetic name order. Use Stream’s
                forEach method to output the names (use the method reference version for the required Consumer lambda).
         */

        List<Item> items = List.of(new Item(1, "Screw"), new Item(2, "Nail"), new Item(3, "Bolt"));
        items.stream().sorted(Item::compareTo).forEach(System.out::print);

        /*
        Generate a Stream<List<String>> using the Stream.of(Arrays.asList(“a”, “b”), Arrays.asList(“a”,
        “c”)) method call. Filter the stream so that only list’s that contain “c” make it through the filter.
        Flatten the Stream<List<String>> to a Stream<String> using the flatMap() operation. Note that
        flapMap() states in the API “Each mapped stream is closed after its contents have been placed into
        this [new] stream.”. Use forEach() to output the new stream.
        */
        System.out.println("\n" + "*".repeat(20));
        Stream<List<String>> stream = Stream.of(Arrays.asList("a", "b"), Arrays.asList("a", "c"));
        Stream<String> flattenStream = stream.filter(x -> x.contains("c")).flatMap(Collection::stream);
        flattenStream.forEach(System.out::print);

        /*
        There are several parts to this:
        a. Using 1, 2 and 3 create a List of Integers.
            i. Stream the list and calculate the sum, using the sum() method from IntStream.
            ii. Stream the list again and calculate the maximum value, using the max() method from IntStream.
        b. Given the Person class (in the zip file), declare a List typed for Person with the following Person’s:
            i. “Alan”, “Burke”, 22
            ii. “Zoe”, “Peters”, 20
            iii. “Peter”, “Castle”, 29
           Using the max(Comparator) from Stream, calculate the oldest person in the list.
        c. Using 10, 47, 33 and 23 create a List of Integers. Stream the list and using the following versions of reduce(), calculate the maximum value:
            i. Optional<T> reduce(BinaryOperator<T> accumulator)
            ii. T reduce(T identity, BinaryOperator<T> accumulator)
         */

        System.out.println("\n" + "*".repeat(20));
        List<Integer> listOfIntegers = List.of(1, 2, 3);
        int sum = listOfIntegers.stream().mapToInt(x -> x).sum();
        System.out.println("Sum : " + sum);
        int max = listOfIntegers.stream().mapToInt(x -> x).max().orElse(0);
        System.out.println("Max : " + max);

        List<Person1> person1List = List.of(new Person1("Alan", "Burke", 22),
                                            new Person1("Zoe", "Peters", 20),
                                            new Person1("Peter", "Castle", 29));
        Person1 oldestPerson = person1List.stream().max(Person1::compareTo).orElse(null);
        System.out.println("Oldest person : " + oldestPerson);

        Optional<String> grade1 = getGrader(50);
        System.out.println("Grade1 : " + grade1.orElse("UNKNOWN"));
        Optional<String> grade2 = getGrader(50);
        if (grade2.isPresent()) {
            grade2.ifPresent(System.out::println);
        } else {
            System.out.println(grade2.orElse("Empty"));
        }

        /*
        6. Given the Book class (in the zip file), declare a List typed for Book with the following Book’s:
            a. title=”Thinking in Java”, price=30.0
            b. title=”Java in 24 hrs”, price=20.0
            c. title=”Java Recipes”, price=10.0
            Stream the books and calculate the average price of the books whose price is > 10.
            Change the filter to books whose price is > 90. Ensure you do not get an exception.
         */

        List<Book> bookList = List.of(  new Book("Thinking in Java", 30.0F),
                                        new Book("Java in 24 hrs", 20.0F),
                                        new Book("JAva Recipes", 10.0F));

        double avg1 = bookList.stream()
                      .filter( n -> n.price > 90)
                      .mapToDouble(n -> n.price)
                      .average().orElse(0);
        double avg2 = bookList.stream()
                    .filter( n -> n.price > 90)
                            .collect(Collectors.averagingDouble( n-> n.price));
        System.out.println("Books Avg : " + avg1 + " : " + avg2);

        /*
        Given the Book class (in the zip file), declare a List typed for Book with the following Book’s:
            a. title=”Atlas Shrugged”, price=10.0
            b. title=”Freedom at Midnight”, price=5.0
            c. title=”Gone with the wind”, price=5.0
        Stream the books and instantiate a Map named ‘bookMap’ that maps the book title to its price.
        To do this use the collect(Collectors.toMap(Function fnToGetKey, Function fnToGetValue)).
        Iterate through ‘bookMap’ (using the Map forEach(BiConsumer) method).
        The BiConsumer only outputs prices where the title begins with “A”
         */

        List<Book> bookList1 = List.of( new Book("Atlas Shrugged", 10.0F),
                                        new Book("Freedom at Midnight", 5.0F),
                                        new Book("Gone with the wind", 5.0F));
        Map<String, Float> bookMap = bookList1.stream().collect(Collectors.toMap(Book::getTitle, Book::getPrice));
        System.out.println(bookMap);
        bookMap.entrySet().stream()
                .filter(e -> e.getKey().startsWith("A"))
                .forEach(e -> System.out.println(e.getValue()));

        /*
        8. Given the Book class (in the zip file), declare a List typed for Book with the following Book’s:
            a. title=”Gone with the wind”, price=5.0
            b. title=”Gone with the wind”, price=10.0
            c. title=”Atlas shrugged”, price=15.0
            In a pipeline which has no return type: (QID 2.1847)
                 stream the books
                 using the collect() method, generate a Map that maps the book title to its price
                 using forEach(), output the title and price of each entry in the map
            What happened and why? Fix this by using the Collectors.toMap(Function, Function, BinaryOperator) method.
         */

        List<Book> bookList2 = List.of( new Book("Gone with the wind", 5.0F),
                                        new Book("Gone with the wind", 10.0F),
                                        new Book("Atlas shrugged", 15.0F));
        bookList2.stream()
                .collect(Collectors.toMap(Book::getTitle, Book::getPrice, Float::sum))
                .forEach((k, v) -> System.out.println(k + " : " + v));

        /***
         * Given the Person class (in the zip file), declare a List typed for Person with the following Person’s:
         * a. name=”Bob”, age=31
         * b. name=”Paul”, age=32
         * c. name=”John”, age=33
         * Pipeline the following where the return type is double: (QID 2.1810)
         *  stream the people
         *  filter the stream for Person’s whose age is < 30
         *  map to int primitives
         *  calculate the average age.
         * This should generate a NoSuchElementException. Using orElse(), fix the pipeline (not the filter) so that 0.0 is returned instead of an exception being generated.
         */

        List<Person1> person1List2 = List.of(new Person1("Bob", "", 31), new Person1("Paul", "Burke", 32), new Person1("John", "", 33));
        OptionalDouble averageAge = person1List2.stream().filter(x -> x.age >= 30).mapToInt(x -> x.age).average();
        System.out.println("Average Age : " + averageAge.orElseGet(()->0.0));



    }
    /*
        Code a method public static Optional<String> getGrade(int marks)
            a. in the method getGrade:
                i. declare an empty optional, typed for String called grade
                ii. insert the following code:
                    if (marks > 50) {grade = Optional.of(“PASS”);} else {grade.of(“FAIL”);}
            b. in main():
                i. declare an Optional, typed for String named grade1 which is initialised to the return value of calling getGrade(50)
                ii. declare an Optional, typed for String named grade2 which is initialised to the return value of calling getGrade(55)
                iii. using orElse() on grade1, output the value of grade1 or “UNKNOWN”
                iv. if(grade2.isPresent()) is true: use ifPresent(Consumer) to output the contents of grade2; if false, use orElse() to output the contents of grade2 or “Empty”
                v. Notes:
                    1. Optional’s are immutable.
                    2. Optional.of(null); // NullPointerException
                    3. Optional.ofNullable(null); // Optional.empty returned
         */
    public static Optional<String> getGrader(int marks) {
        System.out.println("Marks : " + marks);
        Optional<String> grade = Optional.empty();
        if(marks > 50) {
            grade = Optional.of("PASS");
        } else if(marks < 50) {
            grade = Optional.of("FAIL");
        } else {
            grade = Optional.empty();
        }
        return grade;
    }
}


class Item implements Comparable<Item> {
    int id;
    String name;
    public Item(int id, String name) { this.id = id; this.name = name; }

    public int getId() { return id; }
    public String getName() { return name; }

    @Override
    public String toString() { return name;}

    @Override
    public int compareTo(Item o) { return name.compareTo(o.getName());}

    public int compareToId(Item o) {return id - o.id;}
}

class Person1 implements Comparable<Person1> {
    String firstName;
    String lastName;
    int age;

    public Person1(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public int compareTo(Person1 o) {
        return age - o.age;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + age;
    }
}

class Book {
    String title;
    Float price;

    public Book(String title, Float price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() { return title; }
    public Float getPrice() { return price; }
}

