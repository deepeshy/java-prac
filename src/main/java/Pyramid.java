public class Pyramid {
    public static void main(String[] args) {
        printPyramid(10);
    }

    private static void printPyramid(int n) {
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n - j; i++) {
                System.out.print(" ");
            }

            for (int i = 0; i < 2 * j + 1; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
