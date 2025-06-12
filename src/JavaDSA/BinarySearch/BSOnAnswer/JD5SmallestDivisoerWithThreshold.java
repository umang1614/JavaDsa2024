package JavaDSA.BinarySearch.BSOnAnswer;

public class JD5SmallestDivisoerWithThreshold {
    public static boolean checkThreshold(int[] nums, int mid, int threshold){
        int sum = 0;
        for(int i  = 0; i<nums.length; i++){
            sum += Math.ceil((double) nums[i]/(double) mid);
        }
        if(sum <= threshold) return true;
        return false;
    }
    public static int findDivisor(int[] nums, int threshold){
        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length; i++){
            maxi = Math.max(maxi, nums[i]);
        }
        int low = 1, high = maxi, ans = -1;
        while(low <= high){
            int mid = (low + high)/2;
            if(checkThreshold(nums, mid, threshold)){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,5,9};
        System.out.println(findDivisor(nums, 7));
    }
}
