import java.util.Arrays;

public class SeparateZeros {
    public static void main(String[] args) {
        separateZeroesArrMethod(new int[]{1, 3, 5, 4, 32345, 35, 0, 6565, 5, 0, 0, 0, 45, 4, 0, 56, 67, 77777, 0});
    }

    private static int[] separateZeroesArrMethod(int[] inp) {
        int[] op = new int[inp.length];
        int nz = 0;
        int z = 0;
        for (int i = 0; i < inp.length; i++) {
            if (inp[i] != 0) {
                op[nz] = inp[i];
                nz++;
            } else {
                op[inp.length - z - 1] = 0;
                z++;
            }
        }

        (Arrays.stream(op)).forEach(System.out::println);

        return op;
    }
}
