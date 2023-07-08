import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int ble[]=new int[n];
            
            
            for(int i=0;i<n;i++)
            {
                ble[i]=sc.nextInt();
            }
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for(int i=1;i<=n;i++)
            {
                pq.offer(ble[i-1]);
                int median=0;
                int mid=i/2;
                if(i%2==1)
                {
                    Iterator<Integer> iterator = pq.iterator();
                    while (iterator.hasNext() && mid > 0) {
                        Integer element = iterator.next();
                    if (--mid == 0) {
                        median=element;
                        
                    }
                    }
                }
                else
                {
                    Iterator<Integer> iterator = pq.iterator();
                    while (iterator.hasNext() && mid > 0) {
                        Integer element = iterator.next();
                        --mid;
                    if (mid == 0||mid==1) {
                        median+=element;
                        
                    }
                    
                }
                median/=2;
                
            }
            System.out.print(i+" "+median+" ");
            }
System.out.println();
        }
    }
}

