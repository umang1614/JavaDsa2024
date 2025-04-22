package JavaDSA.Array.Easy;

public class JD11FindNumberAppearOnce {

    public int singleNumber(int[] nums) {
        int xor = 0;
        for(int i = 0; i<nums.length; i++){
            xor ^= nums[i];
        }
        return xor;
    }
    public static void main(String[] args) {

    }
}
