package JavaDSA.Array.Easy;

public class JD6RotateByDPlace {
    public static void leftRotateBrute(int[] arr, int d){
        int n = arr.length;
        d = d % n;
        int temp[] = new int[d];
        for(int i =0; i<d; i++){
            temp[i] = arr[i];
        }
        for(int i = d; i<n; i++){
            arr[i-d] = arr[i];
        }
        for(int i = n-d; i<n; i++){
            arr[i] = temp[i-(n-d)];
        }
    }
    public static void reverse(int[] arr, int start, int end){
        while(start <= end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public static void RightRotateBest(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        reverse(nums, 0, n-1-k);
        reverse(nums, n-k, n-1);
        reverse(nums, 0, n-1);
    }
    public static void LeftRotateBest(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
        reverse(nums, 0, n-1);
    }
    public static void print(int[] nums){
        for(int i=0; i< nums.length; i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        print(arr);
//        leftRotateBrute(arr, 7);
//        RightRotateBest(arr, 3);
        LeftRotateBest(arr, 3);
        print(arr);
    }
}
