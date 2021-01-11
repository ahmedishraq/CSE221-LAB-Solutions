/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task1;

/**
 *
 * @author ahmed_ishraq
 */
import java.util.*;
import java.io.*;

public class Task1 {

    public static void main(String[] args) {
        try {
            FileReader f = new FileReader("input.txt");
            BufferedReader b = new BufferedReader(f);
            String v = b.readLine();
            System.out.println("Number of vertices : " + v);

            LinkedList<list> l = new LinkedList<list>();
            String s;
            while ((s = b.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(s, " ");
                l.add(new list(st.nextToken(), st.nextToken()));
            }
            for (int i = 0; i < l.size(); i++) {
                System.out.println(l.get(i).source + " --> " + l.get(i).destination);
            }
        } catch (Exception e) {

        }

    }

}
