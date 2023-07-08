import java.util.*;
public class CF_1847 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int k=sc.nextInt();
            int arr[]=new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i]=sc.nextInt();
            }
            ArrayList<Integer>  check=new ArrayList<>();
            for(int i=0;i<n-1;i++)
            {
                check.add(Math.abs(arr[i]-arr[i-1]));
            }
            Collections.sort(check);
            for(int i=1;i<k;i++)
            {
                check.remove(check.size()-1);
            }

            int ans=0;
            for (int i = 0; i < check.size(); i++) {
                ans+=check.get(i);
            }

            System.out.println(ans);



        }
    }
}
