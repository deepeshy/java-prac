public class ArmstronNumber {
    public static void main(String[] args) {

        System.out.println(isArmstrong(153));
        System.out.println(isArmstrong(371));
        System.out.println(isArmstrong(9474));
        System.out.println(isArmstrong(54748));
        System.out.println(isArmstrong(407));
        System.out.println(isArmstrong(1674));
    }

    // true if power(a,d) + power(b,d) +power(c,d) = abc (d = num of digits)
    private static boolean isArmstrong(int i) {
        System.out.print(i + ":"); // Hack: Tight coupling with code in main to make it easy to print
        int runningSum = 0;
        // Find the number of digits
        int digits = String.valueOf(i).length();
        for (int j = 0; j < digits; j++) {
            int currDigit = (int) ((i % Math.pow(10, j + 1)) / (Math.pow(10, j)));
            runningSum += Math.pow(currDigit, digits);
        }
        return runningSum == i;
    }
}
