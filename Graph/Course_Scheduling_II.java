
import java.util.*;
import java.util.HashMap;
public class Course_Scheduling_II {
    public HashMap<Integer, ArrayList<Integer>> map=new HashMap<>();
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int res[]=new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            
            
            
            map.put(i,new ArrayList<Integer>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int v1=prerequisites[i][0];
            int v2=prerequisites[i][1];
            map.get(v2).add(v1);
        }
        return TopologicalSort();
        
    }
    public int[] TopologicalSort()
    {
        
        int [] in=indegree();
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<in.length;i++)
        {
            if(in[i]==0)
                q.add(i);
        }
        int[] order=new int[map.size()];
        int count=0;
        while(!q.isEmpty())
        {
            int rv=q.poll();
            order[count]=rv;
            count++;
            System.out.println(rv);
            for(int nbrs:map.get(rv))
            {
                in[nbrs]--;
                if(in[nbrs]==0) q.add(nbrs);
            }
        }
        return count==map.size() ?order:new int[0];
    }

    //inderees 
    public int[] indegree()
    {
        int[] in=new int[map.size()];
        for(int key:map.keySet())
        {
            for(int nbrs:map.get(key))
            {
                in[nbrs]++;
            }
        }
        
        return in;
    }

}
