package Graph;
import java.util.*;

public class Prims {
    private HashMap<Integer, HashMap<Integer,Integer>> map=new HashMap<>();
    public Prims(int v)
    {
        for (int i = 1; i <=v; i++) {
            map.put(i,new HashMap<>());
        }
    }
    public void AddEdge(int v1,int v2,int cost)
    {
        map.get(v1).put(v2,cost); //v1---->v2
        
        map.get(v2).put(v1,cost);//v2 --->v1
    }
    public class PrimsPair{
        int vtx;
        int aqrdvtx;
        int cost;
        public PrimsPair(int vtx,int aqrdvtx,int cost)
        {
            this.vtx=vtx;
            this.aqrdvtx=aqrdvtx;
            this.cost=cost;
        }
        @Override
        public String toString()
        {
            return this.vtx+" "+this.aqrdvtx+" @"+this.cost;
        }
    }
    public void primsAlgo()
    {
        PriorityQueue<PrimsPair> pq =new PriorityQueue<>(new Comparator<PrimsPair>() {
            @Override
            public int compare(PrimsPair o1,PrimsPair o2)
            {
                return o1.cost -o2.cost;
            }
            
        });
        pq.add(new PrimsPair(1, 1, 0));
        HashSet<Integer> visited=new HashSet<>();
        while(!pq.isEmpty())
        {
            PrimsPair rv=pq.remove();
            if(visited.contains(rv.vtx))
            {
                continue;
            }
            visited.add(rv.vtx);
            System.out.println(rv);
            for(int nbrs:map.get(rv.vtx).keySet())
            {
                if(!visited.contains(nbrs))
                {
                    PrimsPair np=new PrimsPair(nbrs, rv.vtx, map.get(rv.vtx).get(nbrs));
                    pq.add(np);
                }
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Prims p=new Prims(n);
        int m=sc.nextInt();
        for(int i=0;i<m;i++)
        {
            int v1=sc.nextInt();
            int v2=sc.nextInt();
            int cost=sc.nextInt();
            p.AddEdge(v1, v2, cost);

        }
        p.primsAlgo();
    }
}
