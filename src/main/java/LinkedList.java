public class LinkedList {

  Node head;

  private void print() {
    Node curr = head;
    while (curr != null) {
      System.out.print(curr.val);
      if (curr.next != null) {
        System.out.print("->");
      }
      curr = curr.next;
    }
    System.out.println();
  }

  private void reverse() {
    Node curr = head;
    Node prev = null;
    Node next = null;

    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }

    head = prev;
  }

  private void add(Node n) {
    if (head == null) {
      head = n;
      return;
    }

    Node curr = head;
    while (curr.next != null) {
      curr = curr.next;
    }
    curr.next = n;
  }

  private void addNumber(int n) {
    Node node = new Node(n);
    add(node);
  }


  private static class Node {

    private int val;
    private Node next;

    public Node(int val) {
      this.val = val;
    }

    @Override
    public String toString() {
      return "Node{" +
          "val=" + val +
          '}';
    }
  }

  private Node getMiddle() {
    if (head == null) {
      return head;
    }
    Node slow = head;
    Node fast = head;
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }

  public static void main(String[] args) {
    LinkedList ll = new LinkedList();
    ll.addNumber(12);
    ll.addNumber(16);
    ll.addNumber(18);
    ll.addNumber(15);
    ll.addNumber(13);
    ll.addNumber(11);
    ll.print();
    System.out.println(ll.getMiddle());
    ll.reverse();
    ll.print();
  }
}
