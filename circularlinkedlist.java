public class circularlinkedlist {
    public static void main(String[] args) {
        circular c = new circular();
        c.insert(10);
        c.insert(20);
        c.insert(30);
        c.insert(40);
        c.insert(50);
        c.swap();
        c.print();
    }
}

class circular {
    Node head;

    circular() {
        Node head = null;
    }

    public void insert(int data) {
        Node nn = new Node(data);
        if (head == null) {
            head = nn;
            head.next = nn;
            return;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = nn;
            nn.next = head;
        }
    }

    public void print() {
        if (head == null) {
            System.out.println("Empty List");
            return;
        } else {
            Node temp = head;
            do {
                System.out.println(temp.data);
                temp = temp.next;
            } while (temp != head);
        }
    }

    public void swap() {
        if (head == null) {
            System.out.println("Empty List");
            return;
        } else {
            Node temp = head;
            Node prev = head;
            while(temp.next != head){
                prev = temp;
                temp = temp.next;
            }
            temp.next = head.next;
            prev.next = head;
            head.next = temp;
            head = temp;
        }
    }
}

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}