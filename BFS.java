/*
 * Consider an undirected graph where each edge is the same weight. Each of the nodes is labeled consecutively.

You will be given a number of queries. For each query, you will be given a list of edges describing an undirected graph. After you create a representation of the graph, you must determine and report the shortest distance to each of the other nodes from a given starting position using the breadth-first search algorithm (BFS). Distances are to be reported in node number order, ascending. If a node is unreachable, print  for that node. Each of the edges weighs 6 units of distance.
 */

import java.util.*;

public class BFS {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner ob = new Scanner(System.in);
        int queries = ob.nextInt();
        while(queries-- > 0) {
            int n = ob.nextInt();
            int m = ob.nextInt();
            short[][] data = new short[n][n];
            while(m-- > 0) {
                int u = ob.nextInt();
                int v = ob.nextInt();
                data[u-1][v-1]=1;
                data[v-1][u-1]=1;
                
            }
            int s = ob.nextInt();
            String output = "";
            int[] lengths = bfs(s, data, n);
            for(int i = 0 ; i < n;i++) {
                if(i != s-1) 
                output += (lengths[i] == 0 ? -1 : lengths[i]) + " ";
            }
            output = output.trim();
            System.out.println(output);
        }
        ob.close();
    }
    
    private static int[] bfs(int s , short[][] list, int n) {
        int[] lengths = new int[n];
        boolean[] visited = new boolean[n];
        List<Integer> nodes = new ArrayList<Integer>();
        for(int i = 0 ; i < n;i++) {
            if(list[s-1][i] != 0) {
            nodes.add(i);
            lengths[i] += 6;
        }}
        visited[s-1] = true;
        while(nodes.size() > 0) {
            int node = nodes.remove(0);
            visited[node] = true;
            for(int i = 0 ; i < n;i++) {
                if(!visited[i] && list[node][i] != 0) {
                    nodes.add(i);
                    if(lengths[i] == 0) lengths[i] = lengths[node]+6;
                    else if(lengths[i] > lengths[node]+6)
                        lengths[i] = lengths[node]+6;
                }
            }
            }
        
        return lengths;
    }
    
}
