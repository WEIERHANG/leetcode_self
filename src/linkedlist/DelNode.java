package linkedlist;

import java.util.Random;



public class DelNode {


    /**
     * 删除链表的指定的元素节点
     * @param head
     * @param n
     * @return
     */
    public static Node delNodeList(Node head, int n) {
        // 1. head来到第一个不需要删除的节点
        while (head != null && head.val == n) head = head.next;
        // 如果全部为空，那说明全是目标值
        if (head == null) return null;

        Node pre = head, cur = head.next;
        while (cur != null) {
            if (cur.val == n) pre.next = cur.next;
            else pre = cur;
            cur = cur.next;
        }
        return head;
    }

    // 暴力方法：通过直接遍历删除节点
    public static Node delNodeListBruteForce(Node head, int n) {
        // 删除头部是n的节点
        while (head != null && head.val == n) {
            head = head.next;
        }
        if (head == null) return null; // 全部是目标值
        Node cur = head;
        while (cur != null && cur.next != null) {
            if (cur.next.val == n) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    // 对数器：随机生成链表，进行测试
    public static void testDelNodeList(int testTime, int maxSize, int maxValue) {
        Random random = new Random();
        for (int i = 0; i < testTime; i++) {
            // 随机生成链表和目标值
            Node head = generateRandomLinkedList(random.nextInt(maxSize), maxValue);
            int deleteValue = random.nextInt(maxValue);

            // 复制链表
            Node copy1 = copyList(head);
            Node copy2 = copyList(head);

            // 用两种方法分别删除节点
            Node result1 = delNodeList(copy1, deleteValue);
            Node result2 = delNodeListBruteForce(copy2, deleteValue);

            // 比较结果
            if (!isEqual(result1, result2)) {
                System.out.println("测试失败！");
                System.out.println("初始链表: ");
                printLinkedList(head);
                System.out.println("删除的值: " + deleteValue);
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
        testDelNodeList(1000, 100, 100);
    }
}
