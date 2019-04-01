public class StringReverseRecurse {

  public static void main(String[] args) {
    System.out.println(rev("abcdef"));
  }

  private static String rev(String string) {
    if (string.length() == 0 || string.length() == 1) return string;
    return string.charAt(string.length() - 1) + rev(string.substring(0, string.length() - 1));
  }
}
