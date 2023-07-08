public class Edit_Distance_LT {
    public static void main(String[] args) {
        String s1="Food";
        String s2="Monkey";
    }

    public static int MinOp(String s1,String s2,int i,int j)
    {
        if(i==s1.length()) return s2.length()-j;
        if(i==s2.length()) return s1.length()-i;
        int ans=0;
        if(s1.charAt(i)==s2.charAt(j))
        {
            ans=MinOp(s1, s2, i+1, j+1);
        }
        else
        {
            int I=MinOp(s1, s2, i, j+1);
            int D=MinOp(s1, s2, i+1, j);
            int R=MinOp(s1, s2, i+1, j+1);
            ans=Math.min(I,Math.min(D,R)) +1;
        }
        return ans;


    }

}
