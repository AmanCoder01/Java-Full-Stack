package linkedlist.singly;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.display();
        list.insertFromBeg(10);
        list.insertFromBeg(12);
        list.insertFromBeg(16);
        list.display();
        list.insertFromEnd(40);
        list.insertFromEnd(50);
        list.display();
        list.deleteFromBeg();
        list.display();
        list.deleteFromEnd();
        list.display();

        list.insertAtSpecificPos(2,54);
        list.display();

        list.deleteFromSpecificPos(2);
        list.display();


    }
}
