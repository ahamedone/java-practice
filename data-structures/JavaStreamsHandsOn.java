import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

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