import java.util.ArrayList;
import java.util.List;

public class StackOverflow {

  public static void main(String[] args) {

//    new StackOverflow().methodWithNoEnd(0);

//    new StackOverflow().methodThatNeedsWayTooMuchMemory(1000000);
  }

  private void methodThatNeedsWayTooMuchMemory(int i) {
    List<int[]> faltuVar = new ArrayList<>();

    int[] temp = new int[i];
    for (int j = 0; j < i; j++) {
      for (int k = 0; k < i; k++) {

        temp[k] = k;
      }
      faltuVar.add(temp);
    }
  }

//  private void methodWithNoEnd(int i) {
//    System.out.println("call # " + i);
//    methodWithNoEnd(i + 1);
//  }


}
