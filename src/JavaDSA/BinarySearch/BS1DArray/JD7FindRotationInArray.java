package JavaDSA.BinarySearch.BS1DArray;

public class JD7FindRotationInArray {
    public static int findRotation(int[] nums){
        int n = nums.length;;
        int low = 0, high = n-1, ans = Integer.MAX_VALUE, index = -1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[low] <= nums[mid] && nums[mid] <= nums[high]){
                if(nums[low] < ans){
                    ans = nums[low];
                    index = low;
                }
            }
            if(nums[low] <= nums[mid]){
                if(nums[low] < ans){
                    ans = nums[low];
                    index = low;
                }
                low = mid + 1;
            }
            else{
                if(nums[mid] < ans){
                    ans = nums[mid];
                    index = mid;
                }
                high = mid -1;
            }
        }
        return index;
    }
    public static void main(String[] args) {
        int[] arr = {4,5,1,2,3};
        int ans = findRotation(arr);
        System.out.println(ans);
    }
}
