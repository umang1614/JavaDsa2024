package JavaDSA.BasicMath;

public class JD5PrintAllDivisor {
    class Solution{
        static long sumOfDivisors(int N){
            // code here
            long result = 0;
            for(int i=1; i<=N; i++){
                long item = (i*(N/i));
                result += item;
            }
            return result;
        }
    }
}
