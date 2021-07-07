/**
 * 题目
 * 输入一个链表的头结点，从尾到头反过来打印出每个结点的值 也就是链表的反转
 * tips 如果我们打算修改输入的数据 最好衔问面试官是不是允许做修改
 *
 * 单链表的结点结构：
 * data-next
 *
 * data域：存储数据元素信息的域称为数据域；　
 * next域：存储直接后继位置的域称为指针域，它是存放结点的直接后继的地址（位置）的指针域（链域）。
 * data域+ next域：组成数据ai的存储映射，称为结点；
 * 注意：
 * ①链表通过每个结点的链域将线性表的n个结点按其逻辑顺序链接在一起的。 　　
 * ②每个结点只有一个链域的链表称为单链表（Single Linked List）。
 * 所谓的链表就好像火车车厢一样，从火车头开始，每一节车厢之后都连着后一节车厢。
 * 要实现单链表存储，首先是创建一结点类Node
 *
 * 两种方法：遍历与递归
 *
 *
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
        //打印链表每一个结点
        while (newNode != null) {
            System.out.print(newNode.data + " ");
            newNode = newNode.getNext();
        }

    }

    /**
     * 递归实现 在反转当前节点之前先反转后续节点
     *
     * @param head
     * @return
     */
    private static Node reverse(Node head) {
        // head看作是前一结点，head.getNext()是当前结点，reverseHead是反转后新链表的头结点
        if (head == null || head.next == null) {
            return head; // 若为空链或者当前结点在尾结点，则直接还回
        }
        Node reverseHead = reverse(head.getNext()); // 先反转后续节点head.getNext()
        head.getNext().setNext(head);// 将当前结点的指针域指向前一结点
        head.setNext(null);// 前一结点的指针域令为null;
        return reverseHead;// 反转后新链表的头结点

    }

    /**
     * 遍历方法 双指针方法 将当前节点的下一个节点缓存后更改当前节点指针
     *
     * 假设链表节点是12345 这里的放前面就是通过指针的指向来实现
     * 遍历的第一步 将2放到1前 也就是21345
     * 第二步 将3放到2前面 也就是32145
     * 第三步 将4放到3前面 也就是43215
     * 第四步 将5放到4前面 也就是54321 完成反转
     * @param head
     * @return
     */
    private static Node reverse2(Node head) {
        Node pre = head; //上一结点 p1指针
        Node cur = head.getNext(); //当前结点 p2指针
        Node temp;// 临时结点，用于保存当前结点的指针域（即下一结点）
        while (cur != null) { // p1 p2向右移动 直到当前结点为null，说明位于尾结点
            temp = cur.getNext();
            cur.setNext(pre); // 反转指针域的指向
            // 指针往右移动
            pre = cur;
            cur = temp;
        }
        // 最后将原链表的头节点的指针域置为null，还回新链表的头结点，即原链表的尾结点
        head.setNext(null);
        return pre;
    }

}

//单链表结构
class Node {
    String data;//数据域
    Node next;//指针域

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
