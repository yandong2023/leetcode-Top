/**
 * 题目
 * 输入一个链表的头结点，从尾到头反过来打印出每个结点的值 也就是链表的反转
 * tips 如果我们打算修改输入的数据 最好衔问面试官是不是允许做修改
 */

public class PrintListReversingly {

    public static void main(String[] args) {
        Node node1 = new Node("A");
        Node node2 = new Node("B");
        Node node3 = new Node("C");
        Node node4 = new Node("D");
        Node node5 = new Node("E");
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        Node newNode = reverse2(node1);
        while (newNode != null) {
            System.out.print(newNode.data + " ");
            newNode = newNode.getNext();
        }


    }

    private static Node reverse(Node head) {
        if (head.next == null) {
            return head;
        }
        Node reverseHead = reverse(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);

        return reverseHead;

    }

    private static Node reverse2(Node head) {
        Node pre = head;
        Node cur = head.getNext();
        Node temp;
        while (cur != null) {
            temp = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = temp;
        }
        head.setNext(null);
        return pre;
    }

}

class Node {
    String data;
    Node next;

    public Node(String data) {
        super();
        this.data = data;
    }

    public Node(String data, Node next) {
        super();
        this.data = data;
        this.next = next;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }


}
