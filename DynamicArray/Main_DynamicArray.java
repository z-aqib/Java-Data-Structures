package DynamicArray;

// FINISHED
public class Main_DynamicArray {

    public static void main(String[] args) {
        System.out.println("done - tried and tested"); // you can test each method of the dynamic array's here
    }

    public static MyArrayList1D getMyArrayList1D() {
        // method: creates a standard size MyArrayList1D with random integers
        MyArrayList1D list = new MyArrayList1D();
        list.assignRandomIntegers();
        return list;
    }

    public static MyArrayList2D getMyArrayList2D() {
        // method: creates a standard size MyArrayList2D with random integers
        MyArrayList2D list = new MyArrayList2D();
        list.assignRandomIntegers();
        return list;
    }

}
