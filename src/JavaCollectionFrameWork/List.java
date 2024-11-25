package JavaCollectionFrameWork;

import java.util.*;

public class List {
    public static void main(String[] args) {
        //ArrayList
//        ArrayList<Integer> list = new ArrayList<>();
        java.util.LinkedList<Integer> LL = new LinkedList<>();
        Stack<Integer> list = new Stack<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size");
        int size = sc.nextInt();
        for(int i = 0; i<size; i++){
            int data = sc.nextInt();
//            list.add(data);
            list.push(data);
        }
        System.out.println(list);
    }
}
