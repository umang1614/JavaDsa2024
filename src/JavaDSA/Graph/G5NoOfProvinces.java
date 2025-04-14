package JavaDSA.Graph;
import java.util.*;

public class  G5NoOfProvinces {
    class Solution {
        public void dfs(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj){
            vis[node] = true;

            for(Integer it:adj.get(node)){
                if(!vis[it]){
                    dfs(it, vis, adj);
                }
            }
        }
        public int findCircleNum(int[][] isConnected) {
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            int n = isConnected.length;
            for(int i = 0; i<n; i++){
                adj.add(new ArrayList<Integer>());
            }

            for(int i = 0; i<n; i++){
                for(int j = 0; j<n; j++){
                    if(isConnected[i][j] == 1 && i != j){
                        adj.get(i).add(j);
                        adj.get(j).add(i);
                    }
                }
            }

            boolean vis[] = new boolean[n+1];
            int ctr = 0;
            for(int i = 0; i<n; i++){
                if(!vis[i]){
                    ctr++;
                    dfs(i, vis, adj);
                }
            }
            return ctr;
        }
    }
}
