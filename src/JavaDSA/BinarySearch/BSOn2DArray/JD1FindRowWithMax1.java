package JavaDSA.BinarySearch.BSOn2DArray;
import java.util.*;
public class JD1FindRowWithMax1 {
    public static int upperBound(int[] nums, int x){
        int n = nums.length;
        int ans = n;
        int low = 0, high = n-1;
        while(low <= high){
            int mid = (low+high)/2;
            if(nums[mid] > x){
                ans = mid;
                high = mid -1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
    public static int findMax1(int[][] nums, int n, int m){
        int maxCnt = 0, ind = -1;
        for(int i = 0; i<n; i++){
            int cnt_One = m - upperBound(nums[i], 0);
            if(cnt_One > maxCnt){
                maxCnt = cnt_One;
                ind = i;
            }
        }
        return ind;
    }
    public static void main(String[] args) {
        int[][] nums = {{0, 0, 1},{1, 1, 1},{0, 0, 0}};
        int n = 3, m = 3;
        System.out.println("The row with the maximum number of 1's is: " +
                findMax1(nums, n, m));
    }
}
