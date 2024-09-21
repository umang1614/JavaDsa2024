package JavaDSA.BasicMath;

public class JD2ReverseNumber {
    class Solution2{
        public static int reverse(int x) {
            int result =0;
            int negFlag = 0;
            if(x < 0){
                negFlag = 1;
                x = 0-x;
            }
            while(x > 0){
                int lastDigit = x%10;
                if(result<Integer.MIN_VALUE/10 || result>Integer.MAX_VALUE/10){
                    return 0;
                }
                result = (result * 10) + lastDigit;
                x = x/10;
            }
            if(negFlag ==1 ){
                result = -result;
            }
            return result;
        }
    }
    public static void main(String[] args) {
        int x = -321;
        System.out.println(Solution2.reverse(x));
    }
}
