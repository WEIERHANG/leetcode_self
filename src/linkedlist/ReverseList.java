package linkedlist;

import java.util.Random;


public class ReverseList {


    /**
     * 翻转单链表
     * @param head
     * @return
     */
    public static Node reverseNode(Node head) {
        Node pre = null, next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    // 暴力方法：通过构建反转后的链表来验证
    public static Node reverseNodeBruteForce(Node head) {
        if (head == null) return null;

        // 把所有节点值存到数组中
        Node cur = head;
        int length = 0;
        while (cur != null) {
            length++;
            cur = cur.next;
        }

        int[] values = new int[length];
        cur = head;
        for (int i = 0; i < length; i++) {
            values[i] = cur.val;
            cur = cur.next;
        }

        // 构建一个反转后的链表
        Node reversedHead = new Node(values[length - 1]);
        Node newCur = reversedHead;
        for (int i = length - 2; i >= 0; i--) {
            newCur.next = new Node(values[i]);
            newCur = newCur.next;
        }
        return reversedHead;
    }

    // 对数器：随机生成链表，进行测试
    public static void testReverseNode(int testTime, int maxSize, int maxValue) {
        Random random = new Random();
        for (int i = 0; i < testTime; i++) {
            // 随机生成链表
            Node head = generateRandomLinkedList(random.nextInt(maxSize), maxValue);

            // 复制链表
            Node copy1 = copyList(head);
            Node copy2 = copyList(head);

            // 用两种方法分别反转链表
            Node result1 = reverseNode(copy1);
            Node result2 = reverseNodeBruteForce(copy2);

            // 比较结果
            if (!isEqual(result1, result2)) {
                System.out.println("测试失败！");
                System.out.println("初始链表: ");
                printLinkedList(head);
                System.out.println("快方法结果: ");
                printLinkedList(result1);
                System.out.println("暴力方法结果: ");
                printLinkedList(result2);
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

    // 复制链表
    public static Node copyList(Node head) {
        if (head == null) return null;
        Node newHead = new Node(head.val);
        Node cur = newHead;
        Node oldCur = head.next;
        while (oldCur != null) {
            cur.next = new Node(oldCur.val);
            cur = cur.next;
            oldCur = oldCur.next;
        }
        return newHead;
    }

    // 比较两条链表是否相等
    public static boolean isEqual(Node head1, Node head2) {
        while (head1 != null && head2 != null) {
            if (head1.val != head2.val) return false;
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1 == null && head2 == null;
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
        // 测试1000次，链表最大长度为100，节点值的最大范围为100
        testReverseNode(1000, 100, 100);
    }
}
