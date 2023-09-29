/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exam_2;

import java.util.Scanner;

/**
 *
 * @author Acer
 */
public class sarisariStore {
    private class DoubleNode {
        DoubleNode next;
        String data;  
        DoubleNode prev;
    }

    private int size;
    private DoubleNode head;

    private DoubleNode createNewNode(String value) throws Exception {
        DoubleNode doubleNewNode = new DoubleNode();
        doubleNewNode.data = value;
        doubleNewNode.prev = null;
        doubleNewNode.next = null;
        return doubleNewNode;
    }
     public void insert(String value) throws Exception {
        DoubleNode doubleNewNode = createNewNode(value);

        if (head == null) {
            head = doubleNewNode;
        } else {
            doubleNewNode.next = head;
            head.prev = doubleNewNode;
            head = doubleNewNode;
        }
        size++;
    }

    public DoubleNode getNodeAt(int index) throws Exception {
        if (size == 0) {
            throw new Exception("Linked list is empty");
        }
        if (index < 0 || index >= size) {
            throw new Exception("Invalid Index");
        }
        DoubleNode temporary = head;

        for (int i = 0; i < index; i++) {
            temporary = temporary.next;
        }
        return temporary;
    }
    public void deletion(int position) throws Exception {
        if (position < 0 || position == size) {
            throw new Exception("Invalid index");
        }
        if (size == 0) {
            throw new Exception("List is empty");
        }
        String deletedData = null;
        if (position == 0) {
            deleteBeginning();
        } else if (position == size - 1) {
            deleteAtEnd();
        } else {
            DoubleNode prevNode = getNodeAt(position - 1);
            DoubleNode nextNode = getNodeAt(position + 1);
            deletedData = prevNode.next.data;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            size--;
        }
        System.out.println("Deleted data: " + deletedData);
    }

    public void deleteBeginning() throws Exception {
        if (head == null) {
            return;
        }
        String deletedData = head.data;
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
        size--;
        System.out.println("imo g plait: " + deletedData);
    }

    public void deleteAtEnd() throws Exception {
        if (head == null) {
            return;
        }
        String deletedData;
        if (head.next == null) {
            deletedData = head.data;
            head = null;
        } else {
            DoubleNode temporary = head;
            while (temporary.next != null) {
                temporary = temporary.next;
            }
            deletedData = temporary.data;
            temporary.prev.next = null;
        }
        System.out.println("imo g palit: " + deletedData);
        size--;
    }

    public void searchNode(String value) {
        int i = 1;
        boolean flag = false;
        DoubleNode current = head;

        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        while (current != null) {
            if (current.data.equalsIgnoreCase(value)) {  
                flag = true;
                break;
            }
            current = current.next;
            i++;
        }
        if (flag)
            System.out.println("Naa ang " );
        else
            System.out.println("WALA!");
    }

    private void display() throws Exception {
        if (size == 0) {
            throw new Exception("Linked list is empty");
        } else {
            DoubleNode temporary = head;
            while (temporary != null) {
                System.out.print(temporary.data + " <-> ");
                temporary = temporary.next;
            }
            System.out.println(" ");
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        sarisariStore list = new sarisariStore();
        boolean start = true;
          list.insert("fita, pride power, canola oil, nescafe black coffee,"
                 + "\n Arieal poweder, rebisco, steelwool, head&shoulders, nova, tanduay, bearbrand, "
                 + "\n nature spring,coke 1lt, sprite kasalo 1ltr, royal 1ltr, sugar  ");
          list.display();
       

        while (start) {
            
            System.out.println("Ayoooo");
            System.out.println("1.palit ko");
            System.out.println("2. Exit");
            int choice = s.nextInt();
            

            switch (choice) {
                
                case 1:
                    System.out.println("onsa imo: ");
                    String search = s.next();
                    list.searchNode(search);
                    break;
                case 2:
                    start = false;
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }
}

