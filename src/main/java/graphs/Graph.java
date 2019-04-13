package graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Graph {

  private int V;
  private List<Integer>[] edges;

  public Graph(int i) {
    V = i;
    edges = (ArrayList<Integer>[]) (new ArrayList[V]);
    for (int j = 0; j < V; j++) {
      edges[j] = new ArrayList<>();
    }

  }

  private void addEdge(int node1, int node2) {
    edges[node1].add(node2);
    edges[node2].add(node1);
  }

  ////////////////// DFS Starts Here //////////////////////

  private void dfs(int startingNode) {
    boolean visited[] = new boolean[V];
    dfs(startingNode, visited);
  }

  private void dfs(int i, boolean visited[]) {
    if (!visited[i]) {
      visited[i] = true;
      System.out.print(i + "->");
      for (int neighbor : edges[i]) {
        dfs(neighbor, visited);
      }
    }
  }

  private void dfsStack(int origin) {
    Deque<Integer> stack = new ArrayDeque<>();
    stack.push(origin);
    boolean visited[] = new boolean[V];
    while (!stack.isEmpty()) {
      Integer current = stack.pop();
      if (!visited[current]) {
        System.out.print(current + "->");

        for (int i : edges[current]) {
          if (!visited[i]) {
            stack.push(i);
          }
        }
        visited[current] = true;
      }

    }
  }

  ////////////////// DFS Ends Here ////////////////////////

  ////////////////// BFS Starts Here ///////////////////////

  private void bfs(int orig) {
    boolean[] visited = new boolean[V];
    Deque<Integer> queue = new ArrayDeque<>();
    queue.addFirst(orig);

    while (!queue.isEmpty()) {
      Integer current = queue.pollLast();
      if (!visited[current]) {
        System.out.print(current + "->");
        visited[current] = true;
      }
      for (int i : edges[current]) {
        if (!visited[i]) {
          System.out.print(i + "->");
          queue.addFirst(i);
          visited[i] = true;
        }
      }
    }
  }

////////////////// BFS Ends Here /////////////////////////

  public static void main(String[] args) {
    Graph graph = new Graph(10);
    graph.addEdge(1, 2);
    graph.addEdge(1, 9);
    graph.addEdge(2, 3);
    graph.addEdge(2, 8);
    graph.addEdge(3, 4);
//    graph.addEdge(3, 5);
//    graph.addEdge(5, 1);
    graph.addEdge(5, 7);
    graph.addEdge(5, 9);
    graph.addEdge(5, 0);
    graph.addEdge(5, 2);

    System.out.println("Done");
    graph.dfsStack(1);
    System.out.println();
    graph.dfs(1);
    System.out.println();
    graph.bfs(1);
  }
}
