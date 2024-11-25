package JavaDSA.Sorting;

public class QuickSort {

     static int findPivot(int arr[], int low, int high){
        int pivot = arr[low];
        int i = low;
        int j = high;

        while(i < j){
            while(arr[i] <= pivot && i <= high-1){
                i++;
            }
            while(arr[j] > pivot && j >= low+1
            ){
                j--;
            }
            if(i<j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;
        return j;
    }
     static void sort(int arr[], int low, int high){
        if(low < high){
            int pivotIndex = findPivot(arr, low, high);
            sort(arr, low, pivotIndex -1);
            sort(arr, pivotIndex+1, high);
        }
    }
    public static void main(String[] args) {
        int arr[] = {4,6,2,5,7, 9, 1,3};
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
        sort(arr, 0, arr.length-1);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
}
