import java.util.*;

public class Graph_Client {
    public static void main(String[] args) {
        Graph g=new Graph(10);
        g.AddEdge(1, 4, 6);
        g.AddEdge(1   , 2, 10);
        g.AddEdge(2, 3, 7);
        g.AddEdge(3, 4, 5);
        g.AddEdge(4, 5, 1);
        g.AddEdge(10, 7, 4);
        g.AddEdge(7, 5,2);
        g.AddEdge(6, 7, 3);
        // g.display();
        // System.out.println(g.hasPath(1, 6,new HashSet<Integer>()));
        // g.PrintAllPath(1,   3, new HashSet<Integer>(), "");
        // System.out.println(g.BFS(1, 0));
        // System.out.println(g.DFS(1, 0));
        g.BFT();
    }
}
