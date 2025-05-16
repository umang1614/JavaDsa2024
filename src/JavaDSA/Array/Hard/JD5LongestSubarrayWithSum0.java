package JavaDSA.Array.Hard;

import java.util.*;

public class JD5LongestSubarrayWithSum0 {
    public static int findSubarray(int[] nums){
        int sum = 0, maxi = Integer.MIN_VALUE;
        Map<Integer, Integer> hash = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            sum += nums[i];
            if(sum == 0){
                int temp = i+1;
                maxi = Math.max(maxi, temp);
            }
            else{
                if(hash.containsKey(sum)){
                    int temp = i - hash.get(sum);
                    maxi = Math.max(temp, maxi);
                }
                else{
                    hash.put(sum, i);
                }
            }
        }
        return maxi;
    }
    public static void main(String[] args) {
        int[] nums = {1,-1,3,2,-2,-8,1,7,10,23};
        int ans = findSubarray(nums);
        System.out.println(ans);
    }
}
