package JavaDSA.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class G2AdjList {
    public static void main(String[] args) {
//        List<List<Integer>> matrix = new ArrayList<>();
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
        Scanner sc = new Scanner(System.in);
        int n = 3;
        int m = 2;

        for(int i = 0; i<=n; i++){
            matrix.add(new ArrayList<Integer>());
        }
        for(int i = 0; i<m; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();

            matrix.get(u).add(v);
            matrix.get(v).add(u);
        }

//        for(int i = 1; i<=n; i++){
//            System.out.print(i + " -> ");
//            for(int j = 0; j<matrix.get(i).size(); j++){
//                System.out.print(matrix.get(i).get(j) + " ");
//            }
//            System.out.println();
//        }
        G3BFS o1 = new G3BFS();
        ArrayList<Integer> bfs = new ArrayList<>();
        bfs = o1.traversal(n,matrix);
        for(Integer it : bfs){
            System.out.println(it);
        }
    }
}
