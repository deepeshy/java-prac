import java.util.Arrays;

public class FindSubstring {

  public static void main(String[] args) {
    String s1 = "51a55551ax1abc";
    String s2 = "1ax1a";
    System.out.println(findSubstring(s1, s2));
    System.out.println(KMP(s1, s2));
  }

  private static int findSubstring(String s1, String s2) {
    int startingIndx = 0;
    for (int i = 0; i < s1.length(); ) {
      startingIndx = i;
      for (int j = 0; j < s2.length(); ) {
        if (s1.charAt(i) == s2.charAt(j)) {
          i++;
          j++;
          if (j == s2.length()) {
            return startingIndx;
          }
        } else {
          i = startingIndx + 1;
          break;
        }
      }
    }
    return -1;
  }

  private static int KMP(String s1, String s2) {
    // Build position table
    int[] table = buildTable(s2);
    for (int i = 0; i < s1.length(); ) {
      for (int j = 0; j < s2.length(); ) {
        if (s1.charAt(i) == s2.charAt(j)) {
          // if matches
          i++;
          j++;
          if (j == s2.length()) {
            return i - s2.length();
          }
        } else {
          // if it doesn't match go back based on j's prior element's index
          i++;
          j = table[Math.max(j - 1, 0)];
        }
      }
    }
    return -1;
  }


  private static int[] buildTable(String s2) {
    int[] table = new int[s2.length()];
    table[0] = 0;
    int pIter = 1;
    int eqIter = 0;
    while (pIter < s2.length()) {
      if (s2.charAt(eqIter) == s2.charAt(pIter)) {
        eqIter++;
        pIter++;
        table[pIter] = eqIter + 1;
      } else {
        eqIter = table[Math.max(eqIter - 1, 0)];
        table[pIter] = 0;
        pIter++;
      }
    }
    Arrays.stream(table).forEach(System.out::println);
    return table;
  }

}
