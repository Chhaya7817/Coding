public class Queen_Combination {
    public static void main(String[] args) {
        combination(new boolean[4],0, 0, 2, "");
    }
    public static void combination(boolean [] boxes,int start,int qpsf,int tq,String ans) {
        if(qpsf==tq)
        {
            System.out.println(ans);
            return;
        }
        for(int i=start;i<boxes.length;i++)
        {
            if(!boxes[i])
            {    
                boxes[i]=true;
                combination(boxes, i+1,qpsf+1, tq, ans+"q"+qpsf+"b"+i);
                boxes[i]=false;
            }
        }
        
    }
}
