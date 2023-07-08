package Assignment;

import java.util.*;

public class Clone_Graph {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=1;i<=n;i++)
        {
            map.put(i,new ArrayList<>());
        }
        for(int i=1;i<=n;i++)
        {
            int c=sc.nextInt();
            while(c-->0)
            {
                int v=sc.nextInt();
                if(!map.get(i).contains(v))
                {
                    map.get(i).add(v);
                }
            }
        }
        System.out.println(map);
    }
}
