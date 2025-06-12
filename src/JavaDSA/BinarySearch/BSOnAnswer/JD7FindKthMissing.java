package JavaDSA.BinarySearch.BSOnAnswer;

public class JD7FindKthMissing {
    public static int findMissingBrute(int[]nums, int k){
        for(int i = 0; i<nums.length; i++){
            if(nums[i] <= k){
                k++;
            }
            else{
                break;
            }
        }
        return k;
    }
    public static int findMissingOptimal(int[] nums, int k){
        int n = nums.length;
        int low = 0, high = n-1;
        while(low <= high){
            int mid =  (low + high)/2;
            int midMissing = nums[mid] - (mid +1);
            if(midMissing < k){
                low = mid +1;
            }
            else{
                high = mid -1;
            }
        }
        return high + k +1;
    }
    public static void main(String[] args) {
        int[] nums = {2,3,4,7,11};
        System.out.println(findMissingOptimal(nums, 5));
    }
}
