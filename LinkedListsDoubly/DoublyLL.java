package LinkedListsDoubly;

// COMPLETED - ALL METHODS DONE
public class DoublyLL<T extends Comparable<T>> {

    /*
    this is a doubly linked list data structure. it is different to a singly linked list 
    as in singly all the nodes point to the next node but in doubly each node points 
    to the next node as well as its previous node. doubly uses more space but it is 
    more time effeceient. it is of generic type i.e. any type. 
     */
    DoublyNode headNode; // saves the starting address of the nodes
    int size; // counts the number of elements in the index

    public DoublyLL() {
        // constructor: standard constructor
        // starts the linked list and intialises the head node to be null. 
        System.out.println("Welcome to Doubly MyLinkedList! ");
        this.headNode = null;
        this.size = 0;
    }

    @Override
    public String toString() {
        /*
        method: toString, converts the data structure to a string
         */
        String str = "{\n\t";
        DoublyNode duplicateHead = this.headNode;
        while (duplicateHead != null && duplicateHead.next != null) {
            str = str + duplicateHead.data.toString() + " , ";
            if (duplicateHead.data.toString().length() >= 10) {
                str += "\n\t";
            }
            duplicateHead = duplicateHead.next;
        }
        str = "size=" + size + str + duplicateHead + "\n}";
        return str;
    }

    public void display() {
        // method: displays the data structure's string
        System.out.println(toString());
    }

    private void insertFirst(T valueToInsert) {
        // method: inserts the first value in the linkedlist by inserting at head
        this.headNode = new DoublyNode(valueToInsert);
        size++;
        System.out.println("SUCCESS: '" + valueToInsert + "' inserted as the first value. ");
    }

    public void insertStart(T valueToInsert) {
        /*
        method: inserts a value at the start of a data structure
        saves the head and inserts at the head, then attachs the old head with the new head
         */
        if (this.headNode == null) {
            insertFirst(valueToInsert);
            return;
        }
        DoublyNode temporaryNode = this.headNode;
        this.headNode = new DoublyNode(valueToInsert);
        this.headNode.next = temporaryNode;
        this.headNode.next.previous = this.headNode;
        size++;
        System.out.println("SUCCESS: '" + valueToInsert + "' has been inserted at the start successfully. ");
    }

    public void insertEnd(T valueToInsert) {
        /*
        method: inserts a value at the end of a data structure
        triverses the linkedlist then inserts at the last element
         */
        if (this.headNode == null) {
            insertFirst(valueToInsert);
            return;
        }
        DoublyNode temp = this.headNode;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new DoublyNode(valueToInsert);
        temp.next.previous = temp;
        size++;
        System.out.println("SUCCESS: '" + valueToInsert + "' inserted at the end successfully. ");
    }

    public void insertBefore(DoublyNode dataInsertBefore, T valueToInsert) {
        /*
        method: inserts a value before a specific value in the data structure
        links the node behind this given node to a new node with the inserting value, 
        then links the given node to the new node. 
         */
        if (this.headNode == null) {
            insertFirst(valueToInsert);
            return;
        }
        if (dataInsertBefore.previous != null) {
            DoublyNode prevNode = dataInsertBefore.previous;
            prevNode.next = new DoublyNode(valueToInsert);
            prevNode.next.previous = prevNode;
            prevNode.next.next = dataInsertBefore;
            dataInsertBefore.previous = prevNode.next;
        } else { // if its empty from behind, means its a head node. this new node is now head
            this.headNode = new DoublyNode(valueToInsert);
            this.headNode.next = dataInsertBefore;
        }
        System.out.println("SUCCESS: '" + valueToInsert + "' inserted before '" + dataInsertBefore + "' successfully. ");
    }

    public void insertAfter(DoublyNode dataInsertAfter, T valueToInsert) {
        /*
        method: inserts a value after a specific value in the data structure
        first attachs connections on the given node with a new node of the inserting value. 
        then attachs connections with the next node after the given node with the new node. 
         */
        if (this.headNode == null) {
            insertFirst(valueToInsert);
            return;
        }
        DoublyNode next = dataInsertAfter.next;
        dataInsertAfter.next = new DoublyNode(valueToInsert);
        dataInsertAfter.next.previous = dataInsertAfter;
        if (next != null) {
            next.previous = dataInsertAfter.next;
            dataInsertAfter.next.next = next;
        }
        System.out.println("SUCCESS: '" + valueToInsert + "' inserted after '" + dataInsertAfter + "' successfully. ");
    }

    public void insertAt(int indexToInsert, T valueToInsert) {
        /*
        method: inserts a value at a specific index in the data structure
        inserts at a specific index by getting the node at that index, and inserting before 
        that node. 
         */
        if (this.headNode == null) {
            insertFirst(valueToInsert);
            return;
        }
        insertBefore(getNodeUsingIndex(indexToInsert), valueToInsert);
        System.out.println("SUCCESS: '" + valueToInsert + "' inserted at index " + indexToInsert + " successfully. ");
    }

