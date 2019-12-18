package stack;

/**
 * Author：Alex
 * Date：2019/12/13
 * Note：单链表实现的栈
 */
public class SingleLinkStack {

    //单链表
    private SingleLinkedList linkedList;

    public SingleLinkStack() {
        linkedList = new SingleLinkedList();
    }

    /**
     * 压入数据
     *
     * @param ob
     * @return
     */
    public Object push(Object ob) {
        return linkedList.addHeader(ob);
    }

    /**
     * 取出数据
     *
     * @return
     */
    public Object pop() {
        return linkedList.deleteHeader();
    }

    /**
     * 栈大小
     *
     * @return
     */
    public int size() {
        return linkedList.size();
    }


    /**
     * 单链表类
     */
    private class SingleLinkedList {

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
         * 反转链表
         */
        public void reverse() {
            header = reverse(header);
        }

        private Node reverse(Node head) {
            // 当head没有前驱时，代表函数执行到最后一个节点了，此时开始返回结果并反转执行
            if (head == null || head.next == null) {
                return head;// 若为空链或者当前结点在尾结点，则直接返回
            }
            Node reHead = reverse(head.next);
            //递归到最后此时这个head为倒数第二个节点，首先将最后一个节点的前驱设置倒数第二个节点，以此类推
            head.next.next = head;// 将head下一个节点的前驱设置为head，即指向反转了
            head.next = null;// 将head的前驱暂时设置为null
            //最终reHead其实是原来链表的最后一个节点
            return reHead;
        }

        /**
         * 显示链表元素
         */
        public void display() {
            if (size > 0) {
                Node node = header;
                int tempSize = size;
                if (tempSize == 1) {//当前链表只有一个节点
                    System.out.println("[" + node.data + "]");
                    return;
                }
                while (tempSize > 0) {
                    if (node.equals(header)) {
                        System.out.print("[" + node.data + "->");
                    } else if (node.next == null) {
                        System.out.print(node.data + "]");
                    } else {
                        System.out.print(node.data + "->");
                    }
                    node = node.next;
                    tempSize--;
                }
                System.out.println();
            } else {//如果链表一个节点都没有，直接打印[]
                System.out.println("[]");
            }
        }

        /**
         * 判断链表是否为空
         *
         * @return
         */
        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
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

}
