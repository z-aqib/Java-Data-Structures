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
* MAL ~> MyArrayList

|       | Function Name | Use | 1D | Implementation | 2D | Implementation |
| ----- | ------------- | --- | -- | -------------- | -- | -------------- |
| 1     | **constructor**(): void | starts DS with a standard size | *O(1)* | initializes size of 5 to the constructor(size) | *O(1)* | initializes size of 5 by 5 to the constructor(row,col) |
| 2     | **constructor**(size): void (where *size* will be *row, col* for 2D) | starts DS with given *size* | *O(1)* | initializes array[] of size *size* | *O(1)* | initializes array[][] of size rows *row* by columns *col* |
| 3     | **toString**(): String | converts DS into a single string | *O(n)* | adds each non-null element enclosed in square brackets [] | *O(m * n)* | adds all the m*n elements in a tabular form, with row and column numbers for better readability |
| 4     | **display**(): void | displays the DS | *O(n)* | prints toString() | _O(m*n)_ | prints toString() |
| 5     | **insertStart**(data): void | inserts at the start | *O(n)* | moves each element one forward and places *data* at index 0 | *O(m * n)* | moves each element one forward and places *data* at index (0,0) |
| 6     | **insertEnd**(data): void | inserts at the end, after the last added element | *O(n)* | call *incSize()* if array is full and place *data* at index _pointerIndex_ | *O(m * n)* | call *incSize()* if array is full and place *data* at index (_currentRow_, _currentCol_) |
| 7     | **insertBefore**(dataBefore, dataInsert): boolean | inserts a data before a given data | *O(n)* | shift all the elements after and including *dataBefore* and place *dataInsert* at the previous index of *dataBefore* | *O(m * n)* | shift all the elements after and including *dataBefore* and place *dataInsert* at the previous index of *dataBefore* |
| 8     | **insertAfter**(dataAfter, dataInsert): boolean | inserts a data after a given data | *O(n)* | shift all the elements after *dataAfter* and place *dataInsert* at the previous index of *dataAfter* | *O(m * n)* | shift all the elements after *dataAfter* and place *dataInsert* at the previous index of *dataAfter* |
| 9     | **insertAt**(index, dataInsert): boolean (where *index* is *row, col* for 2D) | insert data at a given index | *O(n)* | if *index* is null, it is  placed directly otherwise shift all elements one index forward and place *dataInsert* at *index* | *O(m * n)* | if *index* is null, place *dataInsert* directly otherwise shift all elements one index forward and place *dataInsert* at *index* |
| 10    | **insertInOrder**(data): void | insert data in order in the DS | *O(n)* | if sorted, find correct position and call *insertAt()* else call *insertEnd()* and run *sortInOrder()* | *O(m * n)* | if sorted, find correct position and call *insertAt()*, else call *insertEnd()* and run *sortInOrder()* |
| 11    | **updateIndex**(index, dataUpdate): boolean (where *index* is *row, col* for 2D) | updates an existing index with data | *O(1)* | update *index* with *dataUpdate* | *O(1)* | update *index* with *dataUpdate* |
| 12    | **find**(data): boolean | finds if a given data exists in the DS | *O(n)* | traverses the array[] and returns if found or not | *O(m * n)* | traverses the array[][] and returns if found or not |
| 13    | **getValue**(index): T (where *index* is *row, col* for 2D) | gets the data at a given index | *O(1)* | returns the data at *index* | *O(1)* | returns the data at *index* |
| 14    | **getIndex**(data): int (it will return int[] for 2D) | gets the index of a certain data | *O(n)* | traverses the array[] to find the data and return the index | *O(m * n)* | traverses the array[][] to find the *data* and return the index (row,col) |
| 15    | **getFirst**(): T | gets the first element in the DS | *O(1)* | returns data at the 0th index | *O(1)* | returns data at the (0,0)th index |
| 16    | **getLast**(): T | gets the last element in the DS | *O(1)* | returns data at _pointerIndex_ index | *O(1)* | returns data at (_currentRow_, _currentCol_) index |
| 17    | **clear**(): boolean | clears the DS | *O(1)* | re-initializes the array[] of same length | *O(1)* | re-initializes the array[][] of same rows and columns |
| 18    | **size**(): int | gets the used up/occupied space of the DS | *O(1)* | returns _pointerIndex_ and _extraIndexesCounter_ | *O(1)* | return (_currentRow_* no. of columns)+ _currentCol_ |
| 19    | **capacity**(): int | the total space of the DS | *O(1)* | returns *array.length* | *O(1)* | returns *array.length* * *array[0].length* | 
