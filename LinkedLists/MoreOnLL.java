package LinkedLists;

import LinkedListsDoubly.*;
import LinkedListsSingly.*;

public class MoreOnLL {

    public SinglyNode findMiddleNodeS(SinglyNode headNode) {
        /*
        1. Find the middle node of a linked list. Assume no other information 
        is given except head pointer.
        we are only given the head i.e. singly.head;
            METHOD 1 -> compute middle index of linked list using size of linked list / 2, 
        then use getNode(int index) function to get the node at that middle index. 
        but here we are not given the linked list or the size so not possible.
            METHOD 2 -> traverse the head until you get null and run a counter to find the 
        size of the linked list. then, find the middle of the size (size/2) and then 
        traverse again from head to that middle. but this is more time consuming as 
        we have to traverse twice. 
            METHOD 3 -> traverse the linked list but save each node in a dynamic arraylist 
        until you get null. then, using the arraylist, get the size and access quickly the 
        middle index. this is space complexity as it uses a second data structure - what 
        if we have limited space and capacity? what if the linked list has a large sum of 
        nodes?
            METHOD 4 -> run two pointer nodes, one moving two spaces forward (fastRunner) 
        and one moving one space forward (slowRunner). as soon as the fastRunner gets null, 
        or the fastRunner doesnt have a second space to move forward too, it means the 
        slowRunner is at the middle. hence return slowRunner. this is the best method out of 
        all as it only traverses the linkedlist once and in only n/2 iterations. it also 
        does not use a second data structure. 
         */
        if (headNode == null) {
            System.out.println("ERROR: Head is null. No middle node could be found. ");
            return null;
        }
        SinglyNode fastRunner = headNode;
        SinglyNode slowRunner = headNode;
        while (fastRunner != null && fastRunner.next != null) {
            fastRunner = fastRunner.next.next;
            slowRunner = slowRunner.next;
        }
        return slowRunner;
    }

    public DoublyNode findMiddleNodeD(DoublyNode headNode) {
        /*
        method: finds middle node in a linked list
        same as logic given for singly middle node
         */
        if (headNode == null) {
            System.out.println("ERROR: Head is null. No middle node could be found. ");
            return null;
        }
        DoublyNode fastRunner = headNode;
        DoublyNode slowRunner = headNode;
        while (fastRunner != null && fastRunner.next != null) {
            fastRunner = fastRunner.next.next;
            slowRunner = slowRunner.next;
        }
        return slowRunner;
    }

    public SinglyLL sortedMerge(SinglyLL l1, SinglyLL l2) {
        /*
        method: gets two linked lists and merges them in sorted order
        first sort both the linked lists.
        METHOD 1 -> create a new linked list and insert in order i.e. take each node, 
        which ever is smaller, insert that. problems: creates a new data structure (space complexity, 
        what if we have limited space) and longer code
        METHOD 2 -> insert l2 inside l1 by comparing each node of l1, wherever we find 
        a node in l1 that is greater than l2, insert before that node. lesser time 
        will be taken and no additional data structure is used. 
         */
        l1.sortLowToHigh();
        l2.sortLowToHigh();
        SinglyNode duplicateHead = l1.peekHead();
        SinglyNode previousNode = null;
        while (duplicateHead.next != null && l2.peekHead() != null) {
            if (l2.peekHead().data.compareTo(duplicateHead.data) >= 0
                    && l2.peekHead().data.compareTo(duplicateHead.next.data) < 0) {
                if (previousNode == null) {
                    l1.insertStart(l2.deleteHead().data);
                } else {
                    l1.insertAfter(duplicateHead, l2.deleteHead().data);
                }
            } else {
                previousNode = duplicateHead;
                duplicateHead = duplicateHead.next;
            }
        }
        while (l2.peekHead() != null) {
            l1.insertEnd(l2.deleteHead().data);
        }
        return l1;
    }

    public SinglyLL getSinglyLL() {
        // method: creates a random, unsorted singlyLL and returns it. 
        SinglyLL singly = new SinglyLL();
        singly.assignRandomIntegers();
        return singly;
    }

    public DoublyLL getDoublyLL() {
        // method: creates a random, unsorted doublyLL and returns it. 
        DoublyLL doubly = new DoublyLL();
        doubly.assignRandomIntegers();
        return doubly;
    }

    public DoublyNode[] listSplit(DoublyLL l) {
        // 6. Given a doubly linked list, split it into two sublists, one for the front half, and one for the back half. If the number of elements is odd, the extra element should go in the front list. So for example, public node[ ] ListSplit(Linklist L) on the list {2, 3, 5, 7, 11} should return the two lists {2, 3, 5} and {7, 11}. Note: Getting this right for all the cases is harder than it looks. You should check your solution against a few cases (length = 2, length = 3, length=4) to make sure that the list gets split correctly near the short-list boundary conditions. If it works right for length=4, it probably works right for length=1000. You will probably need special case code to deal with the (length <2) cases.
        DoublyNode middle = findMiddleNodeD(l.getFirst());
        if (middle.previous != null) {
            middle.previous.next = null;
        }
        middle.previous = null;
        return new DoublyNode[]{l.getFirst(), middle};
    }

}
