package linklist.singlelink;

/**
 * Author：Alex
 * Date：2019/12/12
 * Note：单链表实现的栈
 */
public class SingleLinkListStack {

    //单链表
    private SingleLinkedList linkedList;

    public SingleLinkListStack(){
        linkedList=new SingleLinkedList();
    }

    /**
     * 压入数据
     * @param ob
     * @return
     */
    public Object push(Object ob){
       return linkedList.addHeader(ob);
    }

    /**
     * 取出数据
     * @return
     */
    public Object pop(){
        return linkedList.deleteHeader();
    }

    /**
     * 栈大小
     * @return
     */
    public int size(){
        return linkedList.size();
    }
}
