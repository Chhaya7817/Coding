public class fibonacci{
    public static void main(String[] args) {
        int n=145;
        int[] dp=new int[n+1];
        System.out.println(fibo_TD(n, dp));
        // System.out.println(fiborec(n));
        //bottom down approach DP
        
        System.out.println(fibo_BU(n));

    }
    public static int fiborec(int n) {
        if(n==0||n==1)
            return n;
        return fiborec(n-1)+fiborec(n-2);
        
    }
    //top down approach DP
    public static int fibo_TD(int n,int[] dp) {
        // space complexity=O(n+1)
        // time complexity=O(n) no. of levels
        if(n==0||n==1)
            return n;
        if(dp[n]!=0)
            return dp[n];
        return dp[n]=fiborec(n-1)+fiborec(n-2);
        
    }
    //bottom down approach DP-----faster than top down
    //no stack space
    public static int fibo_BU(int n) {
        // space complexity=O(n+1)
        // time complexity=O(n) no. of levels
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<dp.length;i++)
        {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
        
    }
}