public class Recover_BST {
     public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode() {}
             TreeNode(int val) { this.val = val; }
             TreeNode(int val, TreeNode left, TreeNode right) {
                 this.val = val;
                 this.left = left;
                 this.right = right;
             }
         }

         class Solution {
            public void recoverTree(TreeNode root) {
                List<TreeNode> list =new  ArrayList<>();
                Inorder(root,list);
                TreeNode fst=null;
                TreeNode snd=null;

                for(int i=0;i<list.size()-1;i++)
                {
                    if(list.get(i).val >list.get(i+1).val){
                        fst=list.get(i);
                        break;
                    }
                }
                for(int i=list.size()-1;i>0;i--)
                {
                    if(list.get(i).val <list.get(i-1).val){
                        snd=list.get(i);
                        break;
                    }
                }
                int temp=fst.val;
                fst.val=snd.val;
                snd.val=temp;
            }

            public void Inorder(TreeNode root,List<TreeNode> list)
            {
                if(root==null) return;

                Inorder(root.left,list);
                list.add(root);
                Inorder(root.right,list);
            }

            TreeNode prev;
            TreeNode fst;
            TreeNode sec;
            public void recoverTree_Space(TreeNode root) {
                Inorde(root);
                int temp=fst.val;
                fst.val=sec.val;
                sec.val=temp;
            }
            public void Inorde(TreeNode root)
            {
                if(root==null) return ;

                Inorde(root.left,list);
                if(prev!=null && prev.val>root.val)
                {
                    if(fst==null) fst=prev;
                    else sec=root;
                }
                prev=root;
                Inorde(root.right,list);
            }
        }
        
}
