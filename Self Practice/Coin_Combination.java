public class Coin_Combination {
    public static void main(String[] args) {
        int[] coins={2,3,5,7};
        combination(coins, 10, 0, "");
    }
    public static void combination(int[] coins,int amt,int lcu,String ans)
    {
        if(amt==0)
        {
            System.out.println(ans);
            return;
        }
        // if(amt<0)
        // {
        //     return;
        // }
        for(int i=lcu;i<coins.length;i++)
        {
            if(amt-coins[i]>=0)
                combination(coins,amt-coins[i],i,ans+coins[i]+"");
        }
    }
}
