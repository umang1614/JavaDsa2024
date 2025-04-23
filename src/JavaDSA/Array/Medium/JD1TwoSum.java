package JavaDSA.Array.Medium;

import java.util.*;

public class JD1TwoSum {
    public static boolean twoSumBrute(int[] nums, int target){
        for(int i = 0; i<nums.length; i++){
            for(int j = i+1; j<nums.length; j++){
                if(nums[i]+nums[j] == target){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean twoSumBetter(int[] nums, int target){
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            int rem = target - nums[i];
            if(mp.containsKey(rem)){
                return true;
            }
            mp.put(nums[i], i);
        }
        return false;
    }

    public static boolean twoSumOptimal(int[] nums, int target){
        int left = 0, right = nums.length-1;
        while(left < right){
            int sum = nums[left] + nums[right];
            if(sum < target){
                left++;
            } else if (sum > target) {
                right--;
            }
            else {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {2,6,5,8,11};
        int[] num = new int[2];
        num[0] = 1;
        boolean res = twoSumOptimal(nums, 15);
        System.out.println(res);
    }
}
