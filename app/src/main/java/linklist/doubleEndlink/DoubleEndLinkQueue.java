package linklist.doubleEndlink;

/**
 * Author：Alex
 * Date：2019/12/12
 * Note：双端链表实现的队列
 */
public class DoubleEndLinkQueue {

    private DoubleEndLinkedList linkedList;

    public DoubleEndLinkQueue() {
        linkedList = new DoubleEndLinkedList();
    }

    public void insert(Object data) {
        linkedList.addTail(data);
    }


    public boolean delete() {
        return linkedList.deleteHeader();
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    public int size() {
        return linkedList.size();
    }
}
