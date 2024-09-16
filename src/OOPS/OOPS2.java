package OOPS;

public class OOPS2 extends LinkedList{
OOPS2(){
    super(5);
    System.out.println("OOPS2 is created");
}
    public static void main(String[] args) {
        OOPS2 obj = new OOPS2();
//        LinkedList L1 = new LinkedList(23);
        System.out.println(obj.getData());
//        System.out.println(L1.getData());
    }
}


