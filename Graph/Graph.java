import java.util.*;
import java.util.HashSet;
import java.util.HashMap;

public class Graph {
    private HashMap<Integer, HashMap<Integer,Integer>> map=new HashMap<>();
    public Graph(int v)
    {
        for (int i = 1; i <=v; i++) {
            map.put(i,new HashMap<Integer,Integer>());
        }
    }
    public void AddEdge(int v1,int v2,int cost)
    {
        map.get(v1).put(v2,cost); //v1---->v2
        map.get(v2).put(v1,cost);//v2 --->v1
    }

    public boolean ContainsEdge(int v1,int v2)
    {
        return map.get(v1).containsKey(v2);
    }
    public boolean Containsvertex(int v1)
    {
        return map.containsKey(v1);
    }

    public int noOfEdge(int v1)
    {
        int sum=0;
        for(int key:map.keySet())
        {
            sum+=map.get(key).size();
        }
        return sum/2;
    }
    public void remove(int v1,int v2)
    {
        if(ContainsEdge(v1, v2))
        {
            map.get(v1).remove(v2);
            map.get(v2).remove(v1);
        }
    }
    public void removevertex(int v1)
    {
        for(int key: map.get(v1).keySet())
        {
            map.get(key).remove(v1);
        }
        map.remove(v1);
    }

    public void display()
    {
        for(int key:map.keySet())
            System.out.println(key+"->  "+map.get(key));
    }
    public boolean hasPath(int src,int des,HashSet<Integer> visited)
    {
        if(src==des)
            return true;
            
        visited.add(src); 
        for(int nbrs:map.get(src).keySet())
        {
            if(!visited.contains(nbrs))
            {
                boolean ans=hasPath(src, des,visited);
            if(ans)
                return ans;
            }
        }
        visited.remove(src);
        return false;
    }
    public void PrintAllPath(int src,int des,HashSet<Integer> visited,String ans)
    {
        if(src==des)
        {
            System.out.println(ans+src);
            return;
        }
            
        visited.add(src); 
        for(int nbrs:map.get(src).keySet())
        {
            if(!visited.contains(nbrs))
            {
                PrintAllPath(src, des, visited, ans+src);
            
            }
        }
        visited.remove(src);
    }
    public boolean BFS(int src,int des)
    {
        HashSet<Integer> visited=new HashSet<>();
        Queue<Integer> q=new LinkedList<>();
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
            if(rv==des)
            {
                return true;
            }
            //step 5: add neighbours
            for(int nbrs:map.get(rv).keySet())
            {
                if(!visited.contains(nbrs))
                {
                    q.add(nbrs);
                }
            }

            
        }
        return false;
    }

    public boolean DFS(int src,int des)
    {
        HashSet<Integer> visited=new HashSet<>();
        Stack<Integer> st=new Stack<>();
        st.push(src);
        while(!st.isEmpty())
        {
            //step 1 : remove
            int rv=st.pop();
            //step 2 :if already visited the ignore it
            if(visited.contains(rv))
                continue;
            //step 3: visited
            visited.add(rv);
            //step 4: Self work
            if(rv==des)
            {
                return true;
            }
            //step 5: add neighbours
            for(int nbrs:map.get(rv).keySet())
            {
                if(!visited.contains(nbrs))
                {
                    st.push(nbrs);
                }
            }

            
        }
        return false;
    }
    public void BFT()
    {
        HashSet<Integer> visited=new HashSet<>();
        Queue<Integer> q=new LinkedList<>();
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
                System.out.println(rv);
                //step 5: add neighbours
                for(int nbrs:map.get(rv).keySet())
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
