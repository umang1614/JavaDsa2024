package JavaDSA.Sorting;

public class SelectionSort {
    static void sort(int arr[], int N){
        for(int i = 0; i< N-1; i++){
            int min = i;
            for(int j = i; j<=N-1; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    public static void main(String[] args) {
        int arr[] = {23, 45, 18, 10, 32, 4};
        for (int i:arr){
            System.out.print(i + " ");
        }
        sort(arr, arr.length);
        System.out.println();
        for (int i:arr){
            System.out.print(i + " ");
        }
    }
}
