package JavaDSA.Array.Easy;

public class JD9FindMissingNumber {

    public static int findNumber(int[] nums){
        int res = 0;
        int sum = 0;
        int n = nums.length;
        int sumOfNumber = n*(n+1)/2;
        for(int i = 0; i<n; i++){
            sum+=nums[i];
        }
        res = sumOfNumber - sum;
        return res;
    }

    public static int findNumberXOR(int []a, int N) {

        int xor1 = 0, xor2 = 0;

        for (int i = 0; i < N -1; i++) {
            xor2 = xor2 ^ a[i]; // XOR of array elements
            xor1 = xor1 ^ (i + 1); //XOR up to [1...N-1]
        }
        xor1 = xor1 ^ N; //XOR up to [1...N]

        return (xor1 ^ xor2); // the missing number
    }

    public static void main(String[] args) {
        int[] nums = {5,2,1,4};
        int n = 5;
        int res = findNumberXOR(nums, n);
        System.out.println(res);
    }
}
