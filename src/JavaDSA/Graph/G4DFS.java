package JavaDSA.Graph;

import java.util.ArrayList;

public class G4DFS {

    static void dfs(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> result){
        vis[node] = true;
        result.add(node);
        for(Integer it:adj.get(node)){
            if(!vis[it]){
                dfs(it, vis, adj, result);
            }
        }
    }
    static ArrayList<Integer> DFSTraversal(int n, ArrayList<ArrayList<Integer>> adj){
        boolean vis[] = new boolean[n];
        ArrayList<Integer> result = new ArrayList<>();
        dfs(0, vis, adj, result);
        return result;
    }
    public static void main(String[] args) {
        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(4);
        adj.get(4).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);

        ArrayList<Integer> result = DFSTraversal(5, adj);
        int n = result.size();
        for(int i = 0;i<n;i++) {
            System.out.print(result.get(i)+" ");
        }
    }
}
