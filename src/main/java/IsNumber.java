public class IsNumber {
    public static void main(String[] args) {
        System.out.println(isNum("dsdgsdg"));
        System.out.println(isNum("1234757"));

    }

    private static boolean isNum(String num) {
        try {
            Integer.parseInt(num);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
