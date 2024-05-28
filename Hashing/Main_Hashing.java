package Hashing;

public class Main_Hashing {

    public static void main(String[] args) {

//        DS PAPER CHECK: insert [2,12,3,18,4] // 18 insert nahi horaha tha
//        Hashing hashing = new Hashing(5);
//        int[] insert = {2, 12, 3, 18, 4};
//        hashing.display();
//        for (int i = 0; i < insert.length; i++) {
//            hashing.insert(insert[i]);
//            hashing.display();
//        }
    }

}

class Hashing {

    public Integer[] table;

    public Hashing(int size) {
        table = new Integer[size];
    }

    public int hash(int num, int i) {
        return (int) ((num + Math.pow(i, 2)) % table.length);
    }

    public int hash(int num) {
        return num % table.length;
    }

    public int rehash(int num, int i) {
        return hash((int) (num + Math.pow(i, 2)));
    }

    public int insert(int num) {
        int i = 0;
        int hash = hash(num);
        while (table[hash] != null) {
            hash = rehash(num, ++i);
            System.out.println("collision number -> " + i + " , hash value -> " + hash);
        }
        table[hash] = num;
        System.out.println("inserting " + num + " , number of collisions -> " + i);
        return i;
    }

    @Override
    public String toString() {
        // method: converts the hashtable into a string
        String str = "";
        for (int i = 0; i < table.length; i++) {
            str += (i + 1) + ":'" + table[i] + "'";
            if (i != table.length - 1) {
                str = str + " , ";
            }
        }
        return "[" + str + "]";
    }

    public void display() {
        // method: displays hash table
        System.out.println(toString());
    }
}
