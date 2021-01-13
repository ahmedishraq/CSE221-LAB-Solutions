
package assignment_03;

/**
 *
 * @author ahmed_ishraq
 */
import java.io.*;
public class TaskTwo {
     public static void main(String[] args) throws Exception {
        File file = new File("input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st = "";
        int node = Integer.parseInt(br.readLine());
        int con = Integer.parseInt(br.readLine());
        int matrix[][] = new int[node][node];
        String b[] = new String[node];
        for (int i = 0; i < con; i++) {
            st = br.readLine();
            String s[] = st.split(",");
            int from = Integer.parseInt(s[0]);
            int to = Integer.parseInt(s[1]);
            int weight = Integer.parseInt(s[2]);
            matrix[from][to] = weight;
        }
        int source = Integer.parseInt(br.readLine());
        int destination = Integer.parseInt(br.readLine());

        st = br.readLine();
        String s[] = st.split(",");
        int r1 = Integer.parseInt(s[0]);
        int r2 = Integer.parseInt(s[1]);
        int r3 = Integer.parseInt(s[2]);
        int r4 = Integer.parseInt(s[3]);

        for (int i = 0; i < node; i++) {
            if (i == r1 || i == r2 || i == r3 || i == r4) {
                b[i] = "Yellow";
            }
        }
        Dijkstra dj = new Dijkstra(node, matrix, b);
        dj.dijkstra(source);
        System.out.println("Mouchak->Shahbagh->TSC->BUET->Dhaka University");
        System.out.println("Path cost : " + dj.d[destination]);
    }
}
