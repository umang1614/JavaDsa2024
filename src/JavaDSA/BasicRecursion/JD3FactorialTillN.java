package JavaDSA.BasicRecursion;
import java.util.*;

public class JD3FactorialTillN {
    class Solution {

        static long factorial(int n){
            if(n == 1){
                return 1;
            }
            return n * factorial(n-1);
        }
        static ArrayList<Long> factorialNumbers(long n) {

            ArrayList<Long>l= new ArrayList<>();

            long sum = 0;
            for(int i = 1; sum <= n; i++){
                sum = factorial(i);
                if(sum <= n){
                    l.add(sum);
                }
            }
            return l;
        }
    }
}
