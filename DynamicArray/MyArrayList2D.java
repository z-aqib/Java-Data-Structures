package DynamicArray;

// COMPLETED - ALL METHODS DONE
public class MyArrayList2D<T extends Comparable<T>> {

    /*
    This is a dynamic (resizeable) array (also known as an array list) data structure. it is two dimensional and of generic (any) type. you can insertEnd as many values as you like as it will resize itself where needed. Each method in the class is a function that can be performed on this two dimensional array. 
     */
    private T[][] array; // the array containing the values
    private int currentRow; // the current row till which we have filled
    private int currentCol; // the current column till which we have filled
    private int max_length; // the maximum length of the elements
    private boolean sorted; // whether or not the array list is sorted

    public MyArrayList2D() {
        // constructor: if user doesnt specify its required size of 2d array, it will create a standard size of 5 by 5. it is a dynamic resizeable array. 
        this(5, 5);
    }

    public MyArrayList2D(int row, int col) {
        // constructor: calls start() which performs the necessary actions. 
        start(row, col);
        System.out.println("Two Dimension Dynamic Array[][] of " + row + " rows and " + col + " columns has been created successfully. ");
    }

    private void start(int row, int col) {
        // method: starts the class. BIG OH = 1. create a 2d array of row,col size and intialize the currentRow and currentCol indexes to be -1 (to show that array is empty)the maximum length of each element is 4 as all elements are 'null'. the maximum length will be recaculated at every element addition. 
        this.array = (T[][]) new Comparable[row][col];
        this.currentCol = this.currentRow = -1;
        this.max_length = 4;
        this.sorted = true;
    }

    @Override
    public String toString() {
        /*
        method: to String() method. Big OH = m*n. 
        prints the 2d array by creating its string, first it runs two for loops: one till the currently occupied row and one for all columns. it will first get an element, display it then getIndex out how many spaces to leave before the next element. here max_length will be used, if it a null element, its length is 4. but if not null, we will compute its length. using its length, we getIndex how many remaining spaces are left after we deduct from the max_length of element. then we display that many spaces using a for loop. after each row, we leave a line. 
        UPDATE: so now the remaining_spaces are computed before the data is printed and half of the spaces are displayed before the digit and half after. this makes the digit in the middle of the cell instead of left side. UPDATE: column numbers are to be displayed as well. 
         */
        // column heading string
        String str = "column| ";
        int max_cols = array[0].length;
        for (int i = 0; i < max_cols; i++) {
            max_cols = Math.max(max_cols, array[i].length);
            for (int j = 0; j < max_length / 2; j++) {
                str += " ";
            }
            str += i;
            for (int j = 0; j < max_length / 2; j++) {
                str += " ";
            }
        }
        // border string
        str += "\n";
        String borderString = "----";
        for (int i = 0; i < 8 + (max_cols * max_length); i++) {
            borderString += "-";
        }
        // data string
        for (int i = 0; i < this.array.length; i++) {
            str += "row " + i + " | ";
            for (int j = 0; j < this.array[0].length; j++) {
                int remaining_spaces = max_length - 4;
                if (this.array[i][j] != null) {
                    remaining_spaces = max_length - this.array[i][j].toString().length();
                }
                int count_spaces_left = remaining_spaces - (remaining_spaces / 2);
                for (int k = 0; k < remaining_spaces / 2; k++) {
                    str += " ";
                }
                str += this.array[i][j] + " "; // print the element
                // now for the spacing between each element
                for (int k = 0; k < count_spaces_left; k++) {
                    str += " ";
                }
            }
            str += "\n";
        }
        return borderString + "\n" + str.substring(0, str.length() - 2) + "\n" + borderString;
    }

    public void display() {
        // method: displays the entire array. BIG OH = M*N. by converting to string and displaying the string
        System.out.println(toString());
        System.out.println("SUCCESS: MyArrayList has been displayed successfully. ");
    }

