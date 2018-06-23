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

  public void addTail(int val) {
    if (head == null) {
      initializeLinkedList(val);
    } else {
      Node n = head;
      while (n.next != null) {
        n = n.next;
      }
      n.next = new Node(val);
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
    Node next = this.head;
    while (next != null) {
      System.out.print(next.getValue());
      System.out.print("->");
      next = next.getNext();
    }
    System.out.println();
  }

  public static void main(String[] args) {
    LinkedListCustom linkedListCustom = new LinkedListCustom();
    linkedListCustom.addHead(10);
    linkedListCustom.addHead(12);
    linkedListCustom.addHead(3);
    linkedListCustom.display();

    LinkedListCustom linkedListCustom2 = new LinkedListCustom();
    linkedListCustom2.addTail(10);
    linkedListCustom2.addTail(12);
    linkedListCustom2.addTail(3);
    linkedListCustom2.addTail(32);
    linkedListCustom2.addTail(35);
    linkedListCustom2.display();
    linkedListCustom.reverse();
    linkedListCustom2.reverse();

    linkedListCustom.display();
    linkedListCustom2.display();

    LinkedListCustom linkedListCustomOneElement = new LinkedListCustom();
    linkedListCustomOneElement.addTail(10);
    linkedListCustomOneElement.reverse();
    linkedListCustomOneElement.display();

    LinkedListCustom linkedListCustomTwoElement = new LinkedListCustom();
    linkedListCustomTwoElement.addTail(10);
    linkedListCustomTwoElement.addTail(13);
    linkedListCustomTwoElement.reverse();
    linkedListCustomTwoElement.display();

  }

  public void reverse() {
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
