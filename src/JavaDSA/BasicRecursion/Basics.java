package JavaDSA.BasicRecursion;

public class Basics {
    static int counter = 0;
static void func(){
    if(counter == 10){
        return;
    }
    System.out.println(counter++);
    func();
}

    public static void main(String[] args) {
        func();
    }
}
