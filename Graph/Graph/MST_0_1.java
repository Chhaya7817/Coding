package Graph;

import java.util.*;

public class MST_0_1 {
    private HashMap<Integer, List<Integer>> map=new HashMap<>();
    public MST_0_1(int v)
    {
        for (int i = 1; i <=v; i++) {
            map.put(i,new ArrayList<>());
        }
    }
    public void AddEdge(int v1,int v2)
    {
        map.get(v1).add(v2);
        map.get(v2).add(v1);
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
    public int primsAlgo()
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
        int sum=0;
        while(!pq.isEmpty())
        {
            PrimsPair rv=pq.remove();
            if(visited.contains(rv.vtx))
            {
                continue;
            }
            sum+=rv.cost;
            visited.add(rv.vtx);
            // System.out.println(rv);
            for(int nbrs=1;nbrs<=map.size();nbrs++)
            {
                if(!visited.contains(nbrs))
                {
                    int cost=0;
                    if(map.get(rv.vtx).contains(nbrs))
                        cost=1;
                    PrimsPair np=new PrimsPair(nbrs, rv.vtx, cost);
                    pq.add(np);
                }
            }
        }
        return sum;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        MST_0_1 ms=new MST_0_1(n);

        for(int i=0;i<m;i++)
        {
            int v1=sc.nextInt();
            int v2=sc.nextInt();
            ms.AddEdge(v1, v2);

        }
        System.out.println(ms.primsAlgo());
        
    }
}
