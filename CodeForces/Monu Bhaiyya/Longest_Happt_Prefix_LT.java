public class Longest_Happt_Prefix_LT {
    public String longestPrefix(String s) {
        int n=s.length();
        int dp[]=new int[n];
        int len=0;
        for (int i = 1; i < dp.length;) {
            if(s.charAt(len)==s.charAt(i)){
                len++;
                dp[i]=len;
                i++;
            }
            else{
                if(len>0){
                    len=dp[len-1];
                }else
                {
                    dp[i]=0;
                    i++;
                }
            }
        }

        return s.substring(0, dp[n-1]);
    }
}
