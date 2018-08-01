import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

  Node root;

  public void addRecursive(int val) {
    this.root = addRecursive(root, val);
  }

  private Node addRecursive(Node n, int val) {
    Node newNode = new Node(val);
    if (n == null) {
      return newNode;
    } else {
      // traverse based on the value
      if (val > n.val) {
        n.right = addRecursive(n.right, val);
      } else {
        n.left = addRecursive(n.left, val);
      }
    }
    return n;
  }

  public void addIterative(int val) {
    Node newNode = new Node(val);
    if (root == null) { //initialize the tree
      root = newNode;
      root.setLeft(null);
      root.setRight(null);
    } else {
      // traverse based on the value
      Node parent = root;
      Node current = root;

      while (current != null) {
        parent = current;
        if (val > current.val) {
          current = current.right;
        } else {
          current = current.left;
        }
      }
      current = newNode;

      if (parent.val > current.val) {
        parent.setLeft(current);
      } else {
        parent.setRight(current);
      }
    }
  }

  private static class Node {

    private int val;
    private Node left;
    private Node right;

    public Node(int val) {
      this.val = val;
    }

    public boolean isLeaf() {
      return left == null && right == null;
    }

    public void setLeft(Node left) {
      this.left = left;
    }

    public void setRight(Node right) {
      this.right = right;
    }
  }

  public void preOrder() {
    inOrder(root);
  }

  private void preOrder(Node node) {
    if (node != null) {
      System.out.println(node.val);
      if (node.left != null) {
        inOrder(node.left);
      }
      if (node.right != null) {
        inOrder(node.right);
      }
    }
  }

  private void inOrder(Node node) {
    if (node != null) {
      if (node.left != null) {
        inOrder(node.left);
      }
      System.out.println(node.val);
      if (node.right != null) {
        inOrder(node.right);
      }
    }
  }

  public void bfsTraversal() {
    Queue<Node> bfsNodes = new LinkedList<>();
    bfsNodes.add(root);
    while (!bfsNodes.isEmpty()) {
      Node curr = bfsNodes.remove();
      System.out.println(curr.val);
      if (curr.left != null) {
        bfsNodes.add(curr.left);
      }
      if (curr.right != null) {
        bfsNodes.add(curr.right);
      }
    }
  }

  public void inOrder() {
    inOrder(root);
  }

  public void printBoundary() {
    printLeft(root);
    printLeaves(root);
    printRight(root);
  }

  private void printLeft(Node n) {
    if (n == null) {
      return;
    }
    if (!n.isLeaf()) {
      System.out.println(n.val);
      printLeft(n.left);
    }
  }

  private void printRight(Node n) {
    if (n == null) {
      return;
    }
    if (!n.isLeaf()) {
      printRight(n.right);
      System.out.println(n.val);
    }
  }

  private void printLeaves(Node n) {
    if (n == null) {
      return;
    }
    if (!n.isLeaf()) {
      printLeaves(n.left);
      printLeaves(n.right);
    } else {
      System.out.println(n.val);
    }
  }

  public static void main(String[] args) {
//    BinaryTree binaryTree = new BinaryTree();
//    binaryTree.addIterative(10);
//    binaryTree.addIterative(20);
//    binaryTree.addIterative(40);
//    binaryTree.addIterative(60);
//    binaryTree.addIterative(880);
//    binaryTree.addIterative(1);
//    binaryTree.addIterative(3);
//    binaryTree.preOrder();
//    System.out.println("\n*********************\n");
//    binaryTree.inOrder();

    BinaryTree binaryTree = new BinaryTree();
    binaryTree.addRecursive(10);
    binaryTree.addRecursive(20);
    binaryTree.addRecursive(40);
    binaryTree.addRecursive(60);
    binaryTree.addRecursive(880);
    binaryTree.addRecursive(1);
    binaryTree.addRecursive(3);
    binaryTree.preOrder();
    System.out.println("\n*********************\n");
    binaryTree.inOrder();
    System.out.println("\n*********************\n");
    binaryTree.bfsTraversal();
    System.out.println("\n#########################\n");

    binaryTree.printBoundary();
  }
}
