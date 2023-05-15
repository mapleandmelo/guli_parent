package algorithm.daimasuixianglu.erchashu;

/**
 * @Auther:liujingfeng
 * @Date: 2022/3/2
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode() {}
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
