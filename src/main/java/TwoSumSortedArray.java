import java.util.HashMap;
import java.util.Map;

public class TwoSumSortedArray {

  public static void main(String[] args) {
    int[] input = {1, 2, 3, 4, 8, 10, 11, 15, 16, 17, 21, 23, 88, 987};

    twoSumPairs(input, 25).entrySet().stream()
        .map(x -> "[" + x.getKey().toString() + "-" + x.getValue().toString() + "]")
        .forEach(System.out::print);
  }

  private static Map<Integer, Integer> twoSumPairs(int[] input, int sum) {
    Map<Integer, Integer> pairs = new HashMap<>();
    int i = 0, j = input.length - 1;
    while (i < j) {
      int currentSum = input[i] + input[j];
      if (sum == currentSum) {
        pairs.put(input[i], input[j]);// assuming no duplicates
        i++;
        j--;
      } else {
        if (sum < currentSum) {
          j--;
        } else {
          i++;
        }
      }
    }
    return pairs;
  }
}
