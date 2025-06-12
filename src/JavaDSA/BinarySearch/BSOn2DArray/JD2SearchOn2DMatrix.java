package JavaDSA.BinarySearch.BSOn2DArray;

public class JD2SearchOn2DMatrix {
    public static boolean findX(int[][] matrix, int target){
        int n = matrix.length, m = matrix[0].length;
        int low = 0, high = n*m-1;
        while (low <= high){
            int mid = (low + high)/2;
            int row = mid/m, col = mid%m;
            if(matrix[row][col] == target)return true;
            else if(matrix[row][col] > target) high = mid -1;
            else low = mid +1;
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        boolean result = findX(matrix, 13);
        System.out.println(result ? "true" : "false");
    }
}
