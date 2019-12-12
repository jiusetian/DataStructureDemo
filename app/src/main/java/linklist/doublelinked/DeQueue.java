package linklist.doublelinked;

/**
 * Author：Alex
 * Date：2019/12/12
 * Note：双端队列，两端都实现插入和删除操作
 */
public class DeQueue {

    private DoubleLinkedList linkedList;

    public DeQueue() {
        linkedList = new DoubleLinkedList();
    }

    public void insertFront(Object data) {
        linkedList.addHeader(data);
    }

    public void insertBehind(Object data) {
        linkedList.addTail(data);
    }

    public Object removeFront() {
        return linkedList.deleteHeader();
    }

    public Object removeBehind() {
        return linkedList.deleteTail();
    }

}
