import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;
public class KosaRaju_Algo {
    HashMap<Integer,HashMap<Integer,Integer>> map=new HashMap<>();
    public KosaRaju_Algo(int v)
    {
        for (int i = 0; i <v; i++) {
            map.put(i,new HashMap<>());
        }
    }
    public void addEdge(int v1,int v2)
    {
        map.get(v1).put(v2,2);
    }
    public int kosaRajuAlgo()
    {
        Stack<Integer> st=new Stack<>();
        HashSet<Integer> visited=new HashSet<>();
        //1....
        dfs(visited,st,0);
        HashMap<Integer,HashMap<Integer,Integer>> map1=new HashMap<>();
        //2....
        System.out.println(map);
        transposeGraph(map1);
        System.out.println(map1);

        visited=new HashSet<>();
        int count=0;
        while(!st.isEmpty())
        {
            int top=st.pop();
            if(!visited.contains(top))
            {
                System.out.print("component top:"+top+"=");

                dfs2(map1,visited,top);
                count++;
                System.out.println();
            }
            
            
            
            
        }
        return count;

    }

    private void dfs2(HashMap<Integer, HashMap<Integer, Integer>> map1, HashSet<Integer> visited, int top) {
        visited.add(top);
        System.out.print(top+" ");
        for(int nbrs:map1.get(top).keySet())
        {
            if(!visited.contains(nbrs))
            {
                dfs2(map1, visited, nbrs);
            }
        }
    }
    private void transposeGraph(HashMap<Integer, HashMap<Integer, Integer>> map1) {
        for(int key:map.keySet())
        {
            
            map1.put(key,new HashMap<>());
        }
        for (int key : map.keySet()) {
            for(int nbrs:map.get(key).keySet())
            {
                // if(!map1.get(nbrs))
                map1.get(nbrs).put(key,2);
            }
        }
    }
    private void dfs(HashSet<Integer> visited, Stack<Integer> st, int i) {
        visited.add(i);
        for(int nbrs:map.get(i).keySet())
        {
            if(!visited.contains(nbrs))
            {
                dfs(visited, st, nbrs);
            }
        }
        st.push(i);
    }
    //To Find Strongly connected components in directed graph
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        KosaRaju_Algo ks=new KosaRaju_Algo(n);
        int m=sc.nextInt();
        for (int i = 0; i < m; i++) {
            int e1=sc.nextInt();
            int e2=sc.nextInt();
            ks.addEdge(e1, e2);
        }
        System.out.println(ks.kosaRajuAlgo());

    }
}
