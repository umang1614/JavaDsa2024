package JavaDSA.BinarySearch.BS1DArray;

public class JD4SearchInRotatedSortedArray {
    public static int searchEl (int[] nums, int k){
        int n = nums.length;
        int low = 0, high = n-1;
        while(low <= high){
            int mid = (low+high)/2;
            if(nums[mid] == k) return k;
            if(nums[low] <= nums[mid]){
                if(nums[low] <= k && k <= nums[mid]){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
            else{
                if(nums[mid] <= k && k <= nums[high]){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {

    }
}
