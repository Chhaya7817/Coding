import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Two_Arrays_and_Sumof_Functions_CF1165E {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long[] a=new long[n];
        Long[] b=new Long[n];
        int mod=998244353;
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextLong();
            a[i]=a[i]*(n-i)*(i+1);
        }
        for(int i=0;i<n;i++)
        {
            b[i]=sc.nextLong();
        }
        Arrays.sort(a);
        Arrays.sort(b,Collections.reverseOrder());
        long ans=0;
        for(int i=0;i<n;i++)
        {
            ans+=((a[i]*b[i])%mod);
            ans%=mod;
        }
        System.out.println(ans);

    }
}
