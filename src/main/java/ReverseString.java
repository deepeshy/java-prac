public class ReverseString {
    public static void main(String[] args) {
//        String[] inputs = {"dufehehtue", "A forward moving string", "Reverse me", "I am the input"};
        String[] inputs = {"abcde"};
        for (String input : inputs) {
//            System.out.println(reverse1(input));
//            System.out.println(reverse2(input));
//            System.out.println(reverse3(input));
//            System.out.println(reverse4(input));
            System.out.println(reverse5(input));
        }
    }

    private static String reverse1(String input) {
        return new StringBuffer(input).reverse().toString();
    }

    private static String reverse2(String input) {
        StringBuffer out = new StringBuffer();
        for (int i = input.length() - 1; i >= 0; i--) {
            out.append(input.charAt(i));
        }
        return out.toString();
    }

    private static String reverse3(String input) {
        char[] chars = input.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[length - i - 1];
            chars[length - i - 1] = temp;
        }
        return new String(chars);
    }

    private static String reverse4(String input) {
        if (input == null || input.length() <= 1) return input;
        return reverse4((input.substring(1))) + input.charAt(0); // take off the first char, put it at the end
    }

    private static String reverse5(String input) {
        for (int i = 0; i < input.length(); i++) {
            String part1 = input.substring(1, input.length() - i);
            char part2 = input.charAt(0);
            String part3 = input.substring(input.length() - i);
            input = part1 + part2 + part3;
            System.out.print(part1);
            System.out.print(" ");
            System.out.print(part2);
            System.out.print(" ");
            System.out.print(part3);
            System.out.print("\n");
            System.out.println(input);
        }
        return input;
    }
}
