package DynamicArray;

// COMPLETED - ALL METHODS DONE
public class MyArrayList1D<T extends Comparable<T>> {

    /*
    This is a dynamic (resizeable) array (also known as an array list) data structure. it is one dimensional and of generic (any) type. you can add as many values as you like as it will resize itself where needed. Each method in the class is a function that can be performed on this one dimensional array. 
     */
    private T[] array; // the array
    private int pointerIndex; // pointer till which indexes previously are filled
    private int extraIndexCounter; // counts the no of indexes filled AFTER the pointerIndex with spaces in between
    private boolean sorted; // if the array is sorted or not

    public MyArrayList1D() {
        // constructor: to create a standard size array of 5
        this(5);
    }

    public MyArrayList1D(int size) {
        // constructor: creates an array of the given capacity by calling the start() method
        System.out.println("Welcome to MyArrayList1D!");
        start(size);
        System.out.println("Program has started running successfully. ");
    }

    private void start(int size) {
        // method: starts the array list, it declares an array of size given and sets the pointer Index. the extra indexes is zero as no elements have been inserted. 
        this.array = (T[]) new Comparable[size];
        this.pointerIndex = -1;
        this.extraIndexCounter = 0;
        this.sorted = true;
    }

    @Override
    public String toString() {
        // method: toString to getValue the entire array in one line
        String str = "[";
        int size = 0; // to count if we have displayed each non-null value or not
        for (int i = 0; i < capacity(); i++) {
            if (size < size()) { // if we still have to display values, 
                if (this.array[i] != null) { // if its a non-null value, 
                    size++; // increment size
                    if (this.array[i].toString().length() >= 5) { // if its string is too long, 
                        str += "\n"; // leave a line
                    }
                }
                str += this.array[i] + ","; // then display the value at that index
            } else if (size() == 0) {
                str += " ";
                break;
            }
        }
        return str.substring(0, str.length() - 1) + "]";
    }

    public void display() {
        // method: prints the array
        System.out.println(toString());
        System.out.println("SUCCESS: MyArrayList has been displayed successfully. ");
    }

