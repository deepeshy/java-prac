public class Maze {

  private final int[][] maze;
//  int[][] maze = {
//      {1, 0, 0, 4, 8, 9, 0, 0, 6},
//      {7, 3, 0, 0, 0, 0, 0, 4, 0},
//      {0, 0, 0, 0, 0, 1, 2, 9, 5},
//      {0, 0, 7, 1, 2, 0, 6, 0, 0},
//      {5, 0, 0, 7, 0, 3, 0, 0, 8},
//      {0, 0, 6, 0, 9, 5, 7, 0, 0},
//      {9, 1, 4, 6, 0, 0, 0, 0, 0},
//      {0, 2, 0, 0, 0, 0, 0, 3, 7},
//      {8, 0, 0, 5, 1, 2, 0, 0, 4}
//  };

  public static void main(String[] args) {
    int[][] mazeInput = {
        {0, 0, 0, 0},
        {1, 1, 0, 1},
        {0, 0, 0, 0},
        {0, 0, 0, 0},
    };

    System.out.println(new Maze(mazeInput).solve(3, 0, 0, 0));
  }

  private int solve(int i, int j, int ti, int tj) {
    boolean[][] visited = new boolean[maze.length][maze[0].length];
    return solve(i, j, ti, tj, visited);
  }


  public Maze(int[][] maze) {
    this.maze = maze;
  }

  // 0 means you can go, 1 means blocked
  private boolean isViable(int i, int j, boolean[][] visited) {
    return i >= 0 && j >= 0 && i < maze.length && j < maze[0].length && !visited[i][j]
        && maze[i][j] == 0;
  }


  private int solve(int i, int j, int targeti, int targetj,
      boolean[][] visited) {

    visited[i][j] = true;

    if (i == targeti && j == targetj) {
      visited[i][j] = false;
      return 0;
    }
    int[][] moves = new int[][]{
        {i + 1, j},
        {i - 1, j},
        {i, j + 1},
        {i, j - 1},
    };

    int[] dist = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE,
        Integer.MAX_VALUE};

    for (int k = 0; k < moves.length; k++) {
      int newi = moves[k][0];
      int newj = moves[k][1];
      if (isViable(newi, newj, visited)) {
        visited[newi][newj] = true;
        int distance = solve(newi, newj, targeti, targetj, visited);
        if (distance != Integer.MAX_VALUE) {
          dist[k] = 1 + distance;
        }
      }
    }
    visited[i][j] = false;
    return Math.min(Math.min(dist[0], dist[1]), Math.min(dist[2], dist[3]));
  }
}
