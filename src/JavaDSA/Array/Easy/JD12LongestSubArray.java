package JavaDSA.Array.Easy;

public class JD12LongestSubArray {

    public static int getLongestSubArray(int[] nums, long sum){
        int len = 0;
        for(int i = 0; i<nums.length; i++){
            for(int j = 0; j<nums.length; j++){
                long s = 0;
                for(int k = i; k<=j;k++){
                    s += nums[k];
                }
                if(s == sum){
                    len = Math.max(len,j-i+1);
                }
            }
        }
        return len;
    }


    public static int getLongestSubArray2(int[] nums, int sum){
        int len = 0;
        for(int i = 0; i<nums.length; i++){
            for(int j = 0; j<nums.length; j++){
                int s = 0;
                for(int k = i; k<=j; k++){
                    s+=nums[k];
                }
                if(s == sum){
                    len = Math.max(len, j-i+1);
                }
            }
        }
        return len;
    }
    public static void main(String[] args) {
        int[] a = {2, 3, 5, 1, 9};
        long k = 10;
        int len = getLongestSubArray2(a, 5);
        System.out.println("The length of the longest subarray is: " + len);
    }
}
