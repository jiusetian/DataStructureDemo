package linklist.single;

/**
 * Author：Alex
 * Date：2019/12/12
 * Note：单向链表
 */
public class SingleLinkedList {

    //链表大小
    private int size;
    //头节点
    private Node header;


    public SingleLinkedList() {
        size = 0;
        header = null;
    }

    /**
     * 添加头节点
     *
     * @param data
     * @return
     */
    public Object addHeader(Object data) {
        Node node = new Node(data);
        if (size == 0) {
            header = node;
        } else {
            node.next = header;
            header = node;
        }
        size++;
        return data;
    }

    /**
     * 删除头节点
     */
    public Object deleteHeader() {
        //主要是改变头节点的next指针，还有size--
        Object data = header.data;
        header = header.next;
        size--;
        return data;
    }

    /**
     * 查找元素，需要从头开始遍历链表，直到找到查找的元素或者链表不存在此元素
     *
     * @param ob
     * @return
     */
    public Node find(Object ob) {
        //遍历的当前节点
        Node current = header;
        //查找的目标
        Node target = null;
        //如果当前遍历到的节点为null，查找结束
        while (current != null) {
            if (ob.equals(current.data)) { //找到了目标
                target = current;
                break;
            } else { //继续下一个节点
                current = current.next;
            }
        }
        return target;
    }

    /**
     * 删除指定的元素，首先还是要遍历找到对应的元素，找到以后要改变当前节点的前节点的next值
     *
     * @param ob
     * @return
     */
    public boolean delete(Object ob) {

        Node current = header;
        Node previous = header;
        Node target = null;

        //首先找目标
        while (current != null) {
            if (ob.equals(current.data)) { //找到了跳出
                target = current;
                break;
            } else {
                previous = current;
                current = current.next;
            }
        }

        //没有找到元素
        if (target == null) {
            return false;
        } else if (target.equals(header)) { //如果头节点是目标元素
            header = header.next;
            size--;
            return true;
        } else {
            //删除节点，改变前节点的next值即可
            previous.next = target.next;
            size--;
            return true;
        }

    }

    /**
     * 显示链表元素
     */
    public void display(){

    }

    /**
     * 判断链表是否为空
     * @return
     */
    public boolean isEmpty(){
        return size==0;
    }

    public int size(){
        return size;
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


