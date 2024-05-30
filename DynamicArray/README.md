# MyArrayLists
This is a dynamic (resizable) data structure, which is an extension of **arrays**. In normal arrays, if it gets full, we can no longer use it / add values. But in ArrayLists, we can add as many values as we like. 
### How does an Array be dynamic?
The array-unlimited-size is because every time the array gets full, a new array of double size is created and all the values are copy pasted from the old array to the new array. 

### Types of MyArrayLists
There are two types of MyArrayLists,
* One-Dimensional (ex. int[], char[], String[])
* Two-Dimensional (ex. int[][], char[][], String[][])

The resizable unlimited option is available for **both**. 

## Functions in MyArrayList
This table lists the possible functions in MyArrayList, how they were implemented and what their time complexity is. 
* n ~> elements in each row 
* m ~> elements in each column

|    | Function Name | Use | 1D | Implementation | 2D | Implementation |
| -- | ------------- | --- | -- | -------------- | -- | -------------- |
| 1  | **constructor**(): void | starts DS with a standard size | *O(1)* | initializes size of 5 to the constructor(size) | *O(1)* | initializes size of 5 by 5 to the constructor(row,col) |
| 2  | **constructor**(size): void (where *size* will be *row, col* for 2D) | starts DS with given *size* | *O(1)* | initializes array[] of size *size* | *O(1)* | initializes array[][] of size rows *row* by columns *col* |
| 3  | **toString**(): String | converts DS into a single string | *O(n)* | adds each non-null element enclosed in square brackets [] | _O(m*n)_ | adds all the m*n elements in a tabular form, with row and column numbers for better readability |
| 4  | **display**(): void | displays the DS | *O(n)* | prints toString() | _O(m*n)_ | prints toString() |
| 5  | **insertStart**(data): void | inserts at the start | *O(n)* | moves each element one forward and places *data* at index 0 | _O(m*n)_ | moves each element one forward and places *data* at index (0,0) |
| 6  | **insertEnd**(data): void | inserts at the end, after the last added element | *O(n)* | call *incSize()* if array is full and place *data* at index _pointerIndex_ | _O(m*n)_ | call *incSize()* if array is full and place *data* at index (_currentRow_, _currentCol_) |
| 7  | **insertBefore**(dataBefore, dataInsert): boolean | inserts a data before a given data | *O(n)* | shift all the elements after and including *dataBefore* and place *dataInsert* at the previous index of *dataBefore* | _O(m*n)_ | shift all the elements after and including *dataBefore* and place *dataInsert* at the previous index of *dataBefore* |
| 8  | **insertAfter**(dataAfter, dataInsert): boolean | inserts a data after a given data | *O(n)* | shift all the elements after *dataAfter* and place *dataInsert* at the previous index of *dataAfter* | _O(m*n)_ | shift all the elements after *dataAfter* and place *dataInsert* at the previous index of *dataAfter* |
| 9  | **insertAt**(index, dataInsert): boolean (where *index* is *row, col* for 2D) | insert data at a given index | *O(n)* | if *index* is null, it is  placed directly otherwise shift all elements one index forward and place *dataInsert* at *index* | _O(m*n)_ | if *index* is null, place *dataInsert* directly otherwise shift all elements one index forward and place *dataInsert* at *index* |
| 10 | **insertInOrder**(data): void | insert data in order in the DS | *O(n)* | if sorted, find correct position and call *insertAt()* else call *insertEnd()* and run *sortInOrder()* | _O(m*n)_ | if sorted, find correct position and call *insertAt()*, else call *insertEnd()* and run *sortInOrder()* |
| 11 | **updateIndex**(index, dataUpdate): boolean (where *index* is *row, col* for 2D) | updates an existing index with data | *O(1)* | update *index* with *dataUpdate* | *O(1)* | update *index* with *dataUpdate* |
| 12 | **find**(data): boolean | finds if a given data exists in the DS | *O(n)* | traverses the array[] and returns if found or not | _O(m*n)_ | traverses the array[][] and returns if found or not |
| 13 | **getValue**(index): T (where *index* is *row, col* for 2D) | gets the data at a given index | *O(1)* | returns the data at *index* | *O(1)* | returns the data at *index* |
| 14 | **getIndex**(data): int (it will return int[] for 2D) | gets the index of a certain data | *O(n)* | traverses the array[] to find the data and return the index | _O(m*n)_ | traverses the array[][] to find the *data* and return the index (row,col) |
| 15 | **getFirst**(): T | gets the first element in the DS | *O(1)* | returns data at the 0th index | *O(1)* | returns data at the (0,0)th index |
| 16 | **getLast**(): T | gets the last element in the DS | *O(1)* | returns data at _pointerIndex_ index | *O(1)* | returns data at (_currentRow_, _currentCol_) index |
| 17 | **clear**(): boolean | clears the DS | *O(1)* | re-initializes the array[] of same length | *O(1)* | re-initializes the array[][] of same rows and columns |
| 18 | **size**(): int | gets the used up/occupied space of the DS | *O(1)* | returns _pointerIndex_ and _extraIndexesCounter_ | *O(1)* | return (_currentRow_ * no. of columns) + _currentCol_ |
| 19 | **capacity**(): int | the total space of the DS | *O(1)* | returns *array.length* | *O(1)* | returns *array.length* * *array[0].length* | 
| 20 | **isEmpty**(): boolean | is the DS empty? | *O(1)* | returns if _size()_ is equal to 0 | *O(1)* | returns if _currentRow_ and _currentCol_ are equal to -1 | 
| 21 | **isFull**(): boolean | is the DS full? | *O(1)* | returns if _size()_==_capacity()_ | *O(1)* | returns if _size()_==_capacity()_ |
| 22 | **deleteIndex**(index): T (where *index* is *row, col* for 2D) | deletes a specific index & returns the data on it | *O(n)* | shift all values after _index_ one backward and make the _pointerIndex_ index null | _O(m*n)_ | shift all values after _index_ one backward and move _currentRow_ and _currentCol_ one back |
| 23 | **deleteFirstOccurence**(data): T | deletes the first occurence of given data | *O(n)* | finds the index of _data_ and calls _deleteIndex()_ |  _O(m*n)_ | finds the row, col of _data_ and calls _deleteIndex()_ |
| 24 | **deleteAllOccurrences**(data): void | deletes all the occurences of given data | *O(n^2)* | repeatedly calls _deleteFirstOccurence()_ each time _find(data)_ is true | _O((m*n)^2)_ | repeatedly calls _deleteFirstOccurence()_ each time _find(data)_ is true |
| 25 | **deleteByNull**(data): T | deletes the first occurence of given data by making that index NULL | *O(n)* | finds the index of that data and *O(1)* make it null | _O(m*n)_ | find the row,col of that data and make it null |
| 26 | **deleteFirst**(): T | deletes the first element | *O(n)* | shifts all the elements one position back | _O(m*n)_ | shifts all the elements one position back |
| 27 | **deleteLast**(): T | deletes the last element | *O(1)* | makes the _pointerIndex_ index null | _O(1)_ | makes index (_currentRow_, _currentCol_) null | 
| 28 | **sortLowToHigh**(): void | sorts the DS from low to high | *O(n^2)* | performs selection sort | _O((m*n)^2)_ | performs selection sort |
|29| **removingDuplicates**(): void | removes duplicates in the DS after sorting it | *O(n)* | compares each element with its preceeding and succeeding element | _O(m*n)_ | compares each element with its preceeding and succeeding element | 
| 30 | **findMax**(): T | returns the maximum element in the DS | *O(n^2)* | first sorts, then returns last element | _O((m*n)^2)_ | first sorts, then returns last element |
| 31 | **findMin**(): T | 