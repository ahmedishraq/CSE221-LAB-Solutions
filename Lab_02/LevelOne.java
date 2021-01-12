
package assignment_01_bfs_dfs;

/**
 *
 * @author ahmed_ishraq
 */
import java.util.*;
import java.io.*;

public class LevelOne {

    static int n, conn, end;
    static int[] color;
    static int[] d;
    static int[] parent;
    static int[][] matrix;

    static void eUMatrixConn(int i, int j) {
        matrix[i][j] = 1;
        matrix[j][i] = 1;
    }

    static void BFS(int s) {
        color = new int[n];
        d = new int[n];
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            color[i] = 0; //  (White) the node is Undiscovered 
            d[i] = 0;
            parent[i] = -1;  // null 
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        color[s] = 1; // (Grey) the node is discovered 

        while (!q.isEmpty()) {
            int u = q.remove();
            for (int v = 0; v < n; v++) {
                if (matrix[u][v] == 1) {
                    if (color[v] == 0) {
                        d[v] = d[u] + 1;
                        parent[v] = u;
                        color[v] = 1;
                        q.add(v);
                    }
                }
            }
            color[s] = 2;  // (Black) finished processing 
        }
        System.out.println(d[end]);
    }

    public static void main(String[] args) {
        File f = new File("input_LevelOne.txt");

        try {
            Scanner sc = new Scanner(f);
            n = Integer.parseInt(sc.nextLine());
            matrix = new int[n][n];
            conn = Integer.parseInt(sc.nextLine());

            String[] split;
            int i = 0;
            while (i < conn) {
                String line = sc.nextLine();
                split = line.split(" ");
                int x = Integer.parseInt(split[0]);
                int y = Integer.parseInt(split[1]);

                eUMatrixConn(x, y);
                i++;
            }
            end = Integer.parseInt(sc.nextLine());  // Target possition
            BFS(0); // Starting possition 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
