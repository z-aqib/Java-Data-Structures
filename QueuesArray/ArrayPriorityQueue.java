package QueuesArray;

public class ArrayPriorityQueue<T extends Comparable<T>> {

    public T[] queue;
    public int front;

    public ArrayPriorityQueue() {
        this(10);
    }

    public ArrayPriorityQueue(int size) {
        queue = (T[]) new Comparable[size];
        front = -1;
    }

    public void Enqueue(T obj) {
        if (isEmpty() == true) {
            this.queue[++this.front] = obj;
            return;
        }
        if (isFull() == true) {
            System.out.println("ERROR: Cannot be enqueued as queue is full. ");
            return;
        }
        for (int i = 0; i < this.queue.length && i <= this.front; i++) {
            T t = this.queue[i];
            if (t.compareTo(obj) == -1) {
                for (int counter = ++this.front; counter-- != i;) {
                    this.queue[counter + 1] = this.queue[counter];
                }
                this.queue[i] = obj;
                return;
            }
        }
        this.queue[++this.front] = obj;
    }

    public T Dequeue() {
        if (isEmpty() == true) {
            System.out.println("ERROR: Cannot be dequeued as queue is empty. ");
            return null;
        }
        return this.queue[this.front--];
    }

    public boolean isEmpty() {
        return this.front == -1;
    }

    public boolean isFull() {
        return this.front == queue.length - 1;
    }

    public T peek() {
        return this.queue[this.front];
    }

    @Override
    public String toString() {
        String str = "[";
        for (int i = this.front; i > 0; i--) {
            str = str + queue[i].toString() + " , ";
        }
        return str + queue[0].toString() + "]";
    }

}// class end

