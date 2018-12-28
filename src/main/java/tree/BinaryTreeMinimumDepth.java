package tree;

public class BinaryTreeMinimumDepth {

  private static class Node {

    int val;
    Node left, right;

    public Node(int val) {
      this.val = val;
    }
  }

  private static int minDepth(Node node) {
    // leaf node
    if (node.left == null && node.right == null) {
      return 1;
    }

    if (node.left == null) {
      return 1 + minDepth(node.right);
    }

    if (node.right == null) {
      return 1 + minDepth(node.left);
    }
    return Math.min(1 + minDepth(node.left), 1 + minDepth(node.right));
  }

  public static void main(String[] args) {
    Node root = new Node(0);
    root.left = new Node(12);
    root.right = new Node(52);
//    root.left.left = new Node(12);
//    root.left.right = new Node(13);
    root.right.left = new Node(22);
    root.right.right = new Node(23);
    root.right.right.left = new Node(20);

    System.out.println(minDepth(root));
  }
}
