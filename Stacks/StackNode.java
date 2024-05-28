package Stacks;

public class StackNode<T extends Comparable<T>> {

    public T data; // the data to be saved on the node
    public StackNode next; // the node after this node

    public StackNode(T data) {
        // constructor: save the data on this node, then make the next node null. 
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        /*
        method: converts the node to a string. 
        if the data is not null, return the data.toString() else return "null"
         */
        if (data != null) {
            return data.toString();
        }
        return "null";
    }

}
