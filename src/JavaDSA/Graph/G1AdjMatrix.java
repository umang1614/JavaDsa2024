package JavaDSA.Graph;

import java.util.Scanner;

public class   G1AdjMatrix {

    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        int n = Sc.nextInt();
        int m = Sc.nextInt();
        int matrix[][] = new int[n+1][n+1];

        for(int i = 0; i<m;i++){
            int u = Sc.nextInt();
            int v = Sc.nextInt();
            matrix[u][v] = 1;
            matrix[v][u] = 1;
        }
    }
}
