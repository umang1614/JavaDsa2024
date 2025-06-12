package JavaDSA.BinarySearch.BS1DArray;

public class JD1LowerBound {
    public static int lowerBound(int[] nums, int target){
        int n = nums.length;
        int low = 0, high = n-1, ans = n;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid] >= target){
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 15, 19};
        int n = 5, x = 9;
        int ind = lowerBound(arr, x);
        System.out.println("The lower bound is the index: " + ind);
    }
}
