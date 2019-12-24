package queue;

/**
 * Author：Alex
 * Date：2019/12/24
 * Note：一个基于堆实现的简单的优先队列
 * 如果要构造优先队列的最小堆，则重写E的compareTo方法的时候 reture -（参数1 - 参数2），构造最大堆则 reture 参数1 - 参数2
 */
public class SimplePriorityQueue<E extends Comparable<E>> {

    private Heap<E> heap;

    public SimplePriorityQueue() {
        heap = new Heap<>();
    }

    public SimplePriorityQueue(int capacity){
        heap=new Heap<>(capacity);
    }


    /**
     * 获取队列的大小
     * @return
     */
    public int getSize() {
        return heap.size();
    }

    /**
     * 是否为空队列
     * @return
     */
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    /**
     * 获取队列中最前面的元素
     * @return
     */
    public E getFront() {
        return heap.getFront();
    }

    /**
     * 入列一个元素
     * @param e
     */
    public void add(E e) {
        heap.add(e);
    }

    /**
     * 出列一个元素
     * @return
     */
    public E dequeue() {
        return heap.removeFront();
    }

    /**
     * 堆化一个数组
     * @param array
     */
    public void heapify(E[] array){
        heap.heapify(array);
    }
}

