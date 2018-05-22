public class IsBinary {
    public static void main(String[] args) {
        System.out.println(isBinary(111011));
    }

    private static boolean isBinary(int num) {
        while (num > 0) {
            if (num % 10 != 0 && num % 10 != 1) {
                return false;
            }
            num = num / 10;
        }
        return true;
    }
}
