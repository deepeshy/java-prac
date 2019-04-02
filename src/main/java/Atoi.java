public class Atoi {

  // take a string and return a number represented by the string
  // "42" -> 42, "abc 234 fgt" -> 234, "+234vfg" -> 234
  // whatever best can be done
  public static void main(String[] args) {
    System.out.println(atoi("2385638jfgjbg"));
    System.out.println(atoi("aaaaa-661dd2385638jfgjbg"));
  }

  private static int atoi(String str) {
    if (str == null || str.isEmpty()) {
      return 0;
    }

    int start = -1;
    int val = 0;
    int sign = 1;
    for (int i = 0; i < str.length(); i++) {
      if (isDigitOrSign(str.charAt(i))) {
        start = i;
        break;
      }
    }

    if (start < str.length() - 1 && start >= 0 && isSign(str.charAt(start))) {
      if (str.charAt(start) == '-') {
        sign = -1;
      }
      start++;
    }

    for (int i = start; i < str.length(); i++) {
      if (!isDigit(str.charAt(i))) {
        break;
      }
      val = val * 10 + (str.charAt(i) - '0');
    }
    return val * sign;
  }

  private static boolean isDigitOrSign(char c) {
    return isDigit(c) || isSign(c);
  }

  private static boolean isDigit(char c) {
    return c >= '0' && c <= '9';
  }

  private static boolean isSign(char c) {
    return c == '-' || c == '+';
  }

}
