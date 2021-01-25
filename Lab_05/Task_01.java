package assignment_05;

/**
 *
 * @author ahmed_ishraq
 */
import java.io.*;

public class Task_01 {

    static int total_budget;
    static int shortlist_player;
    static int[][] matrix;
    static String[] pricing;
    static String[] form;
    static Knapsack_Node[] node;

    static void Knapsack(String[] pricing, String[] forms) {
        matrix = new int[shortlist_player + 1][total_budget + 1];

        for (int i = 1; i <= pricing.length; i++) {
            for (int j = 1; j <= total_budget; j++) {
                if (i == 0 || j == 0) {
                    matrix[i][j] = 0;
                } else if (j >= Integer.parseInt(pricing[i - 1])) {
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i-1][j - Integer.parseInt(pricing[i - 1])] + Integer.parseInt(forms[i - 1]));
                } else {
                    matrix[i][j] = matrix[i - 1][j];
                }
            }
        }
    }

    static void show() {
        int a = matrix[shortlist_player][total_budget];
        int total = a;
        int wgt = total_budget;
        int mo = 0;
        String[] pls = new String[shortlist_player];

        System.out.println("Bought Players:");

        for (int i = shortlist_player; i > 0 && a > 0; i--) {
            if (a == matrix[i - 1][wgt]) {
                // do nothing just chill man  :p
            } else {
                pls[mo] = node[i - 1].player;
                mo++;
                a -= Integer.parseInt(form[i - 1]);
                wgt -= Integer.parseInt(pricing[i - 1]);
            }
        }

        for (int i = shortlist_player - 1; i >= 1; i--) {
            if (pls[i] != null) {
                System.out.print(pls[i] + "-> ");
            }
        }
        System.out.println(pls[0]);
        System.out.println("Maximum summation of form: "+total);
    }

    public static void main(String[] args) {
        try {
            File f = new File("input_T01.txt");
            BufferedReader br = new BufferedReader(new FileReader(f));
            total_budget = Integer.parseInt(br.readLine());
            shortlist_player = Integer.parseInt(br.readLine());

            node = new Knapsack_Node[shortlist_player];
            String[] str;

            String player, price, form, position;
            br.readLine();
            for (int i = 0; i < shortlist_player; i++) {
                str = br.readLine().split(", ");
                player = str[0];
                price = str[1];
                form = str[2];
                position = str[3];
                node[i] = new Knapsack_Node(player, price, form, position);
            }

            pricing = new String[shortlist_player];
            Task_01.form = new String[shortlist_player];

            for (int j = 0; j < shortlist_player; j++) {
                pricing[j] = node[j].price;
                Task_01.form[j] = node[j].form;
            }

            Knapsack(pricing, Task_01.form);
            show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
