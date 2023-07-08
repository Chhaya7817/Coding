import java.net.NetPermission;
import java.util.HashMap;
import java.util.*;

public class Weather {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {

            int n=sc.nextInt();
            int k=sc.nextInt();
            int[] a=new int[n];
            int[] b=new int[n];
            TreeMap<Integer,ArrayList<Integer>> mapa=new TreeMap<>();
            TreeMap<Integer,Integer> mapb=new TreeMap<>();
            for(int i=0;i<n;i++) {a[i]=sc.nextInt();mapa.put(a[i],new ArrayList<>());}
            for(int i=0;i<n;i++) {

                mapa.get(a[i]).add(i);
            }
            for(int i=0;i<n;i++){ b[i]=sc.nextInt(); mapb.put(b[i],mapb.getOrDefault(b[i],0)+1);}
            int l=0;
            for(int keys:mapa.keySet())
            {
                for(int v:mapa.get(keys))
                a[l++]=v;
            }
            l=0;
            for(int key:mapb.keySet())
            {
                while(mapb.get(key)!=0)
                {
                        b[a[l++]]=key;
                        mapb.put(key,mapb.get(key)-1);
                }
            }
            for (int i = 0; i < b.length; i++) {
                System.out.print(b[i]+" ");
                
            }




        }
    }
}
