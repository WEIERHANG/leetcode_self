package linkedlist;

public class FindMidAndDel {

    public static void main(String[] args) {


    }
    public static Node findMidDel(Node head){
        if(head == null || head.next == null) return null;
        Node m = head, cur = head, mPre = null;
        while (cur != null && cur.next != null){
            mPre = m;
            m = m.next;
            cur = cur.next.next;
        }
        if(mPre != null) mPre.next = m.next;
        return head;
    }

}
