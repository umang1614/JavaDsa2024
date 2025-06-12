package JavaDSA.Array.Hard;

public class JD10FindMissingRepeatingNumber {
    public static int[] findNumber(int[] nums){
        int n = nums.length;
        long sn = (n*(n+1))/2;
        long s2n = (n*(n+1)*(2*n+1))/6;
        long s = 0, s2 = 0;
        for(int i  = 0; i<n; i++){
            s += (long)nums[i];
            s2 += (long)nums[i] * nums[i];
        }
        long val1 = s-sn; //x -y
        long val2 = s2-s2n;
        val2 = val2/val1; //x+y
        long x = ((val1+val2)/2);
        long y = x-val1;
        int[] ans = {(int)x,(int)y};
        return ans;
    }
    public static void main(String[] args) {
        int[] a = {3, 1, 2, 5, 4, 6, 7, 5};
        int[] ans = findNumber(a);
        System.out.println("The repeating and missing numbers are: {"
                + ans[0] + ", " + ans[1] + "}");
    }
}