    public void insertStart(T valueToInsert) {
        // method: inserts at the start of the matrix. BIG OH = M*N. first it moves all the elements one ahead, then adds the new valueToInsert to the start. this is done by first finding the next null space. then it shifts the lastly inserted valueToInsert to the null space. then it shifts all the rest of the valueToInsert just one ahead until we reach (0,0). then it inserts at (0,0)
        // if array is null, insert at the head normally
        if (currentRow == -1) {
            array[++currentRow][++currentCol] = valueToInsert;
        } else {
            // first getIndex the next null space
            int[] current = {currentRow, currentCol}; // save the current space somewhere
            assignNextNullSpace();
            // shift the last index to this new null space
            this.array[currentRow][currentCol] = array[current[0]][current[1]];
            // now move all the values behind currentRow and currentCol one space forward
            int[] nextIndex;
            while (isFirst(current[0], current[1]) != true) {
                nextIndex = moveBackward(current[0], current[1]);
                array[current[0]][current[1]] = array[nextIndex[0]][nextIndex[1]];
                current[0] = nextIndex[0];
                current[1] = nextIndex[1];
            }
            // now that we are at the first space, insert the value
            array[current[0]][current[1]] = valueToInsert;
            max_length = Math.max(max_length, valueToInsert.toString().length()); // recompute max_length
            sorted = false;
        }
        System.out.println("SUCCESS: '" + valueToInsert + "' has been successfully inserted at start. ");
    }

    public void insertEnd(T valueToInsert) {
        // method: adds a valueToInsert to the next NULL space in the matrix. BIG OH = M*N. i.e. it inserts at the end of all inserted. first it checks if the matrix is full or not. then it checks if we've reached the end of the row, then increment row and go to the first column. then it checks, is that space null? if yes, break the loop and place the valueToInsert at that space. if not, rerun the loop to getIndex an empty null space. after the valueToInsert is placed, compare its length to the max_length and re-calculate max_length. 
        // getIndex the next available space
        assignNextNullSpace();
        this.array[currentRow][currentCol] = valueToInsert; // put the valueToInsert at this null space
        max_length = Math.max(max_length, valueToInsert.toString().length()); // compute its max_length
        sorted = false;
        System.out.println("SUCCESS: '" + valueToInsert + "' has been added to (" + currentRow + "," + currentCol + "). ");
    }

    public boolean insertBefore(T dataInsertBefore, T valueToInsert) {
        // method: inserts before the first occurence of a specific data. BIG OH = M*N. gets index and inserts before that. 
        int[] index = getIndex(dataInsertBefore);
        if (index[0] == -1 || index[1] == -1) {
            System.out.println("ERROR: Cannot be inserted before '" + dataInsertBefore + "' as it not inside the ArrayList. ");
            return false;
        }
        insertAt(index[0], index[1], valueToInsert);
        sorted = false;
        System.out.println("SUCCESS: '" + valueToInsert + "' inserted before '" + dataInsertBefore + "' successfully. ");
        return true;
    }

    public boolean insertAfter(T dataInsertAfter, T valueToInsert) {
        // method: inserts after the first occurence of a specific data. BIG OH = M*N. gets index and inserts after that.
        int[] index = getIndex(dataInsertAfter);
        if (index[0] == -1 || index[1] == -1) {
            System.out.println("ERROR: Cannot be inserted after '" + dataInsertAfter + "' as it not inside the ArrayList. ");
            return false;
        }
        index = moveForward(index[0], index[1]);
        insertAt(index[0], index[1], valueToInsert);
        sorted = false;
        System.out.println("SUCCESS: '" + valueToInsert + "' inserted after '" + dataInsertAfter + "' successfully. ");
        return true;
    }

    public boolean insertAt(int row, int col, T valueToInsert) {
        // method: inserts at a specific index BIG OH = M*N; if that index doesnt exist, return . if that index requires more space, increase space. if that index is null, insert normally. otherwise, find the next null space, move all the values forward, and then insert at that index. 
        if (row < 0 || col < 0) {
            System.out.println("ERROR: Cannot be inserted at (" + row + "," + col + ") as it is invalid. ");
            return false;
        }
        // increase space
        if (row + 1 >= this.array.length && col + 1 >= this.array[0].length) {
            incSize(row + 2, col + 2);
        } else if (row + 1 >= this.array.length) {
            incSize(row + 2, this.array[0].length);
        } else if (col + 1 >= this.array[0].length) {
            incSize(this.array.length, col + 2);
        }
        // insert value
        if (array[row][col] == null) {
            array[row][col] = valueToInsert;
        } else {
            // first getIndex the next null space
            int[] current = {currentRow, currentCol}; // save the current space somewhere
            assignNextNullSpace();
            // shift the last index to this new null space
            this.array[currentRow][currentCol] = array[current[0]][current[1]];
            // now move all the values behind currentRow and currentCol one space forward
            int[] nextIndex;
            while (current[0] != row || current[1] != col) {
                nextIndex = moveBackward(current[0], current[1]);
                array[current[0]][current[1]] = array[nextIndex[0]][nextIndex[1]];
                current = nextIndex;
            }
            array[current[0]][current[1]] = valueToInsert;
            max_length = Math.max(max_length, valueToInsert.toString().length());
        }
        System.out.println("SUCCESS: The value '" + valueToInsert + "' is inserted at (" + row + "," + col + ") successfully. ");
        return true;
    }

