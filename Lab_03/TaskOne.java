
package assignment_03;

/**
 *
 * @author ahmed_ishraq
 */
import java.io.*;
public class TaskOne {
     public static void main(String[] args) throws Exception {
        File file = new File("input_TaskOne.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st = "";
        st = br.readLine();
        String se[] = st.split(" ");
        int node = Integer.parseInt(se[0]) + 1;
        int con = Integer.parseInt(se[1]);
        int visit = Integer.parseInt(se[3]);
        int matrix[][] = new int[node + 1][node + 1];
        String b[] = new String[node];
        for (int i = 0; i < con; i++) {
            st = br.readLine();
            String s[] = st.split(" ");
            int from = Integer.parseInt(s[0]);
            int to = Integer.parseInt(s[1]);
            int weight = Integer.parseInt(s[2]);
            matrix[from][to] = weight;
        }
        System.out.println("Case 1:");
        for (int i = 0; i < visit; i++) {
            st = br.readLine();
            String sa[] = st.split(" ");
            int source = Integer.parseInt(sa[0]);
            int destination = Integer.parseInt(sa[1]);
            Dijkstra dj = new Dijkstra(node, matrix, b);
            dj.dijkstra(source);
            if (destination > node) {
                System.out.println("Be seeing ya, John");
            } else {
                System.out.println(dj.d[destination]);
            }
        }
    }
}
