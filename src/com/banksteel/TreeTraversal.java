package com.banksteel;

/**
 * 使用递归遍历二叉树
 * 前序遍历 中序遍历 后序遍历
 *
 * @author dingfubing
 * @since 2020/9/1 14:21
 */
public class TreeTraversal {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        HeroNode heroNode1 = new HeroNode("丁一", 1); // 根节点
        HeroNode heroNode2 = new HeroNode("丁二", 2);
        HeroNode heroNode3 = new HeroNode("丁三", 3);
        HeroNode heroNode4 = new HeroNode("丁四", 4);
        HeroNode heroNode5 = new HeroNode("丁五", 5);
        heroNode1.setLeft(heroNode2);
        heroNode1.setRight(heroNode3);
        heroNode3.setRight(heroNode4);
        heroNode3.setLeft(heroNode5);
        treeNode.setRoot(heroNode1);
        treeNode.preTreeTraversal();
        treeNode.midTreeTraversal();
        treeNode.afterTreeTraversal();
    }
}

class TreeNode {
    private HeroNode root;

    public HeroNode getRoot() {
        return root;
    }

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void preTreeTraversal(){
        root.preTraversal();
    }
    public void midTreeTraversal(){
        root.midTraversal();
    }
    public void afterTreeTraversal(){
        root.afterTraversal();
    }

}

class HeroNode {

    private String name;
    private Integer value;
    private HeroNode left;
    private HeroNode right;

    // 前序遍历 输出顺序 中左右
    public void preTraversal() {
        // 先输出当前节点
        System.out.println("preTraversal -> name = " + this.getName() + " value = " + this.getValue());

        // 左子树不为空，则对左子树进行前序遍历
        if (this.left != null) {
            this.left.preTraversal();
        }

        // 右子树不为空，则对右子树进行前序遍历
        if (this.right != null) {
            this.right.preTraversal();
        }

    }

    // 中序遍历   左中右
    public void midTraversal() {

        // 左子树不为空，则对左子树进行前序遍历
        if (this.left != null) {
            this.left.midTraversal();
        }

        // 先输出左子树节点
        System.out.println("midTraversal -> name = " + this.getName() + " value = " + this.getValue());

        // 右子树不为空，则对右子树进行前序遍历
        if (this.right != null) {
            this.right.midTraversal();
        }

    }

    // 后序遍历  左右中
    public void afterTraversal() {

        // 左子树不为空，则对左子树进行前序遍历
        if (this.left != null) {
            this.left.afterTraversal();
        }

        // 右子树不为空，则对右子树进行前序遍历
        if (this.right != null) {
            this.right.afterTraversal();
        }
        // 最后输出节点
        System.out.println("afterTraversal -> name = " + this.getName() + " value = " + this.getValue());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    public HeroNode(String name, Integer value) {
        this.name = name;
        this.value = value;
    }
}
