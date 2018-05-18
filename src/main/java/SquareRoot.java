public class SquareRoot {
    public static void main(String[] args) {
        System.out.println(customSqrt(2500));
    }

    private static double customSqrt(int i) {
        double lower = 0;
        double higher = i;
        double sqrtVal = (higher + lower) / 2;

        while (true) {
            double sqr = sqrtVal * sqrtVal;
            if (Math.abs(sqr - i) < 0.001) break;

            if (sqr > i) {
                higher = sqrtVal;
                sqrtVal = (lower + sqrtVal) / 2;
            } else {
                lower = sqrtVal;
                sqrtVal = (higher + sqrtVal) / 2;
            }
        }
        return sqrtVal;
    }
}
