public class Segment_Tree {

    public void BuildTree(int[] arr,int s,int e,int[] tree,int index){
        if(s==e){
            tree[index]=arr[s];
            return;
        }

        int mid=(s+e)/2;
        BuildTree(arr,s,mid,tree,2*index);
        BuildTree(arr,mid+1,e,tree,2*index +1);
        tree[index]=Math.min(tree[2*index],tree[2*index+1]);
        return;

    }

    public int Query(int tree[],int s,int e,int qs,int qe,int index)
    {
        //complete overlap
        if(s>=qs && e<=qe) return tree[index];

        //no overlap
        if(e<qs || qe<s) return Integer.MAX_VALUE;

        //partial overlap

        int mid=(s+e)/2;
        int left=Query(tree,s,mid,qs,qe,2*index);
        int right=Query(tree,mid+1,e,qs,qe,2*index+1);
        return Math.min(left,right);

    }

    // /Point update
    public void updateNode(int[] tree,int s,int e,int i,int increment ,int index){
        if(i<s || i>e) return ;
        if(s==e) {
            tree[index]+=increment;
            return;
        }
        int mid=(s+e)/2;
        updateNode(tree, s, mid, i, increment, 2*index);
        updateNode(tree, mid+1,e, i, increment, 2*index+1);
        tree[index]=Math.min(tree[2*index], tree[2*index+1]);
        
    }
    
}
