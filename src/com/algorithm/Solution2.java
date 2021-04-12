package com.algorithm;

/**
 * . 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * 2->4->3
 * 5->6->4
 * 结果
 * 7->0->8
 * 返回结果807  输出708
 * <p>
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 * <p>
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 *
 * @author dingfubing
 * @since 2021/4/12 15:30
 */
public class Solution2 {

    // 遍历数组
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 解题思路：需要有一个值表示进位，并且两个链表长度不同时，可以用0代替
        // 初始进位是0
        int carry = 0;
        // 方法返回的链表头，返回的时候取result.next即可
        ListNode result = new ListNode(-1);

        // 此时p指向了result的地址，-1
        ListNode p = result;
        // 当l1 l2遍历结束 && 进位=0的时候，while循环结束
        while (l1 != null || l2 != null || carry > 0) {
            // 如果当前节点为null，则值可用0替代
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            int sum = a + b + carry;

            carry = sum / 10;

            // p指向地址的next = sum%10  也就是result.next = sum%10
            p.next = new ListNode(sum % 10);
            // 取链表后面的值继续while循环
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            // 重点：指针需要往后偏移一位
            p = p.next;
        }
        return result.next;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        int carry = 0, newVal = 0;
        while (p1 != null || p2 != null || carry > 0) {
            newVal = (p1 == null ? 0 : p1.val) + (p2 == null ? 0 : p2.val) + carry;
            carry = newVal / 10;
            newVal %= 10;
            p.next = new ListNode(newVal);
            p1 = p1 == null ? null : p1.next;
            p2 = p2 == null ? null : p2.next;
            p = p.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode listNode = new Solution2().addTwoNumbers(l1, l2);
        while (listNode != null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
        }

    }


}

class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}