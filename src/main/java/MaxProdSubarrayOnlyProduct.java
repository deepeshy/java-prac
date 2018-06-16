public class MaxProdSubarrayOnlyProduct {
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
        int currMax = inp[0];
        int currMin = inp[0];
        int max = inp[0];

        for (int i = 0; i < inp.length; i++) {
            if (inp[i] > 0) {
                currMax = Math.max(currMax, currMax * inp[i]);
                currMin = Math.min(currMin, currMin * inp[i]);
            } else {
                int currMaxNeg = Math.max(currMin * inp[i], inp[i]);
                currMin = Math.min(currMax * inp[i], inp[i]);
                currMax = currMaxNeg;
            }
            max = Math.max(max, currMax);
        }
        return max;
    }
}
