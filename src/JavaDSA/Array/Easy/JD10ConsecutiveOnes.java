package JavaDSA.Array.Easy;

public class JD10ConsecutiveOnes {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int ctr = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] == 1){
                ctr++;
                if(ctr > max){
                    max = ctr;
                }
            }
            else{
                ctr = 0;
            }
        }
        return max;
    }
    public static void main(String[] args) {

    }
}
