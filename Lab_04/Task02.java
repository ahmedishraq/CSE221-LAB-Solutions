package assignment_04;

/**
 *
 * @author ahmed_ishraq
 */
import java.io.*;

public class Task02 {

    static int[][] matrix;
    static String[] lcs;
    static String[] input_m;
    static String[] input_c;
    static LCS_node[] n;

    static void LCS(String[] s1, String[] s2) {
        matrix = new int[s1.length + 1][s2.length + 1];

        for (int i = 1; i <= s1.length; i++) {
            for (int j = 1; j <= s2.length; j++) {
                if (s1[i - 1].equals(s2[j - 1])) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                } else {
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
                }
            }
        }

        int idx = matrix[s1.length][s2.length];
        int tmp = idx;

        lcs = new String[idx];

        int x = s1.length;
        int y = s2.length;

        while (x > 0 && y > 0) {
            if (s1[x - 1].equals(s2[y - 1])) {
                lcs[idx - 1] = s1[x - 1];
                x--;
                y--;
                idx--;
            } else if (matrix[x - 1][y] > matrix[x][y - 1]) {
                x--;
            } else {
                y--;
            }
        }
        System.out.println(lcs.length);
        for (int i = 0; i < tmp; i++) {
            for (int j = 0; j < n.length; j++) {
                if (lcs[i].equals(n[j].c)) {
                    System.out.print(n[j].s + " ");
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        try {
            File f = new File("input_T02.txt");
            BufferedReader br = new BufferedReader(new FileReader(f));
            String[] m = br.readLine().split(" ");
            String[] c = br.readLine().split(" ");

            n = new LCS_node[10];
            String[] split;

            for (int i = 0; i < 10; i++) {
                split = br.readLine().split(":");
                String x = split[0];
                String y = split[1];
                n[i] = new LCS_node(x, y);
            }

            input_m = new String[m.length];
            input_c = new String[n.length];

            for (int j = 0; j < m.length; j++) {
                for (int k = 0; k < n.length; k++) {
                    if (m[j].equals(n[k].s)) {
                        input_m[j] = n[k].c;
                    }
                }
            }

            for (int j = 0; j < c.length; j++) {
                for (int k = 0; k < n.length; k++) {
                    if (c[j].equals(n[k].s)) {
                        input_c[j] = n[k].c;
                    }
                }
            }

            LCS(input_m, input_c);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
