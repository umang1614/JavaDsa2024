package JavaDSA.Array.Medium;

import java.util.HashMap;
import java.util.Map;

public class JD3MajorityElement {
    public static Integer findMajorityBetter(int[] nums){
        int n = nums.length;
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            int value = mp.getOrDefault(nums[i], 0);
            mp.put(nums[i], value+1);
        }
        for(Map.Entry<Integer, Integer> it : mp.entrySet()){
            if(it.getValue() > n/2){
                return it.getKey();
            }
        }
        return -1;
    }
    public static Integer findMajorityOptimal(int[] nums){
        int el = 0, ct = 0;
        for(int i = 0; i<nums.length; i++){
            if(ct == 0){
                el = nums[i];
                ct = 1;
            }
            else if(el == nums[i]){
                ct++;
            }
            else{
                ct--;
            }
        }
        int ct2 = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] == el) {
                ct2++;
            }
        }
        if(ct2 > nums.length/2){
            return el;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {3, 2, 3, 1, 1, 2, 2};
        int res = findMajorityOptimal(arr);
        System.out.println(res);
    }
}
