import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    Node head;

    // Method to add a new node at the end of the list
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Method to print the linked list
    public void printList() {
        Node current = head;
        System.out.print("Linked List: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Method to remove a node by value
    public void remove(int data) {
        if (head == null) {
            return; // List is empty
        }

        // If the head needs to be removed
        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next; // Bypass the node
                return;
            }
            current = current.next;
        }
    }
}

public class LinkedListImplementation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        SinglyLinkedList linkedList = new SinglyLinkedList();

        // Adding elements to the linked list
        System.out.print("Enter the number of elements to add to the linked list: ");
        int n = scan.nextInt();
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            int data = scan.nextInt();
            linkedList.add(data);
        }

        // Print the linked list
        linkedList.printList();

        // Removing an element from the linked list
        System.out.print("Enter an element to remove from the linked list: ");
        int removeData = scan.nextInt();
        linkedList.remove(removeData);

        // Print the linked list after removal
        linkedList.printList();

        // Close the scanner
        scan.close();
    }
}
