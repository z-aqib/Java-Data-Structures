# MyArrayLists
This is a dynamic (resizable) data structure, which is an extension of **arrays**. In normal arrays, if it gets full, we can no longer use it / add values. But in ArrayLists, we can add as many values as we like. 
## How is that possible?
The array-unlimited-size is because every time the array gets full, a new array of double size is created and all the values are copy pasted from the old array to the new array. 
## What data types does this data structure support?
This data structures supports **all** data types, whether it be a built-in data type, or of a class you made by yourself. Just make sure to add *extends Comparable* to your class name and adjust your *compareTo()* function as per need. 

## Types of MyArrayLists
There are two types of MyArrayLists,
* One-Dimensional (ex. int[], char[], String[])
* Two-Dimensional (ex. int[][], char[][], String[][])