    public void insertStart(T valueToInsert) {
        // method: it inserts values at the start. BIG OH = n. this is done by moving all the values one space forward and then inserting the value at the first index. if the array is already full, we will first increase its size then shift the values. 
        if (++pointerIndex == array.length) {
            incSize(array.length * 2);
        }
        for (int i = pointerIndex; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = valueToInsert;
        sorted = false;
        System.out.println("SUCCESS: Value '" + valueToInsert.toString() + "' has been added to the start successfully. ");
    }

    public void insertEnd(T valueToInsert) {
        // method: inserting values to the array. BIG OH = n. if array is full, double the size; after that add the element. else add normally. 
        if (size() == capacity()) {
            incSize(capacity() * 2);
        }
        this.array[++this.pointerIndex] = valueToInsert;
        sorted = false;
        System.out.println("SUCCESS: Value '" + valueToInsert.toString() + "' has been added to the end successfully. ");
    }

    public boolean insertBefore(T dataBeforeInserting, T valueToInsert) {
        // method: inserts a value before a specific value. (first occurence of that value) BIG OH = n. first it finds the index at which that value exists, if it doesnt exist it does not insert, else move all the values including the index one forward, then insert the value at the index. 
        int index = getIndex(dataBeforeInserting);
        if (index == -1) {
            System.out.println("ERROR: '" + valueToInsert + "' cannot be inserted before '" + dataBeforeInserting + "' as MyArrayList does not contain it. ");
            return false;
        }
        if (size() == capacity()) {
            incSize(capacity() * 2);
        }
        for (int i = ++pointerIndex; i >= index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = valueToInsert;
        sorted = false;
        System.out.println("SUCCESS: '" + valueToInsert + "' inserted before '" + dataBeforeInserting + "' successfully. ");
        return true;
    }

    public boolean insertAfter(T dataAfterInserting, T valueToInsert) {
        // method: inserts a value after a specific value. (first occurence of that value) BIG OH = n. first it finds the index at which that value exists, if it doesnt exist it does not insert, else move all the values not including the index one forward, then insert the value at index+1. 
        int index = getIndex(dataAfterInserting);
        if (index == -1) {
            System.out.println("ERROR: '" + valueToInsert + "' cannot be inserted after '" + dataAfterInserting + "' as MyArrayList does not contain it. ");
            return false;
        }
        if (size() == capacity()) {
            incSize(capacity() * 2);
        }
        for (int i = ++pointerIndex; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index + 1] = valueToInsert;
        sorted = false;
        System.out.println("SUCCESS: '" + valueToInsert + "' inserted after '" + dataAfterInserting + "' successfully. ");
        return true;
    }

    public boolean insertAt(int indexToInsertAt, T valueToInsert) {
        // method: inserts a value at a specific index. BIG OH = n. first it increases the array if its full. it checks the indexToInsertAt, if its valid, it runs further. first it checks, if the indexToInsertAt we are inserting on is just the next indexToInsertAt after where our currentPointer is, we will insert at end normally. otherwise, if the indexToInsertAt which we have to insert at is between our inserted elements, we will move them one forward and insert at that indexToInsertAt. otherwise, if we arent near our currentPointer, then insert at that indexToInsertAt and increment extra indexes. 
        if (indexToInsertAt < 0) {
            System.out.println("ERROR: Index to be updated is lesser than 0 and does not exist. ");
            return false;
        }
        if (indexToInsertAt >= capacity()) {
            incSize(indexToInsertAt + 1);
        }
        if (indexToInsertAt == this.pointerIndex + 1) { // if its just the next space, insertEnd normally
            insertEnd(valueToInsert);
        } else if (indexToInsertAt <= this.pointerIndex) { // if its in between, shift the rest then insert
            for (int i = ++pointerIndex; i >= indexToInsertAt && i != 0; i--) {
                array[i] = array[i - 1];
            }
            array[indexToInsertAt] = valueToInsert;
        } else { // otherwise, its being inserted. increment extraIndexes
            this.array[indexToInsertAt] = valueToInsert;
            this.extraIndexCounter++;
        }
        sorted = false;
        System.out.println("SUCCESS: '" + valueToInsert + "' inserted at '" + indexToInsertAt + "' successfully. ");
        return true;
    }

    public void insertInOrder(T valueToInsert) {
        // method: inserts in order in the arraylist. BIG OH = n^2. if it is sorted, find the correct index and call insertAt(); but if it is not sorted, just add it to the end and call sort(); 
        if (sorted == true) {
            int indexToInsertAt = -2;
            for (int i = 0; i < array.length; i++) {
                if (this.array[i].compareTo(valueToInsert) == 1) {
                    indexToInsertAt = i - 1;
                    break;
                }
            }
            if (indexToInsertAt == -2) {
                indexToInsertAt = pointerIndex;
            } else if (indexToInsertAt == -1) {
                indexToInsertAt = 0;
            }
            insertAt(indexToInsertAt, valueToInsert);
            sorted = true;
        } else {
            insertEnd(valueToInsert);
            sortLowToHigh();
        }
        System.out.println("SUCCESS: '" + valueToInsert + "' inserted in order successfully. ");
    }

    public boolean updateIndex(int indexToUpdate, T valueToUpdate) {
        // method: updates the valueToUpdate at a specific indexToUpdate. BIG OH = 1. it does not matter if the valueToUpdate at that indexToUpdate is null or already existing; this method will modify the data at an indexToUpdate. 
        // if indexToUpdate is lesser than zero, return immediately
        if (indexToUpdate < 0) {
            System.out.println("ERROR: Index to be updated is lesser than 0 and does not exist. ");
            return false;
        }
        // if indexToUpdate is greater than capacity of array, return. 
        if (indexToUpdate >= capacity()) {
            System.out.println("ERROR: Index to be updated is not within array bounds. ");
            return false;
        }
        // now either add it normally or updateIndex the specific indexToUpdate
        if (indexToUpdate == this.pointerIndex + 1) { // if its just the next space, insertEnd normally
            insertEnd(valueToUpdate);
        } else if (indexToUpdate <= this.pointerIndex) { // if its being modified, modify it
            this.array[indexToUpdate] = valueToUpdate;
        } else { // otherwise, its being inserted. increment extraIndexes
            this.array[indexToUpdate] = valueToUpdate;
            this.extraIndexCounter++;
        }
        sorted = false;
        System.out.println("SUCCESS: Value '" + valueToUpdate + "' has been updated to index " + indexToUpdate + " successfully. ");
        return true;
    }

    public boolean find(T valueToFind) {
        // method: finds if a specific value is in the arraylist or not. BIG OH = n. it uses getIndex(). getIndex() checks the entire array, if it finds it it returns its index else -1. in find, it checks if its -1, it returns false else true.
        if (getIndex(valueToFind) == -1) {
            System.out.println("ERROR: Value '" + valueToFind.toString() + "' does not exist in MyArrayList. ");
            return false;
        } else {
            System.out.println("SUCCESS: Value '" + valueToFind.toString() + "' is found");
            return true;
        }
    }

    public T getValue(int indexToGet) {
        // method: get the value at a specific indexToGet. BIG OH = 1. if array is large enough to have that indexToGet and value at it is not null, return the value, else return null.
        if (indexToGet <= capacity() - 1 && indexToGet >= 0) {
            System.out.println("SUCCESS: Value at index " + indexToGet + " is '" + this.array[indexToGet] + "'.");
            return this.array[indexToGet];
        } //else return null
        System.out.println("ERROR: Index " + indexToGet + " does not exist in MyArrayList. ");
        return null;
    }

    public int getIndex(T valueToGet) {
        // method: gets the index of a specific value. BIG OH = n. it searches each value in the array, if it finds the value, it returns its index else it returns -1. 
        if (size() == 0) {
            System.out.println("ERROR: MyArrayList is empty. ");
            return -1;
        }
        if (valueToGet == null) {
            System.out.println("ERROR: Value to find is null. ");
            return -1;
        }
        for (int i = 0; i < capacity(); i++) {
            if (this.array[i] != null && this.array[i].compareTo(valueToGet) == 0) {
                return i;
            }
        }
        return -1;
    }

    public T getFirst() {
        // method: gets the first element in the arraylist. BIG OH = 1. 
        if (size() > 0) {
            return this.array[0];
        } else {
            System.out.println("ERROR: MyArrayList is empty. ");
            return null;
        }
    }

    public T getLast() {
        // method: gets the last CONTINOUS element in the arraylist, updated indexes do not count. BIG OH = 1. i.e., if my arraylist is 1 5 4 3 n n n 10 n n, where n = null, then this method will return 3 as the last continuous value, 10 must have been inserted using insertAt()
        if (size() > 0) {
            return this.array[this.pointerIndex];
        } else {
            System.out.println("ERROR: MyArrayList is empty. ");
            return null;
        }
    }

    public boolean clear(T value) {
        // method: clear the array. make array new and default size, clear the index pointer and extra counter
        start(array.length);
        System.out.println("SUCCESS: MyArrayList has been cleared successfully. \n" + toString());
        System.out.println("Size = " + size() + "\nCapacity = " + capacity());
        return true;
    }

    public int size() {
        // method: gets how many elements are initialized in the array. BIG OH = 1. return the number of indexes used ex if pointerIndex is -1, it means 0 indexes used
        return this.pointerIndex + 1 + this.extraIndexCounter;
    }

    public int capacity() {
        // method: gets how many spaces we have in total. return the capacity of the array. BIG OH = 1;
        return this.array.length;
    }

    public boolean isEmpty() {
        // method: checks is the arraylist empty. returns if the size is 0 or not. for 0, true, else false. BIG OH = 1. 
        return size() == 0;
    }

    public boolean isFull() {
        // method: checks is the arraylist full. returns if the size is equal to capacity or not. BIG OH = 1. 
        return size() == capacity();
    }

    public T deleteIndex(int indexToDelete) {
        /*
        method: removes a specific index. BIG OH = 1. 
        by moving all the values ahead of it one step forward, and making the last value null. 
         */
        //if indexToDelete is lesser than zero, return immediately
        if (indexToDelete == -1 || indexToDelete >= capacity()) {
            System.out.println("ERROR: ArrayList does not contain index " + indexToDelete);
            return null;
        } else if (indexToDelete < 0) {
            System.out.println("ERROR: Index to be removed is lesser than 0 and does not exist. ");
            return null;
        }
        T deletingValue = array[indexToDelete];
        //until the last indexToDelete, move each value forward to remove the removing indexToDelete
        while (indexToDelete + 1 < capacity()) {
            this.array[indexToDelete++] = this.array[indexToDelete + 1];
        }
        this.array[this.pointerIndex--] = null;
        System.out.println("SUCCESS: index " + indexToDelete + " has been removed successfully.");
        return deletingValue;
    }

    public T deleteFirstOccurence(T valueToDelete) {
        /*
        method: this method removes a specific valueToDelete from the array. BIG OH = n. 
        it backtracks the rest of the values. first find the index that you want to remove. then remove that index. 
         */
        int index = getIndex(valueToDelete);
        if (index != -1) {
            return deleteIndex(index);
        }
        System.out.println("ERROR: Value '" + valueToDelete + "' could not be removed as it doesnt exist. ");
        return null;
    }

    public void deleteAllOccurrences(T valueToDelete) {
        // method: deletes all occurences of a value. BIG OH = n. repeatedly calls delete until the value is no longer found
        int index = getIndex(valueToDelete);
        while (index != -1) {
            deleteIndex(index);
            index = getIndex(valueToDelete);
        }
        System.out.println("SUCCESS: All occurences of '" + valueToDelete + "' has been deketed successfully. ");
    }

    public T deleteFirst() {
        // method: deletes the first index. BIG OH = n. 
        return deleteIndex(0);
    }

    public T deleteLast() {
        // method: deletes the last index. BIG OH = 1. 
        return deleteIndex(pointerIndex);
    }

    public void sortLowToHigh() {
        /*
        method: sorts the array. BIG OH = n^2. 
        getValue a value and compare it to each value after it IF they are not null. if the value being compared with each value is LARGER, switch its places. then do this in nested for loop so that each value in the array is compared with every value. 
         */
        if (sorted == true) {
            System.out.println("MyArrayList1D is already sorted. ");
            return;
        }
        for (int i = 0; i < this.array.length; i++) {
            for (int j = i + 1; j < this.array.length; j++) {
                if (this.array[i] != null && this.array[j] != null && this.array[i].compareTo(this.array[j]) == 1) {
                    T temp = this.array[j];//swap the values
                    this.array[j] = this.array[i];
                    this.array[i] = temp;
                }
            }
        }
        sorted = true;
        System.out.println("SUCCESS: The arraylist has been sorted from low to high successfully. ");
    }

    public void removingDuplicates() {
        //method: removes duplicates. BIG OH = n. sort the array then check each value with its forward value. if same, remove it
        if (sorted == false) {
            sortLowToHigh();
        }
        for (int i = 0; i + 1 < capacity(); i++) {
            // forward checking
            if (array[i] != null && array[i + 1] != null && array[i].compareTo(array[i + 1]) == 0) {
                deleteIndex(i + 1);
            }
            // backward checking
            if (i != 0 && array[i] != null && array[i - 1] != null && array[i].compareTo(this.array[i - 1]) == 0) {
                deleteIndex(i);
            }
        }
        System.out.println("SUCCESS: All the duplicates have been removed successfully. ");
    }

    public T findMax() {
        // method: finding the maximum value. BIG OH = n^2. sort the array and return the last value used
        if (sorted == false) {
            sortLowToHigh();
        }
        return this.array[this.pointerIndex];
    }

    public T findMin() {
        // method: finding the minimum value. BIG OH = N^2. sort the array and return the first value
        if (sorted == false) {
            sortLowToHigh();
        }
        return this.array[0];
    }

    public Comparable<T>[] toArray() {
        // method: converts the matrix to a single dimensional array
        return array;
    }

    public void reverse() {
        /*
        method: reverses the values of the array. space and time complexity is n/2
        two ways are:
        WAY 1 -> create another arraylist and copy each value from bottom to top. problems are that there is more time complexity and space complexity
        WAY 2 -> swap the beginning and last values and move further inside until there are no more values to swap. this is better as it doesnt required additional 
         */
        for (int forward = 0, backward = pointerIndex; forward != backward && backward > forward; forward++, backward--) {
            T temp = array[forward];
            array[forward] = array[backward];
            array[backward] = temp;
        }
        System.out.println("SUCCESS: ArrayList has been reversed successfully. ");
    }

    private void incSize(int incrementSize) {
        /*
        method: resizes the array when space is finished. BIG OH = N. 
        it creates a new array with larger size, copies each value, then assigns the new array to the array. 
         */
        T[] newArray = (T[]) new Comparable[incrementSize];
        System.arraycopy(this.array, 0, newArray, 0, capacity());
//        OR, YOU CAN MANUAL COPY: 
//        for (int i = 0; i < capacity(); i++) {
//            newArray[i] = this.array[i];
//        }
        this.array = newArray;
    }

    public void assignRandomIntegers() {
        // method: assigns random integer values to the data structure. BIG OH = N. 
        int remainingSpace = capacity() - size();
        for (int i = 0; i < remainingSpace; i++) {
            insertEnd((T) (Comparable) (int) (Math.random() * 10));
        }
        System.out.println("SUCCESS: MyArrayList has been assigned " + remainingSpace + " random integers successfully. ");
    }

}
