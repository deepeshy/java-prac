public class NonAdjacentSum {

  public static void main(String[] args) {
    int[] inp = {3, 4, -1, 1, 0, 7, 2, 5, 6, 12, 23, 123, 2, 3, 7, 89, 1, 4, 7, 6, 80, 25,
        43, 33, 12, 65, 123, 77, 90, 200, 120, 111, 112, 1111, 231, 222, 907, 45, 32, 28,
        7, 6, 80, 12, 65, -1, 1, // Takes 10 seconds on my computer for sub optimal, optimal is 1 ms
        //0, 7, 0, 7, 90, 200, 120
    };
    long start = System.currentTimeMillis();
    System.out.println(nonAdjMaxSumSubOptimal(inp));
    long end = System.currentTimeMillis();
    System.out.println("SubOptimal:" + (end - start));

    long startOptimal = System.currentTimeMillis();

    System.out.println(nonAdjMaxSum(inp));
    long endOptimal = System.currentTimeMillis();
    System.out.println("Optimal:" + (endOptimal - startOptimal));
  }

  private static int nonAdjMaxSum(int[] inp) {
    int[] max = new int[inp.length];
    for (int i = 0; i < max.length; i++) {
      max[i] = Integer.MIN_VALUE;
    }
    return nonAdjMaxSum(inp, inp.length - 1, max);
  }

  private static int nonAdjMaxSum(int[] inp, int i, int[] max) {
    if (max[i] == Integer.MIN_VALUE) {
      if (i == 0) {
        max[i] = inp[i];
      } else if (i == 1) {
        max[i] = Integer.max(inp[0], inp[1]);
      } else {
        max[i] = Integer.max(nonAdjMaxSum(inp, i - 1, max), nonAdjMaxSum(inp, i - 2, max) + inp[i]);
      }
    }
    return max[i];
  }


  // Sub optimal - Start
  private static int nonAdjMaxSumSubOptimal(int[] inp) {
    return nonAdjMaxSumSubOptimal(inp, inp.length - 1);
  }

  private static int nonAdjMaxSumSubOptimal(int[] inp, int i) {
    if (i == 0) {
      return inp[i];
    }

    if (i == 1) {
      return Integer.max(inp[0], inp[1]);
    }

    return Integer
        .max(nonAdjMaxSumSubOptimal(inp, i - 1), nonAdjMaxSumSubOptimal(inp, i - 2) + inp[i]);
  }
  // Sub optimal - Ends


}
