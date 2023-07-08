package Graph;

import java.util.*;

public class MST_0_1_Optimise {
    static TreeSet<Integer>[] arr;//Hashset at every index of array
    static Set<Integer> set;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        arr=new TreeSet[n];
        for (int i = 0; i < n; i++) {
            arr[i]=new TreeSet<>();
            
        }
        for (int i = 0; i < m; i++) {
            int a=sc.nextInt()-1;
            int b=sc.nextInt()-1;
            arr[a].add(b);
            arr[b].add(a);
        }
        set=new TreeSet<>();
        // for(HashSet<Integer> hs:arr)
        // {
        //     System.out.println(hs);
        // }
        for(int i=0;i<n;i++)
        {
            set.add(i);
        }
        int ans=0;
        for(int i=0;i<n;i++)
        {
            if(set.remove(i))
            {
                ans++;
                dfs(i);
            }
        }
        System.out.println(ans-1);


    }
    public static void dfs(int x) {
        List<Integer> ll=new ArrayList<>();
        for(int i:set)
        {
            if(!arr[x].contains(i))
            {
                ll.add(i);
            }
        }
        for(int i:ll)
        {
            set.remove(i);
        }
        for(int i:ll)
        {
            dfs(i);
        }
        
        
    }
}
