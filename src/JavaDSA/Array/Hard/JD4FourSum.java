package JavaDSA.Array.Hard;
import java.awt.image.AreaAveragingScaleFilter;
import java.net.Inet4Address;
import java.util.*;

public class JD4FourSum {
    public static List<List<Integer>> findQuadBrute(int[] nums, int target){
        Set<List<Integer>> st = new HashSet<>();
        int n = nums.length;
        for(int i = 0; i<n; i++){
            for(int j = i+1; j < n; j++){
                for(int k = j+1; k<n; k++){
                    for(int l = k+1; l<n; l++){
                        int sum = nums[i] + nums[j] + nums[k] + nums[l];
                        if(sum == target){
                            List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                            temp.sort(null);
                            st.add(temp);
                        }
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;
    }
    public static List<List<Integer>> findQuadBetter(int[] nums, int target){
        Set<List<Integer>> st = new HashSet<>();
        int n = nums.length;
        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n; j++){
                Set<Integer> hash = new HashSet<>();
                for(int k = j+1; k<n; k++){
                    int sum = nums[i]+nums[j];
                    sum += nums[k];
                    int fourth = target - sum;
                    if(hash.contains(fourth)){
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], fourth);
                        temp.sort(null);
                        st.add(temp);
                    }
                    hash.add(nums[k]);
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;
    }
    public static List<List<Integer>> findQuadOptimal(int[] nums, int target){
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i<n; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j<n; j++){
                if(j != i+1 && nums[j] == nums[j-1]) continue;
                int k = j+1;
                int l = n-1;
                while(k<l){
                    long sum = nums[i] + nums[j];
                    sum += nums[k];
                    sum += nums[l];
                    if(sum == target){
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                        ans.add(temp);
                        k++;
                        l--;
                        while(k<l && nums[k] == nums[k-1]) k++;
                        while(k<l && nums[l] == nums[l+1]) l--;
                    }
                    else if(sum > target){
                        l--;
                    }
                    else{
                        k++;
                    }
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {4, 3, 3, 4, 4, 2, 1, 2, 1, 1};
        int target = 9;
        List<List<Integer>> ans = findQuadOptimal(nums, target);
        System.out.println("The quadruplets are: ");
        for (List<Integer> it : ans) {
            System.out.print("[");
            for (int ele : it) {
                System.out.print(ele + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
    }
}
