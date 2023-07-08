import java.util.*;
import java.util.HashMap;
import java.util.ArrayList;

public class PrimsAlgo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        HashMap<Integer,HashMap<Integer,Integer>> map=new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i,new HashMap<Integer,Integer>());
            
        }
        for(int i=0;i<n;i++)
        {
            int u=sc.nextInt();
            int v=sc.nextInt();
            int w=sc.nextInt();
            map.get(u).put(v,w);
            map.get(v).put(u,w);
        }
        prims(map);
    }
    public static void prims( HashMap<Integer,HashMap<Integer,Integer>> map)
    {
        int src=0;
        PriorityQueue<prim_pair> pq=new PriorityQueue<prim_pair>(new Comparator<prim_pair>(){
            @Override
            public int compare(prim_pair o1,prim_pair o2)
            {
                return o1.cost-o2.cost;
            }
        });
        
        pq.add(new prim_pair(src, "", 0));
        Set<Integer> visited=new HashSet<>();
        while(!pq.isEmpty())
        {
            prim_pair rv=pq.poll();
            System.out.println(map.get(rv.vtx));
            if(visited.contains(rv.vtx))
                continue;
            visited.add(rv.vtx);
            System.out.println(rv);
            for(int nbrs:map.get(rv.vtx).keySet())
            {
                if(!visited.contains(nbrs))
                pq.add(new prim_pair(nbrs, rv.path+nbrs,rv.cost + map.get(rv.vtx).get(nbrs)));
            }

        }

    }
    public static class prim_pair{
        int vtx;
        String path;
        int cost;
        public prim_pair(int vtx,String path,int dis)
        {
            this.vtx=vtx;
            this.path=path;
            this.cost=cost;

        }
        @Override
        public String toString()
        {
            return this.vtx+" "+this.path+"@"+this.cost;
        }
    }
}
