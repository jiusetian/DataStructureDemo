package queue;

import java.util.Arrays;

/**
 * Author：Alex
 * Date：2019/12/24
 * Note：堆的实现
 */
public class Heap<E extends Comparable<E>> {

    private Object[] array; //数组数据
    private int size;
    private static final int DEFAULT_INITIAL_CAPACITY = 11;
    /**
     * The maximum size of array to allocate.
     * Some VMs reserve some header words in an array.
     * Attempts to allocate larger arrays may result in
     * OutOfMemoryError: Requested array size exceeds VM limit
     */
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    public Heap() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public Heap(int capacity) {
        array = new Object[capacity];
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
    private int parent(int index) {
        if (index == 0)
            return 0;
        return (index - 1) / 2;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    //交换元素
    public void swap(int i, int j) {
        Object temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 添加元素
     * 直接将元素添加到数组的最后位置，然后进行上浮即shifUp操作，shifUp会把添加的元素移动到合适的位置
     *
     * @param e
     */
    public void add(E e) {
        if (size == array.length) {
            //扩容
            grow(array.length + 1);
        }
        array[size] = e;
        shiftUp(size);
        size++;
    }



    /**
     * 将下标为k的元素进行上浮操作
     * 如果一个节点比它的父节点大（最大堆）或者小（最小堆），那么需要将它同父节点交换位置。这样这个节点在数组的位置上升
     *
     * @param k
     */
    private void shiftUp(int k) {
        //当compare(object o1 ,object o2)直接reture o1 - o2的时候，大于0代表前者大于后者，此时建立的是最大堆，如果reture o2 - o1,
        //大于0代表o2大于o1，此时建立的是最小堆
        while (k > 0 && ((E) array[k]).compareTo((E) array[parent(k)]) > 0) {
            //交换元素
            swap(k, parent(k));
            k = parent(k);
        }
    }

    /**
     * 堆化操作
     * 从最后那个非子叶节点开始shifDown操作，直到根节点的shifDown操作结束则整个堆化完成，最后那个非子叶节点就是最后一个那个节点的父节点
     *
     * @param array
     */
    public void heapify(E[] array) {
        this.array = array;
        for (int i = parent(size - 1); i >= 0; i--) {
            shifDown(i);
        }
    }

    /**
     * 获取最前面的元素
     *
     * @return
     */
    public E getFront() {
        if (isEmpty())
            return null;
        return (E) array[0];
    }

    /**
     * 移除第一个元素
     * 取出数组的第一个元素，然后将最后一个元素替换上去，再从第一个元素开始进行shifDown操作，shifDown可以为第一个元素找到合适的位置，然后整个堆又
     * 重新调整为正确的堆结构，至于为什么要取最后一个元素替换第一个元素，这个没有严格规定的，可以是其他位置的元素，只是取最后一个元素方便
     *
     * @return
     */
    public E removeFront() {
        E e = getFront();
        //空堆直接返回null
        if (e == null)
            return e;
        //将最后一个值赋予第一个值，然后最后一个置为null
        array[0] = array[size - 1];
        array[size-1] = null;
        size--;
        shifDown(0);

        return e;
    }

    /**
     * 将下标为k的元素进行下沉操作
     * 如果一个节点比它的子节点小（最大堆）或者大（最小堆），那么需要将它向下移动
     * 如果是最大堆要取子节点中大的那个跟当前节点比，如果是最小堆要取子节点中小的那个跟当前节点比
     *
     * @param k
     */
    private void shifDown(int k) {

        int left = leftChild(k); //当前节点的左节点
        int right = rightChild(k); //当前节点的右节点
        int i = 0; //进行比较的子节点下标

        //如果当前节点没有子节点了，则退出
        while (left < size || right  < size) {

            //左右节点都有，则取小（最大堆）或者大（最小堆）
            if (left < size && right < size) {
                i = ((E) array[left]).compareTo((E) array[right]) > 0 ? left : right;
            }
            //只有左节点
            else if (left < size) {
                i = left;
            }
            //只有右节点
            else if (right < size) {
                i = right;
            }else { //没有左右节点
                break;
            }

            //如果一个节点比它的子节点小（最大堆）或者大（最小堆），则跟被比较节点交换
            if (((E) array[k]).compareTo((E) array[i]) < 0) {
                //交换
                swap(k, i);
                k = i;
                left=leftChild(k);
                right=rightChild(k);
            } else { //shifDown结束
                break;
            }
        }

    }


    //扩容
    private void grow(int minCapacity) {
        int oldCapacity = array.length;
        // Double size if small; else grow by 50%
        int newCapacity = oldCapacity + ((oldCapacity < 64) ?
                (oldCapacity + 2) :
                (oldCapacity >> 1));
        // overflow-conscious code
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        array = Arrays.copyOf(array, newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE :
                MAX_ARRAY_SIZE;
    }
}























