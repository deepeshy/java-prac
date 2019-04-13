public class MaxHeap {

  private int[] store = new int[32]; // can be taken as an input too
  private int size = 0;

  private int getParentIdx(int childIdx) {
    if (childIdx == 0) {
      throw new IllegalArgumentException("Parent for Root Element queried");
    }
    return (childIdx - 1) / 2;
  }

  private int getIdxOfLargerChild(int parentIdx) {
    int children[] = getChildrenIndices(parentIdx);
    if (children[0] == -1) {
      return -1;
    }

    if (children[0] != -1 && children[1] == -1) {
      return children[0];
    }

    if (store[children[0]] > store[children[1]]) {
      return children[0];
    } else {
      return children[1];
    }
  }


  private int[] getChildrenIndices(int parentIdx) {
    int idx1 = parentIdx * 2 + 1;
    int idx2 = parentIdx * 2 + 2;
    if (idx1 >= size) {
      idx1 = -1;
    }
    if (idx2 >= size) {
      idx2 = -1;
    }

    return new int[]{idx1, idx2};
  }

  private int poll() {
    int extracted = store[0];
    // Mov the last element in its place
    store[0] = store[size - 1];
    size--;
    // Run a shift Down Operation here
    shiftDown();
    return extracted;
  }

  private void swap(int idx1, int idx2) {
    int temp = store[idx1];
    store[idx1] = store[idx2];
    store[idx2] = temp;
  }

  private void shiftDown() {
    int idx = 0;
    while (idx < size && idx != -1) {
      int idxOfLargerChild = getIdxOfLargerChild(idx);

      if (idxOfLargerChild != -1 && store[idxOfLargerChild] > store[idx]) {
        swap(idxOfLargerChild, idx);
        idx = idxOfLargerChild;
      } else {
        break;
      }
    }
  }

  private void offer(int newVal) {
    store[size] = newVal;
    int idx = size;
    size++;
    // Run a shift up Operation here
    while (idx > 0) {
      int parentIdx = getParentIdx(idx);
      if (store[parentIdx] > store[idx]) {
        break;
      } else {
        swap(idx, parentIdx);
        idx = parentIdx;
      }
    }
  }

  public static void main(String[] args) {
    MaxHeap maxHeap = new MaxHeap();
    maxHeap.offer(10);
    maxHeap.offer(1);
    maxHeap.offer(8);
    System.out.println(maxHeap.poll());
    maxHeap.offer(7);
    maxHeap.offer(9);
    System.out.println(maxHeap.poll());
    System.out.println(maxHeap.poll());
    System.out.println(maxHeap.poll());
    System.out.println(maxHeap.poll());

  }

}
