package QueuesLinkedList;

public class LLQueueNormalFR<T extends Comparable<T>> {

    public Node front;
    public Node rear;

    public LLQueueNormalFR() {
        System.out.println("SUCCESS: Linked List Based Queue has started running successfully. ");
    }

    public void Enqueue(T obj) {
        if (isEmpty() == true) {
            this.front = this.rear = new Node(obj);
            return;
        }
        Node temp = this.rear;
        this.rear = new Node(obj);
        temp.next = this.rear;
    }

    public T Dequeue() {
        if (isEmpty() == true) {
            System.out.println("ERROR: Cannot be dequeued as queue is empty. ");
            return null;
        }
        Node removingNode = this.front;
        this.front = this.front.next;
        return (T) removingNode.data;
    }

    public boolean isEmpty() {
        return this.front == null;
    }

    public T peek() {
        if (isEmpty() == true) {
            System.out.println("ERROR: Queue is empty. ");
            return null;
        }
        return (T) this.front.data;
    }

    @Override
    public String toString() {
        String str = "[";
        Node duplicateNode = this.front;
        while (duplicateNode != null) {
            str = str + duplicateNode.toString() + " , ";
            duplicateNode = duplicateNode.next;
        }
        if (str.length() > 2) {
            str = str.substring(0, str.length() - 3);
        }
        return str + "]";
    }

}
