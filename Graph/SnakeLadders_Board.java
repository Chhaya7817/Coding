import java.util.*;
import java.util.HashMap;

public class SnakeLadders_Board {

   public static  Map<Integer,ArrayList<Integer>> map= new HashMap<>();

   public static void addEdge(int x,int y){
        map.get(x).add(y);
   }

   public static int bfs(int src,int des){
    Map<Integer,Integer> dis=new HashMap<>();
    for(int key:map.keySet())
    {
        dis.put(key,Integer.MAX_VALUE);

    }
    dis.put(src,0);

    Queue<Integer> q=new LinkedList<>();
    Set<Integer> vis=new HashSet<>();
    q.add(src);
    while(!q.isEmpty()){
        int rs=q.poll();
        vis.add(rs);
        if(rs==des) return dis.get(des);
        // if(vis.contains(rs) ) continue;
        System.out.print(rs+" ");
        for(int nbrs:map.get(rs))
        {
            if(!vis.contains(nbrs))
            {
                q.add(nbrs);
                if(dis.get(nbrs)>=dis.get(rs)+1)
                    dis.put(nbrs,dis.get(rs)+1);
                
            }
        }


    }
    // System.out.println(dis);
    return dis.get(des);
   }
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int l=sc.nextInt();
            int s=sc.nextInt();

            for(int i=0;i<=n;i++)
            {
                map.put(i,new ArrayList<>());
            }
            int[] board=new int[n+1];
            for(int i=0;i<l;i++)
            {
                int x=sc.nextInt();
                int y=sc.nextInt();
                board[x]=y;
            }
            for(int i=0;i<s;i++)
            {
                int x=sc.nextInt();
                int y=sc.nextInt();
                board[x]=y;
            }

            for(int i=1;i<=n;i++)
            {
                for(int j=1;j<=6;j++)
                {
                    int p=i+j;
                      
                    if(p<=n)
                    {
                        if(board[p]>p)
                            addEdge(i, board[p]);
                        else
                            addEdge(i, p);
                    }
                }
            }
            addEdge(n, n);
            // System.out.println(map);
            System.out.println(bfs(1, n));




        }
    }
}
