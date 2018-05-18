import java.util.*;

public class Permute {
    private Set<String> combs = new LinkedHashSet<String>();

    public static void main(String[] args) {
        new Permute().permute("aabc");
    }

    private void permute(String str) {
        combs.addAll(permute(str, ""));
        System.out.println(combs);
    }

    private Set<String> permute(String remainingString, String prefix) {
        if (remainingString.length() == 0) {
            combs.add(prefix);
        } else {
            for (int i = 0; i < remainingString.length(); i++) {
                permute(remainingString.substring(0, i) + remainingString.substring(i + 1), prefix + remainingString.charAt(i));
            }
        }
        return combs;
    }
}
