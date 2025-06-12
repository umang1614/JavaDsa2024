package JavaDSA.Array.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JD9Merge2SortedArrays {
    public static void sortArrayBrute(int[] arr1, int[] arr2){
        int left = 0, right = 0;
        int n = arr1.length, m = arr2.length;
        List<Integer> ans = new ArrayList<>();
        while(left<n && right < m){
            if(arr1[left] <= arr2[right]){
                ans.add(arr1[left]);
                left++;
            }
            else{
                ans.add(arr2[right]);
                right++;
            }
        }
        while(left<n){
            ans.add(arr1[left++]);
        }
        while(right<m){
            ans.add(arr2[right++]);
        }
        for(int i = 0; i<n+m; i++){
            if(i<n) arr1[i] = ans.get(i);
            else arr2[i-n] = ans.get(i);
        }
    }
    public static void sortArrayOptimal1(int[] arr1, int[] arr2){
        int n = arr1.length, m = arr2.length;
        int left = n-1, right = 0;
        while(left >= 0 && right < m){
            if(arr1[left] > arr2[right]){
                int temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;
            }
            else{
                break;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
    public static void swapIfGreater(int[] arr1, int[] arr2, int left, int right){
        if(arr1[left] > arr2[right]){
            int temp = arr1[left];
            arr1[left] = arr2[right];
            arr2[right] = temp;
        }
    }
    public static void sortArrayoptimal2(int[] arr1, int[] arr2){
        int n = arr1.length, m = arr2.length;
        int len = n+m;
        int gap = len/2 + len%2; //to get the cieling value
        while(gap > 0){
            int left = 0;
            int right = left + gap;
            while(right < len){
                //arr1 and arr2
                if(left < n && right >= n){
                    swapIfGreater(arr1, arr2, left, right - n);
                }
                // arr2 and arr2
                else if(left >= n){
                    swapIfGreater(arr2, arr2, left-n, right-n);
                }
                //arr1 and arr1
                else{
                    swapIfGreater(arr1, arr1, left, right);
                }
                left++;
                right++;
            }
            if(gap == 1) break;
            gap = (gap/2) + (gap%2);
        }
    }
    public static void main(String[] args) {
        int[] arr1 = {1, 4, 8, 10};
        int[] arr2 = {2, 3, 9};
        int n = 4, m = 3;
        sortArrayoptimal2(arr1, arr2);
        System.out.println("The merged arrays are:");
        System.out.print("arr1[] = ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.print("\narr2[] = ");
        for (int i = 0; i < m; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
    }
}
