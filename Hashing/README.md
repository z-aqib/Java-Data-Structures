# Hashing
This is an ideal insertion, deletion and searching in _O(1)_ data structure. It uses the concept of **Hashing** and **arrays**. So upon insertion of data, the algorithm first gets the .toString() of it, then computes its _hashValue_. This _hashValue_ depends on the size of the HashTable. This _hashValue_ is the index of the data. The data is then placed on that index. When that data is searched, the same algorithm is performed, it is converted to string, its _hashValue_ is computed and that **specific index** is checked. This makes insertion, searching, deletion _O(1)_ as we compute an index and go straight to that. 
> However, this may cause a problem. What if two data are mapped to the same index? What if a data already exists when we are inserting a data on an index? To solve this problem, we have two ways, either we perform Seperate Chaining or Open Addressing. This is discussed in Types of Hashing. 

## Types of Hashing
There are two types of Hashing,
* Seperate Chaining
* Open Addressing

### Seperate Chaining


## Functions in MyArrayList
This table lists the possible functions in MyArrayList, how they were implemented and what their time complexity is. 
* n ~> elements in each row 
* m ~> elements in each column
