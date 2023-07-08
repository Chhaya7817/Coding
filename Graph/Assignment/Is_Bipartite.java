package Assignment;

import java.util.*;

public class Is_Bipartite {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i,new ArrayList<>());
        }
        for(int i=0;i<n;i++)
        {
            int u=sc.nextInt();
            int v=sc.nextInt();
            map.get(u).add(v);
            map.get(v).add(u);
        }
		if(BFS_Odd_Cycle_Detection(map))
			System.out.println("1");
		else
			System.out.println("0");
    }
    public static boolean BFS_Odd_Cycle_Detection(HashMap<Integer,List<Integer>> map)
	{
		Map<Integer,Integer> visited=new HashMap<>();
		Queue<B_pair> q=new LinkedList<>();
		for(int i=0;i<map.size();i++)
		{
			if(visited.containsKey(i))
				continue;
			q.add(new B_pair(i, 0));

			while(!q.isEmpty())
			{
				B_pair rv=q.poll();
				if(visited.containsKey(rv.vtx))
				{
					if(visited.get(rv.vtx)!=rv.dis)
					{
						return false;
					}
					else
						continue;
				}
				visited.put(rv.vtx,rv.dis);
				for(int nbrs:map.get(rv.vtx))
				{
					if(!visited.containsKey(nbrs))
					{
						visited.put(nbrs,rv.dis+1);
					}
				}
			}
		}

		return true;
	}
	public static class B_pair {
		int vtx;
		int dis;
		public B_pair(int vtx,int dis)
		{
			this.vtx=vtx;
			this.dis=dis;
		}
	}
}

