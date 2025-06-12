package JavaDSA.BinarySearch.BSOnAnswer;

public class JD3KokoEatingBanana {
    public static int maxPile(int[] nums){
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length; i++){
            ans = Math.max(ans, nums[i]);
        }
        return ans;
    }
    public static int calTime(int[] nums, int mid){
        int totalTime = 0;
        for(int i =0; i<nums.length; i++){
            totalTime += Math.ceil((double) nums[i]/(double) mid);
        }
        return totalTime;
    }
    public static int findMinK(int[] piles, int h){
        int low = 1, high = maxPile(piles);
        int ans = 0;
        while(low <= high){
            int mid = (low+high)/2;
            int totalHour = calTime(piles, mid);
            if(totalHour <= h){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        System.out.println(findMinK(piles, 8));
    }
}
