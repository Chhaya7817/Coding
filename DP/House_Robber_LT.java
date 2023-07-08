import java.util.Arrays;

public class House_Robber_LT {
    public static void main(String[] args) {
        int[] arr={2,3,9,42,3};
        int [] dp=new int[arr.length];
        Arrays.fill(dp,-1);

    }
    //using recursion
    public static int Robber(int[] arr,int i)
    {
        if(i>=arr.length)
            return 0;
        int rob=arr[i]+Robber(arr, i+2);
        int dontrob=Robber(arr, i+1);
        return Math.max(rob,dontrob);
    }

    //using DP top down
    public static int Robber_DP(int[] arr,int i,int[] dp)
    {
        if(i>=arr.length)
            return 0;
        if(dp[i]!=-1)
        {
            return dp[i];
        }
        int rob=arr[i]+Robber_DP(arr, i+2,dp);
        int dontrob=Robber_DP(arr, i+1,dp);
        return dp[i]=Math.max(rob,dontrob);
    }
    //using DP  bottom up
    // filling dp table from back side
    public int Robber_Bottm(int[] arr) {
        if(arr.length==1)
            return arr[0];
        int[] dp=new int[arr.length];
        dp[0]=arr[0];
        dp[1]=Math.max(arr[0],arr[1]);
        for (int j = 2; j < dp.length; j++) {
            int rob=arr[j]+dp[j-2];
            int dontrob=dp[j-1];
            dp[j]=Math.max(rob,dontrob);
        }
        return dp[arr.length-1];
    }


}
