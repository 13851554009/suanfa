package guangdu;

public class ListNode {
    private int val;
    private ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public int val() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode next() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
