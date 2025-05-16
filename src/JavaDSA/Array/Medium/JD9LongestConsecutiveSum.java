package JavaDSA.Array.Medium;

import java.util.*;

public class JD9LongestConsecutiveSum {
    public static boolean ls(int[] nums, int x){
        boolean res = false;
        for(int i = 0; i<nums.length;i++){
            if(nums[i] == x){
                return true;
            }
        }
        return res;
    }
    public static int countConsBrute(int[] nums){
        int cnt = 0, maxi = 0;
        for(int i = 0; i<nums.length; i++){
            int x = nums[i];
            cnt = 1;
            while(ls(nums, x+1) == true){
                x++;
                cnt++;
            }
            maxi = Math.max(maxi, cnt);
        }
        return maxi;
    }

    public static int countConsBetter(int[] nums){
        int ctr = 0, lastSmall = Integer.MIN_VALUE, maxi = 0;
        Arrays.sort(nums);
        for(int i = 0; i<nums.length; i++){
            if(lastSmall == nums[i]-1){
                ctr++;
                lastSmall = nums[i];
            }
            else if(nums[i] != lastSmall){
                ctr = 1;
                lastSmall = nums[i];
            }
            maxi = Math.max(maxi, ctr);
        }
        return maxi;
    }

    public static int countConsOptimal(int[] nums){
        int ctr = 0, maxi = 0;
        Set<Integer> st = new HashSet<>();
        for(int i = 0; i< nums.length; i++){
            st.add(nums[i]);
        }
        for(int it:st){
            if(!st.contains(it-1)){
                int x = it;
                ctr = 1;
                while(st.contains(x+1)){
                    x++;
                    ctr++;
                }
                maxi = Math.max(maxi, ctr);
            }
        }
        return maxi;
    }
    public static void main(String[] args) {
        int[] a = {100, 200, 1, 2, 3, 4};
        int x = countConsOptimal(a);
        System.out.println(x);
    }
}
