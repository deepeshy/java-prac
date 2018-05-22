public class ReverseWordsInASentence {
    public static void main(String[] args) {
        System.out.println(reverseWords("This is the input"));
    }

    private static String reverseWords(String input) {
        String[] words = input.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < words.length; i++) {
            sb.append(new StringBuffer(words[i]).reverse());
            sb.append(" ");
        }
        return sb.toString();
    }
}
