package JavaDSA.Array.Medium;

import java.util.ArrayList;

public class JD6RearrangeElementBySign {
    public static void rearrangeElementBrute(int[] nums){
        int length = nums.length;
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        for(int i = 0; i<length; i++){
            if(nums[i] >= 0){
                pos.add(nums[i]);
            }
            else{
                neg.add(nums[i]);
            }
        }
        for(int i = 0; i<length/2; i++){
            nums[2*i] = pos.get(i);
            nums[2*i+1] = neg.get(i);
        }
    }
    public static void print(int[] nums){
        for(int i=0; i< nums.length; i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
    public static int[] rearrangeElementOptimal(int[] nums) {
        int[] res = new int[nums.length];
        int pos = 0, neg = 1;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] < 0){
                res[neg] = nums[i];
                neg += 2;
            }
            else{
                res[pos] = nums[i];
                pos += 2;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int A[]= {1,2,-4,-5};
        int[] res = new int[A.length];
        print(A);
        res = rearrangeElementOptimal(A);
        print(res );
    }
}
