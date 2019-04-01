import java.util.Scanner;

// sample result is Yes, No
public class GridSearch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int R = in.nextInt();
            int C = in.nextInt();
            String[] G = new String[R];
            for (int G_i = 0; G_i < R; G_i++) {
                G[G_i] = in.next();
            }
            int r = in.nextInt();
            int c = in.nextInt();
            String[] P = new String[r];
            for (int P_i = 0; P_i < r; P_i++) {
                P[P_i] = in.next();
            }
            System.out.println(isPresent(G, P));
        }
    }

    private static int[][] stringToDigitArray(String str[]) {
        if (str == null || str.length == 0 || str[0].length() == 0)
            throw new IllegalArgumentException("Bad string input");
        int[][] res2DArray = new int[str.length][str[0].length()];
        for (int i = 0; i < str.length; i++) {

            int[] resArray = new int[str[i].length()];
        }

        return res2DArray;
    }

    private static boolean isPresent(String[] g, String[] p) {

        return false;
    }
}


