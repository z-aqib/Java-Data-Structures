package Hashing;

public class HashOpenAddQuad<T extends Comparable<T>> {

    /*
    This is a hash table data structure. it is NOT resizeable/dynamic. the size is defined at the start. This is used to retrive values in 0(1) and search in 0(1). but this is not always the case - as this hash table is of OPEN ADDRESSING (QUADRATIC). in this, each data value to be added or retrieved gets an index computed based on their data, and it maps it to that index. but, if the index has already been asisgned to a data, the index is Re-Hashed (recomputed) until an empty index is found. 
     */
    private Comparable<T>[] table; // the table of values
    private int countOccupied; // the number of occupied values

    public HashOpenAddQuad(int size) {
        // constructor: creates a table of 1.33 times of given size and intializes count as 0
        System.out.println("Welcome to MyHashTable! This HashTable implements Open Addressing in Quadratic Form. ");
        table = (T[]) new Comparable[size + (size / 3)];
        // table size should be a prime number and 1/3 extra.
        this.countOccupied = 0;
        System.out.println("HashTable of size " + size + " has been created successfully. ");
    }

    public HashOpenAddQuad() {
        //constructor: passes to next constructor with standard table size 100
        this(10);
    }

    @Override
    public String toString() {
        // method: converts the hashtable into a string. it takes one line for each index. first it displays the index number and then its value and then takes a new line. 
        String str = "";
        for (int i = 0; i < table.length; i++) {
            str += (i + 1) + ":'" + table[i] + "'";
            if (i != table.length - 1) {
                str = str + " , \n";
            }
        }
        return "[" + str + "]";
    }

    public void display() {
        // method: displays hash table
        System.out.println(toString());
    }

    private int strToInt(String stringToBeChanged) {
        // method: convert string into integer by summing the ASCII values
        int sum = 0;
        for (int i = 0; i < stringToBeChanged.length(); i++) {
            sum += (int) stringToBeChanged.charAt(i);
        }
        return sum;
    }

    public int Hash(int sum) {
        // method: hash value calculator. compute hash value by taking mod on table length
        return sum % table.length;
    }

    public int Rehash(int sum, int i) {
        /* 
        method: rehash function. in quadratic addressing, we will square 'i' which is the number of times we encounter a collision. then we will call hash() function and find the hash of the new value (value + i^2)
         */
        return Hash(sum + (int) (Math.pow(i, 2)));
    }

    public int insert(Comparable<T> valueToBeInserted) {
        /*
        method: inserts a value in the table using its hash() value. call strToInt(v) and change the value to string, save return value in sum. call Hash(sum) and save return value in sum if (no collision on hash value) then place value else call rehash function until empty cell found also compute number of collisions on insertion of each word. IF a significant number of iterations have been run, it throws error that it cannot be inserted. RETURNS: number of iterations to insert that value.  
         */
        if (countOccupied == table.length) {
            System.out.println("ERROR: Cannot be inserted as hash table is full. ");
            return -1;
        }
        int sum = strToInt(valueToBeInserted.toString());
        sum = Hash(sum);
        int i = 0; // counts the number of times re-hashed i.e. no. of collisions faced
        while (this.table[sum] != null && i < (table.length * 5)) {
            sum = Rehash(sum, ++i);
        }
        if (i > table.length) {
            System.out.println("ERROR: Cannot be inserted as Re-Hash has ran " + i + " times and no available index is found. ");
            return -1;
        }
        this.table[sum] = valueToBeInserted;
        countOccupied++;
        System.out.println("SUCCESS: '" + valueToBeInserted + "' successfully inserted at index " + sum + ". ");
        return i;
    }

    public boolean delete(Comparable<T> valueToBeDeleted) {
        /*
        method: delete word from hash table. first search for the value. if found, then proceed deletion. run a loop and keep checking if the hash() and rehash() is equal to the value that is being deleted. if yes, make that value null. 
         */
        if (search(valueToBeDeleted) == true) {
            int sum = strToInt(valueToBeDeleted.toString());
            sum = Hash(sum);
            int i = 0;
            while (table[sum] == null || table[sum].compareTo((T) valueToBeDeleted) != 0) {
                sum = Rehash(sum, ++i);
            }
            if (table[sum] != null && table[sum].compareTo((T) valueToBeDeleted) == 0) {
                table[sum] = null;
                countOccupied--;
                System.out.println("SUCCESS: '" + valueToBeDeleted + "' is deleted successfully at index "+sum+". ");
                return true;
            }
        }
        System.out.println("ERROR: '" + valueToBeDeleted.toString() + "' cannot be deleted as it is not found. ");
        return false;
    }

    public boolean search(Comparable<T> valueToBeSearched) {
        /*
        method: search word in a hash table
        first it changes the object to string, computes its sum, then computes its 
        hash() value. then it iteratively searches for that value at 
         */
        int sum = strToInt(valueToBeSearched.toString());
        sum = Hash(sum);
        int i = 0;
        while (i <= 50 && table[sum] == null || table[sum].compareTo((T) valueToBeSearched) != 0) {
            sum = Rehash(sum, ++i);
        }
        if (table[sum] != null && table[sum].compareTo((T) valueToBeSearched) == 0) {
            System.out.println("SUCCESS: '" + valueToBeSearched.toString() + "' is found at index " + sum);
            return true;
        }
        System.out.println("ERROR: '" + valueToBeSearched.toString() + "' could not be found. ");
        return false;
    }

}
