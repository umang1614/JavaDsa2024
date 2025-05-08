package JavaDSA.Array.Medium;
import java.util.*;
public class JD5StockBuySell {
    public static int stockBuySell(int[] nums){
        int maxPro = 0, minPrice = nums[0];
        for(int i = 1; i<nums.length; i++){
            int cost = nums[i] - minPrice;
            maxPro = Math.max(cost, maxPro);
            minPrice = Math.min(minPrice, nums[i]);
        }
        return maxPro;
    }
    public static void main(String[] args) {

    }
}
