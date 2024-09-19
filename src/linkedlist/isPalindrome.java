package linkedlist;

import java.util.Random;
import java.util.Stack;


/**
 * 判断是否为回文链表
 *
 */
public class isPalindrome {


    /**
     * 判断是否为回文链表
     * @param head
     * @return
     */
    public static boolean isPaid(Node head) {
        if (head == null || head.next == null) return true;
        // 1. 找到链表的中点
        Node m = head, cur = head;
        while (cur != null && cur.next != null) {
            m = m.next;
            cur = cur.next.next;
        }
        // 2. 将后半部分入栈
        Stack<Node> s = new Stack<>();
        while (m != null) {
            s.push(m);
            m = m.next;
        }
        // 3. 对比栈中元素与前半部分链表
        while (!s.isEmpty()) {
            if (head.val != s.pop().val) return false;
            head = head.next;
        }
        return true;
    }

    // 暴力方法：将链表节点值存入数组中，检查是否回文
    public static boolean isPalindromeBruteForce(Node head) {
        if (head == null || head.next == null) return true;

        // 将链表的值存入数组
        int[] values = new int[getLength(head)];
        Node cur = head;
        int index = 0;
        while (cur != null) {
            values[index++] = cur.val;
            cur = cur.next;
        }

        // 检查数组是否对称
        for (int i = 0; i < values.length / 2; i++) {
            if (values[i] != values[values.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    // 获取链表长度
    public static int getLength(Node head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    // 对数器：随机生成链表，进行测试
    public static void testIsPaid(int testTime, int maxSize, int maxValue) {
        Random random = new Random();
        for (int i = 0; i < testTime; i++) {
            // 随机生成链表
            Node head = generateRandomLinkedList(random.nextInt(maxSize), maxValue);

            // 复制链表
            Node copy1 = copyList(head);
            Node copy2 = copyList(head);

            // 用两种方法分别判断是否回文
            boolean result1 = isPaid(copy1);
            boolean result2 = isPalindromeBruteForce(copy2);

            // 比较结果
            if (result1 != result2) {
                System.out.println("测试失败！");
                System.out.println("初始链表: ");
                printLinkedList(head);
                System.out.println("快方法结果: " + result1);
                System.out.println("暴力方法结果: " + result2);
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
        testIsPaid(1000, 100, 100);
    }
}
