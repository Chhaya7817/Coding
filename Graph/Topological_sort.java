import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Topological_sort {
    private HashMap<Integer, HashMap<Integer,Integer>> map=new HashMap<>();
    public Topological_sort(int v)
    {
        for (int i = 1; i <=v; i++) {
            map.put(i,new HashMap<>());
        }
    }
    public void addEdge(int v1,int v2,int cost)
    {
        map.get(v1).put(v2,cost); //v1---->v2
    }

    public void TopologicalSort()
    {
        int [] in=indegree();
        Queue<Integer> q=new LinkedList();
        for(int i=1;i<in.length;i++)
        {
            if(in[i]==0)
                q.add(i);
        }
        while(!q.isEmpty())
        {
            int rv=q.poll();
            System.out.println(rv);
            for(int nbrs:map.get(rv).keySet())
            {
                in[nbrs]--;
                if(in[nbrs]==0) q.add(nbrs);
            }
        }
    }

    //inderees 
    public int[] indegree()
    {
        int[] in=new int[map.size() +1];
        for(int key:map.keySet())
        {
            for(int nbrs:map.get(key).keySet())
            {
                in[nbrs]++;
            }
        }
        return in;
    }
    public static void main(String[] args) {
        Topological_sort t = new Topological_sort(7);
		t.addEdge(1, 2,0);
		//t.addEdge(2, 1);
		t.addEdge(1, 4,0);
		t.addEdge(2, 3,0);
		t.addEdge(3, 6,0);
		t.addEdge(1, 2,0);
		t.addEdge(4, 3,0);
		t.addEdge(4, 6,0);
		t.addEdge(4, 5,0);
		t.addEdge(5, 7,0);
		t.addEdge(5, 6,0);
		t.addEdge(7, 6,0);
        System.out.println(Arrays.toString(t.indegree()));
        t.TopologicalSort();
        
    }
}
