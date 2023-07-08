import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Rudolph_1846B {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            char[][] tic=new char[3][3];
            for (int i = 0; i < tic.length; i++) {
                String str=sc.next();
                for (int j = 0; j < str.length(); j++) {
                    tic[i][j]=str.charAt(j);
                }
            }
            // for(char ch[]:tic)
            // {
            //     System.out.println(Arrays.toString(ch));
            // }
            char ans=play(tic);
            if(ans=='N') System.out.println("DRAW");
            else 
            System.out.println(ans);


        }

        Collections.sort(vv, new Comparator<T>() {
            
        });
    }
   
    public static char play(char[][] tic)
    {
        for(int i=0;i<3;i++)
        {
            if(tic[i][0]=='X' && tic[i][1]=='X' && tic[i][2]=='X')
            return 'X';
            if(tic[i][0]=='O' && tic[i][1]=='O' && tic[i][2]=='O')
            return 'O';
            if(tic[i][0]=='+' && tic[i][1]=='+' && tic[i][2]=='+')
            return '+';
        }
        for(int i=0;i<3;i++)
        {
            if(tic[0][i]=='X' && tic[1][i]=='X' && tic[2][i]=='X')
            return 'X';
            if(tic[0][i]=='O' && tic[1][i]=='O' && tic[2][i]=='O')
            return 'O';
            if(tic[0][i]=='+' && tic[1][i]=='+' && tic[2][i]=='+')
            { System.out.println("p");
                return '+';}
        }
        
        if(tic[0][0]=='X' && tic[1][1]=='X' && tic[2][2]=='X')
        return 'X';
        if(tic[0][0]=='O' && tic[1][1]=='O' && tic[2][2]=='O')
        return 'O';
        if(tic[0][0]=='+' && tic[1][1]=='+' && tic[2][2]=='+')
        return '+';

        if(tic[0][2]=='X' && tic[1][1]=='X' && tic[2][0]=='X')
        return 'X';
        if(tic[0][2]=='O' && tic[1][1]=='O' && tic[2][0]=='O')
        return 'O';
        if(tic[0][2]=='+' && tic[1][1]=='+' && tic[2][0]=='+')
        return '+';

        return 'N';

        
    }
}
