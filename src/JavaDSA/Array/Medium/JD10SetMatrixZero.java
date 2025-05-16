package JavaDSA.Array.Medium;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class JD10SetMatrixZero {
    public static void setRow(ArrayList<ArrayList<Integer>> matrix,int row){
        for(int col = 0; col<matrix.get(row).size(); col++){
            if(matrix.get(row).get(col) != 0){
                matrix.get(row).set(col, -1);
            }
        }
    }
    public static void setCol(ArrayList<ArrayList<Integer>> matrix,int col){
        int n = matrix.size();
        for(int row = 0; row < n; row++){
            if(matrix.get(row).get(col) != 0){
                matrix.get(row).set(col, -1);
            }
        }
    }
    public static void setMatrixBrute(ArrayList<ArrayList<Integer>> matrix){
        int row = matrix.size();
        int col = matrix.get(0).size();

        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(matrix.get(i).get(j) == 0){
                    setRow(matrix, i);
                    setCol(matrix,j);
                }
            }
        }

        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(matrix.get(i).get(j) == -1){
                    matrix.get(i).set(j, 0);
                }
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

public static void setMatrixBetter(ArrayList<ArrayList<Integer>> matrix){
        int n = matrix.size();
        int m = matrix.get(0).size();
        int[] row = new int[n];
        int[] col = new int[m];

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(matrix.get(i).get(j) == 0){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(row[i] == 1 || col[j] == 1){
                    matrix.get(i).set(j, 0);
                }
            }
        }
}
public static void setMatrixOptimal(ArrayList<ArrayList<Integer>> matrix){
//        int col[m] = matrix[0][...]
//          int row[n] = matrix[...][0]
    int n = matrix.size();
    int m = matrix.get(0).size();
    int col0 = 1;
    for(int i = 0; i<n; i++){
        for(int j = 0; j<m; j++){
            if(matrix.get(i).get(j) == 0){
                matrix.get(i).set(0, 0);
                if(j!=0){
                    matrix.get(0).set(j, 0);
                }
                else{
                    col0 = 0;
                }
            }
        }
    }

    for(int i = 1; i<n; i++){
        for(int j = 1; j<m; j++){
            if(matrix.get(i).get(0) == 0 || matrix.get(0).get(j) == 0){
                matrix.get(i).set(j, 0);
            }
        }
    }
    if(matrix.get(0).get(0) == 0){
        for(int j = 0; j<m; j++){
            matrix.get(0).set(j, 0);
        }
    }
    if(col0 == 0){
        for(int i = 0; i<n; i++){
            matrix.get(i).set(0, 0);
        }
    }
}
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1,1,1,1)));
        matrix.add(new ArrayList<>(Arrays.asList(1,0,1,1)));
        matrix.add(new ArrayList<>(Arrays.asList(1,1,0,1)));
        matrix.add(new ArrayList<>(Arrays.asList(1,0,0,1)));
        print(matrix);
        System.out.println();
        setMatrixOptimal(matrix);
        print(matrix);

    }
}
