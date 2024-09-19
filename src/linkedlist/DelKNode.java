package linkedlist;


/**
 * 删除倒数第k节点
 * 1. 新建虚拟node 他的next指向头结点
 * 2. 快慢指针分别指向新节点
 * 3. 快指针先走n步, 然后快慢在同时走 一直到快指针到头,此时慢指针就是倒数第k
 */
public class DelKNode {

    public static Node delKNode(Node head, int n) {
        Node tempNode = new Node(-1); // 创建虚拟节点
        tempNode.next = head;
        Node fast = tempNode, slow = tempNode;

        // 快指针先走 n 步
        for (int i = 0; i < n; i++) fast = fast.next;

        // 快慢指针同时移动
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 删除倒数第 n 个节点
        slow.next = slow.next.next;
        // 返回头节点
        return tempNode.next;
    }

    // 打印链表的方法
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // 测试 delKNode 方法
    public static void main(String[] args) {
        // 创建一个测试链表：1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("原始链表：");
        printList(head); // 打印原始链表

        // 测试删除倒数第 2 个节点（即删除节点 4）
        int n = 2;
        head = delKNode(head, n);

        System.out.println("删除倒数第 " + n + " 个节点后的链表：");
        printList(head); // 打印删除节点后的链表
    }
}
