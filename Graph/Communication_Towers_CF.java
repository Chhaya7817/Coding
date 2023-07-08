import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Communication_Towers_CF {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
        int[][] fre=new int[n+1][2];
        for (int i = 1; i <= n; i++) {
            int l=sc.nextInt();
            int r=sc.nextInt();
            fre[i][0]=l;
            fre[i][1]=r;
        }
        for (int i = 1; i <= n; i++) {
            map.put(i,new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u=sc.nextInt();
            int v=sc.nextInt();
            map.get(u).add(v);
            map.get(v).add(u);
        }
        //Lets start
        Queue<Integer> q=new LinkedList<>();
        q.add(1);
        ArrayList<Integer> visited=new ArrayList<>();
        // HashSet<Integer> visited=new HashSet<>();
        while(!q.isEmpty())
        {
            int rv=q.poll();
            if(visited.contains(rv))
                continue;
            visited.add(rv);
            // ans.add(rv);
            for(int nbrs:map.get(rv))
            {
                if(Math.max(fre[nbrs][0],fre[rv][0])<=Math.min(fre[rv][1],fre[nbrs][1]))
                {
                    fre[nbrs][0]=Math.max(fre[nbrs][0],fre[rv][0]);
                    fre[nbrs][1]=Math.min(fre[rv][1],fre[nbrs][1]);
                    q.add(nbrs);
                }
            }

        }
        // System.out.println(map);
        // System.out.println(Arrays.toString(fre));
        // System.out.println(visited);
        for(int v:visited)
        {
            System.out.print(v+" ");
        }

    }
}
