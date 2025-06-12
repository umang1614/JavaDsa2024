package JavaDSA.Array;

import javax.swing.*;
import java.util.HashMap;
import java.util.*;

public class Revision {
    public static void rotateByOnePlace(int[] nums){
        int temp = nums[0];
        int n = nums.length;
        for(int i = 1; i<n; i++){
            nums[i-1] = nums[i];
        }
        nums[n-1] = temp;
    }
    public static void rotateByKPlaces(int[] nums, int k){
        int[] temp = new int[k];
        int n = nums.length;
        for(int i = 0; i<k; i++){
            temp[i] = nums[i];
        }
        for(int i = k; i<n; i++){
            nums[i-k] = nums[i];
        }
        for(int i = n-k; i<n; i++){
            nums[i] = temp[i-(n-k)];
        }
    }
    public static void reverse(int[] arr, int start, int end){
        while(start <= end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public static void rotateByKPlacesOptimal(int[] nums, int k){
        int n = nums.length;
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
        reverse(nums, 0, n-1);
    }
    public static void moveZeroes(int[] nums){
        int j = -1;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] == 0){
                j = i;
                break;
            }
        }
        if(j == -1) return;
        for(int i = j+1; i< nums.length; i++){
            if(nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }
    public static int findNumber(int[] nums, int n){
        int xor1 = 0, xor2 = 0;
        for(int i  = 0; i<n-1; i++){
            xor2 = xor2 ^ nums[i];
            xor1 = xor1 ^ (i+1);
        }
        xor1 = xor1 ^ n;
        int last = xor1 ^ xor2;
        return last;
    }
    public static int longestSubArray1(int[] nums, int k){
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();
        int sum = 0, maxLen = 0;
        for(int i = 0; i<n; i++){
            sum += nums[i];
            if(sum == k){
                maxLen = Math.max(maxLen, i+1);
            }
            int rem = sum - k;
            if(mp.containsKey(rem)){
                int len = i - mp.get(rem);
                maxLen = Math.max(len, maxLen);
            }
            if(!mp.containsKey(sum)){
                mp.put(sum, i);
            }
        }
        return maxLen;
    }
    public static int longestSubArray2(int[] nums, int k){
        int left = 0, right = 0, sum = nums[0];
        int maxLen = 0;
        int n = nums.length;
        while(right < n){
            while(left <= right && sum > k){
                sum -= nums[left];
                left++;
            }
            if(sum == k){
                maxLen = Math.max(maxLen, right-left+1);
            }
            right++;
            if(right < n){
                sum += nums[right];
            }
        }
        return maxLen;
    }
    public static int[] twoSum(int[] nums, int k){
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i<n; i++){
            int rem = k - nums[i];
            if(mp.containsKey(rem)){
                return new int[]{i, mp.get(rem)};
            }
            mp.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
    public static void sortZOT(int[] nums){
        int n = nums.length;
        int low = 0, mid = 0, high = n-1;
        while(mid <= high){
            if(nums[mid] == 0){
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            }
            else if(nums[mid] == 1){
                mid++;
            }
            else{
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
    public static int majorityElement1(int[] nums){
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            mp.put(nums[i], mp.getOrDefault(nums[i], 0)+1);
            if(mp.getOrDefault(nums[i], 0) > nums.length/2){
                return nums[i];
            }
        }
        return -1;
    }
    public static int majorityElement2(int[] nums){
        int el = 0, count = 0;
        for(int i = 0; i<nums.length; i++){
            if(count == 0){
                el = nums[i];
                count++;
            }
            else if(el == nums[i]){
                count++;
            }
            else{
                count--;
            }
        }
        return el;
    }
    public static int maxSubarraySum(int[] nums){
        int maxSum = Integer.MIN_VALUE;
        int sum = 0, start = -1, startAns = -1, endAns = -1;
        for(int i = 0; i<nums.length; i++){
            if(sum == 0){
                start = i;
            }
            sum += nums[i];
            if(sum > maxSum){
                maxSum = sum;
                startAns = start;
                endAns = i;
            }
            if(sum < 0){
                sum = 0;
            }
        }
        return maxSum;
    }
    public static int buySellStock(int[] nums){
        int minPrice = nums[0], maxPro = 0;
        for(int i = 0; i<nums.length; i++){
            int cost = nums[i] - minPrice;
            maxPro = Math.max(cost, maxPro);
            minPrice = Math.min(nums[i], minPrice);
        }
        return maxPro;
    }
    public static int[] rearrangeElement(int[] nums){
        int n = nums.length;
        int[] ans = new int[n];
        int pos = 0, neg = 1;
        for(int i = 0; i<n; i++){
            if(nums[i] >= 0){
                ans[pos] = nums[i];
                pos+=2;
            }
            else{
                ans[neg] = nums[i];
                neg+=2;
            }
        }
        return ans;
    }
    public static int[] rearrangeElement2(int[] nums){
        int n = nums.length;
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        for(int i = 0; i<n; i++){
            if(nums[i] >= 0){
                pos.add(nums[i]);
            }
            else{
                neg.add(nums[i]);
            }
        }
        if(pos.size() > neg.size()){
            int ind = 2*neg.size();
            for(int i = 0; i<neg.size(); i++){
                nums[i*2] = pos.get(i);
                nums[i*2+1] = neg.get(i);
            }
            for(int i = neg.size(); i<pos.size(); i++){
                nums[ind++] = pos.get(i);
            }
        }
        if(pos.size() < neg.size()){
            int ind = 2*pos.size();
            for(int i = 0; i<pos.size(); i++){
               nums[2*i] = pos.get(i);
               nums[2*i+1] = neg.size();
            }
            for(int i = pos.size(); i<neg.size(); i++){
                nums[ind++] = neg.get(i);
            }
        }
        return nums;
    }
    public static void nextPermutation(int[] nums){
        int ind = -1;
        int n = nums.length;
        for(int i = n-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                ind = i;
                break;
            }
        }
        if(ind == -1){
            reverse(nums, 0, n-1);
        }
        for(int i = n-1; i>ind; i--){
            if(nums[i] > nums[ind]){
                int temp = nums[i];
                nums[i] = nums[ind];
                nums[ind] = temp;
                break;
            }
        }
        reverse(nums, ind+1, n-1);
    }
    public static ArrayList<Integer> findLeaders(int[] nums){
        int maxi = Integer.MIN_VALUE;
        ArrayList<Integer> res = new ArrayList<>();
        int n = nums.length;
        for(int i = n-1; i>=0; i--){
            if(nums[i] > maxi){
                res.add(nums[i]);
                maxi = nums[i];
            }
        }
        return res;
    }
    public static boolean ls(int[] nums, int target){
       for(int i = 0; i<nums.length; i++){
           if(nums[i] == target){
               return true;
           }
       }
       return false;
    }
    public static int consSequence(int[] nums){
        int maxi = Integer.MIN_VALUE;
        int count = 0;
        for(int i = 0; i<nums.length; i++){
            int x = nums[i];
             count = 1;
            while(ls(nums, x+1) == true){
                x = x+1;
                count++;
            }
            maxi = Math.max(maxi, count);
        }
        return maxi;
    }
    public static int consSequence2(int[] nums){
        int count = 0, last_Small = Integer.MIN_VALUE, res = 0;
        Arrays.sort(nums);
        for(int i = 0; i<nums.length; i++){
            if(nums[i]-1 == last_Small){
                last_Small = nums[i];
                count++;
            }
            else{
                last_Small = nums[i];
                count = 1;
            }
            res = Math.max(res, count);
        }
        return res;
    }
    public static int consSequence3(int[] nums){
        Set<Integer> st = new HashSet<>();
        int count = 0, maxi = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length; i++){
            st.add(nums[i]);
        }
        for(int i = 0; i<nums.length; i++){
            int x = nums[i];

            if(st.contains(nums[i]-1)){
                continue;
            }
            else{
                count = 1;
                while(st.contains(x+1)){
                    x = x+1;
                    count++;
                }
                maxi = Math.max(maxi, count);
            }
        }
        return maxi;
    }
    public static void setRow(int[][] matrix, int row){
        int size = matrix[0].length;
        for(int j = 0; j<size; j++){
            if(matrix[row][j] != 0){
                matrix[row][j] = -1;
            }
        }
    }
    public static void setCol(int[][] matrix, int col){
        int size = matrix.length;
        for(int i = 0; i<size; i++){
            if(matrix[i][col] != 0){
                matrix[i][col] = -1;
            }
        }
    }
    public static void setMatrixZero(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(matrix[i][j] == 0){
                    setRow(matrix, i);
                    setCol(matrix, j);
                }
            }
        }
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(matrix[i][j] == -1){
                    matrix[i][j] = 0;
                }
            }
        }
    }
    public static void matrixPrint(ArrayList<ArrayList<Integer>> matrix){
        for (ArrayList<Integer> row : matrix) {
            for (Integer ele : row) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
    public static void setMatrixZero2(ArrayList<ArrayList<Integer>> matrix){
        int n = matrix.size(), m = matrix.get(0).size();
      int[] row = new int[n];
      int[] col = new int[m];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m ;j++){
                if(matrix.get(i).get(j) == 0){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(row[i] == 1 || col[j] == 1){
                    matrix.get(i).set(j, 0);
                }
            }
        }
    }
    public static void setMatrixZero3(ArrayList<ArrayList<Integer>> matrix){
        int n = matrix.size();
        int m = matrix.get(0).size();
        int col0 = 1;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(matrix.get(i).get(j) == 0){
                    matrix.get(i).set(0, 0);
                    if(j != 0){
                        matrix.get(0).set(j, 0);
                    }
                    else{
                        col0 = 0;
                    }
                }
            }
        }
        for(int i = 1; i<n; i++){
            for(int j = 1; j<m; j++){
                if(matrix.get(i).get(0) == 0 || matrix.get(0).get(j) == 0){
                    matrix.get(i).set(j, 0);
                }
            }
        }
        if(matrix.get(0).get(0) == 0){
            for(int j = 0; j<m; j++) {
                matrix.get(0).set(j, 0);
            }
        }
        if(col0 == 0){
            for(int i = 0; i<n; i++){
                matrix.get(i).set(0, 0);
            }
        }
    }
    public static void rotateMatrix(ArrayList<ArrayList<Integer>> matrix){
        int n = matrix.size(), m = matrix.get(0).size();
        int[][] ans = new int[n][m];
        for(int i =0; i<n; i++){
            for(int j = 0; j<m; j++){
                ans[j][n-i-1] = matrix.get(i).get(j);
            }
        }

    }
    public static void rotateMatrix2(int[][] matrix){
        int n = matrix.length, m = matrix[0].length;
        for(int i = 0; i<n-1; i++){
            for(int j = i+1; j<n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i = 0; i<n; i++){
            int start = 0, end = n-1;
            while(start <= end){
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
                start++;
                end--;
            }
        }
    }
    public static ArrayList<Integer> spiralMatrix(int[][] matrix){
        int n = matrix.length, m = matrix[0].length;
        ArrayList<Integer> ans = new ArrayList<>();
        int left = 0, right = n-1, top = 0, bottom = n-1;
        while(left <= right && top <= bottom){
            for(int i = left; i<= right; i++){
                ans.add(matrix[top][i]);
            }
            top++;
            for(int i = top; i<=bottom; i++){
                ans.add(matrix[i][right]);
            }
            right--;
            if(top<=bottom){
                for(int i = right; i >=left; i--){
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(left<=right){
                for(int i = bottom; i>=top; i--){
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }
        return ans;
    }
    public static int subArraySum(int[] nums, int target){
        int count = 0;
        int prefSum = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for(int i = 0; i<nums.length; i++){
            prefSum += nums[i];
            int rem = prefSum - target;
            count += mp.getOrDefault(rem, 0);
            mp.put(prefSum, mp.getOrDefault(prefSum, 0)+1);
        }
        return count;
    }
    public static ArrayList<ArrayList<Integer>> pascalTriangle(int n){
        ArrayList<ArrayList<Integer>> pascal = new ArrayList<>();
        for(int i = 1; i<=n; i++){
            ArrayList<Integer> row = new ArrayList<>();
            int el = 1;
            row.add(el);
            for(int col = 1; col<i; col++){
                el = el * (i-col);
                el = el/col;
                row.add(el);
            }
            pascal.add(row);
        }
        return pascal;
    }
    public static List<Integer> majorityElementN3(int[] nums){
        List<Integer> ans = new ArrayList<>();
        int el1 = Integer.MIN_VALUE, el2 = Integer.MIN_VALUE, cnt1 = 0, cnt2 = 0;
        int min = (nums.length/3)+1;
        for(int i = 0; i<nums.length; i++){
            if(cnt1 == 0 && nums[i] != el2){
                cnt1 = 1;
                el1 = nums[i];
            }
            else if(cnt2 == 0 && nums[i] != el1) {
                cnt2 = 1;
                el2 = nums[i];
            }
            else if (nums[i] == el1) {
                cnt1++;
            }
            else if(nums[i] == el2){
                cnt2++;
            }
            else{
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = 0;
        cnt2 = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] == el1) cnt1++;
            else if (nums[i] == el2) cnt2++;
        }
        if(cnt1 >= min) ans.add(el1);
        if(cnt2 >= min) ans.add(el2);
        return ans;
    }
    public static List<List<Integer>> threeSum1(int[] nums){
        Set<List<Integer>> st = new HashSet<>();
        for(int i = 0; i<nums.length; i++){
            Set<Integer> hash = new HashSet<>();
            for(int j = i+1; j<nums.length; j++){
                int rem = -(nums[i] + nums[j]);
                if(hash.contains(rem)){
                    List<Integer> temp = new ArrayList<>(Arrays.asList(nums[i], nums[j], rem));
                    temp.sort(null);
                    st.add(temp);
                }
                hash.add(nums[j]);
            }
        }
        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;
    }
    public static List<List<Integer>> threeSum2(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i<n; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int j = i+1;
            int k = n-1;
            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum > 0){
                    k--;
                }
                else if(sum < 0){
                    j++;
                }
                else{
                    List<Integer> temp = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k]));
                    ans.add(temp);
                    j++;
                    k--;
                    while(j<k && nums[j] == nums[j-1]) j++;
                    while(j<k && nums[k] == nums[k+1]) k--;
                }
            }
        }
        return ans;
    }
    public static List<List<Integer>> fourSum(int[] nums, int target){
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i<n ;i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j<n; j++){
                if(j>1 && nums[j] == nums[j-1]) continue;
                int k = j+1;
                int l = n-1;
                while(k<l){
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if(sum > target){
                        l--;
                    }
                    else if(sum < target){
                        k++;
                    }
                    else{
                        List<Integer> temp = new ArrayList<>(Arrays.asList(nums[i], nums[j] , nums[k] , nums[l]));
                        ans.add(temp);
                        k++;
                        l--;
                        while(k<l && nums[k] == nums[k-1]) k++;
                        while(k<l && nums[l] == nums[l+1]) l--;
                    }
                }
            }
        }
        return ans;
    }
    public static int longestSubarraySum(int[] nums){
        Map<Integer, Integer> mp = new HashMap<>();
        int sum = 0;
        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length; i++){
            sum += nums[i];
            if(sum == 0){
                maxi = Math.max(maxi, i+1);
            }
            else{
                if(mp.containsKey(sum)){
                    int len = i - mp.get(sum);
                    maxi = Math.max(maxi, len);
                }
                else{
                    mp.put(sum, i);
                }
            }
        }
        return maxi;
    }
    public static int subArrayXOR(int[] nums, int k){
        int xor = 0, cnt = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0,1);
        for(int i = 0; i<nums.length; i++){
            xor = xor^nums[i];
            int x = xor^k;
            cnt += mp.getOrDefault(x, 0);
            mp.put(xor, mp.getOrDefault(xor, 0)+1);
        }
        return cnt;
    }
    public static List<List<Integer>> mergeOverlapping(int[][] nums){
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums, (int[]a, int[]b)->a[0]-b[0]);
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
            List<Integer> temp = new ArrayList<>(Arrays.asList(start, end));
            ans.add(temp);
        }
        return ans;
    }
    public static int[][] mergeOverlapping2(int[][] nums){
        int n = nums.length;
        Arrays.sort(nums, (int[]a, int[]b) -> a[0]-b[0]);
        List<int[]> ans= new ArrayList<>();
        for(int i = 0; i<n; i++){
            int start = nums[i][0];
            int end = nums[i][1];
            if(ans.isEmpty() || start > ans.get(ans.size()-1)[1]){
                int[] temp = {start, end};
                ans.add(temp);
            }
            else{
                int[] temp = ans.get(ans.size()-1);
                ans.remove(ans.size()-1);
                ans.add(new int[]{temp[0], Math.max(temp[1], end)});
            }
        }
        int[][]res = new int[ans.size()][2];
        for(int i = 0; i<ans.size(); i++){
            res[i] = ans.get(i);
        }
        return res;
    }
    public static void swapIfGreater(int[]a, int[]b, int left, int right){
        if(a[left] > b[right]){
            int temp = a[left];
            a[left] = b[right];
            b[right] = temp;
        }
    }
    public static void merge2SortedGap(int[] a, int[] b){
        int n = a.length, m = b.length;
        int len = n+m;
        int gap = (len/2) + (len%2);
        while(len > 0){
            int left = 0, right = left + gap;
            while(right < len){
                if(left < n && right>=n){
                    swapIfGreater(a, b, left, right-n);
                }
                else if(left>=n){
                    swapIfGreater(b,b,left-n, right-n);
                }
                else{
                    swapIfGreater(a,a,left, right);
                }
                left++;
                right++;
            }
            if(gap == 1) break;
            gap = (gap/2) + (gap%2);
        }
    }
    public static void merge2Sorted2(int[] a, int[] b){
        int n = a.length, m = b.length;
        int left = n-1, right = 0;
        while(left >=0 && right < m){
            if(a[left] > b[right]){
                int temp = a[left];
                a[left] = b[right];
                b[right] = temp;
                left--;
                right++;
            }
            else{
                break;
            }
        }
        Arrays.sort(a);
        Arrays.sort(b);
    }
    public static int[] findMissingrepeating(int[] nums){
        int n = nums.length;
        int SN = (n*(n+1))/2;
        int S2N = (n*(n+1)*(2*n+1))/6;
        int numSN = 0, numS2N = 0;
        for(int i = 0; i<n; i++){
            numSN += nums[i];
            numS2N += nums[i] * nums[i];
        }
        int val1 = numSN - SN;
        System.out.println("val1"+val1);
        int val2 = numS2N - S2N;
        val2 = val2/val1;
        System.out.println("val2"+val2);
        int x = (val1+val2)/2;
        System.out.println("X"+x);
        int y = val2-x;
        System.out.println("y"+y);
        int[] res = {x,y};
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {4,3,2,1,1};
        int[]res = findMissingrepeating(arr);
        for (int i = 0; i < 2; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
