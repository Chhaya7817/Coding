public class Coin_Permutaion {
    public static void main(String[] args) {
        int[] coins={2,3,5,6};
        permutation(coins, 10, "");
    }
    public static void permutation(int[] coins,int amt,String ans)
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
        for(int i=0;i<coins.length;i++)
        {
            if(amt-coins[i]>=0)
                permutation(coins,amt-coins[i],ans+coins[i]+"");
        }
    }
}
