package hash;

/**
 * Created by XR_liu on 2018/11/16.
 * 哈希表的链地址法
 */
public class HashChaining {

    private SortLink[] hashArray;//数组中存放链表
    private int arraySize;

    public HashChaining(int size) {
        arraySize = size;
        hashArray = new SortLink[arraySize];
        //new 出每个空链表初始化数组
        for (int i = 0; i < arraySize; i++) {
            hashArray[i] = new SortLink();
        }
    }

    public void displayTable() {
        for (int i = 0; i < arraySize; i++) {
            System.out.print(i + "：");
            hashArray[i].displayLink();
        }
    }

    public int hashFunction(int key) {
        return key % arraySize;
    }

    //插入
    public void insert(SortLink.LinkNode node) {
        int key = node.getKey();
        int hashVal = hashFunction(key);
        hashArray[hashVal].insert(node);//直接往链表中添加即可
    }

    public SortLink.LinkNode delete(int key) {
        int hashVal = hashFunction(key);
        SortLink.LinkNode temp = find(key);
        hashArray[hashVal].delete(key);//从链表中找到要删除的数据项，直接删除
        return temp;
    }

    public SortLink.LinkNode find(int key) {
        int hashVal = hashFunction(key);
        SortLink.LinkNode node = hashArray[hashVal].find(key); //直接从链表中查找
        return node;
    }

}
