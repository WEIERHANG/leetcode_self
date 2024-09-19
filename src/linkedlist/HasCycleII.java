package linkedlist;

import java.util.HashSet;
import java.util.Set;
import java.util.Random;


/**
 * 给定一个链表的头节点  head
 *返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 */
public class HasCycleII {


    public static Node detectCycle(Node head) {
        if (head == null || head.next == null) return null;
        Node fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        if (fast == null || fast.next == null) return null;
        fast = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    // 对数器：验证detectCycle函数
    public static void testDetectCycle() {
        int testTimes = 1000;  // 测试次数
        int maxLength = 100;   // 最大链表长度
        Random random = new Random();

        for (int i = 0; i < testTimes; i++) {
            // 随机生成链表是否有环
            boolean hasCycle = random.nextBoolean();
            Node head = generateLinkedList(random.nextInt(maxLength), hasCycle);

            Node cycleNode = detectCycle(head);
            if (hasCycle) {
                if (cycleNode == null) {
                    System.out.println("测试失败：预期有环，但未检测到环。");
                } else {
                    System.out.println("测试通过：检测到环，环的起点值为：" + cycleNode.val);
                }
            } else {
                if (cycleNode != null) {
                    System.out.println("测试失败：预期无环，但检测到了环。");
                } else {
                    System.out.println("测试通过：无环检测成功。");
                }
            }
        }
        System.out.println("所有测试已完成。");
    }

    // 生成随机链表，可以选择是否生成有环链表
    public static Node generateLinkedList(int length, boolean hasCycle) {
        if (length == 0) return null;

        Node head = new Node(0);
        Node current = head;
        Node cycleEntry = null;

        Random random = new Random();
        if (hasCycle) {
            if (length == 1) {
                // 单节点情况下直接将自身形成环
                head.next = head;
                cycleEntry = head;
                System.out.println("生成了有环链表，环的入口节点值为：" + cycleEntry.val);
                return head;
            }

            // 随机生成环的入口，注意长度至少为2
            int cycleEntryIndex = random.nextInt(length);
            for (int i = 1; i < length; i++) {
                current.next = new Node(i);
                current = current.next;
                if (i == cycleEntryIndex) {
                    cycleEntry = current;  // 标记环的入口节点
                }
            }
            current.next = cycleEntry; // 形成环
            System.out.println("生成了有环链表，环的入口节点值为：" + cycleEntry.val);
        } else {
            for (int i = 1; i < length; i++) {
                current.next = new Node(i);
                current = current.next;
            }
            System.out.println("生成了无环链表。");
        }
        return head;
    }


    // 手动打印链表，用于调试
    public static void printLinkedList(Node head) {
        Set<Node> visited = new HashSet<>();
        while (head != null) {
            if (visited.contains(head)) {
                System.out.println("检测到环，环的节点值为：" + head.val);
                break;
            }
            visited.add(head);
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // 运行对数器
        testDetectCycle();
    }
}
