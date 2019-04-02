public class LongestCommonSuffix {


  public static void main(String[] args) {
    String s1 = "Faxi";
    String s2 = "Taxi";
    System.out.println(lcs(s1, s2));
  }

  private static String lcs(String s1, String s2) {
    int j = 0;

    for (; j < s1.length() && j < s2.length(); j++) {
      if (s1.charAt(s1.length() - 1 - j) != s2.charAt(s2.length() - 1 - j)) {
        break;
      }
    }
    return s1.substring(s1.length() - j);
  }
}
