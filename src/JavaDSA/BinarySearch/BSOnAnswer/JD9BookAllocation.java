package JavaDSA.BinarySearch.BSOnAnswer;

public class JD9BookAllocation {
    public static int countStd(int[] nums, int lim, int k){
        int std = 1, pages = 0;
        for(int i = 0; i<nums.length; i++){
            if(pages + nums[i] <= lim){
                pages += nums[i];
            }
            else{
                std++;
                pages = nums[i];
            }
        }
        return std;
    }
    public static int findMin(int[] nums, int k){
        int maxi = Integer.MIN_VALUE, sumAll = 0;
        for(int i = 0; i<nums.length; i++){
            maxi = Math.max(maxi, nums[i]);
            sumAll += nums[i];
        }
        int low = maxi, high = sumAll, ans = -1;
        while(low <= high){
            int mid = (low + high)/2;
            int cntStd = countStd(nums, mid, k);
            if(cntStd <= k){
                ans = mid;
                high = mid -1;
            }
            else{
                low = mid +1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {25, 46, 28, 49, 24};
        System.out.println(findMin(nums, 4));
    }
}
