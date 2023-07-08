public class Minimize_XOR_LTCODe {
    

    public static int minimizeXor(int num1, int num2) {
        int count=countBits(num2);
        int ans=0;
        for(int i=31;i>=0 && count >0;i--)
        {
            if((num1 & (1<<i) )  !=0){
                ans+=(1<<i);
                count--;
            }
        }

        for (int i = 0; i <= 31 && count>0; i++) {
            if((num1 & (1<<i)) ==0)
            {
                ans+=(1<<i);
            }
            
        }
        return ans;
    }
    public static int countBits(int num2)
    {
        int count=0;
        while(num2>0)
        {
            count++;
            num2=(num2 & (num2-1));
        }
        return count;
    }
}
