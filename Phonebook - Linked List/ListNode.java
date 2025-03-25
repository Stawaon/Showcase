public class ListNode {
    Integer data;
    ListNode next;

    public ListNode(Integer data) {
        this.data = data;
        this.next = null;
    }

    public ListNode(Integer data, ListNode next) {
        this.data = data;
        this.next = next;
    }

    public ListNode() {
        this.data = null;
        this.next = null;
    }

}