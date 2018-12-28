import java.util.Arrays;
import java.util.stream.Collectors;

public class MaxInSlidingWindow {

  public static void main(String[] args) {
    int[] input = new int[]{1, 2, 6, 57, 9, 67, 43, 658, 886, 46, 457, 895, 12};
    int windowSize = 4;
    System.out.println();
    System.out.println(Arrays.stream(maxInSlidingWindow(input, windowSize))
        .mapToObj(Integer::toString).collect(
            Collectors.joining(",")));
  }

  private static int[] maxInSlidingWindow(int[] input, int windowSize) {
    int[] maxInWindow = new int[input.length - windowSize + 1];
    for (int i = 0; i < maxInWindow.length; i++) {
      int max = Integer.MIN_VALUE;
      for (int j = 0; j < windowSize; j++) {
        max = Math.max(max, input[i + j]);
      }
      maxInWindow[i] = max;
    }
    return maxInWindow;
  }

}
