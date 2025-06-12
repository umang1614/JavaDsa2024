package JavaDSA.BinarySearch.BS1DArray;

public class JD3FirstAndLastOccurence {
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
    public static int upperBound(int[] nums, int target){
        int n = nums.length;
        int low = 0, high = n-1, ans = n;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid] > target){
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
    public static int[] firstAndLastWithLB(int[] nums, int target){
        int n = nums.length;
        int lb = lowerBound(nums, target);
        if(lb == n || nums[lb] != target){
            return new int[]{-1, -1};
        }
        return new int[]{lb, upperBound(nums, target)-1};
    }
    public static int bsForFirst(int[] nums, int target){
        int n = nums.length;
        int low = 0, high = n-1, first = -1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid] == target){
                first = mid;
                high = mid - 1;
            }
            else if(nums[mid] > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return first;
    }
    public static int bsForLast(int[] nums, int target){
        int n = nums.length;
        int low = 0, high = n-1, last = -1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid] == target){
                last = mid;
                low = mid + 1;
            }
            else if(nums[mid] > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return last;
    }
    public static int[] firstAndLastWithBS(int[] nums, int target){
        return new int[]{bsForFirst(nums, target), bsForLast(nums, target)};
    }
    public static void main(String[] args) {


    }
}
