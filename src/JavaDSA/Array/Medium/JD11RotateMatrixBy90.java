package JavaDSA.Array.Medium;

import java.util.ArrayList;
import java.util.Arrays;

import static JavaDSA.Array.Medium.JD10SetMatrixZero.setMatrixOptimal;

public class JD11RotateMatrixBy90 {
    public static ArrayList<ArrayList<Integer>> rotateMatrix(ArrayList<ArrayList<Integer>> matrix){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int n = matrix.size();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(0); // placeholder values
            }
            result.add(row);
        }
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                int element = matrix.get(i).get(j);
                result.get(j).set((n-1)-i, element);
            }
        }
        return result;
    }

    public static void rotateMatrixOptimal(int[][] matrix){
        int n = matrix.length;
//        Transposing the matrix
        for(int i = 0; i<n-1; i++){
            for(int j = i+1; j<n; j++){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }

    }

    
    public static void print(ArrayList<ArrayList<Integer>> matrix){
        for (ArrayList<Integer> row : matrix) {
            for (Integer ele : row) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
  /*      ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1,2,3,4)));
        matrix.add(new ArrayList<>(Arrays.asList(5,6,7,8)));
        matrix.add(new ArrayList<>(Arrays.asList(9,10,11,12)));
        matrix.add(new ArrayList<>(Arrays.asList(13,14,15,16)));
        print(matrix);
//        ArrayList<ArrayList<Integer>> result = rotateMatrix(matrix);
        System.out.println();*/
        int arr[][] = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        rotateMatrixOptimal(arr);
        System.out.println("Rotated Image");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
