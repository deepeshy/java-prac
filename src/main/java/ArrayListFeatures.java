import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListFeatures {

    public static void main(String[] args) {
        creation();
    }

    private static void creation() {

        List<String> arrL1 = new ArrayList<>();
        System.out.println(arrL1.size()); // internally it create a list with size 10

        List<String> arrL2 = new ArrayList<>(25);
        System.out.println(arrL2.size()); // internally it create a list with the supplied size

        List<String> strings = Arrays.asList("a", "b", "c");

        ArrayList<String> arrL3 = new ArrayList<>(strings);
        System.out.println(arrL3); // internally it create a list with size 10



        // ensure capacity can change the capacity, pls note it is not part of List API, so it has to be an
        // arrayList in the declaration
        // arrL3.trimToSize();
        // does the reverse

        // indexOf, lastIndexOf (first and last occurrence of an object in a list)

    }
}
