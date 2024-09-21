package JavaDSA.BasicMath;

public class JD4ArmstrongNumber {
    static String armstrongNumber(int n) {
        // code here
        int sum = 0;
        int temp = n;
        while(n > 0){
            int lastNum = n%10;
            sum  += lastNum * lastNum * lastNum;
            n /= 10;
        }
        if(sum == temp){
            return "true";
        }
        return "false";
    }
}
