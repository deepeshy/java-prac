public class MissingNumberInSeries {
    public static void main(String[] args) {
        System.out.println(missingNum(new int[]{1, 3, 4, 5, 6}));
    }

    private static int missingNum(int[] inp) {
        int sum = 0;
        for (int i = 0; i < inp.length; i++) {
            sum += inp[i];
        }
        return ((inp.length + 1) * (inp.length + 2)) / 2 - sum;
    }
}
