package DynamicArray;

// FINISHED
public class Main_DynamicArray {

    public static void main(String[] args) {
        /*
        MyArrayList2D m = new MyArrayList2D();
        m.insertEnd(5);
        m.display();
        m.insertEnd(3);
        m.display();
        m.deleteIndex(0, 0);
        m.display();
         */ 
        MyArrayList1D array = new MyArrayList1D();
        array.insertStart(5); 
        array.display();
        array.insertEnd(4); 
        array.display();
        array.insertAt(0, 3);
        array.display();
        array.insertBefore(4, 2);
        array.display();
        array.insertAfter(4, 1);
        array.display();
        System.out.println("done - tried and tested"); // you can test each method of the dynamic array's here
    }

}
