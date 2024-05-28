package Recursion;

// COMPLETED
public class RecursionProblems<T extends Comparable<T>> {

    public T maxFinderRecursive(T[] array, int index) {
        /*
        so start with array and index as the length of the array (4). we find the maximum 
        of array[4-1] and the recursive of index as 3. now we find the max of array[3-1] and 
        recursive 2. now its max of array[2-1] and recursive 1. now we are at 1 and 
        array has been traversed. so we return array[0]. so we check max between 
        array[1] and array[0]. the bigger of this is maxed with array[2]. then the 
        bigger of all three is maxed with array[3]. the biggest of all four is rteturned
        to main. 
         */
        if (index == 1) {
            return array[0];
        }
        T comparing = maxFinderRecursive(array, index - 1);
        if (array[index - 1].compareTo(comparing) == 1) {
            return array[index - 1];
        } else {
            return comparing;
        }
    }

    public T runMaxFinder(T[] array) {
        return this.maxFinderRecursive(array, array.length);
    }

    public T minFinderRecursive(T[] array, int index) {
        // same logic as max finder. 
        if (index == 1) {
            return array[0];
        }
        T comparing = minFinderRecursive(array, index - 1);
        if (array[index - 1].compareTo(comparing) == -1) {
            return array[index - 1];
        } else {
            return comparing;
        }
    }

    public T runMinFinder(T[] array) {
        return this.minFinderRecursive(array, array.length);
    }

    public int power(int base, int powerRaised) {
        /*
        so it decrements the power recursively until the power is 0. then it returns 
        by multiplying the base with itself until all the recursive calls are finished. 
         */
        if (powerRaised <= 0) {
            return 1;
        }
        return base * power(base, powerRaised - 1);
    }

    public void patternMaker(int n) {
        /*
        so first it prints n number of stars, then next line, then n-1 number of stars, 
        then next line, repeat until stars are 0, return. then print 1 star, then next line
        then 2 stars, then next line, until we reach n. 
        if the second part of the function is removed and recursively called then 
        that results in stack overflow. 
         */
        if (n == 0) {
            return;
        }
        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
        System.out.println("");
        patternMaker(n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
        System.out.println("");
    }

    public int vowels(String str, int n) {
        /*
        this method counts the vowels in a string recursively. first it goes to the first index
        checks if its vowel, increments count, returns to the second index. it does this 
        until we reach the last index (n). 
        it sums each of the previous vowel count
         */
        if (n == -1) {
            return 0;
        }
        int count = vowels(str, n - 1);
        if (str.charAt(n) == 'a' || str.charAt(n) == 'A'
                || str.charAt(n) == 'e' || str.charAt(n) == 'E'
                || str.charAt(n) == 'i' || str.charAt(n) == 'I'
                || str.charAt(n) == 'o' || str.charAt(n) == 'O'
                || str.charAt(n) == 'u' || str.charAt(n) == 'U') {
            count++;
        }
        return count;
    }

    public int runVowels(String str) {
        return vowels(str, str.length() - 1);
    }

}
