package assignment_05;

/**
 *
 * @author ahmed_ishraq
 */
import java.io.*;

public class Task_02 {

    static int w;
    static int item;
    static float[][] matrix;
    static int[] wi;
    static float[] bi;
    static Knapsack2_Node[] n;

    static void Knapsack(int[] wi, float[] bi) {
        matrix = new float[item + 1][w + 1];

        for (int i = 1; i <= wi.length; i++) {
            for (int j = 1; j <= w; j++) {
                if (i == 0 || j == 0) {
                    matrix[i][j] = 0;
                } else if (j >= wi[i - 1]) {
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i - 1][j - wi[i - 1]] + bi[i - 1]);
                } else {
                    matrix[i][j] = matrix[i - 1][j];
                }
            }
        }
    }

    static void show() {
        float a = matrix[item][w];
        float total = a;
        System.out.println("Name of clubs whose trophies were sold:");
        int b = w, m = 0;
        String[] pls = new String[item];

        for (int i = item; i > 0 && a > 1; i--) {
            if (a == matrix[i - 1][b]) {
                // do nothing just chill man :p 
            } else {
                pls[m] = n[i - 1].club;
                m++;
                a = a - bi[i - 1];
                b = b - wi[i - 1];
            }
        }

        for (int i = item - 1; i > 0; i--) {
            if (pls[i] != null) {
                System.out.print(pls[i] + " -> ");
            }
        }
        System.out.println(pls[0]);
        System.out.println("Maximum money he earned: " + total + " million");
    }

    public static void main(String[] args) {
        try {
            File f = new File("input_T02.txt");
            BufferedReader br = new BufferedReader(new FileReader(f));

            w = Integer.parseInt(br.readLine());
            item = Integer.parseInt(br.readLine());
            br.readLine();
            n = new Knapsack2_Node[item];
            String[] split;
            int i = 0;
            while (i < item) {
                String l3 = br.readLine();
                split = l3.split(", ");
                String w = split[0];
                String x = split[1];
                String y = split[2];
                String z = split[3];
                n[i] = new Knapsack2_Node(w, x, y, z);
                i++;
            }

            wi = new int[item];
            bi = new float[item];

            for (int j = 0; j < item; j++) {
                wi[j] = Integer.parseInt(n[j].wi);
                bi[j] = Float.parseFloat(n[j].bi);
            }

            Knapsack(wi, bi);
            show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
