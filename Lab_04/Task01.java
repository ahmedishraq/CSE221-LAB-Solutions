package assignment_04;

/**
 *
 * @author ahmed_ishraq
 */
import java.io.*;

public class Task01 {

    static int[][] matrix;
    static String[] lcs;

    static void LCS(String[] s1, String[] s2) {
        matrix = new int[s1.length + 1][s2.length + 1];

        for (int i = 1; i <= s1.length; i++) {
            for (int j = 1; j <= s2.length; j++) {
                if (s1[i - 1].equals(s2[j - 1])) {
                    matrix[i][j] = ++matrix[i - 1][j - 1];
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
        for (int i = 0; i < tmp; i++) {
            System.out.print(lcs[i]);
        }
    }

    public static void main(String[] args) {
        try {
            File f = new File("input_T01.txt");
            BufferedReader br = new BufferedReader(new FileReader(f));
            String[] gn = br.readLine().split(" ");
            String[] pn = br.readLine().split(" ");
            LCS(gn, pn);

            double accuracy = ((double) lcs.length / gn.length) * 100;
            System.out.println();
            if (accuracy >= (double) 50) {
                if (accuracy % 1 != 0) {
                    System.out.printf("%.2f%s", accuracy, "% PASSED");
                } else {
                    System.out.println((int) accuracy + "% PASSED");
                }
            } else {
                if (accuracy % 1 != 0) {
                    System.out.printf("%.2f%s", accuracy, "% FAILED");
                } else {
                    System.out.println((int) accuracy + "% FAILED");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
