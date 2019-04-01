import java.util.Arrays;

public class FirstMissingPositiveInteger {

  public static void main(String[] args) {
    int[] inp = {3, 4, -1, 1, 0, 7, 2, 5, 6};
//    System.out.println(partition(inp, 0));
    System.out.println("Input");
    System.out.println(Arrays.toString(inp));
    System.out.println(firstMissingPositive(inp));
  }

  private static int firstMissingPositive(int[] inp) {

    int startingPoint = partition(inp, 0) + 1;
    if (startingPoint >= inp.length) {
      return 1;
    }

    // at least some positives
    // start at partition + 1

    for (int i = startingPoint; i < inp.length; i++) {
      // starting point = 1
      // ignore cases where the value at a pos is greater than len-1 (that represents len)
      int idxForVal = valToIdx(inp[i], startingPoint);
      if (idxForVal < inp.length) {
        inp[idxForVal] *= -1;
      }
    }

    for (int i = startingPoint; i < inp.length; i++) {
      // starting point = 1
      // ignore cases where the value at a pos is greater than len-1 (that represents len)
      if (inp[i] > 0) {
        return idxToNum(i, startingPoint);
      }
    }
    return idxToNum(inp.length, startingPoint);
  }

  private static int valToIdx(int val, int stpt) {
    return Math.abs(val) + stpt - 1;
  }

  private static int idxToNum(int idx, int stpt) {
    return idx - stpt + 1;
  }

  // return the position of the last element that is smaller than or equal to the pivot
  private static int partition(int[] inp, int pivot) {
    int left = 0, len = inp.length, right = len - 1;

    while (left < len && right >= 0 && left <= right) {
      while (left < len && inp[left] <= pivot) {
        left++;
      }

      while (right >= 0 && inp[right] > pivot) {
        right--;
      }

      if (left < right) {
        int temp = inp[right];
        inp[right] = inp[left];
        inp[left] = temp;
      }
    }
    return right;
  }

}
