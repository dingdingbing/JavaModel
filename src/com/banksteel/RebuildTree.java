package com.banksteel;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * 分析：通过前序遍历序列可知，树的根节点是 1 ，根据中序遍历序列可知，1之前的4 7 2 是根节点的左子树序列 5 3 8 6是根节点的右子树序列
 * 由前序遍历序列的第二个数可知，2是根节点1的左子树，由根节点的左子树 {4 7 2} 可知，4和7是2节点的
 *
 * @author dingfubing
 * @since 2020/9/1 14:50
 */
public class RebuildTree {

    public static void main(String[] args) {
        Student student = new Student();
        student.setAge(null);
        if (student.getAge() == 1) {
            System.out.println("12");
        }
    }
}
