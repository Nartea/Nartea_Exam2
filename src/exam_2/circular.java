/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exam_2;

import java.util.Scanner;
import static javax.management.Query.value;

/**
 *
 * @author Acer
 */
class Node{
    int data;
   Node next;

    Node(int m) {
        data=m;
        next=null;
    }
   
   
}
public class circular{
    private class Node {
            String data;
            Node next;
        }
        
private Node head, tail;
private int size;

private Node createNewNode(String value) throws Exception {
    Node node = new Node();
    
    node.data = value;
    node.next = null;
    
    return node;
    
}

private void insertion(String value, int position) throws Exception {
    if(position < 0 || position > size){
        throw new Exception("value Invalid");
    } else if (position == 0){
        insertBeg(value);
    }else if(position==size){
        insertEnd(value);
}else{
        Node node=createNewNode(value);
        node.next=node;
        tail.next=head;
        size++;
    }
}
private void insertBeg(String value)throws Exception{
    Node node = createNewNode(value);
    
    if (size == 0){
    head = tail = node;
    }else{
        node.next = head;
        head = node;
    }
    
    tail.next = tail;
    
    size++;
}

private void insertEnd(String value)throws Exception{
    Node node= createNewNode(value);
    if(size>0){
        tail.next=node;
        tail=node;
    }else if(size==0){
        head=tail=node;   
    }
    tail.next=head;
    size++;
}
public void display() {
        if (head == null) {
            System.out.println("empty.");
            return;
        }

        Node current = head;
        int position=0;
        do {
            System.out.print(current.data + " -> " );
            current = current.next;
            position++;
        } while (current != head);
        System.out.println("null"); 
    
    }
    public static void main(String[] args)throws Exception {
        circular list = new circular ();
        Scanner scn = new Scanner(System.in);
      boolean start=true;
      
      while(start){
        int position;
        String value;
          System.out.println("menu: ");
          System.out.println("1. insertion ");
          System.out.println("2. display ");
          System.out.println("3. exit ");
          int choiceInput=scn.nextInt();
          
          switch (choiceInput){
              case 1:
                  System.out.println("Enter name: ");
                  value=scn.next();
                  
                  System.out.println("Enter position: ");
                  position=scn.nextInt();
                 
                  list.insertion(value, position);
                   break;
                   
              case 2:
                  list.display();
                  break;
              case 3:
                  start=false;
                  break;
                  
              default:
                  System.out.println("wrong choice");
                  break;
          }
      }
    } 
        
    }
