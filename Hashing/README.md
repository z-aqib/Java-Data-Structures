# Hashing
This is an ideal insertion, deletion and searching in _O(1)_ data structure. It uses the concept of **Hashing** and **arrays**. So upon insertion of data, the algorithm first gets the .toString() of it, then computes its _hashValue_. This _hashValue_ depends on the size of the HashTable. This _hashValue_ is the index of the data. The data is then placed on that index. When that data is searched, the same algorithm is performed, it is converted to string, its _hashValue_ is computed and that **specific index** is checked. This makes insertion, searching, deletion _O(1)_ as we compute an index and go straight to that. 
> However, this may cause a problem. What if two data are mapped to the same index? What if a data already exists when we are inserting a data on an index? To solve this problem, we have two ways, either we perform Seperate Chaining or Open Addressing. This is discussed in Types of Hashing. 

## Types of Hashing
There are two types of Hashing,
* Seperate Chaining
* Open Addressing

### Seperate Chaining


## Functions in MyHashTable
This table lists the possible functions in MyHashTable, how they were implemented and what their time complexity is. 

|    | Function Name | Use | 
| -- | ------------- | --- |
| 1  | **constructor**(): void | starts DS with a standard size |
| 2  | **constructor**(size): void | starts DS with given *size* |
| 3  | **toString**(): String | converts DS into a single string |
| 4  | **display**(): void | displays the DS | 
| 5  | **insert**(data): void | insert data in the DS |
| 6  | **update**(dataOld, dataUpdate): boolean | updates a data with data |
| 7  | **find**(data): boolean | finds if a given data exists in the DS |
| 8  | **getValue**(index): T | gets the data at a given index |
| 9  | **getIndex**(data): int | gets the index of a certain data |
| 10 | **getFirst**(): T | gets the first element in the DS |
| 11 | **getLast**(): T | gets the last element in the DS |
| 12 | **clear**(): boolean | clears the DS |
| 13 | **size**(): int | gets the used up/occupied space of the DS |
| 14 | **capacity**(): int | the total space of the DS |
| 15 | **isEmpty**(): boolean | is the DS empty? |
| 16 | **isFull**(): boolean | is the DS full? |
| 17 | **deleteIndex**(index): T | deletes a specific index & returns the data on it |
| 18 | **deleteFirstOccurence**(data): T | deletes the first occurence of given data |
| 19 | **deleteAllOccurrences**(data): void | deletes all the occurences of given data |
| 20 | **deleteByNull**(data): T | deletes the first occurence of given data by making that index null |
| 21 | **deleteFirst**(): T | deletes the first element |
| 22 | **deleteLast**(): T | deletes the last element |
| 23 | **removingDuplicates**(): void | removes duplicates in the DS after sorting it |
| 24 | **findMax**(): T | returns the maximum element in the DS |
| 31 | **findMin**(): T | returns the minimum element in the DS |
| 32 | **toArray**(): T[] | converts DS to a normal array |
| 35 | **assignRandomIntegers**(): void | assigns random integers between 1 to 10 in the DS |
| 37 | **getDS**(): DS | returns a DS of standard size with random integers in it |