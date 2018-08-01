package dynaprog;

import java.util.ArrayList;
import java.util.List;

public class Knapsack01 {

  public static void main(String[] args) {
    int[] v = {60, 100, 120};
    int[] wt = {1, 2, 3};
    int total = 5;
    System.out.println("Total Value: " + buildKnapsack(v, wt, total));

    int[] v2 = {1, 4, 5, 7};
    int[] wt2 = {1, 3, 4, 7};
    int total2 = 7;
    System.out.println("Total Value: " + buildKnapsack(v2, wt2, total2));

  }

  public static int buildKnapsack(int[] v, int[] wt, int total) {

    List<Integer> items = new ArrayList<>();
    int[][] itemTable = new int[v.length][total + 1];
    for (int i = 0; i < v.length; i++) {
      for (int j = 0; j <= total; j++) {
        if (wt[i] <= j) {
          if (i > 0) {
            itemTable[i][j] = Math.max(itemTable[i - 1][j], v[i] + itemTable[i - 1][j - wt[i]]);
          } else {
            itemTable[i][j] = v[i];
          }
        } else {
          itemTable[i][j] = 0;
        }
      }
//            Arrays.stream(itemTable[i]).forEach(k -> System.out.print(k + " "));
//            System.out.println();
    }

    // Traverse Items
    int valIdx = v.length - 1;
    int wtIdx = total;
    while (valIdx >= 0 && wtIdx >= 0) {
      if (valIdx > 0 && itemTable[valIdx][wtIdx] == itemTable[valIdx
          - 1][wtIdx]) { // valIdx row is not in it
      } else { // valIdx row is in it
        if (itemTable[valIdx][wtIdx] > 0) {
          items.add(v[valIdx]);
          wtIdx = wtIdx - wt[valIdx];
        }
      }
      valIdx--;
    }

    System.out.print("ItemList: ");
    items.stream().forEach(q -> System.out.print(q + " "));

    return itemTable[v.length - 1][total];
  }
}
