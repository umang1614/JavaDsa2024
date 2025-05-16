package JavaDSA.Array.Hard;

import java.util.*;
import java.util.List;
//Majority Element which appears >n/3 times
public class JD2MajorityElement {
    public static List<Integer> findMajorityBrute(int[] nums){
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i< nums.length; i++){
            if(ans.size() == 0 || ans.get(0) != nums[i]){
                int cnt = 0;
                for(int j = 0; j< nums.length ; j++){
                    if(nums[j] == nums[i]){
                        cnt++;
                    }
                }
                if(cnt > nums.length/3){
                    ans.add(nums[i]);
                }
            }
            if(ans.size() == 2){
                return ans;
            }
        }
        return ans;
    }

    public static List<Integer> findMajorityBetter(int[] nums){
        Map<Integer, Integer> mpp = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        int min = (nums.length/3) + 1;
        for(int i = 0; i<nums.length; i++){
            mpp.put(nums[i], mpp.getOrDefault(nums[i], 0)+1);
            if(mpp.get(nums[i]) == min){
                ans.add(nums[i]);
            }
        }
        return ans;
    }

    public static List<Integer> findMajorityOptimal(int[] nums){
        List<Integer> ans = new ArrayList<>();
        int el1 = Integer.MIN_VALUE, el2 = Integer.MIN_VALUE, cnt1 = 0, cnt2 = 0;
        int mini = (nums.length/3);
        for(int i = 0; i< nums.length; i++){
            if(cnt1 == 0 && nums[i] != el2){
                cnt1 = 1;
                el1 = nums[i];
            }
            else if(cnt2 == 0 && nums[i] != el1){
                cnt2 =1;
                el2 = nums[i];
            }
            else if(nums[i] == el1){
                cnt1++;
            }
            else if(nums[i] == el2){
                cnt2++;
            }
            else {
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = 0;
        cnt2 =0;
        for (int i = 0; i<nums.length; i++){
            if(nums[i] == el1){
                cnt1++;
            }
            else if(nums[i] == el2){
                cnt2++;
            }
        }
        if(cnt1 > mini) ans.add(el1);
        if(cnt2 > mini) ans.add(el2);

        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1,3,3,1,3,2};
        List<Integer> ans = new ArrayList<>();
        ans = findMajorityOptimal(nums);
        for (int i : ans){
            System.out.println(i);
        }
    }
}
