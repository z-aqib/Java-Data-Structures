package Hashing;

import LinkedListsSingly.*;

public class HashingSeperateChaining<T extends Comparable<T>> {

    public SinglyLL<T>[] table;
    public int nodesInHashTable;

    public HashingSeperateChaining(int s) {
        this.table = new SinglyLL[s + (s / 3)];
        for (int i = 0; i < table.length; i++) {
            table[i] = new SinglyLL();
        }
        nodesInHashTable = 0;
    }

    public int Hash(T obj) {
        return obj.hashCode() % table.length;
    }

    public void insert(T obj) {
        int index = Hash(obj);
        table[index].insertStart(obj);
        nodesInHashTable++;
    }

    public boolean find(T obj) {
        int index = Hash(obj);
        return table[index].find(obj);
    }

    public boolean delete(T obj) {
        SinglyNode deleted = table[Hash(obj)].deleteFirstOccurence(obj);
        if (deleted != null) {
            --nodesInHashTable;
            return true;
        }
        return false;
    }

    public void displayTable() {
        System.out.println("size of HashTable = " + table.length + " , nodes in HashTable = " + nodesInHashTable);
        for (int i = 0; i < table.length; i++) {
            SinglyLL<T> singlyLinkedList = table[i];
            System.out.println("\t" + singlyLinkedList.toString());
        }
    }

    public double loadFactor() {
        return nodesInHashTable / table.length;
    }

}
