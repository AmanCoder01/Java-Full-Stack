package linkedlist.singly;

public class SinglyLinkedList {
    private Node head;

    SinglyLinkedList(){
        this.head = null;
    }

    public void insertFromBeg(int data){
        Node newnode = new Node(data);

        if(head == null){
            head = newnode;
        }else{
            newnode.next = head;
            head = newnode;
        }
    }

    public void insertFromEnd(int data){
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
        }else{
            Node temp=head;

            while (temp.next!=null){
                temp=temp.next;
            }
            temp.next=newNode;
        }
    }


    public void deleteFromBeg(){
        if(head==null){
            System.out.println("List is Empty..!");
            return;
        }

        head = head.next;
    }

    public void deleteFromEnd(){
        if(head==null){
            System.out.println("List is Empty..!");
            return;
        }

        Node temp = head;

        while (temp.next.next!=null){
            temp=temp.next;
        }

        temp.next=null;
    }


    // Display list
    public void display() {
        if(head==null){
            System.out.println("List is Empty..!");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void insertAtSpecificPos(int pos, int data) {
        Node newNode = new Node(data);

        if(head==null){
            System.out.println("List is Empty ...!");
            return;
        } else if (pos==0) {
            insertFromBeg(data);
            return;
        }

        Node temp=head;
        int i=0;

        // Traverse to the (pos - 1)th node
        while(temp!=null && i <pos-1){
            temp=temp.next;
            i++;
        }

        // If position is beyond current list size
        if (temp == null) {
            System.out.println("Position out of bounds");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void deleteFromSpecificPos(int pos) {
        if(head==null){
            System.out.println("List is Empty ...!");
            return;
        } else if (pos==0) {
            deleteFromBeg();
            return;
        }


        Node temp = head;
        int i=0;

        while(temp!=null && i <pos-1){
            temp=temp.next;
            i++;
        }

        // Check if temp or temp.next is null
        if (temp == null || temp.next == null) {
            System.out.println("Position out of bounds");
            return;
        }

        temp.next = temp.next.next;
    }
}
