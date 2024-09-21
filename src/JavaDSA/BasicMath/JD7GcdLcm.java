package JavaDSA.BasicMath;

public class JD7GcdLcm {
    class Solution {
        static Long[] lcmAndGcd(Long A , Long B) {
            Long a2 = A;
            Long b2 = B;
            Long result[] = new Long[2];

            while(a2 > 0 && b2 > 0){
                if(a2 > b2){
                    a2 = a2 %b2;
                }
                else{
                    b2 = b2 % a2;
                }
            }
            if(a2 == 0){
                result[1] = b2;
            }
            else{
                result[1] = a2;
            }

            Long lcm = (A*B)/result[1];
            result[0] = lcm;
            return result;
        }
    };
}
