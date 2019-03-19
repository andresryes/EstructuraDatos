import java.io.*;
public class LinkedList {

    Node head; // head of the linked list

    static class Node {

        String data;
        Node next;

        // Constructor
        Node(String d){
            data = d;
            next = null;
        }
    }

    // insert
    public static LinkedList insert(LinkedList list, String data){
        // Create a new node with given data
        Node new_node = new Node(data);
        new_node.next = null;

        if (list.head == null) {
            list.head = new_node;
        }else{
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
        }
            last.next = new_node;
        }

        return list;
    }

    public boolean search(Node head, String x)
    {
        Node current = head;    //Initialize current
        while (current != null)
        {
            if (current.data.equals(x))
                return true;    //data found
            current = current.next;
        }
        return false;    //data not found
    }

    public static void printList(LinkedList list){
        Node currNode = list.head;
        System.out.print("LinkedList: ");
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
    }
  }
