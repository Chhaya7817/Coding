import java.util.Arrays;

public class Longest_Common_Subsequence {
    public static void main(String[] args) {
        String s1="abcde";
        String s2="ace";
        System.out.println(lcs(s1, s2, 0, 0));
        System.out.println(lcs2(s1, s2, s1.length()-1, s2.length()-1));
        int[][] dp=new int[s1.length()][s2.length()];
        for(int[] a:dp)
        {
            Arrays.fill(a, -1);
        }
        System.out.println(lcsTD(s1, s2, 0, 0, dp));
        System.out.println(lcsBUU(s1, s2)+" bu");
    }
    //recursion
    public static int lcs(String s1,String s2,int i,int j) {
        if(i==s1.length() || j==s2.length())
            return 0;
        int ans=0;
        if(s1.charAt(i)==s2.charAt(j)){
            ans=1+lcs(s1,s2,i+1,j+1);
        }
        else{
            int fs=lcs(s1, s2, i+1, j);
            int ss=lcs(s1, s2, i , j+1);
            ans=Math.max(fs,ss);
        }
        return ans;
        
    }
    public static int lcs2(String s1,String s2,int i,int j) {
        if(i<0|| j<0)
            return 0;
        int ans=0;
        if(s1.charAt(i)==s2.charAt(j)){
            ans=1+lcs2(s1,s2,i-1,j-1);
        }
        else{
            int fs=lcs2(s1, s2, i-1, j);
            int ss=lcs2(s1, s2, i , j-1);
            ans=Math.max(fs,ss);
        }
        return ans;
        
    }
    public static int lcsTD(String s1,String s2,int i,int j,int[][] dp) {
        if(i==s1.length() || j==s2.length())
            return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int ans=0;
        if(s1.charAt(i)==s2.charAt(j)){
            ans=1+lcsTD(s1,s2,i+1,j+1,dp);
        }
        else{
            int fs=lcsTD(s1, s2, i+1, j,dp);
            int ss=lcsTD(s1, s2, i , j+1,dp);
            ans=Math.max(fs,ss);
        }
        return dp[i][j]=ans;
        
    }
    //Bottom up approach
    //filling table from start
    public static int lcsBU(String s1,String s2) {
        int[][] dp=new int[s1.length()+1][s2.length()+1];
        //remember at 0 index we have a character
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int ans=0;
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    ans=1+dp[i-1][j-1];
                }
                else{
                    int fs=dp[i-1][j];
                    int ss=dp[i][j-1];
                    ans=Math.max(fs,ss);
                }
                dp[i][j]=ans;
            }

        }

        return dp[dp.length-1][dp[0].length-1];//ans is at last of 2D array

        
    }
    //Bottom up approach
    //filling table from end
    public static int lcsBUU(String s1,String s2) {
        int[][] dp=new int[s1.length()+1][s2.length()+1];
        //remember at 0 index we have a character
        for (int i = dp.length-2; i >=0; i--) {
            for (int j = dp[0].length-2; j >=0; j--) {
                int ans=0;
                if(s1.charAt(0)==s2.charAt(0)){
                    ans=1+dp[i+1][j+1];
                }
                else{
                    int fs=dp[i+1][j];
                    int ss=dp[i][j+1];
                    ans=Math.max(fs,ss);
                }
                dp[i][j]=ans;
            }

        }

        return dp[0][0];//ans is at last of 2D array

        
    }
}
