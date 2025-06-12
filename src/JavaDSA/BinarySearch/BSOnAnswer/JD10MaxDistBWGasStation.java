package JavaDSA.BinarySearch.BSOnAnswer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class JD10MaxDistBWGasStation {
    public static class Pair{
        double first;
        int second;
        Pair(double first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public static double findDistBetter(int[] nums, int k){
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Double.compare(b.first, a.first));
        int n = nums.length;
        int[] section = new int[n-1];
        for(int i = 0; i<n-1; i++){
            pq.add(new Pair((nums[i+1]-nums[i]),i));
        }
        for(int i = 1; i<=k; i++){
            Pair top = pq.poll();
            int maxInd = top.second;
            section[maxInd]++;
            double diff = nums[maxInd+1]-nums[maxInd];
            double secLen = (diff/(double) (section[maxInd]+1));
            pq.add(new Pair(secLen, maxInd));
        }
       return pq.peek().first;
    }
    public static double findDistBrute(int[] nums, int k){
//        List<Integer> section = new ArrayList<>();
        int n = nums.length;
        int[] section = new int[n-1];
        for(int station = 1; station<=k; station++){
            double maxSecLen = -1;
            int maxInd = -1;
            for(int i = 0; i<n-1; i++){
                double diff = nums[i+1] - nums[i];
                double secLen = (diff/(double) (section[i]+1));
                if(maxSecLen < secLen){
                    maxSecLen = secLen;
                    maxInd = i;
                }
            }
            section[maxInd]++;
        }
        double ans = -1;
        for(int i = 0; i<n-1; i++){
            double diff = nums[i+1] - nums[i];
            double secLen = (diff/(double) (section[i]+1));
            ans = Math.max(ans, secLen);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,13,17,23};
        System.out.println(findDistBetter(nums, 5));
    }
}
