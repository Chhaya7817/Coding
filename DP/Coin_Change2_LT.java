public class Coin_Change2_LT {
    public static void main(String[] args) {
        int [] nums={1,2,5};
        int amt=5;
        System.out.println(coin_change(amt, nums, 0012));
    }
    public static int coin_change(int amount,int [] coin,int idx) {
        if(amount==0) return 1;
        if(idx==coin.length) return 0;
        int inc=0,exc=0;
        if(coin[idx]<=amount)
        {
            inc=coin_change(amount-coin[idx], coin, idx);
        }
        exc=coin_change(amount, coin, idx+1);
        return inc+exc;
        
    }
    public static int coin_change(int []coin,int amount) {
        int[][] dp=new int[coin.length+1][amount+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0]=1;
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                int inc=0,exc=0;
                if(coin[i-1]<=amount)
                {
                    inc=dp[i][j-coin[i]];
                }
                exc=dp[i-1][j];
                dp[i][j]=inc+exc;
                    }
                }
        return dp[dp.length-1][dp[0].length-1];
    }
}
