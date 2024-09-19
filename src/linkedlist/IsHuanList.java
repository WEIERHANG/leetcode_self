package linkedlist;

import java.util.HashSet;
import java.util.Random;

public class IsHuanList {


    /**
     *  使用快慢指针判断链表是否有环
     *  1. 慢的指向头  快的指向头的下一个节点
     *  2. while循环走 快指针不等于空 或者快指针的下一个不等于空
     *  3. 当快慢指针相遇 == 就代表有环 慢指针走1步 快指针走两步
     *
     * @param head
     * @return
     */
    public static boolean isCycle(Node head) {
        if (head == null || head.next == null) return false;
        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            if (slow == fast) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    // 暴力方法：使用HashSet检测链表是否有环
    public static boolean bruteForceIsCycle(Node head) {
        HashSet<Node> visited = new HashSet<>();
        while (head != null) {
            if (visited.contains(head)) return true;
            visited.add(head);
            head = head.next;
        }
        return false;
    }

    // 随机生成链表，有时带环，有时不带环
    public static Node generateRandomLinkedList(int maxNodes, boolean withCycle) {
        Random random = new Random();
        int nodeCount = random.nextInt(maxNodes) + 1;
        Node head = new Node(1);
        Node current = head;
        Node cycleEntry = null;

        // 随机生成链表
        for (int i = 2; i <= nodeCount; i++) {
            current.next = new Node(i);
            current = current.next;
            // 随机决定环的入口
            if (withCycle && cycleEntry == null && random.nextInt(nodeCount) < 2) {
                cycleEntry = current;
            }
        }

        // 如果生成带环链表，则让链表末尾指向某个中间节点
        if (withCycle && cycleEntry != null) {
            current.next = cycleEntry;
        }

        return head;
    }

    // 对数器方法：测试多次随机链表
    public static void testIsCycle(int testCount, int maxNodes) {
        for (int i = 0; i < testCount; i++) {
            // 生成一个随机链表（50%概率带环）
            boolean withCycle = Math.random() < 0.5;
            Node head = generateRandomLinkedList(maxNodes, withCycle);

            // 用两种方法检测是否有环
            boolean expected = bruteForceIsCycle(head);
            boolean result = isCycle(head);

            // 如果两种方法的结果不一致，打印错误信息
            if (expected != result) {
                System.out.println("Test failed!");
                System.out.println("Expected: " + expected + ", but got: " + result);
                return;
            }
        }

        System.out.println("All tests passed.");
    }

    public static void main(String[] args) {
        // 运行对数器，测试1000次，每次链表最多包含100个节点
        testIsCycle(1000, 100);
    }
}


