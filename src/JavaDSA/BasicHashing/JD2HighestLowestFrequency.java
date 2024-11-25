package JavaDSA.BasicHashing;

import java.util.Collection;

public class JD2HighestLowestFrequency {
    public static int[] checkFrequency(int arr[], int N){
        int freqArr[] = new int[N+1];
        for(int i = 0; i < N; i++){
            if(arr[i] <= N){
                freqArr[arr[i]-1] = freqArr[arr[i]-1] + 1;
            }
        }
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        int result[] = new int[2];
        for(int i = 0; i<N; i++){
            if(freqArr[i] > high){
                high = freqArr[i];
                result[1] = i+1;
            }
            if(freqArr[i] < low){
                low = freqArr[i];
                result[0] = i+1;
            }
        }
        for(int i:freqArr){
            System.out.print(i + " ");
        }
        System.out.println();
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {2,3,2,5,2};
        int result[] = checkFrequency(arr, arr.length);
        for(int i:result){
            System.out.print(i + " ");
        }

    }
}
