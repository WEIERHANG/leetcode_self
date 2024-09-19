package linkedlist;

public class IntersectionNode {

    /**
     * 两个链表的第一个公共焦点
     * @param headA
     * @param headB
     * @return
     */
    public static Node getCommNode(Node headA, Node headB) {
        Node indexA = headA, indexB = headB;
        while (indexA != indexB) {
            if (indexA == null) indexA = headB;
            else indexA = indexA.next;
            if (indexB == null) indexB = headA;
            else indexB = indexB.next;
        }
        return indexA;
    }

    public static void main(String[] args) {
        // 创建两个链表：headA 和 headB
        Node common = new Node(8);
        common.next = new Node(10);

        // 链表 A: 1 -> 2 -> 3 -> 8 -> 10
        Node headA = new Node(1);
        headA.next = new Node(2);
        headA.next.next = new Node(3);
        headA.next.next.next = common;

        // 链表 B: 4 -> 5 -> 8 -> 10
        Node headB = new Node(4);
        headB.next = new Node(5);
        headB.next.next = common;

        // 调用 getCommNode 方法获取交点
        Node intersection = getCommNode(headA, headB);

        if (intersection != null) {
            System.out.println("The intersection node's value is: " + intersection.val);
        } else {
            System.out.println("No intersection found.");
        }
    }


}
