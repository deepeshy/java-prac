public class LongestCommonPrefix {

  public static void main(String[] args) {
    String s1 = "xAppliation";
    String s2 = "Applicationable";
    System.out.println(lcp(s1, s2));
  }

  // can take a StringBuffer to make it readable but doesn't necessarily need any extra memory except an int
  private static String lcp(String s1, String s2) {
    if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
      return "";
    }

    int i = 0;
    for (; i < s1.length() && i < s2.length(); i++) {
      if (s1.charAt(i) != s2.charAt(i)) {
        break;
      }
    }
    return s1.substring(0, i);
  }
}
