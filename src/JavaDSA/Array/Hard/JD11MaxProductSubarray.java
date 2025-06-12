package JavaDSA.Array.Hard;

public class JD11MaxProductSubarray {
    public static int maxProd(int[] nums){
        int pref = 1, suff= 1;
        int n = nums.length;
        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length; i++){
            if(pref == 0) pref = 1;
            if(suff == 0) pref = 1;
            pref *= nums[i];
            suff *= nums[n-i-1];
            maxi = Math.max(maxi, Math.max(pref, suff));
        }
        return maxi;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, -3, 0, -4, -5};
        int answer = maxProd(arr);
        System.out.println("The maximum product subarray is: " + answer);
    }
}