    public void insertInOrder(T valueToInsert) {
        /*
        method: inserts a value in order in the data structure
        inserts in order by checking each value and seeing where it fits. 
         */
        if (this.headNode == null) {
            insertFirst(valueToInsert);
            return;
        }
        sortLowToHigh();
        DoublyNode duplicateHead = this.headNode;
        while (duplicateHead.next != null) {
            if (duplicateHead.data.compareTo(valueToInsert) == 1) {
                insertBefore(duplicateHead, valueToInsert);
                return;
            }
            duplicateHead = duplicateHead.next;
        }
        if (duplicateHead.data.compareTo(valueToInsert) == -1) {
            insertBefore(duplicateHead, valueToInsert);
        } else {
            insertAfter(duplicateHead, valueToInsert);
        }
    }

    public void update(int indexToUpdate, T valueToUpdate) {
        /*
        method: updates a specific index in the data structure
        if the index does not exist in the linked list, returb
        else get the node at that index and change its data
         */
        if (this.headNode == null || indexToUpdate < 0 || indexToUpdate >= size()) {
            System.out.println("ERROR: index " + indexToUpdate + " cannot be updated as it does not exist. ");
            return;
        }
        getNodeUsingIndex(indexToUpdate).data = valueToUpdate;
        System.out.println("SUCCESS: index " + indexToUpdate + " updated successfully. ");
    }

    public boolean find(T valueToFind) {
        /*
        method: finds whether or not a value is in the data structure
        when getting the node of this value, if we get a null node, its not found, 
        else it is found. 
         */
        return getNodeUsingValue(valueToFind) != null;
    }

    public DoublyNode getNodeUsingValue(T valueToGet) {
        /*
        method: gets the node of a specific value
        it checks each node of the linked list, if the value is found, it returns
        the node, else returns null
         */
        if (this.headNode == null) {
            System.out.println("ERROR: LinkedList is empty. ");
            return null;
        }
        DoublyNode duplicateHead = this.headNode;
        while (duplicateHead != null && duplicateHead.data.compareTo(valueToGet) != 0) {
            duplicateHead = duplicateHead.next;
        }
        return duplicateHead;
    }

    public DoublyNode getNodeUsingIndex(int indexToGet) {
        /*
        method: gets the value at a specific index in the data structure
        triverses the array until counter is equal to the index, or we get a null value. 
         */
        if (this.headNode == null || indexToGet >= size()) {
            System.out.println("ERROR: Cannot get node at index " + indexToGet + " as it does not exist. ");
            return null;
        }
        DoublyNode duplicateHead = this.headNode;
        int counter = 0;
        while (duplicateHead != null && counter < indexToGet) {
            duplicateHead = duplicateHead.next;
            counter++;
        }
        return duplicateHead;
    }

    public int getIndex(T valueToGet) {
        /*
        method: gets the index of where a value is placed within the data structure
        triverses the linkedlist and when the value is found, it returns the counter 
        on what index it was found, else it returns -1 to show it was not found. 
         */
        DoublyNode duplicateHead = this.headNode;
        int counter = 0;
        while (duplicateHead != null && duplicateHead.data.compareTo(valueToGet) != 0) {
            duplicateHead = duplicateHead.next;
            counter++;
        }
        if (duplicateHead == null) {
            return -1;
        } else {
            return counter;
        }
    }

    public DoublyNode getFirst() {
        /*
        method: get the first value in the data structure
        returns the head as it stores the first value
         */
        return this.headNode;
    }

    public DoublyNode getLast() {
        /*
        method: gets the last value in the data structure
        traverses the linked list and gets the last node
         */
        DoublyNode temp = this.headNode;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp;
    }

    public boolean clear() {
        /*
        method: clears the data structure
         */
        this.headNode = null;
        this.size = 0;
        System.out.println("SUCCESS: DoublyLinkedList has been cleared successfully. ");
        return true;
    }

    public int size() {
        /*
        method: computes how many elements are present in the data structure
         */
        return size;
    }

    public boolean isEmpty() {
        /*
        method: tells if the data structure is empty or not
         */
        return this.headNode == null;
    }

    public Comparable<T> deleteIndex(int indexToDelete) {
        /*
        method: deletes a specific index in the data structure
        first it gets the node at that index. then it deletes that node. 
         */
        if (this.headNode == null || indexToDelete < 0 || indexToDelete >= size()) {
            System.out.println("ERROR: Cannot delete index " + indexToDelete + " as it does not exist. ");
            return null;
        }
        return deleteNode(getNodeUsingIndex(indexToDelete));
    }

    public Comparable<T> deleteNode(DoublyNode nodeToDelete) {
        /*
        method: delets a node in the linked list. 
        this only works for a doubly node as it contains the previous and next node. 
        if a previous exists, it changes the .next on the previous to the node after 
        the deleting node. then if the next node exists, it changes the .previous 
        on the next to the node before the deleting node. but, if both previous 
        and next dont exist, we've reached the end of the linked list. make the head null. 
         */
        if (nodeToDelete == null) {
            System.out.println("ERROR: Cannot delete '" + nodeToDelete + "' as it is null. ");
            return null;
        }
        Comparable<T> dataOnNode = nodeToDelete.data;
        if (nodeToDelete.next != null) {
            nodeToDelete.next.previous = nodeToDelete.previous;
        }
        if (nodeToDelete.previous != null) {
            nodeToDelete.previous.next = nodeToDelete.next;
        } else {
            this.headNode = nodeToDelete.next;
        }
        if (nodeToDelete.next == null && nodeToDelete.previous == null) {
            this.headNode = null;
        }
        size--;
        System.out.println("SUCCESS: '" + nodeToDelete + "' deleted successfully. ");
        return dataOnNode;
    }

