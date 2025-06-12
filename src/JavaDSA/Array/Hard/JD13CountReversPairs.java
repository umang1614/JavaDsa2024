package JavaDSA.Array.Hard;

import java.util.ArrayList;
import java.util.List;

public class JD13CountReversPairs {
public static int countPairs(int[] arr, int low, int mid, int high) {
    int right = mid + 1;
    int cnt = 0;
    for (int i = low; i <= mid; i++) {
        while (right <= high && (long)arr[i] > 2l * arr[right]) right++;
        cnt += (right - (mid + 1));
    }
    return cnt;
}

public static void merge(int[] arr, int low, int mid, int high ){
        int left = low, right = mid+1;
        ArrayList<Integer> temp = new ArrayList<>();
        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temp.add(arr[left]);
                left++;
            }
            else{
                temp.add(arr[right]);
                right++;
            }
        }
        while(left <= mid){
            temp.add(arr[left]);
            left++;
        }
        while(right<=high){
            temp.add(arr[right]);
            right++;
        }
        for(int i = low; i<=high; i++){
            arr[i] = temp.get(i-low);
        }
    }

public static int mergeSort(int[] arr, int low, int high) {
    int cnt = 0;
    if (low >= high) return cnt;
    int mid = (low + high) / 2 ;
    cnt += mergeSort(arr, low, mid);  // left half
    cnt += mergeSort(arr, mid + 1, high); // right half
    cnt += countPairs(arr, low, mid, high); //Modification
    merge(arr, low, mid, high);  // merging sorted halves
    return cnt;
}

    public static int countReversePairs(int[] nums){
        int n = nums.length;
        int cnt = mergeSort(nums, 0, n-1);
        return cnt;
    }
    public static void main(String[] args) {
            int[] a = {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
        int n = 5;
        int cnt = countReversePairs(a);
        System.out.println("The number of reverse pair is: " + cnt);
    }
}
