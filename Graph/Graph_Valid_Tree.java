import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Description
// Given n nodes labeled from 0 to n - 1 and a list of undirected edges 
// (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.
public class Graph_Valid_Tree {

    //maintain arraylist correc=sponding to every vertex
    public static void main(String[] args) {
        
    }
    public boolean validTree(int n,int [][] edges)
    {
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for (int i = 0; i < n; i++) {
            {
                map.put(i,new ArrayList<>());
            }
        for (int j = 0; j < edges.length; j++) {
            int v1=edges[j][0];
            int v2=edges[j][1];
            map.get(v1).add(v2);
            map.get(v2).add(v1);

            
            }
            
        }
        return isValid(map);

    }

    public boolean isValid(HashMap<Integer,List<Integer>> map)
    {
        HashSet<Integer> visited=new HashSet<>();
        Queue<Integer> q=new LinkedList<>();
        int count=0;
        for(int src:map.keySet())
        {
            if(visited.contains(src))
                continue;
            q.add(src);

        
            while(!q.isEmpty())
            {
                //step 1 : remove
                int rv=q.poll();
                //step 2 :if already visited the ignore it
                if(visited.contains(rv))
                    continue;
                //step 3: visited
                visited.add(rv);
                //step 4: Self work
                // System.out.println(rv);
                //step 5: add neighbours
                for(int nbrs:map.get(rv))
                {
                    if(!visited.contains(nbrs))
                    {
                        q.add(nbrs);
                    }
                }


            }
        }
    }
}
