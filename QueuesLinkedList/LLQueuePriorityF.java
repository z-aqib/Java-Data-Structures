package QueuesLinkedList;

// COMPLETED
public class LLQueuePriorityF<T extends Comparable<T>> {

    public Node front;

    /*
    -it extends the normal linked list with only FRONT node, no rear node
    -the only difference is during enqueue is that we enqueue a node where it is required
    i.e. by its priority
     */
    public LLQueuePriorityF() {
        System.out.println("This is a priority queue. ");
    }

    public void Enqueue(T obj) {
        if (isEmpty() == true) {
            this.front = new Node(obj);
        } else if (this.front.data.compareTo(obj) == 1) {
            Node temp = this.front;
            this.front = new Node(obj);
            this.front.next = temp;
        } else {
            Node temp = this.front;
            Node previous = temp;
            while (temp.next != null) {
                temp = temp.next;
                if (temp.data.compareTo(obj) == 1) {
                    previous.next = new Node(obj);
                    previous.next.next = temp;
                    return;
                }
                previous = temp;
            }
            temp.next = new Node(obj);
        }

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
