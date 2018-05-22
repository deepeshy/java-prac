import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Intersection {
    public static void main(String[] args) {
        System.out.println(intersectionIterativeMethod(new int[]{1, 2, 3, 8, 9, 10}, new int[]{8, 10, 11, 12, 9}));
        System.out.println(intersectionHashsetMethod(new Integer[]{1, 2, 3, 8, 9, 10}, new Integer[]{8, 10, 11, 12, 9}));
    }

    private static Set<Integer> intersectionHashsetMethod(Integer[] first, Integer[] second) {
        HashSet<Integer> firstSet = new HashSet<Integer>(Arrays.asList(first));
        firstSet.retainAll(new HashSet<Integer>(Arrays.asList(second)));
        return firstSet;
    }

    private static Set<Integer> intersectionIterativeMethod(int[] first, int[] second) {
        Set<Integer> intersection = new HashSet<Integer>();
        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < second.length; j++) {
                if (first[i] == second[j]) {
                    {
                        intersection.add(first[i]);
                    }
                }
            }
        }
        return intersection;
    }
}
