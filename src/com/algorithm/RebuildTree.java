package com.algorithm;

import java.util.Arrays;

/**
 * 题目描述：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
 * ，则重建二叉树并返回。
 * <p>
 * 考察类型：重建二叉树
 * <p>
 * 已知条件：前序遍历的结果和中序遍历的结果，如：pre[]{1,2,4,7,3,5,6,8}   in[]{4,7,2,1,5,3,8,6}
 * <p>
 * 主要思路：前序遍历的特点是：根左右    中序遍历的特点是：左根右     所以前序遍历的pre[0]即为根节点root  根据root节点遍历中序结果集，如果 root = in[i]   所以需要遍历中序结果集
 * 则 root 节点的左子树前序遍历结果为 pre[1] ~ pre[i]
 * 则 root 节点的左子树中序遍历结果为 in[0] ~ in[i - 1]
 * 则 root 节点的右子树前序遍历结果为 pre[i+1] ~ pre[pre.length - 1]
 * 则 root 节点的右子树中序遍历结果为 in[i+1] ~ in[pre.length - 1]
 *
 * @author dingfubing
 * @since 2020/9/17 14:26
 */
public class RebuildTree {

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        RebuildTree rebuildTree = new RebuildTree();
        TreeNode treeNode = rebuildTree.reConstructBinaryTree(pre, in);
        System.out.println(treeNode);
    }

    /**
     * @param pre 前序遍历结果
     * @param in 中序遍历结果
     * @return 根节点
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {
            if (in[i] == root.getVal()) {
                // 根节点设置左子树，第一个参数为左子树的前序遍历，第二个参数为左子树的中序遍历   Arrays.copyOfRange 左闭右开
                root.setLeft(reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i)));
                root.setRight(reConstructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length), Arrays.copyOfRange(in,i+1,pre.length)));
            }
        }
        return root;

    }

}

class TreeNode {

    private int val;
    private TreeNode left;
    private TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
            "val=" + val +
            ", left=" + left +
            ", right=" + right +
            '}';
    }
}
