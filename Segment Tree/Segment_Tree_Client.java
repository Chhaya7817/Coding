import java.util.Arrays;

public class Segment_Tree_Client {
    public static void main(String[] args) {
        Segment_Tree t=new Segment_Tree();
        int n=6;
        int [] arr={1,3,2,-5,6,4};
        int[] tree=new int[4*n+1];
        t.BuildTree(arr, 0, n-1, tree,1);
        System.out.println(Arrays.toString(tree));

        System.out.println(t.Query(tree, 0, n-1, 0, 2, 1));
        System.out.println(t.Query(tree, 0, n-1, 6, 9, 1));
        System.out.println(t.Query(tree, 0, n-1, 1, 4, 1));
        System.out.println(t.Query(tree, 0, n-1, 1, 2, 1));
        t.updateNode(tree, 0, n-1, 3, 2, 1);
        System.out.println(Arrays.toString(tree));



    }
}
