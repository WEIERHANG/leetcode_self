package linkedlist;

/**
 * 寻找链表的中点位置
 */
public class FindMid {

    public static void main(String[] args) {
        // 手动测试链表1: 1 -> 2 -> 3 -> 4 -> 5 -> null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        System.out.println("链表1:");
        printLinkedList(head1);
        Node mid1 = findLikedMidNode(head1);
        System.out.println("链表1的中间节点值: " + mid1.val); // 期望输出: 3

        // 手动测试链表2: 10 -> 20 -> 30 -> 40 -> null
        Node head2 = new Node(10);
        head2.next = new Node(20);
        head2.next.next = new Node(30);
        head2.next.next.next = new Node(40);
        System.out.println("\n链表2:");
        printLinkedList(head2);
        Node mid2 = findLikedMidNode(head2);
        System.out.println("链表2的中间节点值: " + mid2.val); // 期望输出: 30

        // 手动测试链表3: 1 -> null
        Node head3 = new Node(1);
        System.out.println("\n链表3:");
        printLinkedList(head3);
        Node mid3 = findLikedMidNode(head3);
        System.out.println("链表3的中间节点值: " + mid3.val); // 期望输出: 1

        // 手动测试链表4: 空链表
        Node head4 = null;
        System.out.println("\n链表4:");
        printLinkedList(head4); // 打印空链表
        Node mid4 = findLikedMidNode(head4);
        System.out.println("链表4的中间节点值: " + (mid4 != null ? mid4.val : "null")); // 期望输出: null

    }

    /**
     * 给定头结点找出链表的中间位置
     *
     * @param head
     * @return
     */
    public static Node findLikedMidNode(Node head){
        if(head == null || head.next == null) return head;
        Node m = head, cur = head;
        while (cur != null && cur.next != null){
            m = m.next;
            cur = cur.next.next;
        }
        return m;

    }

    public static void printLinkedList(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }
        System.out.println("null");
    }


}
