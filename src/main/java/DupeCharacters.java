import java.util.HashMap;
import java.util.Map;

public class DupeCharacters {
    public static void main(String[] args) {
        printDupes("Better Butter");
    }

    private static void printDupes(String str) {
        Map<Character, Integer> dupeCharCount = new HashMap<Character, Integer>();
        Map<Character, Integer> dupeCharCountActual   = new HashMap<Character, Integer>();

        for (char c : str.toCharArray()) {
            if (dupeCharCount.get(c) == null) {
                dupeCharCount.put(c, 1);
            } else {
                dupeCharCount.put(c, dupeCharCount.get(c) + 1);
                dupeCharCountActual.put(c, dupeCharCount.get(c));
            }
        }
        System.out.println(dupeCharCountActual);
    }


}
