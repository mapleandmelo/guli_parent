package algorithm.daimasuixianglu.erchashu.bianli;

import algorithm.daimasuixianglu.erchashu.TreeNode;

import java.util.*;

/**
 * @Auther:liujingfeng
 * @Date: 2022/3/2
 */

public class Solution {
    // 前序遍历顺序：中-左-右，入栈顺序：中-右-左
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return result;
    }


    //中序遍历顺序 左 中 右
    public List<Integer> inorderTraversal(TreeNode root){
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();

        //当前指针
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if(cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }

        return result;

    }


    //后续遍历 左 右 中
    public List<Integer> postorderTraversal(TreeNode root){
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);

            if(node.left != null) {
                stack.push(node.left);

            }

            if(node.right != null) {
                stack.push(node.right);

            }
        }

        Collections.reverse(result);
        return result;

    }
}
