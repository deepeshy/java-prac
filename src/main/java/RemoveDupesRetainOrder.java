import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

public class RemoveDupesRetainOrder {
    public static void main(String[] args) {
        System.out.println(unique(Arrays.asList("ABC", "DEF", "GHR", "DEF")));
    }

    private static List<String> unique(List<String> strings) {
        return new ArrayList<String>(new LinkedHashSet<String>(strings));
    }
}
