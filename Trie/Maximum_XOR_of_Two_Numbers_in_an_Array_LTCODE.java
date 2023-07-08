public class Maximum_XOR_of_Two_Numbers_in_an_Array_LTCODE {
    public static class Node{
        Node zero;
        Node one;
    }
    public static void insert(Node root,int val){
        Node curr=root;
        for(int i=31;i>=0;i--)
        {
            if((val & (i<<i))==0){
                if(curr.zero!=null){
                    curr=curr.zero;
                }
                else
                {
                    Node nn=new Node();
                    curr.zero=nn;
                    curr=nn;
                }
            }
            else
            {
                if(curr.one!=null){
                    curr=curr.one;
                }
                else
                {
                    Node nn=new Node();
                    curr.one=nn;
                    curr=nn;
                }
            
            }
        }
    }

    public static int getmaxXor(Node root,int val){
        int num=0;
        Node curr=root;
        for(int i=31;i>=0;i--)
        {
            int bit=(val & (1<<i));
            if(bit==0)
            {
                if(curr.one!=null){
                    num+=(1<<i);
                    curr=curr.one;
                }
                else{
                    curr=curr.zero;
                }

            }
            else
            {
                if(curr.zero!=null){
                    num+=(1<<i);
                    curr=curr.zero;
                }
                else{
                    curr=curr.one;
                }
            }
        }
        return num;
    }
    public static void main(String[] args) {
        Node root=new Node();
        int[] arr={10,30};
        for (int i : arr) {
            insert(root, i);
        }
        int xor=Integer.MIN_VALUE;
        for (int i : arr) {
            xor=Math.max(getmaxXor(root, i), xor);
        }
        System.out.println(xor);

    }


}
