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
    first.next.next.next = new Node(6);

    Node second = new Node(5);
    second.next = new Node(2);
    second.next.next = new Node(7);

    // add mutates the inputs, so once called it messes up the results
    print(add(first, second));
//    print(addWithoutReversing(first, second));
  }


  private static int len(Node h) {
    int l = 0;
    Node curr = h;
    while (curr != null) {
      l++;
      curr = curr.next;
    }
    return l;
  }

  private static Node addWithoutReversing(Node f, Node s) {
    Node result = new Node(-1);
    Node resultIter = result;

    Node fIter = f;
    Node sIter = s;

    int lf = len(f);
    int ls = len(s);
    int diff = lf - ls; // diff < 0 => f is smaller, >0, s is smaller
    int skipCounter = 0;

    while (fIter != null || sIter != null) {
      if (diff < 0 && skipCounter < Math.abs(diff)) { // f is smaller
        skipCounter++;
        resultIter.next = new Node(sIter.val);
        sIter = sIter.next;
      } else if (diff > 0 && skipCounter < Math.abs(diff)) { // s is smaller, pump in nodes from f
        skipCounter++;
        resultIter.next = new Node(fIter.val);
        fIter = fIter.next;
      } else {
        resultIter.next = addNodes(fIter, sIter, 0);
        fIter = fIter.next;
        sIter = sIter.next;
      }
      resultIter = resultIter.next;
    }
    // Handle Fat nodes, to take out carry
    // Eliminate dummy node
    result = result.next;
    resultIter = result;// new result iter for handling carry values

    int carryCounter;
    do {
      carryCounter = 0;
      while (resultIter.next != null) {
        int nextVal = resultIter.next.val;
        int carry = nextVal / 10;
        if (carry > 0) {
          carryCounter++;
        }
        resultIter.val = resultIter.val + carry;
        resultIter.next.val = nextVal % 10;
        resultIter = resultIter.next;
      }
      resultIter = result;

    } while (carryCounter > 0);

    if (result.val >= 10) {
      Node newHead = new Node(result.val / 10);
      result.val = result.val % 10;
      newHead.next = result;
      return newHead;
    }
    return result;
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
