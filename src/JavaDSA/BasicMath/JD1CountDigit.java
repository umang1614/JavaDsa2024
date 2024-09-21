package JavaDSA.BasicMath;

public class JD1CountDigit {
    class Solution {
        static int evenlyDivides(int N) {
            // code here
            int temp = N;
            int result = 0;
            int lastDigitGlobal = 0;
            while (N > 0) {
                int lastDigit = N % 10;
                if (lastDigit != 0) {
                    if (temp % lastDigit == 0 && lastDigit != lastDigitGlobal) {
                        result++;

                    }
                }
                N = N / 10;
            }
            return result;
        }
    }
}
