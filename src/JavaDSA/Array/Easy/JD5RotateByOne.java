package JavaDSA.Array.Easy;

public class JD5RotateByOne {
    public static void rotateArrayByOne(int[] nums) {
        int temp = nums[0];
        int n = nums.length;
        for(int i = 1; i<nums.length; i++){
            nums[i-1] = nums[i];
        }
        nums[n-1] = temp;
    }
    public static void print(int[] nums){
        for(int i=0; i< nums.length; i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        print(arr);
        rotateArrayByOne(arr);
        print(arr);
    }
}
