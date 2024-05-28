package LinkedListsSingly;

public class SinglyCircular<T extends Comparable<T>> {

    public SinglyNode tail;//stores the tail of the linkedlist
    public int size; //stores how many elements are in the data structure

    public SinglyCircular() {
        // constructor: standard constructor. makes tail null and size zero. 
        this.tail = null;
        this.size = 0;
    }

    @Override
    public String toString() {
        /*
        method: toString, converts the data structure to a string
        it gets each node until the node.next is equal to the tail, meaning we have traversed 
        the entire linked list
         */
        String str = "size=" + size + "{";
        SinglyNode duplicateTail = this.tail;
        if (duplicateTail != null) {
            duplicateTail = duplicateTail.next;
            while (duplicateTail != null && duplicateTail != this.tail) {
                str += duplicateTail + ",";
                duplicateTail = duplicateTail.next;
            }
        }
        return str + duplicateTail + "}";
    }

    public void display() {
        // method: displays the data structure's string
        System.out.println(toString());
    }

    public void insertStart(T valueToInsert) {
        /*
        method: inserts a value at the start of a data structure
        if the tail is null, insert at the tail and make the tail circular to itself
        otherwise create a new node and store it between the tail and the tail's.next
        then make the new node the tail. 
         */
        if (this.tail == null) {
            this.tail = new SinglyNode(valueToInsert);
            this.tail.next = this.tail;
        } else {
            SinglyNode insertingNode = new SinglyNode(valueToInsert);
            insertingNode.next = tail.next;
            this.tail.next = insertingNode;
        }
        size++;
        System.out.println("SUCCESS: '" + valueToInsert + "' inserted at start successfully. ");
    }

    public void insertEnd(T valueToInsert) {
        /*
        method: inserts a value at the end of a data structure
         */
        if (this.tail == null) {
            this.tail = new SinglyNode(valueToInsert);
            this.tail.next = this.tail;
        } else {
            SinglyNode insertingNode = new SinglyNode(valueToInsert);
            insertingNode.next = tail.next;
            this.tail.next = insertingNode;
            this.tail = insertingNode;
        }
        size++;
        System.out.println("SUCCESS: '" + valueToInsert + "' inserted at end successfully. ");
    }

    public void insertBefore(SinglyNode dataInsertBefore, T valueToInsert) {
        /*
        method: inserts a value before a specific value in the data structure
         */
        if (this.tail == null || dataInsertBefore == null) {
            System.out.println("ERROR: Cannot be inserted before '" + dataInsertBefore + "' as it does not exist. ");
            return;
        }
        SinglyNode previous = null;
        SinglyNode duplicateTail = this.tail.next;
        boolean roundCompleted = false;
        while (roundCompleted == false) {
            if (duplicateTail.next == dataInsertBefore) {
                previous = duplicateTail;
            }
            duplicateTail = duplicateTail.next;
            if (duplicateTail == this.tail.next) {
                roundCompleted = true;
            }
        }
        if (previous == null) {
            System.out.println("ERROR: Cannot insert before '" + dataInsertBefore + "' as it not found. ");
            return;
        }
        previous.next = new SinglyNode(valueToInsert);
        previous.next.next = dataInsertBefore;
        System.out.println("SUCCESS: '" + valueToInsert + "' inserted before '" + dataInsertBefore + "' successfully. ");
    }

    public void insertAfter(T dataInsertAfter, T valueToInsert) {
        /*
        method: inserts a value after a specific value in the data structure
         */
        
    }

    public void insertAt(int indexToInsert, T valueToInsert) {
        /*
        method: inserts a value at a specific index in the data structure
         */
    }

    public void insertInOrder(T valueToInsert) {
        /*
        method: inserts a value in order in the data structure
         */
    }

    public void update(int indexToUpdate, T valueToUpdate) {
        /*
        method: updates a specific index in the data structure
         */
    }

    public boolean find(T valueToFind) {
        /*
        method: finds whether or not a value is in the data structure
         */
        return false;
    }

    public Comparable<T> getValue(int indexToGet) {
        /*
        method: gets the value at a specific index in the data structure
         */
        return null;
    }

    public int getIndex(T valueToGet) {
        /*
        method: gets the index of where a value is placed within the data structure
         */
        return -1;
    }

    public Comparable<T> getFirst() {
        /*
        method: get the first value in the data structure
         */
        if (this.tail != null) {
            return this.tail.next.data;
        }
        return null;
    }

    public Comparable<T> getLast() {
        /*
        method: gets the last value in the data structure
         */
        return this.tail.data;
    }

    public boolean clear() {
        /*
        method: clears the data structure
         */
        this.tail = null;
        this.size = 0;
        System.out.println("SUCCESS: Linked List cleared successfully. ");
        return true;
    }

    public int size() {
        /*
        method: computes how many elements are present in the data structure
         */
        return size;
    }

    public boolean isEmpty() {
        /*
        method: tells if the data structure is empty or not
         */
        return size == 0;
    }

    public Comparable<T> deleteIndex(int indexToDelete) {
        /*
        method: deletes a specific index in the data structure
         */
        return null;
    }

    public Comparable<T> deleteFirstOccurence(T valueToDelete) {
        /*
        method: delets the first occurence of a specific value in the data structure
         */
        return null;
    }

    public void deleteAllOccurrences(T valueToDelete) {
        /*
        method: deletes all the occurences of a specific value in the data structure
         */
    }

    public Comparable<T> deleteFirst() {
        /*
        method: deletes the first element in the data structure
         */
        return null;
    }

    public Comparable<T> deleteLast() {
        /*
        method: deletes the last element in the data structure
         */
        return null;
    }

    public void sortLowToHigh() {
        /*
        method: sorts the data structure from low to high
         */
    }

    public void removingDuplicates() {
        /*
        method: removes duplicate values from the data structure
         */
    }

    public Comparable<T> findMax() {
        /*
        method: returns the largest value in the data structure
         */
        return null;
    }

    public Comparable<T> findMin() {
        /*
        method: returns the smallest value in the data structure
         */
        return null;
    }

    public Comparable<T>[] toArray() {
        /*
        method: converts the data structure to a single dimensional array
         */
        return null;
    }

    public void reverse() {
        /*
        method: reverses the values in the data structure
         */
    }

    public void assignRandomIntegers() {
        /*
        method: fills the data structure with random integer values between 0 to 9. 
        insertStart() with standard size of 10 random integers. 
         */
        for (int i = 0; i < 10; i++) {
            insertStart((T) (Integer) (int) (Math.random() * 10));
        }
    }

    public void merge() {
        /*
        method: merges the current data structure with a same data structure
         */
    }

}
