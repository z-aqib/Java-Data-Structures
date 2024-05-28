package SearchingAlgorithms;

// COMPLETED
public class LinearSearch<T extends Comparable<T>> {

    /*
    this class performs a linear search on a generic (any) type of array. you can perform 
    linear search on your array either iteratively or recursively. 
     */
    public int linearSearch(Comparable<T>[] array, T value) {
        /*
        it is linear search. it takes an array and the value that is to be found. it 
        checks each value in the array linearly. if the value is found, it returns 
        the index at which it was found. if all the values in the array are checked and 
        the value is still not found, then it returns -1. 
         */
        for (int i = 0; i < array.length; i++) {
            if (array[i].compareTo(value) == 0) {
                return i;
            }
        }
        return -1;
    }

    public int linearSearchRecursive(Comparable<T>[] array, T value, int index) {
        if (array[index].compareTo(value) == 0) {
            return index;
        } else if (index != array.length - 1) {
            return linearSearchRecursive(array, value, ++index);
        }
        return -1;
    }

    public int runLinearSearchRecursive(Comparable<T>[] array, T value) {
        // this is the same as the iteratively linear search but recursively. 
        return linearSearchRecursive(array, value, 0);
    }

}
