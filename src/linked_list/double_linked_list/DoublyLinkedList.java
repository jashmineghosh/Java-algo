package linked_list.double_linked_list;

import java.util.Arrays;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    public DoublyLinkedList(int value) {
        head = new Node(value);
        tail = head;
        length = 1;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        tail.next = newNode;
        newNode.previous = tail;
        tail = newNode;
        length++;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        head.previous = newNode;
        newNode.next = head;
        head = newNode;
        length++;
    }

    public int getLength() {
        return length;
    }

    public int[] printList() {
        int[] myList = new int[length];
        Node current = this.head;
        int i = 0;
        while (current != null) {
            myList[i] = current.value;
            current = current.next;
            i++;
        }
        return myList;
    }

    public void insert(int index, int value) {
        if (index < 0 || index > length) {
            System.err.println("Index Out Of Bounds For Length " + length);
        } else if (index == 0) {
            prepend(value);
        } else if (index == length) {
            append(value);
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
//            Node newNode = new Node(value);
//            newNode.next = current.next;
//            newNode.previous = current;
//            current.next.previous = newNode.next;
//            current.next = newNode;
//            length++;

            Node newNode = new Node(value);
            newNode.next = current.next;
            current.next = newNode;
            newNode.previous = current;
            newNode.next.previous = newNode;
            length++;
        }
    }

    public void remove(int index) {
        if (index < 0 || index > length) {
            System.err.println("Index Out Of Bounds For Length " + length);
        } else if (index == 0) {
            head = this.head.next;
            this.head.previous = null;
            length--;
        } else {
            Node current = head;
            int i;
            for (i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            length--;
            if (i == length - 1) {
                tail = current;
            } else {
                current.next.previous = current;
            }
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList myDoublyLinkedList = new DoublyLinkedList(5);
        myDoublyLinkedList.append(3);
        myDoublyLinkedList.append(4);
        myDoublyLinkedList.prepend(2);
        myDoublyLinkedList.prepend(1);
        System.out.println(Arrays.toString(myDoublyLinkedList.printList()));
        myDoublyLinkedList.remove(4);
        System.out.println(Arrays.toString(myDoublyLinkedList.printList()));
        myDoublyLinkedList.insert(2, 200);
        System.out.println(Arrays.toString(myDoublyLinkedList.printList()));
        System.out.println("length: " + myDoublyLinkedList.getLength());

        System.out.println("head value: " + myDoublyLinkedList.head.value);
        System.out.println("head.previous: " + myDoublyLinkedList.head.previous);

        System.out.println("tail value: " + myDoublyLinkedList.tail.value);
        System.out.println("tail.next: " + myDoublyLinkedList.tail.next);
    }
}