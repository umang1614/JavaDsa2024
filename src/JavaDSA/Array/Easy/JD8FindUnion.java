package JavaDSA.Array.Easy;

import java.util.ArrayList;

public class JD8FindUnion {
    public static ArrayList<Integer> findUnion(int[] num1, int[] num2){
        int i = 0;
        int j = 0;
        ArrayList<Integer> result = new ArrayList<>();
        while(i<num1.length && j<num2.length){
            if(num1[i] < num2[j]){
                if(!result.contains(num1[i])) {
                    result.add(num1[i++]);
                }
                else{
                    i++;
                }
            } else if (num1[i] > num2[j]) {
                if(!result.contains(num2[j])) {
                    result.add(num2[j++]);
                }
                else{
                    j++;
                }
            }
            else if (num1[i] == num2[j]){
                result.add(num2[j]);
                i++;
                j++;
            }
        }
        while(i<num1.length){
            if(!result.contains(num1[i])){
                result.add(num1[i++]);
            }
            else {
                i++;
            }
        }
        while(j<num2.length){
            if(!result.contains(num2[j])){
                result.add(num2[j++]);
            }
            else {
                j++;
            }
        }
        return result;
    }
    public static void print(ArrayList<Integer> nums){
        for(int i=0; i< nums.size(); i++){
            System.out.print(nums.get(i) + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arr2 = {2, 3, 4, 4, 5, 11, 12};
        ArrayList<Integer> result;
        result = findUnion(arr1, arr2);
        print(result);
    }
}
