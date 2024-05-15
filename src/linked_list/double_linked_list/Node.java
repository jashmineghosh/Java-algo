package linked_list.double_linked_list;

public class Node {
    int value;
    Node next;
    Node previous;

    public Node(int value) {
        this.value = value;
        this.next = null;
        this.previous = null;
    }
}
