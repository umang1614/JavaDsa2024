package JavaDSA.Array.Hard;

import java.util.*;

public class JD6CountNoOfSubarrayWithXORK {
    public static int countSubarray(int[] nums, int k){
        int xr = 0, cnt =0;
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0,1);
        for(int i = 0; i<nums.length; i++){
            xr = xr ^ nums[i];
            int x = xr ^ k;
            cnt += mp.getOrDefault(x,0);
            mp.put(xr, mp.getOrDefault(xr, 0)+1);
        }
        return cnt;
    }
    public static void main(String[] args) {
        int[] a = {4, 2, 2, 6, 4};
        int k = 6;
        int ans = countSubarray(a, k);
        System.out.println(ans);
    }
}
