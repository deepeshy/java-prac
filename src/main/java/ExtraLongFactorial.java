import java.math.BigInteger;
import java.util.Scanner;

public class ExtraLongFactorial {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        System.out.println(fact(t));
    }

    private static BigInteger fact(int i) {
        if (i == 0) return BigInteger.valueOf(1);
        return BigInteger.valueOf(i).multiply(fact(i - 1));
    }
}