    public void insertInOrder(T valueToInsert) {
        //method: inserts in order. IF UNSORTED: inserts normally then sorts it. IF SORTED: finds the position to add it and does insertAt()
        if (sorted == false) {
            insertEnd(valueToInsert);
            sortLowToHigh();
        } else {
            boolean inserted = false;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    if (array[i][j].compareTo(valueToInsert) == 1) {
                        insertAt(i, j, valueToInsert);
                        inserted = true;
                    }
                }
            }
            if (inserted == false) {
                insertEnd(valueToInsert);
            }
        }
        sorted = true;
        System.out.println("SUCCESS: The value '" + valueToInsert + "' has been inserted in order successfully. ");
    }

    public boolean updateIndex(int row, int col, T valueToUpdate) {
        // method: changes/adds a valueToUpdate to a specific space in the matrix. it first checks if the matrix is big enough to have that specific address. it rejects if address is out of bounds. then it modifies that address to give it that valueToUpdate. 
        if (row < 0 || col < 0) {
            System.out.println("ERROR: (" + row + "," + col + ") cannot be updated as it is invalid position. ");
            return false;
        }
        if (row + 1 >= this.array.length || col + 1 >= this.array[0].length) {
            System.out.println("ERROR: (" + row + "," + col + ") cannot be updated as it is not contained by array. ");
        }
        this.array[row][col] = valueToUpdate;
        System.out.println("SUCCESS: Value '" + valueToUpdate + "' has been updated to (" + row + "," + col + ") successfully. ");
        return true;
    }

    public boolean find(T valueToFind) {
        // method: tells whether or not the following value is in the arraylist or not
        if (getIndex(valueToFind)[0] == -1) {
            System.out.println("ERROR: '" + valueToFind + "' not found. ");
            return false;
        } else {
            System.out.println("SUCCESS: '" + valueToFind + "' found. ");
            return true;
        }
    }

    public T getValue(int row, int col) {
        // method: returns the value at a specific index. 
        if (row < array.length && col < array[0].length && row >= 0 && col >= 0) {
            System.out.println("SUCCESS: Value at index (" + row + "," + col + ") is '" + array[row][col] + "'.");
            return array[row][col];
        }
        System.out.println("ERROR: Arraylist does not contain the index (" + row + "," + col + "). ");
        return null;
    }

    public int[] getIndex(T valueToGet) {
        /*
        method: gets a valueToGet, just run two for loops and check each address. if found, return the row,col as an int array. else if not found after checking each address, then return row,col as -1,-1 to show that the valueToGet doesnt exist in the array.
         */
        if (size() == 0) {
            System.out.println("ERROR: MyArrayList is empty. ");
            return new int[]{-1, -1};
        }
        if (valueToGet == null) {
            System.out.println("ERROR: Value to find is null. ");
            return new int[]{-1, -1};
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] != null && array[i][j].compareTo(valueToGet) == 0) {
                    System.out.println("SUCCESS: Found '" + valueToGet + "' at (" + i + ", " + j + "). ");
                    return new int[]{i, j};
                }
            }
        }
        System.out.println("ERROR: Value '" + valueToGet + "' not found. ");
        return new int[]{-1, -1};
    }

    public T getFirst() {
        // method: returns the first value in the arraylist
        return array[0][0];
    }

    public T getLast() {
        // method: returns the last consecutive value in the arraylist
        return array[currentRow][currentCol];
    }

    public boolean clear() {
        // method: clears the arraylist
        start(array.length, array[0].length);
        System.out.println("SUCCESS: ArrayList has been cleared successfully. ");
        return true;
    }

    public int size() {
        // method: tells how many elements are in the matrix. 
        if (currentRow == -1) {
            return currentCol + 1;
        }
        return (currentRow * array[0].length) + (currentCol + 1);
    }

    public int capacity() {
        // method: tells how many available spaces are in the matrix.
        return array.length * array[0].length;
    }

    public boolean isEmpty() {
        // method: returns whether or not the arraylist is empty or not
        return currentRow == -1 && currentCol == -1;
    }

    public boolean isFull() {
        // method: returns whether or not the arraylist is full or not
        return capacity() - size() == 0;
    }

    public T deleteIndex(int row, int col) {
        // method: deletes a specific index. first it checks if the row,col coordinates are within the range 0 to array size and the value at that coordinate is not null. then it moves each value backward and then finally moves currentRow, currentCol one space back. 
        if (row >= array.length || col >= array[0].length || row < 0 || col < 0 || array[row][col] == null) {
            System.out.println("ERROR: (" + row + "," + col + ") could not be deleted as it does not exist. ");
            return null;
        } else {
            // move each element back
            int[] forwardIndex;
            T deletingValue = array[row][col];
            while (array[row][col] != null) {
                // get each element after the deletingValue and put its value to the previous position
                forwardIndex = moveForward(row, col);
                array[row][col] = array[forwardIndex[0]][forwardIndex[1]];
                row = forwardIndex[0];
                col = forwardIndex[1];
            }
            // now move the current pointer one position back
            forwardIndex = moveBackward(currentRow, currentCol);
            currentRow = forwardIndex[0];
            currentCol = forwardIndex[1];
            System.out.println("SUCCESS: The index (" + row + "," + col + ") had value '" + deletingValue + "' and was deleted successfully. ");
            return deletingValue;
        }
    }

    public T deleteFirstOccurence(T valueToDelete) {
        // method: this methods deletes a specific valueToDelete by backtracking all the values after it to remove the empty space, then makes the last space null. it does this by first finding the (row,col) coordinates of the deleting valueToDelete and it moves one space ahead until we come to the last null valueToDelete. 
        int[] find = getIndex(valueToDelete);
        if (find[0] == -1) {
            System.out.println("ERROR: The value '" + valueToDelete + "' does not exist in MyArrayList2D. ");
            return null;
        }
        return deleteIndex(find[0], find[1]);
    }

    public void deleteAllOccurences(T valueToDelete) {
        // method: deletes all the occurences of a specific value - it runs until the value can no longer be found. one way to do this is to run deleteFirstOccurences() until we can no longer find that value. but it would backtrack and shift values after EVERY deletion. a better way is to delete them all at once and then backtrack ONCE. Another way could be that the all the occurences would be made null without backtracking. 
//        WAY ONE
//        while (find(valueToDelete) == true) {
//            deleteFirstOccurence(valueToDelete);
//        }
//        WAY TWO -- thinking
//        WAY THREE 
        int[] index = getIndex(valueToDelete);
        while (index[0] != -1) {
            deleteIndex(index[0], index[1]);
            index = getIndex(valueToDelete);
        }
        System.out.println("SUCCESS: All instances of '" + valueToDelete + "' have been deleted successfully. ");
    }

    public boolean deleteByNull(T valueToDelete) {
        // method: deletes a specific valueToDelete. first it finds its address of row,col using the getIndex method. if the valueToDelete isnt found, return false. it makes that address null and moves the currentRow and currentCol to that position so that the next insertion is at that null valueToDelete. 
        int[] find = getIndex(valueToDelete);
        if (find[0] == -1) {
            System.out.println("ERROR: The value '" + valueToDelete + "' cannot be deleted as it does not exist in MyArrayList2D. ");
            return false;
        }
        this.array[find[0]][find[1]] = null;
        currentRow = find[0];
        currentCol = find[1];
        System.out.println("SUCCESS: The value '" + valueToDelete + "' has been deleted successfully by making it null. ");
        return true;
    }

    public T deleteFirst() {
        // method: deletes the first value
        return deleteIndex(0, 0);
    }

    public T deleteLast() {
        // method: delets the last value
        if (isEmpty() == false) {
            T deletingValue = array[currentRow][currentCol];
            array[currentRow][currentCol] = null;
            int[] backwardIndex = moveBackward(currentRow, currentCol);
            currentRow = backwardIndex[0];
            currentCol = backwardIndex[1];
            return deletingValue;
        } else {
            return null;
        }
    }

    public void sortLowToHigh() {
        /*
        method: get a value (row, col) and compare it to each value after it IF they are not null. if the value being compared with each value is LARGER, switch its places. then do this in nested for loop so that each value in the array is compared with every value. 
         */
        if (sorted == true) {
            System.out.println("MyArrayList2D is already sorted. ");
            return;
        }
        // first 2 for-loops are to get a fixed value to compare
        for (int i = 0; i < array.length; i++) { // to get each row
            for (int j = 0; j < array[i].length; j++) { // to get each column
                // second 2 for-loops are to get a changing value to compare the fixed value with
                for (int k = 0; k < array.length; k++) { // to get each row
                    for (int l = 0; l < array[k].length; l++) { // to get each column
                        if ((i == k && j == l) || (array[i][j] == null || array[k][l] == null)) {
                            // if the changing value is the same as the fixed value, dont compare. 
                            // if any of the values being compared are null, dont compare. 
                            continue;
                        }
                        if (array[k][l].compareTo(array[i][j]) == 1) {
                            T temp = array[i][j]; // swap the values
                            array[i][j] = array[k][l];
                            array[k][l] = temp;
                        }
                    }
                }
            }
        }
        sorted = true;
        System.out.println("SUCCESS: The 2-d ArrayList has been sorted successfully. ");
    }

    public void removingDuplicates() {
        /*
        method: removes duplicates. first it sorts the list. then it gets each row, column and compares it to the next value. if it is same, remove that value. then it compares that existing row, col to the previous value. if it is same, remove that value. do this repeatedly for the entire matrix. 
         */
        if (sorted == false) {
            sortLowToHigh();
        }
        int count = 0;
        int[] forward;
        int[] backward;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (isLast(i, j) == false) {
                    forward = moveForward(i, j); // forward comparision (value with its after value)
                    if (array[i][j] != null && array[forward[0]][forward[1]] != null && array[i][j].compareTo(array[forward[0]][forward[1]]) == 0) {
                        deleteIndex(forward[0], forward[1]);
                        count++;
                    }
                }
                if (isFirst(i, j) == false) {
                    backward = moveBackward(i, j);// backward comparision (value with its previous value)
                    if (array[i][j] != null && array[backward[0]][backward[1]] != null && array[i][j].compareTo(array[backward[0]][backward[1]]) == 0) {
                        deleteIndex(i, j);
                        j--; // move it back for recomparision
                        count++;
                    }
                }
            }
        }
        System.out.println("Number of duplicates removed = " + count);
    }

    public T findMax() {
        //method: returns the highest value. first it sorts low to high then returns the last value
        if (sorted == false) {
            sortLowToHigh();
        }
        return array[currentRow][currentCol];
    }

    public T findMin() {
        //method: returns the lowest value. first it sorts low to high then returns the first value
        if (sorted == false) {
            sortLowToHigh();
        }
        return array[0][0];
    }

    public Comparable<T>[] toArray() {
        // method: converts the matrix to a single dimensional array
        Comparable<T>[] array1D = (T[]) new Comparable[size()];
        for (int i = 0, row = 0, col = 0; i < array1D.length; i++) {
            array1D[i] = array[row][col];
            int[] nextt = moveForward(row, col);
            row = nextt[0];
            col = nextt[1];
        }
        return array1D;
    }

    public void reverse() {
        // method: reverses the array by swapping the first and last values until the middle
        for (int[] forward = {0, 0}, backward = {currentRow, currentCol}, counter = {0}; counter[0] != (size() / 2); counter[0]++) {
            T temp = array[forward[0]][forward[1]];
            array[forward[0]][forward[1]] = array[backward[0]][backward[1]];
            array[backward[0]][backward[1]] = temp;
            forward = moveForward(forward[0], forward[1]);
            backward = moveBackward(backward[0], backward[1]);
        }
        System.out.println("SUCCESS: MyArrayList2D has been reversed successfully. ");
    }

    private void incSize(int row, int col) {
        /*
        method: resizes the array. increases the array to the size specified by creating a new array of the given size and copying all the values given but before that, it checks if the size specified is lesser than the current size, so it returns. 
         */
        if (row < array.length || col < array[0].length) {
            return;
        }
        T[][] newArray = (T[][]) new Comparable[row][col];
        for (int i = 0; i < array.length; i++) {
            System.arraycopy(this.array[i], 0, newArray[i], 0, array[i].length);
//            OR YOU CAN MANUAL ARRAY COPY:
//            for (int j = 0; j < array[i].length; j++) {
//                newArray[i][j] = this.array[i][j];
//            }
        }
        this.array = newArray;
    }

    public void assignRandomIntegers() {
        /*
        method: will intialize random integer values to the remaining matrix
        it will first getIndex how many spaces are left in the matrix by : first it calculates the total number of spaces in the matrix by multiplying row by col example its a standard 5 by 5 matrix, so 25, then it calculates the occupied spaces by first multiplying the fully occupied rows by the columns and then adding the half empty column spaces. example im on (1,4) so i first getIndex fully occupied rows (1*5=5) then remaining columns in the current row (4) = 5+4=9. but actually 10 spaces are occupied in a 5 by5 matrix, so due to indexing, we insertEnd 1. then it runs the loop for the remaining spaces to insertEnd that many values. 
         */
        int remainingSpace = capacity() - size();
        for (int i = 0; i < remainingSpace; i++) {
            insertEnd((T) (Comparable) (int) (Math.random() * 10));
        }
        System.out.println("SUCCESS: MyArrayList2D has been initialized with " + remainingSpace + " random integers. ");
    }

    public void appendRow(T[] rowArray) {
        /*
        method: adds a row to the entire matrix. to insertEnd a row, it must be equal to the number of columns of the matrix. if it is equal, then proceed else return . simple logic, first create space to insertEnd another row if the array is full. then simply copy paste the row array to the next row after current row. now move back to current row, so that when insertEnd function is called, it adds right where we left off before the row append. 
         */
        if (rowArray.length != this.currentCol + 1) {
            System.out.println("ERROR: This row cannot be appended as it needs to have " + this.currentCol + 1 + " columns but it has " + rowArray.length + " columns. ");
            return;
        }
        if (++this.currentRow == this.array.length) {
            incSize(this.array.length + 1, this.array[0].length);
        }
        System.arraycopy(rowArray, 0, array[currentRow], 0, rowArray.length);
//        OR YOU CAN MANUAL ARRAY COPY:
//        for (int i = 0; i < rowArray.length; i++) {
//            array[currentRow][i] = rowArray[i];
//        }
        currentRow--;
        System.out.println("SUCCESS: The row has been appended successfully. ");
    }

    public void appendCol(T[] colArray) {
        /*
        method: adds a col to the entire matrix. to insertEnd a col, it must be equal to the number of rows of the matrix. if it is equal, then proceed else return . simple logic, first create space to insertEnd another col if the array is full. then simply copy paste the col array to the next col after current col. now move back to current col, so that when insertEnd function is called, it adds right where we left off before the col append. 
         */
        if (colArray.length != this.currentRow + 1) {
            System.out.println("ERROR: This column cannot be appended as it needs to have " + this.array.length + " rows but it has " + colArray.length + " rows. ");
            return;
        }
        if (++this.currentCol == this.array[0].length) {
            incSize(this.array.length, this.array[0].length + 1);
        }
        for (int i = 0; i < colArray.length; i++) {
            this.array[i][this.currentCol] = colArray[i];
        }
        currentCol--; // make it back to the column we were at before appending
        System.out.println("SUCCESS: The column has been appended successfully. ");
    }

    private int[] moveForward(int row, int col) {
        // method: computes the coordinates of the next index after row,col
        if (row == -1) { // if we are at the first index, make row a valid number
            row = 0;
        }
        // if we are at the end of row, shift to a new row and make col 0
        if (col + 1 == array[0].length) {
            return new int[]{row + 1, 0};
        } else { // else move one digit after col normally on same row
            return new int[]{row, col + 1};
        }
    }

    private int[] moveBackward(int row, int col) {
        // method: gives the coordinates of the index before the given row,col
        if (col == 0 && row != 0) { // if the row is not zero and the col is first, 
            return new int[]{row - 1, array[row].length - 1}; // decrease row
        } else if (col == 0) { // else if col is 0 row is 0
            return new int[]{-1, -1}; // we have finished the array
        } else {
            return new int[]{row, col - 1}; // else decrement col normally
        }
    }

    private boolean isFirst(int row, int col) {
        // method: checks if the given index is the first index or not
        return row == 0 & col == 0;
    }

    private boolean isLast(int row, int col) {
        // method: checks if the given index is the last index or not
        return row == array.length - 1 && col == array[0].length - 1;
    }

    private void assignNextNullSpace() {
        // method: finds the next null space in the array and assigns CurrentRow CurrentCol its position. this is done by getting the current positions and moving ahead until we get a null space. if while moving ahead we finish the array space, then we increase the array space. 
        int[] nextIndex;
        do {
            nextIndex = moveForward(currentRow, currentCol);
            currentRow = nextIndex[0];
            currentCol = nextIndex[1];
            if (isFull() == true) {
                incSize(currentRow + 2, array[0].length);
            }
        } while (this.array[currentRow][currentCol] != null); // we move forward until we getIndex the next empty space
    }

}
