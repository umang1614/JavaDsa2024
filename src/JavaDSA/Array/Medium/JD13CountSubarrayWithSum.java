package JavaDSA.Array.Medium;

import java.util.HashMap;
import java.util.Map;

public class JD13CountSubarrayWithSum {
    public static int countSubArray(int[] nums, int k){
        int prefSum = 0;
        int subarrayCnt = 0;
        Map<Integer, Integer> mpp = new HashMap();
        mpp.put(0,1);
        for(int i = 0; i<nums.length; i++){
            prefSum += nums[i];
            int rem = prefSum - k;
            subarrayCnt += mpp.getOrDefault(rem, 0);
            mpp.put(prefSum, mpp.getOrDefault(prefSum, 0)+1);
        }
        return subarrayCnt;
    }

    public static void main(String[] args) {
        int nums[] = {1,2,3,-3,1,1,1,4,2,-3};
        int res = countSubArray(nums, 3);
        System.out.println(res);
    }
}
