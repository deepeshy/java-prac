import java.util.ArrayList;
import java.util.HashSet;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(isFib(17711));
        printFibSeries(10);
    }

    private static boolean isFib(int i) {
        int first = 0;
        int second = 1;
        if (i == first || i == second) return true;

        while (second < i) {
            int newFib = first + second;
            if (newFib == i) return true;
            first = second;
            second = newFib;
        }
        return false;
    }

    private static void printFibSeries(int i) {
        for (int j = 0; j < i; j++) {
            System.out.println(getFib(j));
        }

    }

    private static int getFib(int i) {
        if (i == 0 || i == 1) {
            return i;
        }
        return getFib(i - 1) + getFib(i - 2);
    }
}