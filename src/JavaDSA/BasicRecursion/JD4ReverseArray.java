package JavaDSA.BasicRecursion;

public class JD4ReverseArray {
    class Solution {

        int[] reverse(int n, int i, int arr[]){
            if(i >= n/2){
                return arr;
            }
            int temp = arr[i];
            arr[i] = arr[n-1-i];
            arr[n-1-i] = temp;
            i++;
            return reverse(n, i, arr);
        }
        public int[] reverseArray(int arr[]) {
            arr = reverse(arr.length, 0, arr);
            return arr;
        }
    }
}
