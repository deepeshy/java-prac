public class RunLengthEncoding {

  public static void main(String[] args) {
    String s1 = "abcd";
    System.out.println(compress(s1));
  }

  private static String compress(String str) {

    int count = 1;
    StringBuffer compressed = new StringBuffer();
    for (int i = 0; i < str.length(); i++) {

      if (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
        count++;
      } else {
        if (count >= 2) {
          compressed.append(Integer.toString(count));
        }
        compressed.append(str.charAt(i));
        count = 1;
      }
    }

    return compressed.toString();
  }

}
