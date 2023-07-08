package Graph;
import java.util.*;


public class Shortest_Cycle {
    class Solution {
        // public HashMap<Integer,List<Integer>> map=new HashMap<>();
        
        public int findShortestCycle(int n, int[][] edges) {
            
            List<List<Integer>> graph = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<Integer>());
            }
            for (int[] vtx : edges) 
            {
                graph.get(vtx[0]).add(vtx[1]);
                graph.get(vtx[1]).add(vtx[0]);
            }
            int res = n + 1;
            for (int i = 0; i < n; i++) 
            {
                Queue<Integer> q = new LinkedList<>();
                List<Integer> dt = new ArrayList<>(Collections.nCopies(n, n + 1));
                List<Integer> pt = new ArrayList<>(Collections.nCopies(n, -1));
                q.add(i);
                dt.set(i, 0);
                while (!q.isEmpty()) 
                {
                    int rv = q.poll();
                    for (int v : graph.get(rv)) 
                    {
                        if (dt.get(v) == n + 1) 
                        {
                            dt.set(v, dt.get(rv) + 1);
                            pt.set(v, rv);
                            q.add(v);
                        } 
                        else if (v != pt.get(rv) && v != i) 
                        {
                            res = Math.min(res, dt.get(rv) + dt.get(v) + 1);
                        }
                    }
                }
            }
            return res <= n ? res : -1;
        }
    }
        
}
