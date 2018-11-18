package binarytree;

/**
 * Created by XR_liu on 2018/11/18.
 */
public class Node {

    public int data;    //节点数据
    public Node leftChild; //左子节点的引用
    public Node rightChild; //右子节点的引用

    //打印节点内容
    public void display() {
        System.out.println(data);
    }

    public Node(int data) {
        this.data = data;
    }
}
