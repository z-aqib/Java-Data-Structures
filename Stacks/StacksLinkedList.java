package Stacks;

public class StacksLinkedList<T extends Comparable<T>> {

    public StackNode top;

    public void push(T insertingValue) {
        if (this.top == null) {
            this.top = new StackNode(insertingValue);
            return;
        }
        StackNode temp = this.top;
        this.top = new StackNode(insertingValue);
        this.top.next = temp;
    }

    public Comparable<T> pop() {
        if (this.top == null) {
            return null;
        }
        Comparable<T> temp = this.top.data;
        this.top = this.top.next;
        return temp;
    }

}
