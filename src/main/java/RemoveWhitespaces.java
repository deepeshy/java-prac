public class RemoveWhitespaces {
    public static void main(String[] args) {
        System.out.println(removeWhitespaces1("sdkjbvsbj sdvsdkv ggg"));
        System.out.println(removeWhitespaces2("sdkjbvsbj sdvsdkv ggg"));
    }

    private static String removeWhitespaces1(String str) {
        return str.replaceAll("\\s", "");
    }


    private static String removeWhitespaces2(String str) {
        StringBuffer sb = new StringBuffer();
        for (char c : str.toCharArray()) {
            if (c != '\t' && c != ' ') {
                sb.append(c);
            }
        }
        return sb.toString();
    }


}
