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

| Count | Function Name | MyArrayList1D | Implementation | MyArrayList2D | Implementation |
| ----- | ------------- | ------------- | -------------- | ------------- | -------------- |
| 1 | constructor(): void | *O(1)* | initializes a standard size of 5 to the constructor(size) | *O(1)* | initializes a standard size of 5 by 5 to the constructor(row,col) |
| 2 | constructor(size): void (where *size* will be *row, col* for 2D) | *O(1)* | initializes array[] of size *size* | *O(1)* | initializes array[][] of size rows *row* by cols *col* |
| 3 | toString(): String | *O(n)* | adds each non-null element enclosed in square brackets [] | *O(m * n)* | adds all the m*n elements in a tabular form, with row and column numbers for better readability |
| 4 | display(): void | *O(n)* | prints toString() | *O(m * n)* | prints toString() |
| 5 | insertStart(data): void | *O(n)* | moves each element one forward and places *data* at index 0 | *O(m * n)* | moves each element one forward and places *data* at index (0,0) |
| 6 | insertEnd(data): void | *O(n)* | call *incSize()* if array is full and place *data* at _pointerIndex_ | *O(m * n)* | call *incSize()* if array is full and place *data* at _pointerIndex_ |
| 7 | insertBefore(dataBefore, dataInsert): boolean | *O(n)* | shift all the elements after and including *dataBefore* and place *dataInsert* at the previous index of *dataBefore* | *O(m * n)* | shift all the elements after and including *dataBefore* and place *dataInsert* at the previous index of *dataBefore* |
| 8 | insertAfter(dataAfter, dataInsert): boolean | *O(n)* | shift all the elements after *dataAfter* and place *dataInsert* at the previous index of *dataAfter* | *O(m * n)* | shift all the elements after *dataAfter* and place *dataInsert* at the previous index of *dataAfter* |