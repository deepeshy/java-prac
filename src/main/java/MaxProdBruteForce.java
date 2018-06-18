public class MaxProdBruteForce {


    public static void main(String[] args) {
//        int[] inp = {1, 2, 3, 4};
        //        int[] input = {1, 2, -1, 34, 5, 7, -1, 9, 56, 8, -1, 98};
//        int[] input = {6, -3, -10, 0, 2};
//        int[] input = {-1, -3, -10, 0, 60};
//        int[] input = {-2, -3, 0, -2, -40};
        int[] input = {-1, 2, 3, -4, -6};
        System.out.println(maxProd(input));
    }

    private static int maxProd(int[] inp) {
        int runningProduct = 1;
        int max = inp[0];
        for (int i = 0; i < inp.length; i++) {
            runningProduct = inp[i];
            max = Math.max(runningProduct, max);
            for (int j = i + 1; j < inp.length; j++) {
                runningProduct = runningProduct * inp[j];
                max = Math.max(runningProduct, max);
            }
        }
        return max;
    }
}
