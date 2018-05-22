public class IsRotation {
    public static void main(String[] args) {
        System.out.println(isRotationOf("abcd", "bcad"));
    }

    private static boolean isRotationOf(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length()) return false;
        return (str1 + str1).contains(str2);
    }
}
