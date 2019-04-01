public class Sudoku {

  public static void main(String[] args) {
    int[][] board = {
        {1, 0, 0, 4, 8, 9, 0, 0, 6},
        {7, 3, 0, 0, 0, 0, 0, 4, 0},
        {0, 0, 0, 0, 0, 1, 2, 9, 5},
        {0, 0, 7, 1, 2, 0, 6, 0, 0},
        {5, 0, 0, 7, 0, 3, 0, 0, 8},
        {0, 0, 6, 0, 9, 5, 7, 0, 0},
        {9, 1, 4, 6, 0, 0, 0, 0, 0},
        {0, 2, 0, 0, 0, 0, 0, 3, 7},
        {8, 0, 0, 5, 1, 2, 0, 0, 4}
    };
    System.out.println(solve(board, 0, 0));
    print(board);
  }

  private static void print(int[][] b) {
    for (int i = 0; i < b.length; i++) {
      for (int j = 0; j < b[0].length; j++) {
        System.out.print(b[i][j] + "    ");
      }
      System.out.println();
    }
  }

  private static int[] getNextRowCol(int[][] board, int row, int col) {
    col++;
    while (row < 9) {
      while (col < 9) {
        if (board[row][col] == 0) {
          return new int[]{row, col};
        }
        col++;
      }
      row++;
      col = 0;
    }
    return new int[]{9, 9};
  }

  private static boolean solve(int[][] board, int cellRow, int cellCol) {
    if (cellCol == 9 && cellRow == 9) {
      return true;
    }
    for (int i = 1; i <= 9; i++) {
      board[cellRow][cellCol] = i;
      if (isValidState(board)) {
        // Get next cell
        int nextCellRow = getNextRowCol(board, cellRow, cellCol)[0];
        int nextCellCol = getNextRowCol(board, cellRow, cellCol)[1];
        boolean isGood = solve(board, nextCellRow, nextCellCol);
        if (isGood) {
          return true;
        }
      }
    }
    board[cellRow][cellCol] = 0;
    return false;
  }

  private static boolean isValidRow(int[] arr) {
    boolean[] present = new boolean[arr.length];
    if (arr == null || arr.length != 9) {
      throw new IllegalArgumentException("incorrect input to checker");
    }

    for (int i = 0; i < 9; i++) {
      if (notInRange(arr[i])) {
        // return false;
        continue;
      }
      if (present[arr[i] - 1]) {
        return false;
      }
      present[arr[i] - 1] = true;
    }
    return true;
  }

  private static int[] stretch(int[][] board, int blockNum) {
    int[] stretched = new int[9];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        stretched[i * 3 + j] = board[3 * ((blockNum - 1) / 3) + i][((blockNum - 1) % 3) * 3 + j];
      }
    }
    return stretched;
  }

  private static boolean isValidState(int[][] board) {
    for (int i = 0; i < 9; i++) {
      // check rows
      if (!isValidRow(board[i])) {
        return false;
      }

      // check columns
      int[] colArr = getColumnArray(board, i);
      if (!isValidRow(colArr)) {
        return false;
      }

      // check blocks
      int[] blockArr = stretch(board, i + 1);
      if (!isValidRow(blockArr)) {
        return false;
      }
    }
    return true;
  }

  private static int[] getColumnArray(int[][] board, int col) {
    int[] stretched = new int[board[0].length];
    for (int i = 0; i < board.length; i++) {
      stretched[i] = board[i][col];
    }
    return stretched;
  }

  private static boolean notInRange(int i) {
    return i == 0;
  }
}
