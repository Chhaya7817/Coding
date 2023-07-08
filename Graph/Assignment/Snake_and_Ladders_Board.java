package Assignment;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Snake_and_Ladders_Board {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int l=sc.nextInt();
            int s=sc.nextInt();
            int board[]=new int[n];
            for (int i = 0; i < board.length; i++) {
                board[i]=-1;
            }

            for (int i = 0; i < l; i++) {
                int u=sc.nextInt();
                int v=sc.nextInt();
                board[u-1]=v;
                
            }
            for (int i = 0; i < s; i++) {
                int u=sc.nextInt();
                int v=sc.nextInt();
                board[u-1]=v;
                
            }
            System.out.println(winner(board,n));

        }
    }
    private static int winner(int[] board, int n) {
        Queue<pair> q=new LinkedList<>();
        boolean[] visited=new boolean[n];
        q.add(new pair(0, 0));
        visited[0]=true;
        while(!q.isEmpty())
        {
            pair rv=q.peek();
            if(rv.pos==n-1)
                break;
            rv=q.poll();
            int v=rv.pos;
            for(int k=v+1;k<=(v+6)&& k<n;k++ )
            {
                if(!visited[k])
                {
                    visited[k]=true;
                    int next;
                    if(board[k]!=-1)
                        next=board[k];
                    else
                        next=k;
                    q.add(new pair(next, rv.dis+1));
                }
            }

        }
        return q.peek().dis;
    }
    public static class pair{
        int pos;
        int dis;
        public pair(int pos,int dis)
        {
            this.pos=pos;
            this.dis=dis;
        }
    }
}
