package algorithm.daimasuixianglu.erchashu;

import algorithm.daimasuixianglu.erchashu.bianli.Solution;

import java.util.List;

/**
 * @Auther:liujingfeng
 * @Date: 2022/3/2
 */
public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode branch1 = new TreeNode(1);
        TreeNode branch2 = new TreeNode(19);
        TreeNode root1 = new TreeNode(10, branch1, branch2);


        List<Integer> resList1 = solution.preorderTraversal(root1);
        System.out.println(resList1);


        TreeNode root2 = new TreeNode(10, branch1, branch2);

        List<Integer> resList2 = solution.inorderTraversal(root2);
        System.out.println(resList2);

        TreeNode root3 = new TreeNode(10, branch1, branch2);

        List<Integer> resList3 = solution.postorderTraversal(root3);
        System.out.println(resList3);
    }

}
