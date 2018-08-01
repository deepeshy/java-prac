package linkedlists;

public class LinkedListCustom {

  private Node head;

  public static class Node {

    int value;
    Node next;

    public Node(int value) {
      this.value = value;
    }

    public void setNext(Node next) {
      this.next = next;
    }

    public int getValue() {
      return value;
    }

    public Node getNext() {
      return next;
    }
  }

  public void addHead(int val) {
    if (head == null) {
      initializeLinkedList(val);

    } else {
      Node rootCopy = new Node(head.value);
      rootCopy.next = head.next;
      Node newNode = new Node(val);
      newNode.next = rootCopy;
      head = newNode;
    }
  }

  public void addTail(Node newNode) {
    if (head == null) {
      head = newNode;
    } else {
      Node n = head;
      while (n.next != null) {
        n = n.next;
      }
      n.next = newNode;
      n.next.next = null;
    }
  }

  private void initializeLinkedList(int val) {
    head = new Node(val);
    head.next = null;
  }


  public void remove(int val) {

  }

  public void display() {
    if (!hasCycle()) {
      Node next = this.head;
      while (next != null) {
        System.out.print(next.getValue());
        System.out.print("->");
        next = next.getNext();
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    LinkedListCustom linkedListCustom = new LinkedListCustom();
    linkedListCustom.addHead(10);
    linkedListCustom.addHead(12);
    linkedListCustom.addHead(3);
    linkedListCustom.display();

    LinkedListCustom linkedListCustom2 = new LinkedListCustom();
    linkedListCustom2.addTail(new Node(10));
    linkedListCustom2.addTail(new Node(12));
    linkedListCustom2.addTail(new Node(3));
    linkedListCustom2.addTail(new Node(32));
    linkedListCustom2.addTail(new Node(35));
    linkedListCustom2.display();
    linkedListCustom.reverse();
    linkedListCustom2.reverse();

    linkedListCustom.display();
    linkedListCustom2.display();

    LinkedListCustom linkedListCustomOneElement = new LinkedListCustom();
    linkedListCustomOneElement.addTail(new Node(10));
    linkedListCustomOneElement.reverse();
    linkedListCustomOneElement.display();

    LinkedListCustom linkedListCustomTwoElement = new LinkedListCustom();
    linkedListCustomTwoElement.addTail(new Node(10));
    linkedListCustomTwoElement.addTail(new Node(13));
    linkedListCustomTwoElement.reverse();
    linkedListCustomTwoElement.display();
    System.out.println(linkedListCustomTwoElement.hasCycle());

    LinkedListCustom linkedListWithCycle = new LinkedListCustom();
    Node cycle = new Node(10);
    linkedListWithCycle.addTail(cycle);
    Node node2 = new Node(13);
    linkedListWithCycle.addTail(node2);
    node2.next = cycle;
    linkedListWithCycle.reverse();
    linkedListWithCycle.display();
    System.out.println(linkedListWithCycle.hasCycle());

  }

  public boolean hasCycle() {
    if (head == null || head.next == null) {
      return false;
    }

    Node fast = head;
    Node slow = head;

    while (slow != null && fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (fast == slow) {
        return true;
      }
    }
    return false;
  }

  public Node getTail(int n) {
    return null;
  }

  public Node getMid() {
    return null;
  }

  public int size() {
    return 0;
  }


  public void reverse() {
    if (!hasCycle()) {
      Node prev = null;
      Node curr = head;
      Node nxt;
      while (curr != null) {
        nxt = curr.next;
        curr.next = prev;
        prev = curr;
        curr = nxt;
      }
      head = prev;
    }
  }
}