    public Comparable<T> deleteFirstOccurence(T valueToDelete) {
        /*
        method: delets the first occurence of a specific value in the data structure
        gets the node and connects its previous value to its next so that the middle node 
        is skipped entirely
         */
        if (this.headNode == null || find(valueToDelete) == false) {
            System.out.println("ERROR: Cannot delete '" + valueToDelete + "' as it does not exist. ");
            return null;
        }
        return deleteNode(getNodeUsingValue(valueToDelete));
    }

    public void deleteAllOccurrences(T valueToDelete) {
        /*
        method: deletes all the occurences of a specific value in the data structure
         */
        while (find(valueToDelete) == true) {
            deleteFirstOccurence(valueToDelete);
        }
        System.out.println("SUCCESS: All occurences of '" + valueToDelete + "' have been deleted successfully. ");
    }

    public Comparable<T> deleteFirst() {
        /*
        method: deletes the first element in the data structure
        it gets the last element and passes it through delete
         */
        return deleteNode(getFirst());
    }

    public Comparable<T> deleteLast() {
        /*
        method: deletes the last element in the data structure
        it gets the last element and passes it through delete
         */
        return deleteNode(getLast());
    }

    public void sortLowToHigh() {
        /*
        method: sorts the data structure from low to high
        sorts using fixed sort, it compares a fixed node with all the rest of the 
        nodes in the linked list, swapping data of nodes when needed. then compares 
        the next node with each node in the linked list and so on. 
         */
        for (DoublyNode fixed = this.headNode; fixed != null; fixed = fixed.next) {
            for (DoublyNode temporary = fixed.next; temporary != null; temporary = temporary.next) {
                if (fixed.data.compareTo(temporary.data) == 1) {
                    Comparable<T> temp = fixed.data;
                    fixed.data = temporary.data;
                    temporary.data = temp;
                }
            }
        }
    }

    public void removingDuplicates() {
        /*
        method: removes duplicate values from the data structure
        first we sort the linked list so that all duplicates come together
        so traverisng the linked list once, we get each node, check the node after it, 
        if theyre the same, remove the next node. then check the node behind it, if they are 
        same, remove the behind node. 
         */
        sortLowToHigh();
        for (DoublyNode duplicateHead = this.headNode; duplicateHead != null; duplicateHead = duplicateHead.next) {
            // forward checking
            if (duplicateHead.next != null && duplicateHead.data.compareTo(duplicateHead.next.data) == 0) {
                deleteNode(duplicateHead.next);
            }
            // backward checking
            if (duplicateHead.previous != null && duplicateHead.data.compareTo(duplicateHead.previous.data) == 0) {
                deleteNode(duplicateHead.previous);
            }
        }
    }

    public Comparable<T> findMax() {
        /*
        method: returns the largest value in the data structure
        it first sorts the linkedlist then traverses it to the end to get the last value 
        which would be the largest. it returns the last value. 
         */
        sortLowToHigh();
        DoublyNode duplicateHead = this.headNode;
        while (duplicateHead.next != null) {
            duplicateHead = duplicateHead.next;
        }
        return duplicateHead.data;
    }

    public Comparable<T> findMin() {
        /*
        method: returns the smallest value in the data structure.
        it sorts the linked list then returns the first value which would be the smallest
         */
        sortLowToHigh();
        return this.headNode.data;
    }

    public Comparable<T>[] toArray() {
        /*
        method: converts the data structure to a single dimensional array
        creates an array of size of elements in linked list and traverse the linked list 
        by adding each node to the array. return array. 
         */
        Comparable<T>[] array = new Comparable[size];
        DoublyNode duplicateHead = this.headNode;
        for (int i = 0; duplicateHead != null; i++, duplicateHead = duplicateHead.next) {
            array[i] = duplicateHead.data;
        }
        return array;
    }

    public void reverse() {
        /*
        method: reverses the values in the data structure
        it gets each node in the linkedlist, reverses the .previous and .next 
        and then gets the next node and does the same. 
         */
        DoublyNode duplicateHead = this.headNode;
        DoublyNode intermediate;
        while (duplicateHead != null) {
            if (duplicateHead.next == null) {
                this.headNode = duplicateHead;
            }
            intermediate = duplicateHead.next;
            duplicateHead.next = duplicateHead.previous;
            duplicateHead.previous = intermediate;
            duplicateHead = intermediate;
        }
    }

    public void assignRandomIntegers() {
        /*
        method: fills the data structure with random integer values between 0 to 9. 
        fills with standard size of 10, unsorted. 
         */
        for (int i = 0; i < 10; i++) {
            insertStart((T) (Integer) (int) (Math.random() * 10));
        }
    }

}
