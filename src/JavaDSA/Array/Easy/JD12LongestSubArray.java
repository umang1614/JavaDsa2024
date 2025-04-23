package JavaDSA.Array.Easy;
import java.util.*;

public class JD12LongestSubArray {

    public static int getLongestSubArrayBrute(int[] nums, long sum){
        int len = 0;
        for(int i = 0; i<nums.length; i++){
            long s = 0;
            for(int j = i; j<nums.length; j++){
                s += nums[j];
                if(s == sum){
                    len = Math.max(len,j-i+1);
                }
            }
        }
        return len;
    }

    public static int getLongestSubArrayBetter(int[] nums, long k){
        int n = nums.length;
        long sum = 0;
        int maxLen = 0;
        Map<Long, Integer> preMap = new HashMap<>();
        for(int i = 0; i<n; i++){
            sum += nums[i];
            if(sum == k){
                maxLen = Math.max(maxLen, i+1);
            }
            long rem = sum - k;
            if(preMap.containsKey(rem)){
                int len = i - preMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }
            if(!preMap.containsKey(sum)){
                preMap.put(sum,i);
            }
        }
        return maxLen;
    }

    public static int getLongestSubArrayOptimal(int[] nums, long k){
        int left = 0, right = 0;
        long sum = nums[0];
        int maxLen = 0;
        int n = nums.length;
        while(right < n){
            while(left <= right && sum > k){
                sum -= nums[left];
                left++;
            }
            if(sum == k){
                maxLen = Math.max(maxLen, right-left+1);
            }
            right++;
            if(right < n) {
                sum += nums[right];
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int[] a = {1,2,4,1,1,1,1,3,3};
        long k = 6;
        int len = getLongestSubArrayOptimal(a, k);
        System.out.println("The length of the longest subarray is: " + len);
    }
}
