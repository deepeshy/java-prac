import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeKSortedArrays {

  public static void main(String[] args) {
    int[][] inp = {
        {1, 2, 23},
        {5, 6, 9},
        {15, 16, 39}
    };

    System.out.println(Arrays.deepToString(inp));
    System.out.println(Arrays.toString(sort(inp)));
  }

  private static class Element implements Comparable<Element> {

    private int val;
    private int listIdx;

    public Element(int val, int listIdx) {
      this.val = val;
      this.listIdx = listIdx;
    }

    @Override
    public int compareTo(Element o) {
      return Integer.compare(this.val, o.val);
    }
  }

  private static int[] sort(int[][] inp) {
    int listCount = inp.length;

    if (listCount == 0) {
      return new int[0];
    }

    int listSize = inp[0].length;

    int lastPickedIdx = -1;
    int[] output = new int[listCount * listSize];

    PriorityQueue<Element> minHeap = new PriorityQueue<>();
    int[] currIndex = new int[listCount];

    for (int i = 0; i < listCount; i++) {
      minHeap.add(new Element(inp[i][0], i));
      currIndex[i] = 1;
    }

    // initialize current index for all lists to 0
    for (int i = 0; i < listCount * listSize; i++) {
      Element currMin = minHeap.poll();
      output[i] = currMin.val;

      if (currIndex[currMin.listIdx] < listSize) {
        lastPickedIdx = currMin.listIdx;
        minHeap.add(new Element(inp[lastPickedIdx][currIndex[lastPickedIdx]], lastPickedIdx));
        currIndex[lastPickedIdx]++;
      }
    }
    return output;
  }
}
