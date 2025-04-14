package JavaDSA.Array.Easy;

import java.util.ArrayList;

public class JD7MoveZerosToEnd {
    public static void MoveZerosBrute(int[] arr){
        int n = arr.length;
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i = 0; i<n; i++){
            if(arr[i] != 0){
                temp.add(arr[i]);
            }
        }
        for(int i = 0; i<temp.size(); i++){
            arr[i] = temp.get(i);
        }
        for(int i = temp.size(); i<n; i++){
            arr[i] = 0;
        }
    }
    public static void MoveZerosOptimal(int[] arr){
        int j = -1;
        for(int i = 0; i<arr.length; i++){
            if(arr[i] == 0){
                j = i;
                break;
            }
        }
        if(j == -1){
            return;
        }
        for(int i = j+1; i<arr.length; i++){
            if(arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
    }

    public static void MoveZerosOneMore(int[] arr){
        int j = 0;
        for(int i = 0; i<arr.length; i++){
            if(arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;            }
        }
    }
    public static void print(int[] nums){
        for(int i=0; i< nums.length; i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,0,5,3,0,9,0,0,0,8};
        print(arr);
//        MoveZerosBrute(arr);
//        MoveZerosOptimal(arr);
        MoveZerosOneMore(arr);
        print(arr);
    }
}
