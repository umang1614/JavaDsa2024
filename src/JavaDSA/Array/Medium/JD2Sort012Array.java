package JavaDSA.Array.Medium;

public class JD2Sort012Array {
    public static void sortArrayBetter(int[] nums){
        int c0 = 0, c1 = 0, c2 = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] == 0){
                c0++;
            }else if(nums[i] == 1){
                c1++;
            }
            else{
                c2++;
            }
        }
        for(int i = 0; i<c0; i++){
            nums[i] = 0;
        }
        for(int i = c0; i<c0+c1; i++){
            nums[i] = 1;
        }
        for(int i = c0+c1; i<c0+c1+c2; i++){
            nums[i] = 2;
        }
    }
    public static void sortArrayOptimal(int[] nums){
        int low = 0, mid = 0, high = nums.length-1;
        while (mid <= high){
            if(nums[mid] == 0){
                int temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;
                low++;
                mid++;
            }
            else if(nums[mid] == 1){
                mid++;
            }
            else{
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
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
        int[] nums = {0, 2, 1, 2, 0, 1};
        print(nums);
        sortArrayBetter(nums);
        print(nums);
    }
}
