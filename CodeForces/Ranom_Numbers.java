import java.util.Scanner;

public class Ranom_Numbers{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            String str=sc.next();
            int out=Integer.MIN_VALUE;
            StringBuilder st=new StringBuilder(str);
            for (int i = 0; i < str.length(); i++) {
                st.setCharAt(i, 'E');
                out=Math.max(out, solve(st.toString()));
            }
            System.out.println(out);

        }
    }
    public static int solve(String str)
    {
        int ind=str.length()-1;
            char high=str.charAt(str.length()-1);
            int res=values(high);
           
            
            for(int i=str.length()-2;i>=0;i--)
            {
                if(high<=str.charAt(i)) res+=values(str.charAt(i));
                else res-=values(str.charAt(i));
                if(str.charAt(i)>high) high=str.charAt(i);

            }
            return res;

    }
    public static int values(char ch) {
        switch(ch){
            case 'A': return 1;
            case 'B': return 10;
            case 'C': return 100;
            case 'D': return 1000;
            case 'E': return 10000;

        }
        return -1;
        
    }
}