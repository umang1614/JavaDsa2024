package JavaDSA.BinarySearch.BSOn2DArray;

public class JD3SearchIn2DMatrix2 {
    public static boolean findX(int[][] nums, int target){
        int n = nums.length, m = nums[0].length;
        int row = 0, col = m-1;
        while(row < n && col>=0){
            int x = nums[row][col];
            if(x == target) return true;
            else if(x > target)col--;
            else row++;
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15},{2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24},{18, 21, 23, 26, 30}};
        boolean result = findX(matrix, 20);
        System.out.println(result ? "true" : "false");
    }
}
