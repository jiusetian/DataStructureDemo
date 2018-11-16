package hash;

/**
 * Created by XR_liu on 2018/11/16.
 * 有序链表
 */
public class SortLink {
    
    private LinkNode first;

    public SortLink() {
        first = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    //插入节点
    public void insert(LinkNode node) {
        int key = node.getKey();
        LinkNode previous = null;
        LinkNode current = first;
        //按顺序插入，找到需要插入位置两边的节点
        while (current != null && current.getKey() < key) {
            previous = current;
            current = current.next;
        }
        //如果头结点为null
        if (previous == null) {
            first = node;
        } else {
            //插入到中间
            node.next = current;
            previous.next = node;
        }
    }

    public void delete(int key) {
        LinkNode previous = null;
        LinkNode current = first;
        if (isEmpty()) {
            System.out.println("Linked is Empty!!!");
            return;
        }
        while (current != null && current.getKey() != key) {
            previous = current;
            current = current.next;
        }
        if (previous == null) {
            first = first.next;
        } else {
            previous.next = current.next;
        }
    }

    //查找节点
    public LinkNode find(int key) {
        LinkNode current = first;
        //从头节点开始查找
        while (current != null && current.getKey() <= key) {
            if (current.getKey() == key) {
                return current;
            }
        }
        return null;
    }

    public void displayLink() {
        System.out.println("Link(First->Last)");
        LinkNode current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }

    class LinkNode {
        private int iData;
        public LinkNode next;

        public LinkNode(int iData) {
            this.iData = iData;
        }

        public int getKey() {
            return iData;
        }

        public void displayLink() {
            System.out.println(iData + " ");
        }
    }
}
