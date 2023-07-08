package Assignment;
import java.util.*;
public class No_of_islands {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int[][] grid=new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j]=sc.nextInt();
                
            }
        
        }
         System.out.println( islands(grid));

    }
    public static int islands(int[][] grid)
    {
        int count=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==1)
                {
                    rec(grid, i, j);

                    count++;
                }
            }
        }
        return count;
    }
    public static void rec(int[][] grid,int row,int col) {
        if(grid[row][col]==0 || row>=grid.length||col>=grid[0].length)
        {
            return;
        }
        grid[row][col]=0;
        rec(grid, row+1, col);
        rec(grid, row, col+1);

    }
}
