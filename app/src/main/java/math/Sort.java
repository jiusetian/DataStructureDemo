package math;

import java.util.Stack;

/**
 * 排序算法
 */
public class Sort {

    private static String TAG = "tag";

    /**
     * 冒泡排序法
     * 逻辑思路：从第一个开始和后面的数据比较， 把大的那个数往后放，这样比较一轮以后，第一个就是最大数了
     * 然后进行第二轮比较，也是从第一个数开始，但是比较到倒数第二个结束
     * 以此类推比较，最后排出顺序来
     *
     * @param arry
     * @return
     */
    public static int[] bubbleSort(int[] arry) {
        if (arry.length < 2) return arry;
        //要比较的轮次arry.lenth-1
        for (int i = 1; i < arry.length; i++) {
            boolean flag = true;
            //第i轮要比较的次数arry.length-i
            for (int j = 0; j < arry.length - i; j++) {
                if (arry[j] > arry[j + 1]) { //如果比后面那个数大， 则要交换
                    int temp;
                    temp = arry[j];
                    arry[j] = arry[j + 1];
                    arry[j + 1] = temp;
                    flag = false; //代表里面有数据是顺序不对的
                }
            }

            if (flag) //如果经过比较，里面的顺序都是从小到大的，那么就直接跳出，不用再比较了
                break;

        }
        return arry;
    }

    /**
     * 选择排序法
     * 逻辑思路：从第一个数据开始往后比较，找出最小数是哪个位置，然后把最小数当在最前面，把对应位置调换
     * 第二轮是从第二个数据开始比较，跟上面一样
     * 最后排出顺序
     *
     * @param array
     * @return
     */
    public static int[] selectSort(int[] array) {
        if (array.length < 2) return array;

        //首先计算要进行比较的次数为
        for (int i = 0; i < array.length - 1; i++) {
            int min = i; //最小数的index
            //进行比较，找出最小数的下标值
            for (int j = i + 1; j < array.length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            //交换
            if (min != i) {
                int temp = array[min];
                array[min] = array[i];
                array[i] = temp;
            }


        }
        return array;
    }

    /**
     * 插入排序法
     * 基本思路：初始第一个算是一件排序好的数列，然后从它后面那个数开始到最后一个数算是未排序好是数列，
     * 那么我们取出未排好的数列的第一个数插入到已经排序好数列中，即插入到比它小的数当中最大的那个数的后面，
     * 如果没有一个比它小，那么它插到最前面
     * 如此类推排列
     * <p>
     * 官方思路：
     * 1.从第二个数开始算是未排序的数列
     * 2.我们拿未排列的第一个数到已排列的数列中去逐一比较，当发现有比它小的数的时候，就算比较结束
     * 3.那么此数就插入到比它小的数的后面
     *
     * @param array
     * @return
     */
    public static int[] insertSort(int[] array) {

        if (array.length < 2) return array;

        for (int i = 1; i < array.length; i++) {

            int temp = array[i]; //此数是未排列中第一个数,就是我们插入的那个数
            int j = i; //j记录temp应该插入的位置
            //查找插入位置，依次跟排列好的数列的后面开始比较，如果大于要插入的temp，就继续查找，如果小于
            //temp，则比较结束，此时的j值就是要插入的位置
            while (j > 0 && temp < array[j - 1]) {
                array[j] = array[j - 1]; //后面那个位置让给你
                j--; //减一，继续查找，直到array[j-1]大于temp，如果j==0,代表已经查到到第一个数了
            }
            array[j] = temp;
        }
        return array;

    }

    /**
     * 利用栈的后进先出原理，将一个字符串翻转
     *
     * @return
     */
    public static String reversalCharsForStack(String str) {
        Stack stack = new Stack();
        char[] chars = str.toCharArray();
        //首先push进去
        for (char c : chars) {
            stack.push(c);
        }
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) stack.pop();
        }
        return new String(chars);
    }
}
