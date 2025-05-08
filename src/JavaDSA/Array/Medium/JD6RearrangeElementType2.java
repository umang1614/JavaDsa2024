package JavaDSA.Array.Medium;

import java.util.ArrayList;

public class JD6RearrangeElementType2 {
    //Variety 2 questions where pos != neg

    public static void rearrangeElement(int[] nums){
        int length = nums.length;
        int ind = 0;
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        for(int i = 0; i<length; i++){
            if(nums[i] < 0){
                neg.add(nums[i]);
            }
            else{
                pos.add(nums[i]);
            }
        }

        if(pos.size() > neg.size()){
            ind = 2 * neg.size();
            for(int i = 0; i<neg.size(); i++){
                nums[2*i] = pos.get(i);
                nums[2*i + 1] = neg.get(i);
            }
            for(int i = neg.size(); i<pos.size(); i++){
                nums[ind++] = pos.get(i);
            }
        }
        else{
            ind = 2 * pos.size();
            for(int i = 0; i<pos.size(); i++){
                nums[2*i] = pos.get(i);
                nums[2*i + 1] = neg.get(i);
            }
            for(int i = pos.size(); i<neg.size(); i++){
                nums[ind++] = neg.get(i);
            }
        }
    }
    public static void print(int[] nums){
        for(int i=0; i< nums.length; i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] A = {1, 2, -4, -5, 3, 4};
        print(A);
        rearrangeElement(A);
        print(A);
    }
}
