package linklist.cyclelink;

/**
 * Author：Alex
 * Date：2019/12/12
 * Note：双向循环链表
 */
public class CycleDoubleLinkList {

    private Node header;
    private Node tail;
    private int size;

    public CycleDoubleLinkList() {
        header = null;
        tail = null;
        size = 0;
    }

    /**
     * 添加表头
     *
     * @param data
     */
    public void addHeader(Object data) {
        Node node = new Node(data);

        if (size == 0) { //没有元素
            header = node;
            tail = node;
            //头节点的前一个节点是尾节点，尾节点的后一个节点是头节点
            header.prev=tail;
            tail.next=header;
            size++;
        } else {
            //头节点的前一个节点是尾节点，尾节点的后一个节点是头节点
            node.prev=tail;
            tail.next=node;
            //改变header
            node.next = header;
            header.prev = node;
            header = node;
            size++;
        }
    }

    /**
     * 添加表尾
     *
     * @param data
     */
    public void addTail(Object data) {

        Node node = new Node(data);

        if (size == 0) { //没有数据的情况下
            header = node;
            tail = node;
            //头节点的前一个节点是尾节点，尾节点的后一个节点是头节点
            header.prev=tail;
            tail.next=header;
            size++;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
            //头节点的前一个节点是尾节点，尾节点的后一个节点是头节点
            header.prev=tail;
            tail.next=header;
            size++;
        }
    }

    /**
     * 删除头节点
     *
     * @return
     */
    public Object deleteHeader() {
        //没有节点
        if (size == 0) return null;

        Object data = header.data;
        if (header.next == null) { //只有一个节点
            header = null;
            tail = null;
        } else {
            header.next.prev = null;
            header = header.next;
            //头节点的前一个节点是尾节点，尾节点的后一个节点是头节点
            header.prev=tail;
            tail.next=header;
        }
        size--;
        return data;
    }

    /**
     * 删除尾节点
     *
     * @return
     */
    public Object deleteTail() {
        if (size == 0) return null;

        Object data = tail.data;
        if (tail.prev == null) { //只有一个节点
            header = null;
            tail = null;
        } else {
            tail.prev.next = null;
            tail = tail.prev;
            //头节点的前一个节点是尾节点，尾节点的后一个节点是头节点
            header.prev=tail;
            tail.next=header;
        }
        size--;
        return data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private class Node {
        Object data;
        Node next;
        Node prev;

        public Node(Object object) {
            data = object;
        }
    }
}
