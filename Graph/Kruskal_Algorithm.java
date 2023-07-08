import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Kruskal_Algorithm{
    private HashMap<Integer, HashMap<Integer,Integer>> map=new HashMap<>();
    public Kruskal_Algorithm(int v)
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
    public class EdgePair{
        int e1;
        int e2;
        int cost;
        public EdgePair(int e1,int e2,int cost)
        {
            this.e1=e1;
            this.e2=e2;
            this.cost=cost;
        }
        
        @Override
        public String toString()
        {
            return e1+" "+e2+" "+" @ "+ cost;
        }
    }
    public ArrayList<EdgePair> getAllEdges()
    {
        ArrayList<EdgePair> list=new ArrayList<>();
        for(int e1:map.keySet())
        {
            for(int e2:map.get(e1).keySet())
            {
                EdgePair eg=new EdgePair(e1, e2,map.get(e1).get(e2));
                list.add(eg);
            }
            
        }
        return list;
    }
    public void KruskalAlgorithm()
    {
        DisjointSet ds=new DisjointSet();
        for(int key:map.keySet())
        {
            ds.Create(key);
        }
        ArrayList<EdgePair> ll=getAllEdges();
        Collections.sort(ll,new Comparator<EdgePair>() {
            @Override
            public int compare(EdgePair o1,EdgePair o2)
            {
                return o1.cost-o2.cost;
            }
        });
        int ans=0;
        for(EdgePair edge:ll)
        {
            int e1=edge.e1;
            int e2=edge.e2;
            int re1=ds.find(e1);
            int re2=ds.find(e2);
            if(re1==re2)
                {
                    //nothig
                }
            else{
                System.out.println(edge);
                ans+=edge.cost;
                ds.Union(re1, re2);
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Kruskal_Algorithm ks=new Kruskal_Algorithm(n);
        int m=sc.nextInt();
        for(int i=0;i<m;i++)
        {
            int v1=sc.nextInt();
            int v2=sc.nextInt();
            int cost=sc.nextInt();
            ks.AddEdge(v1, v2, cost);
        }
        ks.KruskalAlgorithm();
    }
}