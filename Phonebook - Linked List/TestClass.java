public class TestClass {
    public static void main(String[] args) {
        /* ListNode list = new ListNode();
        String[] wordList1 = {"word", "test", "whatever"};
        list.data = wordList1;
        list.next = new ListNode();
        String[] wordList2 = {"blah", "meh", "hmm"};
        list.next.data = wordList2;
        list.next.next = new ListNode();
        String[] wordList3 = {"yahoo", "whamo", "kapow"};
        list.next.next.data = wordList3;
        list.next.next.next = null;

        ListNode current = list;
        while (current != null) {
            for (int i = 0; current.data.length > i; i++) {
                System.out.print(current.data[i] + " ");
            }
            System.out.println();
            current = current.next;
        } */
        PhonebookManager Bellingham = new PhonebookManager();
        PhonebookManager Centralia = new PhonebookManager();
        Bellingham.add("Noah", "Watson", "1234 Road St", "Bellingham", "360-001-0010");
        Bellingham.add("Ty", "Jones", "1234 Road St", "Bellingham", "206-123-4567");
        Bellingham.add("Kevin", "Watson", "5423 Boulevard Ave", "Centralia", "360-646-4311");
        
        Bellingham.swapBooks(2, Centralia);
        
        Bellingham.printPhonebook();
        System.out.println();
        Centralia.printPhonebook();



    }
}