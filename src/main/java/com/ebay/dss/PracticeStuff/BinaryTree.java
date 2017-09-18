package com.ebay.dss.PracticeStuff;

class BinaryTree 
{
     TreeNode root;
  
    /* Compute the "maxDepth" of a tree -- the number of 
       nodes along the longest path from the root node 
       down to the farthest leaf node.*/
    int maxDepth(TreeNode node) 
    {
        if (node == null)
            return 0;
        else
        {
            /* compute the depth of each subtree */
            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);
  
            /* use the larger one */
            if (lDepth > rDepth)
                return (lDepth + 1);
             else
                return (rDepth + 1);
        }
    }
    
    boolean hasPathSum1(TreeNode root, int sum){
    	
    	if(root==null){
    		return false;
    	}
    	
    	if(root.left==null && root.right==null && root.data==sum){
    		return true;
    	}
    	
    	return hasPathSum1(root.left,sum-root.data) || hasPathSum1(root.right, sum-root.data);
    
    }
      
    /* Driver program to test above functions */
    public static void main(String[] args) 
    {
        BinaryTree tree = new BinaryTree();
  
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.left.left.left = new TreeNode(10);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(4);
        
        
        
        
  
        System.out.println("Height of tree is : " + tree.maxDepth(tree.root));
        System.out.println("Yes or no? : " + tree.hasPathSum1(tree.root, 8));
    }
}
 