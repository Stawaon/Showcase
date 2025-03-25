public class PhonebookManager {
    private ListNode phonebook; // initialize phonebook listnode

    // class contructor
    public PhonebookManager() {
        phonebook = null;
    }

    // method adds entries alphabetically by last name
    public void add(String firstName, String lastName, String address, String city, String phoneNumber) {
        String[] entry = {firstName, lastName, address, city, phoneNumber};
        if (phonebook == null || entry[1].compareTo(phonebook.data[1]) <= 0) {
            // adding to an empty list, or if last name is alphabetically sooner than current first node
            phonebook = new ListNode(entry, phonebook);
        } else {
            // adding entry to list alphabetically by last name
            ListNode current = phonebook;
            while (current.next != null && current.next.data[1].compareTo(entry[1]) > 0) {
                current = current.next;
            } // special case if last names are identical
            if (current.next.data[1].compareTo(entry[1]) == 0) {
                current = current.next;
            }
            current.next = new ListNode(entry);
        }
    }
    
    // method removes entry at given index
    public void remove(int index) {
        if (index == 0) {
            // special case for removing front node of list
            phonebook = phonebook.next;
        } else {
            ListNode current = phonebook;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
    }

    // method gets the first name of a phonebook entry
    public String getFirstName(int index) {
        ListNode current = phonebook;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data[0];
    }

    // method gets the last name of a phonebook entry
    public String getLastName(int index) {
        ListNode current = phonebook;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data[1];
    }

    // method gets the address of a phonebook entry
    public String getAddress(int index) {
        ListNode current = phonebook;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data[2];
    }

    // method gets the city of a phonebook entry
    public String getCity(int index) {
        ListNode current = phonebook;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data[3];
    }

    // method gets the phone number of a phonebook entry
    public String getPhoneNumber(int index) {
        ListNode current = phonebook;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data[4];
    }
    
    // method modifies First Name of a phonebook entry
    public void setFirstName(int index, String firstName) {
        ListNode current = phonebook;
        if (index == 0) {
            // special case for modifying front node of list
            current.data[0] = firstName;
        } else {
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.data[0] = firstName;
        }
    }
    
    // method modifies Last Name of a phonebook entry
    public void setLastName(int index, String lastName) {
        ListNode current = phonebook;
        if (index == 0) {
            // special case for modifying front node of list
            current.data[1] = lastName;
        } else {
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.data[1] = lastName;
        }
    }

    // method modifies address of a phonebook entry
    public void setAddress(int index, String address) {
        ListNode current = phonebook;
        if (index == 0) {
            // special case for modifying front node of list
            current.data[2] = address;
        } else {
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.data[2] = address;
        }
    }

    // method modifies city of a phonebook entry
    public void setCity(int index, String city) {
        ListNode current = phonebook;
        if (index == 0) {
            // special case for modifying front node of list
            current.data[3] = city;
        } else {
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.data[3] = city;
        }
    }

    // method modifies phone number of a phonebook entry
    public void setPhoneNumber(int index, String phoneNumber) {
        ListNode current = phonebook;
        if (index == 0) {
            // special case for modifying front node of list
            current.data[4] = phoneNumber;
        } else {
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.data[4] = phoneNumber;
        }
    }

    // method swaps entry from one phonebook to another
    public void swapBooks(int index, PhonebookManager other) {
        if (index == 0) {
            // special case for modifying front node
            other.add(getFirstName(index), getLastName(index), getAddress(index), getCity(index), getPhoneNumber(index));
            this.remove(index);
            phonebook = phonebook.next;
        } else {
            ListNode current = phonebook;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            other.add(getFirstName(index), getLastName(index), getAddress(index), getCity(index), getPhoneNumber(index));
            this.remove(index);
            current = current.next;
        }
    }

    // method returns the size of a phonebook
    public int size() {
        ListNode current = phonebook;
        int size = 0;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    // method prints specified entry
    public void printEntry(int index) {
        ListNode current = phonebook;
        if (index == 0) {
            // special case for index 0
            System.out.print("Name: ");
            for (int i = 0; i < 2; i++) {
                System.out.print(current.data[i] + " ");
            }
            System.out.println();
            System.out.print("Address: ");
            for (int i = 2; i < 4; i++) {
                System.out.print(current.data[i] + " ");
            }
            System.out.println();
            System.out.print("Phone Number: ");
            System.out.println(current.data[4]);
            System.out.println();
        } else {
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            System.out.print("Name: ");
            for (int i = 0; i < 2; i++) {
                System.out.print(current.data[i] + " ");
            }
            System.out.println();
            System.out.print("Address: ");
            for (int i = 2; i < 4; i++) {
                System.out.print(current.data[i] + " ");
            }
            System.out.println();
            System.out.print("Phone Number: ");
            System.out.println(current.data[4]);
            System.out.println();
        }
    }
    
    // method prints whole phoneBook
    public void printPhonebook() {
        for (int i = 0; i < this.size(); i++) {
            printEntry(i);
        }
    }

}
