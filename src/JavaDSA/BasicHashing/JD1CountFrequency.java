package JavaDSA.BasicHashing;

import java.util.HashMap;
import java.util.Map;

public class JD1CountFrequency {
    class Solution {
        // Function to count the frequency of all elements from 1 to N in the array.
        public static int[] frequencyCount(int arr[], int N, int P) {
            int frequencyArray[] = new int[N + 1];
            for (int i = 0; i < N; i++) {
                if (arr[i] <= N) {
                    frequencyArray[arr[i] - 1] = frequencyArray[arr[i] - 1]+1;
                }
            }
            for (int i = 0; i < N; i++) {
                arr[i] = frequencyArray[i];
            }
            return arr;
        }
    }
public static int[] frequencyCoutWithHash(int arr[], int N){
    Map<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i<N; i++){
        if(map.containsKey(arr[i])) {
            map.put(arr[i], map.get(arr[i])+1);
        }
        else {
            map.put(arr[i], 1);
        }
    }
    for (int i = 0; i<N; i++){
        if(map.containsKey(i+1)){
            arr[i] = map.get(i + 1);
        }
        else{
            arr[i] = 0;
        }
    }
    return arr;
}
    public static void main(String[] args) {
        int arr[] = {2, 3, 2, 5, 3, 2,5,8,2,10};
        for(int i : arr){
            System.out.print(i + " ");
        }
//       int arr2[] = Solution.frequencyCount(arr, arr.length, 5);
       int arr2[] = frequencyCoutWithHash(arr, arr.length);
        System.out.println();
        for(int i : arr2){
            System.out.print(i + " ");
        }
    }
}
