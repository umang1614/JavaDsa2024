public class GenericsClass {

    public static void main(String[] args) {
        GenericMain<Integer> g1 = new GenericMain<>(191320, 17);
        GenericMain<String> g2 = new GenericMain<>("Umang", "17y");
        System.out.println("My roll no is "+g1.getId()+" and my class is "+g1.getClassNo());
        System.out.println("My roll no is "+g2.getId()+" and my class is "+g2.getClassNo());
        getUniqueNumber("umang");
        getUniqueNumber(12);
        getUniqueNumber(12.56);
//        getUniqueNumber("Umang", );
        GenericsClass g54 = new GenericsClass();
        g54.getUniqueNumber("Umang bhatia", "Dinesh Bhatia");
    }

   public static <U> void getUniqueNumber(U data){
       System.out.println(data);
    }

    public <T> void getUniqueNumber(T data, T data2){
        System.out.println("My name is "+ data + " and my father's name is "+ data2);
    }
}

class GenericMain <U>{
    private U id;
    private U classNo;

    public GenericMain(U id, U classNo){
        this.id = id;
        this.classNo = classNo;
    }

    public U getId(){
        return this.id;
    }
    public U getClassNo(){
        return this.classNo;
    }
}
