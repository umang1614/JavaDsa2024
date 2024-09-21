import OOPS.OOPS1;
import OOPS.OOPS2;

import java.util.Scanner;
public class Array {
    public static void main(String[] args) {
      int marks2[] = {10, 9, 8, 7, 6, 5, 0};
       /* Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int marks[] = new int[size];
        for(int i = 0; i<size; i++){
            int mark = sc.nextInt();
            marks[i] = mark;
        }
        for(int i = 0; i<marks.length; i++){
            System.out.print(marks[i]);
        }*/
        /*int min = Integer.MAX_VALUE;
        for(int mark : marks2){
            if(mark < min){
                min = mark;
            }
        }
        System.out.println(min);
        sc.close();
        */
//        int result = sum(1,2);
//        System.out.println(result);
//
//
//        OOPS1 o2 = new OOPS1();
//        o2.getClass();
        String str = "umang";
        System.out.println(str.charAt(0));
    }
    public static int sum(int a, int b){
        int sumNo = a+b;
        return sumNo;
    }
}

