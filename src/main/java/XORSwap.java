public class XORSwap {
    public static void main(String[] args) {
        xorSwap();
        arithSwap();
    }

    private static void arithSwap() {
        int x, y;
        x = 1;
        y = 2; // x=01, y=10
        System.out.println("x:" + x + " y:" + y);
        x = x + y;
        y = x - y;
        x = x - y;
        System.out.println("x:" + x + " y:" + y);
    }

    private static void xorSwap() {
        int x, y;
        x = 1;
        y = 2; // x=01, y=10
        System.out.println("x:" + x + " y:" + y);
        x = x ^ y;    // x=11, y=10
        y = x ^ y;    // x=11, y=01
        x = x ^ y;    // x=10, y=01
        System.out.println("x:" + x + " y:" + y);
    }
}

