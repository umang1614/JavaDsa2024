package JavaDSA.Sorting;

public class InsertionSort {
    static void insertionSort(int arr[], int N){
        for(int i = 0; i<N; i++){
            int j = i;
            while(j > 0 && arr[j-1] > arr[j]){
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {23, 45, 18, 10, 32, 4, 1};
        for (int i:arr){
            System.out.print(i + " ");
        }
        insertionSort(arr, arr.length);
        System.out.println();
        for(int i : arr){
            System.out.print(i + " ");
        }
    }
}
