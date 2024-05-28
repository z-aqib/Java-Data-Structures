package Main;

// this class is used to be copy pasted to all Data Structures
public class General<T extends Comparable<T>> {

    public General() {
        // constructor: standard constructor
    }

    public General(int size) {
        // constructor: with parameters
    }

    @Override
    public String toString() {
        /*
        method: toString, converts the data structure to a string
         */
        return "";
    }

    public void display() {
        // method: displays the data structure's string
        System.out.println(toString());
    }

    public void insertStart(T valueToInsert) {
        /*
        method: inserts a value at the start of a data structure
         */
    }

    public void insertEnd(T valueToInsert) {
        /*
        method: inserts a value at the end of a data structure
         */
    }

    public void insertBefore(T dataInsertBefore, T valueToInsert) {
        /*
        method: inserts a value before a specific value in the data structure
         */
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
        return null;
    }

    public Comparable<T> getLast() {
        /*
        method: gets the last value in the data structure
         */
        return null;
    }

    public boolean clear() {
        /*
        method: clears the data structure
         */
        return false;
    }

    public int size() {
        /*
        method: computes how many elements are present in the data structure
         */
        return -1;
    }

    public int capacity() {
        /*
        method: computes how many available spaces are in the data structure
         */
        return -1;
    }

    public boolean isEmpty() {
        /*
        method: tells if the data structure is empty or not
         */
        return false;
    }

    public boolean isFull() {
        /*
        method: tells if the data structure is full or not
         */
        return size() == capacity();
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

    public void incSize(int incrementSize) {
        /*
        method: increases the size of the data structure
        */
    }

    public void assignRandomIntegers() {
        /*
        method: fills the data structure with random integer values between 0 to 9. 
        */
    }

    public void merge() {
        /*
        method: merges the current data structure with a same data structure
        */
    }

}
