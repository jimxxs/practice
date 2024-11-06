
/*1.Objective: Develop an understanding of pointer manipulation by reversing a singly linked list.
 • Question: In a list with multiple occurrences of element KEY,
 make sure that there remains only single occurrence of the element KEY in the list.
 • Write a function to reverse a singly linked list.
The function should take the head of the list as input and return the head of the new reversed list. */



/*Removing Duplicates of KEY
Here's a function to ensure only a single occurrence of a given element KEY remains in a singly linked list */

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    Node head;

    public void removeDuplicates(int key) {
        if (head == null) {
            return;
        }

        Node current = head;
        // Ensure the first occurrence of key is kept
        while (current != null && current.data == key) {
            current = current.next;
        }

        Node prev = head;
        while (current != null) {
            if (current.data == key) {
                prev.next = current.next; // Skip duplicate
            } else {
                prev = current;
            }
            current = current.next;
        }
    }

    /*Here's how you can reverse a singly linked list */
    public Node reverse(Node head) {
         Node prev = null;
         Node current = head;
         Node next = null;
         while (current != null) {
             next = current.next; // Store next
             current.next = prev; // Reverse current node's pointer
             prev = current; // Move pointers one position ahead
             current = next;
            } 
        head = prev;
        return head;
   }
/*Usage
To use the reverse function and the removeDuplicates function,
you can set up your linked list and call these methods accordingly.
Here's an example of how you might do this: */
   

public static void main(String[] args) {
     LinkedList list = new LinkedList(); // Adding elements to the list
     list.head = new Node(1);
     list.head.next = new Node(2);
     list.head.next.next = new Node(2);
     list.head.next.next.next = new Node(3);
     list.head.next.next.next.next = new Node(3); // Removing duplicates of element 2
     list.removeDuplicates(2); // Reversing the list
     list.head = list.reverse(list.head); // Printing the reversed list
     Node current = list.head;
     while (current != null) {
         System.out.print(current.data + " ");
         current = current.next;
     }
 }
}

/*In this example:
We first create a linked list and add some elements to it.
We then call removeDuplicates(2) to ensure only one occurrence of 2 remains.
Finally, we reverse the linked list using the reverse function and print the elements.*/