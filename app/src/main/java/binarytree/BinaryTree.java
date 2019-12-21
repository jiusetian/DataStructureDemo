package binarytree;

/**
 * Created by XR_liu on 2018/11/18.
 * 二分法的查找过程是，在一个有序的序列中，每次都会选择有效范围中间位置的元素作判断，即每次判断后，都可以排除近一半的元素，直到查找到目标元素或返回不存在，
 * 所以 n 个有序元素构成的序列，查找的时间复杂度为 O(log_2 n)
 * 二叉搜索树的查找，最好的时间复杂度和二分法一样，就是说只有每个子树的左右对称的情况下，查找时间才是O(log_2 n)，最坏情况二叉搜索树为一条直线相当于一个链表的
 * 情况下，因为二叉搜索树为一条链表的情况下，那也是一条从小到到或者从大到小的链表，所以查找时间复杂度为O(n)
 */
public class BinaryTree implements Tree {

    //表示根节点
    private Node root;

    //查找节点
    public Node find(int data) {
        Node current = root;
        while (current != null) {
            if (current.data > data) { //当前值比查找值大，搜索左子树
                current = current.leftChild;
            } else if (current.data < data) { //当前值比查找值小，搜索右子树
                current = current.rightChild;
            } else if (current.data==data){
                return current;
            }
        }
        return null;//遍历完整个树没找到，返回null
    }


    /**
     * 插入节点
     *
     * 1.有一个当前节点，初始值为根节点
     * 2.当根节点为null，直接插入作为根节点
     * 3.如果插入值小于当前节点，则去左子树查找插入位置，如果插入值大于当前节点，则去右子树查找插入位置
     * 4.如果当前节点的下一个节点为null，则直接插入到当前节点的下一个节点，方法结束返回true
     *
     * @param data
     * @return
     */
    public boolean insert(int data) {
        Node newNode = new Node(data);
        if (root == null) {//当前树为空树，没有任何节点
            root = newNode;
            return true;
        } else {
            Node current = root;
            while (current != null) {
                //插入值比当前值小，搜索左子数
                if (data < current.data) {
                    if (current.leftChild == null) { //如果左子节点为空，直接将新值插入到该节点
                        current.leftChild = newNode;
                        return true;
                    }
                    current = current.leftChild;

                } else if (data > current.data) { //插入值比当前值大，搜索右子树
                    //右子节点为空，直接将新值插入到该节点
                    if (current.rightChild == null) {
                        current.rightChild = newNode;
                        return true;
                    }
                    current = current.rightChild;
                }
            }
        }
        return false;
    }

    public Node getRoot() {
        return root;
    }

    //中序遍历，即当前节点先遍历左子树，然后打印自身，然后遍历右子树
    public void infixOrder(Node rootNode) {
        if (rootNode != null) {
            infixOrder(rootNode.leftChild);
            System.out.print(rootNode.data + " ");
            infixOrder(rootNode.rightChild);
        }
    }

    //前序遍历

    /**
     * 这是一个递归函数，从逻辑上来说，前中后序的遍历都一样，只是打印数据的时机不一样
     * 递归算法的条件：
     * 1.算法的整个过程由n多个相同的逻辑单元构成，这是构成递归的基本条件
     * 2.在递归的层次关系中，下一层逻辑单元的返回值（也可以没有返回值）是上一层逻辑单元执行的某个条件
     * 3.逻辑单元的执行在特定的时候，有结束执行的条件
     * 4.递归的特征就是一层嵌套一层的调用，外层方法包含了被嵌套的内存方法，调用顺序是从外层依次到内层，方法结束顺序是从内层依次到外层
     * @param rootNode
     */
    public void preOrder(Node rootNode) {
        if (rootNode != null) {
            System.out.print(rootNode.data + " ");
            preOrder(rootNode.leftChild);
            preOrder(rootNode.rightChild);
        }
    }

    //后序遍历
    public void postOrder(Node rootNode) {
        if (rootNode != null) {
            postOrder(rootNode.leftChild);
            postOrder(rootNode.rightChild);
            System.out.print(rootNode.data + " ");
        }
    }

    //找到最大值
    public Node findMax() {
        Node current = root;
        Node maxNode = current;
        while (current != null) {
            maxNode = current;
            current = current.rightChild;
        }
        return maxNode;
    }

    //找到最小值
    public Node findMin() {
        Node current = root;
        Node minNode = current;
        while (current != null) {
            minNode = current;
            current = current.leftChild;
        }
        return minNode;
    }

    @Override
    public boolean delete(int key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = false;
        //查找删除值，找不到直接返回false
        while (current.data != key) {
            parent = current;
            if (current.data > key) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) {
                return false;
            }
        }
        //如果当前节点没有子节点
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
            return true;

            //当前节点有一个子节点，右子节点
        } else if (current.leftChild == null && current.rightChild != null) {
            if (current == root) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
            return true;
            //当前节点有一个子节点，左子节点
        } else if (current.leftChild != null && current.rightChild == null) {
            if (current == root) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
            return true;
        } else {
            //当前节点存在两个子节点
            Node successor = delNodeWithTwoNodes(current);
            if (current == root) {
                successor = root;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return false;

    }

    //删除节点有两个子节点
    public Node delNodeWithTwoNodes(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        //后继节点不是删除节点的右子节点，将后继节点替换删除节点
        if (successor != delNode.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }

        return successor;
    }

    public static void binaryTreeTest() {
        BinaryTree bt = new BinaryTree();
//        bt.insert(50);
//        bt.insert(20);
//        bt.insert(50);
//        bt.insert(80);
//        bt.insert(10);
//        bt.insert(30);
//        bt.insert(60);
//        bt.insert(90);
//        bt.insert(25);
//        bt.insert(85);
//        bt.insert(100);
        bt.insert(4);
        bt.insert(6);
        bt.insert(5);
        bt.insert(2);
        bt.insert(3);
        bt.insert(1);
        //中序遍历
//        bt.infixOrder(bt.getRoot());
//        System.out.println();
        //前
  //      bt.preOrder(bt.getRoot());
     //   System.out.println();
//        //后
        bt.postOrder(bt.getRoot());
        System.out.println();
        bt.delete(10);//删除没有子节点的节点
        bt.delete(30);//删除有一个子节点的节点
        bt.delete(80);//删除有两个子节点的节点
        System.out.println(bt.findMax().data);
        System.out.println(bt.findMin().data);
        System.out.println(bt.find(100));
        System.out.println(bt.find(200));
        System.out.println(bt.find(50));

    }

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

}


