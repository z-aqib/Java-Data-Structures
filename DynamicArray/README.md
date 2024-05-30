# MyArrayLists
This is a dynamic (resizable) data structure, which is an extension of **arrays**. In normal arrays, if it gets full, we can no longer use it / add values. But in ArrayLists, we can add as many values as we like. 
### How does an Array be dynamic?
The array-unlimited-size is because every time the array gets full, a new array of double size is created and all the values are copy pasted from the old array to the new array. 
### What data types does this data structure support?
This data structures supports **all** data types, whether it be a built-in data type, or of a class you made by yourself. Just make sure to add "*extends Comparable*" to your class name and adjust your *compareTo()* function as per need. 

### Types of MyArrayLists
There are two types of MyArrayLists,
* One-Dimensional (ex. int[], char[], String[])
* Two-Dimensional (ex. int[][], char[][], String[][])

The resizable unlimited option is available for **both**. 

## Functions in MyArrayList
This table lists the possible functions in MyArrayList, how they were implemented and what their time complexity is. 
* n ~> elements in each row 
* m ~> elements in each column

| Function Name | MyArrayList1D | Implementation | MyArrayList2D | Implementation |
| ------------- | --------------- | -------------- | --------------- | -------------- |
| constructor(): void | *O(1)* | intializes a standard size of 5 to the constructor with parameters | *O(1)* | intializes a standard size of 5 by 5 to the constructor with parameters |
| constructor(size): void (where *size* will be *row, col* for 2D) | *O(1)* | intializes array of size *size* | *O(1)* | intializes array[][] of size rows *row* by cols *col* |
| toString(): String | *O(n)* | displays each non-null element | *O(m * n)* | displays all the m*n elements |
| display(): void | *O(n)* | prints toString() | *O(m * n)* | prints toString() |
| insertStart(data): void | *O(n)* | moves each element one forward and places *data* at index 0 | *O(m * n)* | moves each element one forward and places *data* at index (0,0) |
| insertEnd(data): void | *O(n)* | call *incSize()* if array is full and place *data* at _pointerIndex_ | *O(m * n)* | call *incSize()* if array is full and place *data* at _pointerIndex_ |
| insertBefore(dataBefore, dataInsert): boolean | *O(n)* | shift all the elements after and including *dataBefore* and place *dataInsert* before |