public class MedianInTwoSortedArrays {


  public static void main(String[] args) {
    int[] a = new int[]{1, 6, 68, 455, 788, 2345, 2765, 2890};
    int[] b = new int[]{3, 5, 8, 55, 789, 1345, 2885, 2890, 3212};
    System.out.println(med(a, b));
  }

  private static float med(int[] a, int[] b) {

    int aLen = a.length;
    int bLen = b.length;
    int i = aLen / 2;
    int j = bLen / 2;

    int totalLen = aLen + bLen;
    boolean isEven = (totalLen % 2) == 0;

    while (i < aLen && j < bLen && i >= 0 && j >= 0) {
      j = totalLen / 2 - i;

      if (a[i - 1] < b[j] && b[j - 1] < a[i]) { // we are good
        if (isEven) {
          return (float) (Math.max(a[i - 1], b[j - 1]) + Math.min(a[i], b[j])) / 2;
        } else {
          return Math.min(a[i], b[j]);
        }
      }

      if (a[i - 1] > b[j]) { // array a is righter than it should be, move i back
        i = i / 2;
      } else {
        if (b[j - 1] > a[i]) { // b is righter than it should be, move i forward and j back
          i = i - 1 + (aLen - i + 1) / 2;
        }
      }
    }
    return -1;
  }
}
