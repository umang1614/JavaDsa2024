package JavaDSA.BinarySearch.BSOnAnswer;

import java.util.ArrayList;
import java.util.Arrays;

public class JD8AggressiveCows {
    private static boolean canPlace(int[] nums, int dist, int cows){
        int cntCow = 1, last = nums[0];
        for(int i = 0; i<nums.length; i++){
            if(nums[i] - last >= dist){
                cntCow++;
                last = nums[i];
            }
            if(cntCow >= cows){
                return true;
            }
        }
        return false;
    }
    public static int findDist(int[] nums, int cows){
        int n = nums.length;
        Arrays.sort(nums);
        int low = 1, high = nums[n-1] - nums[0], ans = -1;
        while(low <= high){
            int mid = (low + high)/2;
            if(canPlace(nums, mid, cows)){
                ans = mid;
                low = mid +1;
            }
            else{
                high = mid -1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {0,3,4,7,10,9};
        System.out.println(findDist(nums, 4));
    }
}
