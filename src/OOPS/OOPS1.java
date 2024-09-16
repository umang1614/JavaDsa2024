package OOPS;

//Classes and Objects, Method Overloading, Constructor
public class OOPS1 {
    static String className;
    static int counter =0;
    public OOPS1(){
        counter++;
    }
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList(1);
        LinkedList l2 = new LinkedList(2);
        LinkedList l3 = new LinkedList(3, null);
        LinkedList start = l1;

        l1.next = l2;
        l2.next = l3;
        while(start != null){
            System.out.println(start.getData());
            start = start.next;
        }

    }
}

class LinkedList{
   private int data;
   LinkedList next;
    public LinkedList(int data){
        this.data = data;
        System.out.println("LL is Created. Data is "+data);
    }
    public int getData(){
        return this.data;
    }
    public LinkedList(int data, LinkedList L1) {
        this.data = data;
        this.next = L1;
    }

}
