package arith;

/**
 * Author：Alex
 * Date：2019/12/20
 * Note：
 */
public class Search {

    static String TAG = "tag";

    /**
     * 顺序查找
     *
     * @param array
     * @param value
     * @return
     */
    public static int sequenceSearch(int[] array, int value) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] == value)
                return i;
        }
        return -1;
    }


    /**
     * 二分法查找
     * <p>
     * 基本思想：
     * 1.首先被查找数组应该是一个有序数组，如果不是要先排序
     * 2.然后将数组折半，比较中间那个值跟查找值是否相同，相同则返回查找结束，如果查找值大于中间值，则去后半段查找，如果小于则去前半段查找
     * 3.要想得到中间值，必须知道两边的数据是多少，所以要有两个数据记录折半后的数组的头和尾的下标是多少
     * 4.当数组头尾的下标相同的时候，代表只有一个数据了，此时查找结束
     * <p>
     * 复杂度分析：最坏情况下，关键词比较次数为log2(n+1)，且期望时间复杂度为O(log2n)，效率比顺序查找高，但需要被查找数组为有序数组
     *
     * @param array
     * @param value
     * @return
     */
    public static int binarySearch(int[] array, int value) {
        int mid;
        int low = 0;
        int high = array.length - 1;

        while (high >= low) {
            mid = (low + high) >> 1;
            if (array[mid] == value) {
                //找到目标值
                return mid;
            } else if (value > array[mid]) { //下一步查找后半段
                low = mid + 1;
            } else if (value < array[mid]) { //下一步查找前半段
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 递归实现二分法查找
     *
     * @param array
     * @param value
     * @return
     */
    public static int binarySearch2(int[] array, int value) {
        return binarySearchRecursion(array, value, 0, array.length - 1);
    }

    private static int binarySearchRecursion(int[] array, int value, int low, int high) {

        if (high >= low) {
            int mid = (high + low) >> 1;
            if (value == array[mid]) {
                return mid;
            }

            if (value > array[mid]) {
                low = mid + 1;
                return binarySearchRecursion(array, value, low, high);
            }

            if (value < array[mid]) {
                high = mid - 1;
                return binarySearchRecursion(array, value, low, high);
            }
        }

        return -1;
    }

    /**
     * 插值查找
     * <p>
     * 基本思想：插值查找是二分查找的改进版，二分查找在任何情况下都对数组进行对半分，但是如果在一个有序数组中查找一个比较接近前部分的数值，我们是不是可以进可能
     * 地在数组的前面去寻找呢，但是二分查找还是从中间开始寻找，所以这个算法有改进的空间
     * 我们要找到一个根据查找数值的大小来猜测它在数组中的位置的方法，二分法是的中间值是这样计算的mid = low + 1/2*(high - low)，在这里我们要改进的就是这个1/2值，
     * 普遍的做法是 mid = low + (value- array[low])/(high + low) * (high - low)， 其中(value- array[low])/(high + low)就是我们对查找值value的位置的一个猜测
     * <p>
     * 复杂度分析：查找成功或者失败的时间复杂度均为O(log2(log2n))
     * 在数组里的数据分布比较均匀的时候，用插值查找法比较好，否则就不是很好
     *
     * @param array
     * @param value
     * @return
     */
    public static int insertSearch(int[] array, int value) {

        int mid;
        int low = 0;
        int high = array.length - 1;

        while (high >= low) {
            mid = low + (value - array[low]) / (high + low) * (high - low);

            if (value == array[mid])
                return mid;

            if (value > array[mid])
                low = mid + 1;

            if (value < array[mid])
                high = mid - 1;
        }

        return -1;
    }

    public static int insertSearch2(int[] array, int value){
        return insertSearch2(array,value,0,array.length-1);
    }

    /**
     * 插值算法的递归实现
     *
     * @param array
     * @param value
     * @param low
     * @param high
     * @return
     */
    private static int insertSearch2(int[] array, int value, int low, int high) {

        if (high >= low) {
            int mid = low + (value - array[low]) / (high + low) * (high - low);

            if (value == array[mid])
                return mid;

            if (value > array[mid])
                return insertSearch2(array, value, mid + 1, high);

            if (value < array[mid])
                return insertSearch2(array, value, low, mid - 1);
        }

        return -1;
    }


}




















