package linklist.doubleEndlink;

/**
 * Author：Alex
 * Date：2019/12/12
 * Note：双端列表，适合用于实现队列
 */
public class DoubleEndLinkedList {

    private int size;
    //链表头
    private Node header;
    //链表尾
    private Node tail;


    public DoubleEndLinkedList() {
        size = 0;
        header = null;
        tail = null;
    }

    /**
     * 添加表头header
     *
     * @param data
     */
    public void addHeader(Object data) {

        Node node = new Node(data);
        if (header == null) {
            //没有header，此时tail和header为同一个
            header = node;
            tail = node;
            size++;
        } else {
            node.next = header;
            header = node;
            size++;
        }
    }

    /**
     * 添加尾节点
     *
     * @param data
     */
    public void addTail(Object data) {
        Node node = new Node(data);
        //如果链表为空
        if (header == null) {
            header = node;
            tail = node;
            size++;
        } else {
            tail.next = node;
            tail = node;
            size++;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    /**
     * 删除头节点
     *
     * @return
     */
    public boolean deleteHeader() {
        if (size == 0) return false;

        header = header.next;
        if (header == null) { //代表删除后没有节点了
            tail = null;
        }
        size--;
        return true;
    }


    /**
     * 链表的节点
     */
    private class Node {
        //节点数据
        private Object data;
        //下一个节点的引用
        private Node next;

        public Node(Object data) {
            this.data = data;
        }
    }
}
