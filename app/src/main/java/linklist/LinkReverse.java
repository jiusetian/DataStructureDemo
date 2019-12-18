package linklist;

import android.util.Log;

/**
 *  链表反转
 */

public class LinkReverse {

    public void reverseLink() {
        Node head = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);

        // 打印反转前的链表
        Node h = head;
        while (null != h) {
            Log.d("tag","反转前="+h.getData() + " ");
            h = h.getNext();
        }
        // 调用反转方法
        head = reverse(head);

        // 打印反转后的结果
        while (null != head) {
            Log.d("tag","反转后="+head.getData() + " ");
            head = head.getNext();
        }
    }

    /**
     * 递归，在反转当前节点之前先反转后续节点
     * 思路就是：利用递归，去反顺序获取到每个节点，当到达最后一个节点的时候，就开始返回，然后设置next值，就可以了
     *
     * 1.当执行到最后一个节点的时候，方法开始回调。此时返回了最后一个节点node，此时将最后一个节点的next设置为倒数第二个，倒数第二个的next设置为
     * null
     * 2.此时倒数第二个节点的next设置为倒数第三个，
     * 3.以此类推
     *
     *
     */
    public static Node reverse(Node head) {
        // 当head没有前驱时，代表函数执行到最后一个节点了，此时开始返回结果并反转执行
        if (head == null || head.getNext() == null) {
            return head;// 若为空链或者当前结点在尾结点，则直接返回
        }
        Node reHead = reverse(head.getNext());
        //递归到最后此时这个head为倒数第二个节点，首先将最后一个节点的前驱设置倒数第二个节点，以此类推
        head.getNext().setNext(head);// 将head下一个节点的前驱设置为head，即指向反转了
        head.setNext(null);// 将head的前驱暂时设置为null
        //最终reHead其实是原来链表的最后一个节点
        return reHead;
    }

    class Node {
        private int Data;// 数据域
        private Node Next;// 指针域

        public Node(int Data) {
            // super();
            this.Data = Data;
        }

        public int getData() {
            return Data;
        }

        public void setData(int Data) {
            this.Data = Data;
        }

        public Node getNext() {
            return Next;
        }

        public void setNext(Node Next) {
            this.Next = Next;
        }
    }
}


