package linkedlists;

public class LinkedListNumberAddition {

  private static class Node {

    int val;
    Node next;

    public Node(int val) {
      this.val = val;
    }
  }

  public static void main(String[] args) {
    Node first = new Node(5);
    first.next = new Node(2);
    first.next.next = new Node(7);

    Node second = new Node(5);
    second.next = new Node(2);
    second.next.next = new Node(7);

    print(add(first, second));

  }

  private static void print(Node head) {
    Node curr = head;
    while (curr != null) {
      System.out.print(curr.val);
      curr = curr.next;
    }
  }

  private static Node reverse(Node head) {

    Node prev = null;
    Node curr = head;
    Node next = null;

    while (curr != null) {
      // Save the gotoNext node before breaking the link
      next = curr.next;
      // reverse the link
      curr.next = prev;
      // Move the iterating vars
      prev = curr;
      curr = next;
    }
    return prev;
  }


  // Returns a Fat Node where value can be greater than 10
  private static Node addNodes(Node f, Node s, int carry) {
    if (f == null && s == null) {
      throw new IllegalArgumentException("both null");
    }

    if (f == null) {
      return new Node(s.val + carry);
    }

    if (s == null) {
      return new Node(f.val + carry);
    }
    return new Node((f.val + s.val + carry));
  }


  // 563 -> 5 -> 6 -> 3
  public static Node add(Node head1, Node head2) {
    Node num1 = reverse(head1);
    Node num2 = reverse(head2);
    Node result = new Node(-1);
    Node resultIterator = result;
    int carry = 0;
    while (num1 != null || num2 != null) {
      resultIterator.next = addNodes(num1, num2, carry);
      resultIterator = resultIterator.next;
      carry = resultIterator.val / 10;
      resultIterator.val = resultIterator.val % 10;

      num1 = getNext(num1);
      num2 = getNext(num2);
    }

    if (carry != 0) {
      resultIterator.next = new Node(carry);
    }

    // Remove the dummy head
    result = result.next;
    return reverse(result);
  }

  private static Node getNext(Node num1) {
    if (num1 != null) {
      return num1.next;
    } else {
      return null;
    }
  }
}
