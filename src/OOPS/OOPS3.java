package OOPS;

class OOPS3 {
    public static void main(String[] args) {
        OOPS1 o1 = new OOPS1();
////        o1.className = "Umang";
//        OOPS1.className = "Umang";
        OOPS1 o2 = new OOPS1();
        System.out.println(o2.counter);
        OOPS5 o5 = new OOPS5();
        o5.dataValue = 7;
        o5.greet();

        Car c1 = new Car();
        c1.getType();
    }
}

abstract class OOPS4{
    int dataValue;
    abstract void greet();
}

class OOPS5 extends OOPS4{
    void greet(){
        System.out.println("Hello Umang, How you doing ?");
    }

}

interface Motor{
public void getType();
}

interface Scooter {
public void getType();
}

class Car implements Motor, Scooter{
public void getType(){
    System.out.println("Tata Motors");
}
}
