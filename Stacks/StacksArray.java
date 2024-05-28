package Stacks;

public class StacksArray<T extends Comparable<T>> {

    public T stackList[];
    public int top;

    public StacksArray(int sizeOfStack) {
        // constructor
        this.stackList = (T[]) new Comparable[sizeOfStack];
        this.top = -1;
    }

    public void push(T insertingData) {
        if (isFull() == true) {
            System.out.println("ERROR: Stack is full. Element cannot be pushed in stack. ");
            return;
        }
        this.stackList[++this.top] = insertingData;
    }

    public T pop() {
        if (isEmpty() == true) {
            System.out.println("ERROR: Stack is empty. Element cannot be popped from stack. ");
            return null;
        }
        return this.stackList[this.top--];
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public boolean isFull() {
        return this.top == this.stackList.length - 1;
    }

    public T peek() {
        return this.stackList[this.top];
    }

    @Override
    public String toString() {
        String str = "{";
        for (int i = 0; i <= top; i++) {
            str = str + stackList[i].toString() + " , ";
        }
        if (str.length() >= 2) {
            str = str.substring(0, str.length() - 3);
        }
        return str + "}";
    }
}
