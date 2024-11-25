package JavaDSA.Sorting;

public class BubbleSort {

    static void bubbleSort(int arr[], int N){
        for(int i = 0; i<N-1; i++){
            int isSwap = 0;
            for(int j = 0; j<N-1-i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    isSwap = 1;
                }
            }
            if(isSwap == 0){
                break;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {23, 45, 18, 10, 32, 4};
        for (int i:arr){
            System.out.print(i + " ");
        }
        bubbleSort(arr, arr.length);
        System.out.println();
        for (int i:arr){
            System.out.print(i + " ");
        }
    }
}
