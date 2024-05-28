package Heap;

public class HeapArray<T extends Comparable<T>> {

    public T[] heap;
    public int elementsPointer;

    public HeapArray() {
        this(10);
    }

    public HeapArray(int size) {
        this.heap = (T[]) new Comparable[size];
        this.elementsPointer = -1;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < heap.length; i++) {
            str = str + heap[i];
            if (heap[i] != null) {
                str = str + "  ";
            }
            if (i != heap.length - 1) {
                str = str + " , ";
            }
        }
        return "[" + str + "]";
    }

    public void insert(T insertingValue) {
        if (isFull() == false) {
            heap[++elementsPointer] = insertingValue;
            siftup(elementsPointer);
        }
    }

    private void siftup(int index) {
        if (parent(index) < 0) {
            return;
        }
        if (heap[parent(index)].compareTo(heap[index]) == -1) {
            swap(index, parent(index));
            siftup(parent(index));
        }
    }

    public boolean isFull() {
        return elementsPointer == heap.length - 1;
    }

    private void swap(int i, int j) {
        T temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private int right(int index) {
        return (2 * index) + 2;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int left(int index) {
        return (2 * index) + 1;
    }

}
