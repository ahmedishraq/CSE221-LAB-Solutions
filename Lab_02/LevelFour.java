
package assignment_01_bfs_dfs;

/**
 *
 * @author ahmed_ishraq
 */
import java.util.*;
import java.io.*;

public class LevelFour {

    static int n, m;
    static int[][] matrix;
    static int[] acounter;

    static void eDMatrixConn(int i, int j) {
        matrix[i][j] = 1;
    }

    static void tracker() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    acounter[j]++;
                }
            }
        }
        int min_value = acounter[0];
        int min_possition = 0;
        for (int i = 0; i < n; i++) {
            if (acounter[i] < min_value) {
                min_value = acounter[i];
                min_possition = i;
            }
        }
        System.out.println(min_possition);
    }

    public static void main(String[] args) {
        File f = new File("input_LevelFour.txt");

        try {
            Scanner sc = new Scanner(f);
            n = Integer.parseInt(sc.nextLine());
            matrix = new int[n][n];
            m = Integer.parseInt(sc.nextLine());
            acounter = new int[n];
            String[] split;
            int i = 0;
            while (i < m) {
                String line = sc.nextLine();
                split = line.split(" ");
                int x = Integer.parseInt(split[0]);
                int y = Integer.parseInt(split[1]);
                eDMatrixConn(x, y);
                i++;
            }

            tracker();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
