package JavaDSA.Array.Hard;

import java.util.*;

public class JD3ThreeSum {
    public static List<List<Integer>> findTripletBrute(int[] nums){
        Set<List<Integer>> st = new HashSet<>();
        int n = nums.length;
        for(int i = 0; i<n; i++){
            for(int j = i +1; j<n; j++){
                for(int k = j+1; k<n; k++){
                    if(nums[i]+nums[j]+nums[k] == 0){
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                        temp.sort(null);
                        st.add(temp);
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;
    }
    public static List<List<Integer>> findTripletBetter(int[] nums){
        Set<List<Integer>> st = new HashSet<>();
        int n = nums.length;;
        for(int i = 0; i<n; i++){
            Set<Integer> hash = new HashSet<>();
            for(int j = i+1; j<n; j++){
                int k = -(nums[i] + nums[j]);
                if(hash.contains(k)){
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], k);
                    temp.sort(null);
                    st.add(temp);
                }
                hash.add(nums[j]);
            }
        }
        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;
    }
    public static List<List<Integer>> findTripletOptimal(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i<n; i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            int j = i + 1;
            int k = n-1;
            while(j < k){
                int sum = nums[i] +  nums[j] + nums[k];
                if(sum > 0){
                    k--;
                }
                else if(sum < 0){
                    j++;
                }
                else{
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                    ans.add(temp);
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j-1]) j++;
                    while(j < k && nums[k] == nums[k+1]) k--;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = { -1, 0, 1, 2, -1, -4};
        int n = arr.length;
        List<List<Integer>> ans = findTripletOptimal(arr);
        for (List<Integer> it : ans) {
            System.out.print("[");
            for (Integer i : it) {
                System.out.print(i + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
    }
}
