package Assignment;

import java.util.*;

public class Religious_People {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int m=sc.nextInt();
            int a=sc.nextInt();
            int b=sc.nextInt();
            HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
            for (int i = 1; i <= n; i++) {
                map.put(i,new ArrayList<>());

            }
            for (int i = 0; i < m; i++) {
                int u=sc.nextInt();
                int v=sc.nextInt();
                map.get(u).add(v);
                map.get(v).add(u);

            }
            if(a<=b)
            {
                System.out.println(n*a);
                return;
            }
            Set<Integer> visited=new HashSet<>();
            int cost=0;
            for(int i=1;i<=n;i++)
            {
                if(!visited.contains(i))
                {
                    cost+=a;
                    int edges=BFS(map, visited, i);
                    cost+=edges*b;
                }
            }
            System.out.println(cost);
        }

    }
    public static int BFS(HashMap<Integer,ArrayList<Integer>> map,Set<Integer> visited,int src) {
        Queue<Integer> q=new LinkedList<>();


        int c=0;
        q.add(src);
        while(!q.isEmpty())
        {
            int rv=q.poll();
            if(visited.contains(rv))
                continue;
            visited.add(rv);
            c++;
            for(int nbrs:map.get(rv))
            {
                if(!visited.contains(nbrs))
                {
                    q.add(nbrs);
                }
            }
            

        }
        return c;
        
    }
}
