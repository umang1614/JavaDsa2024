package JavaDSA.BinarySearch.BSOnAnswer;

public class JD6LeastCapacityToShipInDDays {
    public static boolean dayReq(int[] weights, int mid, int cap){
        int totalDay = 1, load = 0;
        for(int i = 0; i<weights.length; i++){
            if(load + weights[i] > mid){
                totalDay += 1;
                load = weights[i];
            }
            else {
                load += weights[i];
            }
        }
        if(totalDay <= cap) return true;
        return false;
    }
    public static int findCapacity(int[] weights, int cap){
        int maxi = Integer.MIN_VALUE, sum = 0;
        for(int i = 0; i<weights.length; i++){
            maxi = Math.max(maxi, weights[i]);
            sum += weights[i];
        }
        int low = maxi, high = sum, ans = -1;
        while(low <= high){
            int mid = (low + high)/2;
            if(dayReq(weights, mid, cap)){
                ans = mid;
                high = mid -1;
            }
            else{
                low = mid +1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(findCapacity(weights, 5));
    }
}
