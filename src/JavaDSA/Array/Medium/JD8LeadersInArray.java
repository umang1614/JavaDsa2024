package JavaDSA.Array.Medium;

import java.util.*;

public class JD8LeadersInArray {
    public static ArrayList<Integer> findLeaders(int[] nums){
        ArrayList<Integer> res = new ArrayList<>();
        int maxi = Integer.MIN_VALUE;
        for(int i = nums.length -1; i>=0; i--){
            if(nums[i] > maxi){
                res.add(nums[i]);
                maxi = nums[i];
            }
        }
        return res;
    }
    public static void print(ArrayList<Integer> nums){
        for(int i=0; i< nums.size(); i++){
            System.out.print(nums.get(i) + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[]=  {10, 22, 12, 3, 0, 6};
        ArrayList<Integer> nums = findLeaders(arr);
        print(nums);
    }
}
