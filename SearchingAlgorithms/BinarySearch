package SearchingAlgorithms;

// COMPLETED
public class BinarySearch<T extends Comparable<T>> {

    /*
    this class performs a binary search on a generic (any) type of array. you can perform 
    binary search on your array either iteratively or recursively. 
     */
    public int binarySearch(Comparable<T>[] array, Comparable<T> value) {
        /*
        this method does binary search iteratively. it gets the first and last index 
        of the array and computes the middle. then it checks, is the middle value equal 
        to the value we are searching for? if yes, return the index, if not, check, 
        is the value being searched for smaller than the middle value, then compute 
        the first index and the middle-1 index again. if not, it computes the middle+1 index 
        and the last index. it does this until our first becomes greater than the last, 
        or the value is found. 
         */
        int first = 0;
        int last = array.length;
        while (first <= last) {
            int middle = first + (last - first) / 2; // compute the middle index of the range first to last
            if (value.compareTo((T) array[middle]) == 0) {
                return middle;
            } else if (value.compareTo((T) array[middle]) < 0) {
                last = middle - 1;
            } else {
                first = middle + 1;
            }
        }
        return -1;
    }

    public int binarySearchRecursive(Comparable<T>[] array, Comparable<T> target, int left, int right) {
        int mid = left + (right - left) / 2;
        if (left > right) {
            return -1;
        } else if (array[mid].compareTo((T) target) == 0) {
            return mid;
        } else if (array[mid].compareTo((T) target) > 0) {
            return binarySearchRecursive(array, target, left, mid - 1);
        }
        return binarySearchRecursive(array, target, mid + 1, right);
    }

    public int runBinaryRecursive(Comparable<T>[] array, Comparable<T> value) {
        // this is the same as the above method, it just runs recursively. 
        return binarySearchRecursive(array, value, 0, array.length);
    }

}
