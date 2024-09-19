package linkedlist;

import java.util.Random;



public class MidNodeTest {

    // 原方法：快慢指针法
    public static Node findLikedMidNode(Node head) {
        if (head == null || head.next == null) return head;
        Node m = head, cur = head;
        while (cur != null && cur.next != null) {
            m = m.next;
            cur = cur.next.next;
        }
        return m;
    }

    // 暴力法：先统计链表长度，再走到中间节点
    public static Node findMidNodeBruteForce(Node head) {
        if (head == null) return null;
        int length = 0;
        Node cur = head;
        // 计算链表长度
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        // 找到中间节点
        cur = head;
        int mid = length / 2; // 中间节点的索引
        for (int i = 0; i < mid; i++) {
            cur = cur.next;
        }
        return cur;
    }

    // 对数器：生成随机链表，比较两种方法的结果
    public static void testMidNode(int testTime, int maxSize, int maxValue) {
        Random random = new Random();
        for (int i = 0; i < testTime; i++) {
            Node head = generateRandomLinkedList(random.nextInt(maxSize), maxValue);
            Node mid1 = findLikedMidNode(head);
            Node mid2 = findMidNodeBruteForce(head);

            // 如果两种方法的结果不一致，打印链表并退出
            if (mid1 != mid2) {
                System.out.println("测试失败！");
                printLinkedList(head);
                System.out.println("快慢指针法中间节点值: " + (mid1 != null ? mid1.val : "null"));
                System.out.println("暴力法中间节点值: " + (mid2 != null ? mid2.val : "null"));
                return;
            }
        }
        System.out.println("测试通过！");
    }

    // 生成随机链表
    public static Node generateRandomLinkedList(int size, int maxValue) {
        if (size == 0) return null;

        Node head = new Node((int) (Math.random() * maxValue));
        Node cur = head;
        for (int i = 1; i < size; i++) {
            cur.next = new Node((int) (Math.random() * maxValue));
            cur = cur.next;
        }
        return head;
    }

    // 打印链表
    public static void printLinkedList(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // 测试1000次，链表最大长度为100，节点值的最大范围为1000
        testMidNode(1000, 100, 1000);
    }
}
