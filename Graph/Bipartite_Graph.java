import java.util.*;
import java.util.HashMap;

public class Bipartite_Graph {
    class Solution {
        public boolean isBipartite(int[][] graph) {
    
        HashMap<Integer,Integer> visited=new HashMap<>();
        Queue<BipartitePair> q=new LinkedList<>();
        for(int src=0;src<graph.length;src++)
        {
            if(visited.containsKey(src))
                continue;
            q.add(new BipartitePair(src, 0));

        
            while(!q.isEmpty())
            {
                //step 1 : remove
                BipartitePair rv=q.poll();
                //step 2 :if already visited the ignore it
                if(visited.containsKey(rv.vtx) )
                {
                    if(visited.get(rv.vtx)!=rv.lv)
                    continue;
                    else
                    return false;
                }
                   
                //step 3: visited
                
                visited.put(rv.vtx,rv.lv);
                //step 4: Self work
                // System.out.println(rv);
                //step 5: add neighbours
                for(int nbrs:graph[rv.vtx])
                {
                    if(!visited.containsKey(nbrs))
                    {
                        q.add(new BipartitePair(nbrs,rv.lv +1));
                    }
                }


            }
            
        }
        return true;
    }
    }
    public static class BipartitePair{
        int vtx;
        int lv;
        public BipartitePair(int src,int lv)
        {
            this.vtx=src;
            this.lv=lv;
        }
    }
}
