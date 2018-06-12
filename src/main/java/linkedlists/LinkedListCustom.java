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

    public void add(int val) {
        if (head == null) {
            head = new Node(val);
            head.setNext(null);
        } else {

        }
    }

    public void remove(int val) {

    }

    public void display() {
        Node next = this.head;
        while (next != null) {
            System.out.print(next.getValue());
            System.out.print(" ");
            next = next.getNext();
        }
    }

    public static void main(String[] args) {
        LinkedListCustom linkedListCustom = new LinkedListCustom();
        linkedListCustom.add(10);
        linkedListCustom.add(12);
        linkedListCustom.add(3);
    }

}
