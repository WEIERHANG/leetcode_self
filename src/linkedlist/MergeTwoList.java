package linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * 合并两个升序的链表
 *
 */
public class MergeTwoList {

    public static Node mergeTwo(Node l1, Node l2){
        Node temp = new Node(-1);
        Node cur = temp;
        while (l1 != null && l2 != null){
            if(l1.val <= l2.val){
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
        }
        if(l1 != null) cur.next = l1;
        if(l2 != null) cur.next = l2;
        return temp.next;
    }

    // 暴力解法：将两个链表的所有值放入一个列表，排序后再构建链表
    public static Node mergeTwoByBruteForce(Node l1, Node l2) {
        List<Integer> list = new ArrayList<>();
        while (l1 != null) {
            list.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            list.add(l2.val);
            l2 = l2.next;
        }
        Collections.sort(list);
        Node temp = new Node(-1);
        Node cur = temp;
        for (int val : list) {
            cur.next = new Node(val);
            cur = cur.next;
        }
        return temp.next;
    }

    // 辅助方法：生成随机的升序链表
    public static Node generateSortedLinkedList(int size, int maxValue) {
        if (size == 0) return null;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add((int) (Math.random() * maxValue));
        }
        Collections.sort(list);
        Node head = new Node(list.get(0));
        Node cur = head;
        for (int i = 1; i < list.size(); i++) {
            cur.next = new Node(list.get(i));
            cur = cur.next;
        }
        return head;
    }

    // 对数器验证
    public static void main(String[] args) {
        int testTimes = 1000;
        int maxSize = 20;
        int maxValue = 100;
        boolean success = true;

        for (int i = 0; i < testTimes; i++) {
            Node l1 = generateSortedLinkedList((int)(Math.random() * maxSize), maxValue);
            Node l2 = generateSortedLinkedList((int)(Math.random() * maxSize), maxValue);

            // 复制链表，避免原链表被修改
            Node result1 = mergeTwo(copyList(l1), copyList(l2));
            Node result2 = mergeTwoByBruteForce(copyList(l1), copyList(l2));

            if (!compareLinkedLists(result1, result2)) {
                success = false;
                System.out.println("Error in test case " + i);
                break;
            }
        }

        if (success) {
            System.out.println("All test cases passed!");
        } else {
            System.out.println("Some test cases failed.");
        }
    }

    public static Node copyList(Node head) {
        if (head == null) {
            return null;
        }
        Node newHead = new Node(head.val);
        Node cur = newHead;
        head = head.next;
        while (head != null) {
            cur.next = new Node(head.val);
            cur = cur.next;
            head = head.next;
        }
        return newHead;
    }


    // 比较两个链表是否相同
    public static boolean compareLinkedLists(Node l1, Node l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1 == null && l2 == null;
    }
}
