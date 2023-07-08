package Assignment;

import java.util.*;

public class BFS_ShortestPAth {
    public static class pair{
        int vtx;
        int cost;
        public pair(int vtx,int cost)
        {
            this.vtx=vtx;
            this.cost=cost;
        }
    }
    public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int m=sc.nextInt();
            HashMap<Integer,HashMap<Integer,Integer>> map=new HashMap<>();
            HashMap<Integer,Integer> res=new HashMap<>();
            for(int i=1;i<=n;i++)
            {
                map.put(i,new HashMap<>());
                res.put(i,-1);

            }
            for(int i=0;i<m;i++)
            {
                int u=sc.nextInt();
                int v=sc.nextInt();
                map.get(u).put(v,6);
                map.get(v).put(u,6);
            }
            int s=sc.nextInt();
            BFS(map, res, s);
            System.out.println(res);
            for(int key:res.keySet())
            {
                if(key!=s)
                {
                    System.out.print(res.get(key)+" ");
                }
            }


        }
        
    }
    
    public static void BFS(HashMap<Integer,HashMap<Integer,Integer>> map,HashMap<Integer,Integer> res,int s)
    {
        PriorityQueue<pair> pq=new PriorityQueue<pair>(new Comparator<pair>()
        {
            @Override
            public int compare(pair o1,pair o2)
            {
                return o1.cost-o2.cost;
            }
        });
        

        pq.add(new pair(s,0));
        Set<Integer> visited=new HashSet<>();
        while(!pq.isEmpty())
        {
            pair rv=pq.remove();
            if(visited.contains(rv.vtx))
                continue;
            visited.add(rv.vtx);
            res.put(rv.vtx,rv.cost);
            for(int nbrs:map.get(rv.vtx).keySet())
            {
                if(!visited.contains(nbrs))
                {
                    pq.add(new pair(nbrs,rv.cost+6 ));

                }
            }
        }

    }
}
