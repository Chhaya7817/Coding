import java.util.Stack;
import java.util.*;

public class JourneyToTheMoon_hrank {
    public static Map<Integer,ArrayList<Integer>> map;

    public static void addedge(int x,int y)
    {
        map.get(x).add(y);
        map.get(y).add(x);
    }

    public static int dfs()
    {
        Stack<Integer> st=new Stack();
        Set<Integer> vis=new HashSet<>();
        int ans=0,res=0;

        for(int i=0;i<map.size();i++)
        {
            st.push(i);
            if(vis.contains(i)) continue;
            while(!st.isEmpty())
            {
                int rv=st.pop();

                vis.add(rv);
                for(int nbrs:map.get(rv))
                {
                    if(!vis.contains(nbrs))
                    {
                        st.push(nbrs);
                    }
                }

            }
            System.out.println(vis);
            if(ans==0)
                ans=vis.size();
        }
        System.out.println(vis);
        res=ans*(vis.size()-ans);
        return res;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int p=sc.nextInt();
        map=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            map.put(i,new ArrayList<>());
        }
        for(int i=0;i<p;i++)
        {
            int x=sc.nextInt();
            int y=sc.nextInt();
            addedge(x,y);
        }
        System.out.println(dfs());

    }

    public static int journeyToMoon(int n, List<List<Integer>> astronaut) {
        // Write your code here
        map=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            map.put(i,new ArrayList<>());
        }
        for(List<Integer> list:astronaut)
        {
            int x=list.get(0);
            int y=list.get(1);
            addedge(x,y);
        }

        return dfs();
    
        }
}
