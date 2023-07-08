public class Queen_Permutaion {
    public static void main(String[] args) {
        permution(new boolean[4], 0, 2, "");
    }
    public static void permution(boolean [] boxes,int qpsf,int tq,String ans) {
        if(qpsf==tq)
        {
            System.out.println(ans);
            return;
        }
        for(int i=0;i<boxes.length;i++)
        {
            if(!boxes[i])
            {    
                boxes[i]=true;
                permution(boxes, qpsf+1, tq, ans+"q"+qpsf+"b"+i);
                boxes[i]=false;
            }
        }
        
    }
}
