package JavaDSA.Array.Medium;

import java.util.*;

public class JD12SpiralMatrix {
    public static List<Integer> printSpiral(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        int left = 0, right = m-1, top = 0, bottom = n-1;
        List<Integer> res = new ArrayList<>();
        while(top<=bottom && left <= right){
            for(int i = left; i<=right; i++){
                res.add(matrix[top][i]);
            }
            top++;
            for(int i = top; i<= bottom; i++){
                res.add(matrix[i][right]);
            }
            right--;
            if(top<=bottom) {
                for (int i = right; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(left<=right) {
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        List<Integer> ans = printSpiral(mat);

        for(int i = 0;i<ans.size();i++){
            System.out.print(ans.get(i) + " ");
        }

        System.out.println();
    }
}
