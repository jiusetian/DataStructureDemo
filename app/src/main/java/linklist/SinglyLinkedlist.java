package linklist;

/**
 * 自定义单向链表
 */

public class SinglyLinkedlist {

    private Node header; //链表的头部

    /**
     * 添加节点
     */
    public void addNode(Node node) {
        Node temp = header; //从链表的头部开始遍历
        if (temp == null) { //如果header为null
            header = node;
            return;
        }
        while (temp.next != null) { //循环找到链表的最后一个节点
            temp = temp.next;
        }
        temp.next = node; //在最后一个节点上添加

    }

    //获取链表的长度
    public int length() {
        int len = 0;
        Node temp = header;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        return len;

    }

    /**
     * 获取指定位置的节点
     * @param index
     * @return
     */
    public Node get(int index){
        Node temp=header;
        int len=0;
        while (temp!=null){ //遍历
            if (index==len){
                return temp;
            }
            temp=temp.next;
            len++;
        }
        throw  new ArrayIndexOutOfBoundsException("没有指定位置的节点");
    }


    /**
     * 将节点插入到指定位置
     */
    public void addNodeByIndex(int index, Node node) {

        //首先判断插入的位置是否合法
        if (index < 1 || index > length() + 1) {
            new ComException("插入位置不合法");
            return;
        }

        Node temp = header;
        //如果头结点为null
        if (temp == null) {
            header = node;
            return;
        }
        //如果插入到第一个位置
        if (index==1){
            node.next=temp;
            header=node; //改变header
            return;
        }
        int len = 2; //从第二个位置开始
        while (temp != null) { //循环遍历链表
            //首先len代表遍历到第几个节点，然后判断是否插入当前节点的后面
            if (index==len++){ //如果为true，代表就插入当前节点的后面
                node.next=temp.next;
                temp.next=node;
                return;
            }
            temp=temp.next;
        }

    }

    /**
     * 删除指定位置的节点
     * @param index
     */
    public void removeNodeByIndex(int index){
        //判断index是否合法
        if (index<1||index>length()){
            new ComException("删除的指定位置不合法");
            return;
        }

        //如果删除的是头结点
        if (index==1){
            header=header.next;
            return;
        }

        Node temp=header;
        int len=2;
        while (temp!=null){
            if (index==len++){
                temp.next=temp.next.next;
            }
            temp=temp.next;
        }
    }
}
































