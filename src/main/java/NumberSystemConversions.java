public class NumberSystemConversions {
    public static void main(String[] args) {
        System.out.println(decimalToOtherSystem(13, 2));
        System.out.println(decimalToOtherSystem(45, 8));
        System.out.println(decimalToHexadecimal(45));
    }

    private static String decimalToOtherSystem(int i, int base) {
        StringBuffer op = new StringBuffer();
        while (i > 0) {
            op.append(i % base);
            i = i / base;
        }
        return op.reverse().toString();
    }


    private static String decimalToHexadecimal(int i) {
        StringBuffer op = new StringBuffer();
        char[] alpha = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
//        System.out.println(alpha[i % 16 - 10]);
        while (i > 0) {
            char val = (i % 16) > 9 ? alpha[(i % 16) - 10] : Character.forDigit(i % 16, 10);
            op.append(val);
            i = i / 16;
        }
        return op.reverse().toString();
    }

}
