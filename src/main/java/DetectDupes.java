import java.util.*;

public class DetectDupes {
    public static void main(String[] args) {
        // App 1
        System.out.println(dupes(Arrays.asList("ddd", "dfd", "ddd")));
        System.out.println(dupes(Arrays.asList("ghf", "ghf", " ddd", "dfd", "ddd", "dfd")));
        // App 2
        System.out.println(dupesUsingSet(Arrays.asList("ddd", "dfd", "ddd")));
        System.out.println(dupesUsingSet(Arrays.asList("ghf", "ghf", " ddd", "dfd", "ddd", "dfd")));
    }

    // Brute Force O(n^2)
    private static Set<String> dupes(List<String> fullList) {
        Set<String> dupes = new HashSet<String>();
        for (int i = 0; i < fullList.size(); i++) {
            String ref = fullList.get(i);
            for (int j = i + 1; j < fullList.size(); j++) {
                if (ref.equals(fullList.get(j))) {
                    dupes.add(ref);
                    break;
                }
            }
        }
        return dupes;
    }

    // Set Approach (O(n))
    private static Set<String> dupesUsingSet(List<String> fullList) {
        Set<String> dupes = new HashSet<String>();
        Set<String> unique = new HashSet<String>();
        for (String ref : fullList) {
            if (!unique.add(ref)) {
                dupes.add(ref);
            }
        }
        return dupes;
    }
}
