package LinkedListsDoubly;

public class DoublyNode<T extends Comparable<T>> {

    /*
    this is the node class of the DOUBLY linked list data structure. it is of generic 
    type and can add any type of data. a single node in a doubly linked list contains 
    the data to be stored, the previous node behind it and the next node after it. 
     */
    public T data; // data to be stored
    public DoublyNode next; //next node after this node
    public DoublyNode previous; // previous node before this node

    public DoublyNode(T data) {
        // constructor: saves the data of this node
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    @Override
    public String toString() {
        return data.toString();
    }

}
