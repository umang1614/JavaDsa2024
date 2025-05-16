package JavaDSA.Array.Hard;
import java.util.*;
public class JD1PascalTriangle {
    public static List<Integer> generateRows(int row){
        List<Integer> ans = new ArrayList<>();
        int temp = 1;
        ans.add(temp);
        for(int i = 1; i<row; i++){
            temp = temp*(row-i);
            temp = temp/i;
            ans.add(temp);
        }
        return ans;
    }
    public static List<List<Integer>> generatePascalOptimal(int numRows){
        List<List<Integer>> ans = new ArrayList<>();
        for(int i =1; i<=numRows; i++){
            ans.add(generateRows(i));
        }
        return ans;
    }

    public static int calNCR(int row, int col){
        int ans = 1;
        for(int i = 0; i<col; i++){
            ans = ans * (row-i);
            ans = ans/(i+1);
        }
        return ans;
    }
    public static List<List<Integer>> generatePascalBrute(int numRows){
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 1; i<=numRows; i++){
            List<Integer> temp = new ArrayList<>();
            for(int j = 1; j <= i; j++){
                int el = calNCR(i-1, j-1);
                temp.add(el);
            }
            ans.add(temp);
        }
        return ans;
    }
    public static void main(String[] args) {
        int n = 6;
        List<List<Integer>> ans = generatePascalBrute(n);
        for (List<Integer> it : ans) {
            for (int ele : it) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}
