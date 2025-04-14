package JavaDSA.Graph;

import java.util.*;

public class testingGraph {
    public static void main(String[] args) {
        int n = 4;
        int m = 4;
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i<n; i++){
            matrix.add(new ArrayList<>());
        }
        for(int i = 0; i<m;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            matrix.get(u).add(v);
            matrix.get(v).add(u);
        }
//        ArrayList<Integer> bfs = bfsTest(matrix, n, m);
        boolean[] vis = new boolean[n+1];
        ArrayList<Integer> result = new ArrayList<>();
        dfsTest(0, vis, matrix, result);
        for(int i = 0;i<n;i++) {
            System.out.print(result.get(i)+" ");
        }
    }
    public static ArrayList<Integer> bfsTest(ArrayList<ArrayList<Integer>> matrix, int n, int m){
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] vis = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        vis[0] = true;
        for(int i = 0; i<n; i++){
            if(!vis[i]){
                while(!queue.isEmpty()){
                    int node = queue.poll();
                    bfs.add(node);
                    for(Integer it:matrix.get(node)){
                        if(!vis[it]){
                            queue.add(it);
                            vis[it] = true;
                        }
                    }
                }
            }
        }
        return bfs;
    }

    public static void dfsTest(int node, boolean[] vis, ArrayList<ArrayList<Integer>> matrix, ArrayList<Integer> result){
        vis[node] = true;
        result.add(node);
        for(Integer it : matrix.get(node)){
            if(!vis[it]){
                dfsTest(it, vis, matrix, result);
            }
        }
    }
}
