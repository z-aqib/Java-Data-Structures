# Java-Data-Structures
 This repository showcases diverse Java data structures with detailed comments for clarity. The code is optimized for efficiency, and we appreciate any feedback or suggestions from the community. Your insights contribute to ongoing improvements.
### What data types do these data structures support?
These data structures support **all** data types, whether it be a built-in data type, or of a class you made by yourself. Just make sure to add "*extends Comparable*" to your class name and adjust your "*compareTo()*" function as per need. 

## Functions in Data Structures
This table lists the possible functions in all the data structures, and what the function does. 

|    | Function Name | Use | 
| -- | ------------- | --- |
| 1  | **constructor**(): void | starts DS with a standard size |
| 2  | **constructor**(size): void | starts DS with given *size* |
| 3  | **toString**(): String | converts DS into a single string |
| 4  | **display**(): void | displays the DS | 
| 5  | **insertStart**(data): void | inserts at the start |
| 6  | **insertEnd**(data): void | inserts at the end, after the last added element |
| 7  | **insertBefore**(dataBefore, dataInsert): boolean | inserts a data before a given data |
| 8  | **insertAfter**(dataAfter, dataInsert): boolean | inserts a data after a given data |
| 9  | **insertAt**(index, dataInsert): boolean (where *index* is *row, col* for 2D) | insert data at a given index |
| 10 | **insertInOrder**(data): void | insert data in order in the DS |
| 11 | **updateIndex**(index, dataUpdate): boolean | updates an existing index with data |
| 12 | **find**(data): boolean | finds if a given data exists in the DS |
| 13 | **getValue**(index): T (where *index* is *row, col* for 2D) | gets the data at a given index |
| 14 | **getIndex**(data): int (it will return int[] for 2D) | gets the index of a certain data |
| 15 | **getFirst**(): T | gets the first element in the DS |
| 16 | **getLast**(): T | gets the last element in the DS |
| 17 | **clear**(): boolean | clears the DS |
| 18 | **size**(): int | gets the used up/occupied space of the DS |
| 19 | **capacity**(): int | the total space of the DS |
| 20 | **isEmpty**(): boolean | is the DS empty? |
| 21 | **isFull**(): boolean | is the DS full? |
| 22 | **deleteIndex**(index): T | deletes a specific index & returns the data on it |
| 23 | **deleteFirstOccurence**(data): T | deletes the first occurence of given data |
| 24 | **deleteAllOccurrences**(data): void | deletes all the occurences of given data |
| 25 | **deleteByNull**(data): T | deletes the first occurence of given data by making that index NULL |
| 26 | **deleteFirst**(): T | deletes the first element |
| 27 | **deleteLast**(): T | deletes the last element |
| 28 | **sortLowToHigh**(): void | sorts the DS from low to high |
| 29 | **removingDuplicates**(): void | removes duplicates in the DS after sorting it |
| 30 | **findMax**(): T | returns the maximum element in the DS |
| 31 | **findMin**(): T | returns the minimum element in the DS |
| 32 | **toArray**(): T[] (where it returns T[][] for 2D) | converts DynamicArray to a normal array |
| 33 | **reverse**(): void | reverses the elements of the array |
| 34 | **incSize**(size): void (where *index* is *row, col* for 2D) | increases array size, provides dynamic property |
| 35 | **assignRandomIntegers**(): void | assigns random integers between 1 to 10 in the DS |
| 36 | **merge**(MyArrayList, MyArrayList): MyArrayList | merges two MyArrayLists of capacity p, q into one |
| 37 | **getMyArrayList**(): MyArrayList | returns a randomly generated MyArrayList |
| 38 | **appendRow**(row): void | appends a given row to MyArrayList2D |
| 39 | **appendCol**(col): void | appends a given column to MyArrayList2D |