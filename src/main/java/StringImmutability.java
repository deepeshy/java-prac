public class StringImmutability {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1==s2);
        s1 = "def";
        System.out.println(s1==s2);
    }
}
