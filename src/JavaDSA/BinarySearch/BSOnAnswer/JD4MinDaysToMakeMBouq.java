package JavaDSA.BinarySearch.BSOnAnswer;

public class JD4MinDaysToMakeMBouq {
    public static boolean possible(int[] bloom, int m, int k, int day){
        int cnt = 0, noOfBoq = 0;
        for(int i = 0; i< bloom.length; i++){
            if(bloom[i] <= day){
                cnt++;
            }
            else{
                noOfBoq += cnt/k;
                cnt = 0;
            }
        }
        noOfBoq += cnt/k;
        if (noOfBoq >= m){
            return true;
        }
        return false;
    }
    public static int findMinDays(int[] bloom, int m, int k){
        long val = (long) m * k;
        if(val > bloom.length) return -1;
        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        for(int i = 0; i<bloom.length; i++){
            mini = Math.min(mini, bloom[i]);
            maxi = Math.max(maxi, bloom[i]);
        }
        int low = mini, high = maxi;
        int ans = -1;
        while(low <= high){
            int mid = (low + high)/2;
            if(possible(bloom, m, k, mid)){
                ans = mid;
                high = mid -1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        int[] bloom = {7, 7, 7, 7, 13, 11, 12, 7};
        System.out.println(findMinDays(bloom, 2, 3));
    }
}
