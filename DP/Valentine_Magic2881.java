import java.util.Arrays;

public class Valentine_Magic2881 {
    public static void main(String[] args) {
        int boys[]={2,11,3};
        int[] girls={5,7,3,2};
        Arrays.sort(boys);
        Arrays.sort(girls);
        System.out.println(Mindiff(boys, girls, 0, 0));
    }

    public static int Mindiff(int[] boys,int[] girls,int i,int j) {
        if(i==boys.length) return 0;
        if(j==girls.length) return 100000000;
        int pair=Math.abs(boys[i]-girls[j]) +Mindiff(boys, girls, i+1, j+1);
        int noPair=Mindiff(boys, girls, i, j+1);
        return  Math.min(pair, noPair);
    }
}
