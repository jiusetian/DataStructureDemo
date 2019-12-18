package binarytree;


/**
 * Author：Alex
 * Date：2019/12/13
 * Note：
 */
public interface Tree {

    //查找节点
    public BinaryTree.Node find(int key);
    //插入新节点
    public boolean insert(int data);

    //中序遍历
    public void infixOrder(BinaryTree.Node current);
    //前序遍历
    public void preOrder(BinaryTree.Node current);
    //后序遍历
    public void postOrder(BinaryTree.Node current);

    //查找最大值
    public BinaryTree.Node findMax();
    //查找最小值
    public BinaryTree.Node findMin();

    //删除节点
    public boolean delete(int key);

    //......
}
