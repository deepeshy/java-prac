import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {

  private int V;
  private List<Integer> adjList[];

  public Graph(int v) {
    V = v;
    adjList = new LinkedList[V];
    for (int i = 0; i < V; i++) {
      adjList[i] = new LinkedList<>();
    }
  }

  public void addEdge(Integer src, Integer dest) {
    adjList[src].add(dest);
    adjList[dest].add(src);
  }

  public void printGraph() {
    for (int i = 0; i < V; i++) {
      System.out.println(V + "->");
      for (Integer adj : adjList[i]) {
        System.out.print(adj);
        System.out.print(",");
      }
      System.out.println();
    }
  }

  private void bfs(int s) {
    boolean[] visited = new boolean[V];
    Queue<Integer> q = new LinkedList<>();
    q.add(s);
    while (!q.isEmpty()) {
      Integer ele = q.poll();
      visited[ele] = true;
      System.out.println(ele);
      for (Integer i : adjList[ele]) {
        if (!visited[i]) {
          visited[i] = true;
          q.add(i);
        }
      }
    }
  }

  private void dfsLocal(Integer src, boolean[] visited) {
    if (!visited[src]) {
      System.out.println(src);
      visited[src] = true;
      for (Integer s : adjList[src]) {
        dfsLocal(s, visited);
      }
    }
  }

  public void dfs(Integer s) {
    boolean[] visited = new boolean[V];
    dfsLocal(s, visited);
  }

  public static void main(String[] args) {

    Graph g = new Graph(10);
    g.addEdge(0, 1);
    g.addEdge(0, 4);
    g.addEdge(2, 5);
    g.addEdge(3, 7);
    g.addEdge(2, 1);
    g.printGraph();
    System.out.println("************************");
    g.bfs(0);
    System.out.println("************************");
    g.dfs(0);
  }


}
