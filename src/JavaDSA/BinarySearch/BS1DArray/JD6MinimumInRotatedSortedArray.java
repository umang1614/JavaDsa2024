package JavaDSA.BinarySearch.BS1DArray;

public class JD6MinimumInRotatedSortedArray {
    public static int findMin(int[] nums){
        int n = nums.length;
        int low = 0, high = n-1, ans = Integer.MAX_VALUE;
        while(low <= high){
            int mid = (low+high)/2;
            if(nums[low] <= nums[mid] && nums[mid] <= nums[high]){
                ans = Math.min(ans, nums[low]);
                break;
            }
            if(nums[low] <= nums[mid]){
                ans = Math.min(ans, nums[low]);
                low = mid + 1;
            }
            else{
                ans = Math.min(ans, nums[mid]);
                high = mid - 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {

    }
}
