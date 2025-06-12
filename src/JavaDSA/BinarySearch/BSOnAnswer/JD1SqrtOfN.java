package JavaDSA.BinarySearch.BSOnAnswer;

public class JD1SqrtOfN {
    public static int findSqrt(int n){
        int low = 1, high = n, ans =1;
        while(low <= high){
            int mid = (low + high)/2;
            if((long)mid * mid <= n){
                ans = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int n = 200;
        System.out.println(findSqrt(n));
    }
}
