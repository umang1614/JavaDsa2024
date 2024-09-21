package JavaDSA.BasicRecursion;

public class JD1SumOfFirstNNumber {

    static void sumNParameter(int n, long sum){
        if(n==0){
            System.out.println(sum);
            return;
        }
        long result  = (long)Math.pow(n, 3);
        sumNParameter(n-1, sum+result);
    }

    static long sumNFunctional(int n){
        if(n == 0){
            return 0;
        }
        long result = (long) Math.pow(n,3);
        return result + sumNFunctional(n-1);
    }
    public static void main(String[] args) {
//        sumNParameter(10, 0);

        long result = sumNFunctional(10);
        System.out.println(result);
    }
}
