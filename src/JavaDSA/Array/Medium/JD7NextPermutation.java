package JavaDSA.Array.Medium;

public class JD7NextPermutation {
    public static void reverse(int nums[], int start, int end){
        while(start <= end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
        return;
    }
    public static void nextPermutation(int[] nums){
        int ind = -1;
        int n = nums.length;
        for(int i = n-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                ind = i;
                break;
            }
        }
        if(ind == -1){
            reverse(nums, 0, n-1);
            return;
        }
        for(int i = n-1; i>ind; i--){
            if(nums[i] > nums[ind]){
                int temp = nums[i];
                nums[i] = nums[ind];
                nums[ind] = temp;
                break;
            }
        }
        reverse(nums, ind+1, n-1);
        return;
    }
    public static void print(int[] nums){
        for(int i=0; i< nums.length; i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 4, 3, 0, 0};
        print(nums);
        nextPermutation(nums);
        print(nums);
    }
}
