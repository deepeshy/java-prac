import java.io.IOException;

public class QueenPlacement {

  public static void main(String[] args) throws IOException, InterruptedException {
    int n = 8;
    boolean[][] b = new boolean[n][n];
    print(b);
    nqn(b, 0);
    System.out.println("\n\n\n");
    print(b);
  }

  private static boolean nqn(boolean[][] b, int col) throws IOException, InterruptedException {
    if (col == b.length) {
      return true;
    }

    clear();
    print(b);
    for (int i = 0; i < b.length; i++) {
      // place q @ safe sport
      // recurse with next column
      if (isSafe(b, i, col)) {
        b[i][col] = true;
        boolean solved = nqn(b, col + 1);
        if (solved) {
          return solved;
        } else {
          b[i][col] = false;
        }
      }

    }
    return false;
  }

  private static boolean isSafe(boolean[][] b, int row, int col) {
    for (int i = 0; i < b.length; i++) {
      if (b[row][i]) {
        return false; // check same row
      }
      if (b[i][col]) {
        return false; // check same column
      }
      // diag 1: row - i = col - j; j = col - row + i
      if (isValidIdx(b, col - row + i) && b[i][col - row + i]) {
        return false;
      }

      // Diag 2: row + col = i + j; j = row + col - i
      if (isValidIdx(b, col + row - i) && b[i][col + row - i]) {
        return false;
      }
    }
    return true;
  }

  private static boolean isValidIdx(boolean b[][], int i) {
    return i >= 0 && i < b.length;
  }


  private static void print(boolean[][] b) {
    for (int i = 0; i < b.length; i++) {
      for (int j = 0; j < b[0].length; j++) {
        System.out.print(translate(b[i][j]) + "    ");
      }
      System.out.println();
    }
  }

  private static int translate(boolean b) {
    return b ? 1 : 0;
  }

  private static void clear() throws IOException, InterruptedException {
    new ProcessBuilder("cmd", " /c", "cls").inheritIO().start().waitFor();
  }
}
