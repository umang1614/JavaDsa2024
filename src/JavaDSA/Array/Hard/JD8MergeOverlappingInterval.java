package JavaDSA.Array.Hard;
import java.util.*;
public class JD8MergeOverlappingInterval {
    public static List<List<Integer>> findIntervalBrute(int[][] nums){
        int n = nums.length;
        Arrays.sort(nums,(a,b)->a[0]-b[0]);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i<n; i++){
            int start = nums[i][0];
            int end = nums[i][1];
            if(!ans.isEmpty() && end <= ans.get(ans.size()-1).get(1)){
                continue;
            }
            for(int j = i+1; j<n; j++){
                if(nums[j][0] <= end){
                    end = Math.max(end, nums[j][1]);
                }
                else{
                    break;
                }
            }
            ans.add(Arrays.asList(start, end));
        }
        return ans;
    }
    public static List<List<Integer>> findIntervalOptimal(int[][] nums){
        int n = nums.length;
        Arrays.sort(nums,(a,b)->a[0]-b[0]);
//        Arrays.sort(nums, Comparator.comparingInt(value -> value[0]));
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i<n; i++){
           if(ans.isEmpty() || nums[i][0] > ans.get(ans.size()-1).get(1)){
               ans.add(Arrays.asList(nums[i][0], nums[i][1]));
           }
           else{
               ans.get(ans.size()-1).set(1, Math.max(ans.get(ans.size()-1).get(1), nums[i][1]));
           }
        }
        return ans;
    }
    public int[][] merge(int[][] nums) {
        int n = nums.length;
        Arrays.sort(nums,(a,b)->a[0]-b[0]);
        List<int[]> ans = new ArrayList<>();

        for(int i = 0; i<n; i++){
            if(ans.isEmpty() || nums[i][0] > ans.get(ans.size()-1)[1]){
                ans.add(nums[i]);
            }
            else{
                int[] temp = ans.get(ans.size()-1);
                ans.remove(ans.size()-1);
                ans.add(new int[]{temp[0],Math.max(temp[1], nums[i][1])});
            }
        }
        int[][] res = new int[ans.size()][2];
        for(int i = 0; i<ans.size(); i++){
            res[i] = ans.get(i);
        }
        return res;
    }
    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        List<List<Integer>> ans = findIntervalOptimal(arr);
        System.out.print("The merged intervals are: \n");
        for (List<Integer> it : ans) {
            System.out.print("[" + it.get(0) + ", " + it.get(1) + "] ");
        }
        System.out.println();
    }
}
