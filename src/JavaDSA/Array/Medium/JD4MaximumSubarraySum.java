package JavaDSA.Array.Medium;

public class JD4MaximumSubarraySum {
    public static int subArraySumOptimal(int[] nums){
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        int ansStart = -1, ansEnd = -1;
        int start = -1;
        for(int i = 0; i< nums.length; i++){
            if(sum == 0){
                start = i;
            }
            sum += nums[i];
            if(sum > maxi){
                maxi = sum;
                ansStart = start+1;
                ansEnd = i+1;
            }
            if(sum < 0){
                sum = 0;
            }
        }
        System.out.println("Start " + ansStart +" End " + ansEnd );
        return maxi;
    }
    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
        int res = subArraySumOptimal(arr);
        System.out.println(res);
    }
}
