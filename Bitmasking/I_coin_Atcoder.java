import java.util.Arrays;
import java.util.Scanner;

public class I_coin_Atcoder {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        double [] arr=new double[n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextDouble();
        }
        double dp[][]=new double[(n+4)/2][n];
        for(double[] d:dp) {
            Arrays.fill(d,-1);
        }
        System.out.println(Answer(arr, 0, (n+1)/2,dp));
    }
    public static double Answer(double[] p,int i,int h,double dp[][]) {
        if(h==0) return 1;
        if(i==p.length) return 0;
        if(dp[h][i]!=-1) return dp[h][i];
        double ans=p[i]* Answer(p, i+1, h-1,dp) + (1-p[i])*Answer(p, i+1, h,dp);
        return dp[h][i]=ans;
    }


}
