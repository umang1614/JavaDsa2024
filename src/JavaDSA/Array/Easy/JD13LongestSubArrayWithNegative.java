package JavaDSA.Array.Easy;

import java.util.HashMap;
import java.util.Map;
public class JD13LongestSubArrayWithNegative {
    public static int getLongestSubArrayOptimal(int[] nums, long k){
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
    public static void main(String[] args) {

    }
}
