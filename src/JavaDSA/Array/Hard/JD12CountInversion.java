package JavaDSA.Array.Hard;

import java.awt.image.renderable.RenderableImage;
import java.util.*;

public class JD12CountInversion {
    public static int merge(int[] nums, int low, int high, int mid){
        int cnt = 0;
        int left = low, right = mid+1;
        List<Integer> temp = new ArrayList<>();
        while(left<=mid && right<=high){
            if(nums[left] <= nums[right]){
                temp.add(nums[left]);
                left++;
            }
            else{
                temp.add(nums[right]);
                right++;
                cnt += mid-left+1;
            }
        }
        if(left<=mid){
            while(left<=mid){
                temp.add(nums[left]);
                left++;
            }
        }
        if(right <= high){
            while(right <= high){
                temp.add(nums[right]);
                right++;
            }
        }
        for(int i = low; i<high; i++){
            nums[i] = temp.get(i-low);
        }
        return cnt;
    }
    public static int mergeSort(int[] nums, int low, int high){
        int cnt = 0;
        if(low>=high) return cnt;
        int mid = (low+high)/2;
        cnt += mergeSort(nums, low, mid);
        cnt += mergeSort(nums, mid+1, high);
        cnt += merge(nums, low, high, mid);
        return cnt;
    }
    public static int countInversion(int[] nums){
        int n = nums.length;
        return mergeSort(nums, 0, n-1);
    }
    public static void main(String[] args) {
        int[] a = {5, 4, 3, 2, 1};
        int n = 5;
        int cnt = countInversion(a);
        System.out.println("The number of inversions are: " + cnt);
    }
}
