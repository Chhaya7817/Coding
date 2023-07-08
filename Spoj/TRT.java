import java.util.Scanner;

public class TRT {
    public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int treats[]=new int[n];
		for(int i=0;i<n;i++) treats[i]=sc.nextInt();
        int[][] dp=new int[n][n];
		// System.out.println(maximumprofit(treats,0,n-1,dp));
		System.out.println(maximumprofit_BTUP(treats,n));
		
	}
    public static int maximumprofit_BTUP(int[] treats,int n)
    {
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++) dp[i][i]=n*treats[i];
        for(int i=1;i<n;i++)
        {
            for(int row=0;row<(n-i);row++)
            {
                int left=treats[row]*(n-i) +dp[row+1][row+i];
                int right=treats[row+i]*(n-i) +dp[row][row+i-1];
                dp[row][row+i]=Math.max(left,right);
            }
        }
        return dp[0][n-1];
    }
	public static int maximumprofit(int[] treats,int i,int j,int[][] dp)
	{
		if(i>j) return 0;
        if(dp[i][j]!=0) return dp[i][j];
		int left=treats[i]*(treats.length-(j-i)) +maximumprofit(treats,i+1,j,dp);
		int right=treats[j]*(treats.length-(j-i)) +maximumprofit(treats,i,j-1,dp);
		return dp[i][j]= Math.max(left,right);
		
	}
}
