package arith;

import java.util.Arrays;
import java.util.Stack;

/**
 * 排序算法
 */
public class Sort {

    private static String TAG = "tag";

    /**
     * 冒泡排序法
     * <p>
     * 算法思想：依次比较两个元素，挑出大的那个元素往后移动并且再跟后面的元素比较，最后得到最大的元素并且被移动到了最后面
     * <p>
     * 1.首先有一个参与比较的元素，我们叫它基准元素吧，这个元素的初始值是数组的第一个元素
     * 2.将基准元素和它下一个元素进行比较，如果基准元素大于下一个元素，则交换这两个元素的位置，然后将大的那个元素赋值给基准元素
     * 3.如此一直都是将大的元素再和下一个元素比较，而且大的元素排到两个比较元素的后面，到最后数组中最大的那个元素就排到数组后面了
     * 4.算法优化：如果在一轮比较中，基准元素的下一个元素一直都比它大，那么代表当前数组的排序已经是从小到大了，此时可以跳出循环结束比较
     * <p>
     * 时间复杂度：O(n²)
     *
     * @param array
     * @return
     */
    public static int[] bubbleSort2(int[] array) {
        //一共要比较array.length-1轮
        for (int i = 1; i < array.length; i++) {
            int current = array[0]; //基准元素
            int c = 0; //基准元素下标值
            boolean swap = false; //是否交互了元素位置
            //第i轮比较，比较次数为array.length-i次
            for (int j = 0; j < array.length - i; j++) {
                //如果基准元素大于下一个元素，则进行位置交互，基准元素等于或小于下一个元素的时候是不交换位置的
                if (current > array[c + 1]) {
                    int temp = array[c];
                    array[c] = array[c + 1];
                    array[c + 1] = temp;
                    swap = true;
                }
                //将基准元素赋值为大的那个元素
                current = array[c + 1];
                c++;
            }
            if (!swap) break;
        }
        return array;
    }

    /**
     * 冒泡排序法
     * <p>
     * 逻辑思路：从第一个开始和后面的数据比较， 把大的那个数往后放，这样比较一轮以后，第一个就是最大数了
     * 然后进行第二轮比较，也是从第一个数开始，但是比较到倒数第二个结束
     * 以此类推比较，最后排出顺序来
     * <p>
     * 平均时间复杂度O(n²)
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
     * <p>
     * 基本思想：取前面的元素和下一个元素进行比较，取小的那个元素又跟下一个元素比较，一轮比较下来就得到了最小的那个元素，然后再与刚开始的前面那个元素交换
     * 遍历数组，遍历到i时，a0,a1...ai-1是已经排好序的，然后从i到n选择出最小的，记录下位置，如果最小的不是ai，则将它和ai交换
     * <p>
     * 1.首先有一个基准元素，其初始值是开始排序比较的数组的第一个元素
     * 2.将基准元素和下一个元素进行比较，如果下一个元素小于基准元素，则将下一个元素赋值给基准元素
     * 3.一轮比较下来，基准元素就是数组中最小的那个元素了，然后将基准元素跟第一个元素交换
     *
     * @param array
     * @return
     */
    public static int[] selectSort2(int[] array) {

        for (int i = 0; i < array.length - 1; i++) { //i的最大值是倒数第二个值的下标，所以i < array.length - 1
            //基准元素
            int current = array[i];
            //基准元素下标
            int c = i;

            for (int j = c + 1; j < array.length; j++) { //j的最大值是最后一个值的下标，所以j<array.length
                //如果被比较元素小于基准元素，则将它赋值给基准元素
                if (array[j] < current) {
                    current = array[j];
                    c = j;
                }
            }

            //一轮比较结束，如果有比基准元素更小的元素，则将其与第一个元素交换
            if (c != i) {
                int temp = array[i];
                array[i] = current;
                array[c] = temp;
            }
        }
        return array;
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
     * <p>
     * 算法思想：从第二个元素依次取出来跟它前面的元素进行比较，比较顺序是从后往前，如果当前元素小于被比较元素，则将被比较元素后移一位，否则当前元素
     * 插入到被比较元素的后面
     * <p>
     * 1.首先有个基准元素，初始值为数组的第二个元素
     * 2.将基准元素从前面已经排序好的数组的最后一个元素开始比较，目的是找到一个可以插入的位置，如果基准元素小于被比较元素，代表还不能插入，此时
     * 将被比较元素后移一位，如果基准元素大于或等于被比较元素，此时代表可以插入了，将基准元素插入到被比较元素的后面
     * 3.当待排序的数据基本有序时，插入排序的效率比较高，只需要进行很少的数据移动
     *
     * @param array
     * @return
     */
    public static int[] insertSort2(int[] array) {

        for (int i = 1; i < array.length; i++) {
            int current = array[i]; //基准元素
            int pos = i; //插入位置，初始值为基准元素的下标值
            //从基准元素的前一个元素开始比较
            for (int j = i - 1; j >= 0; j--) {
                //基准元素小于被比较元素的时候，代表还不能插入
                if (current < array[j]) {
                    array[j + 1] = array[j]; //往后移动一位
                    pos = j;
                } else { //当基准元素大于或等于被比较元素时，代表可以插入了，跳出循环
                    break;
                }
            }

            //插入
            array[pos] = current;

        }
        return array;
    }

    public static int[] insertSort3(int[] array) {

        for (int i = 1; i < array.length; i++) {
            int current = array[i]; //基准元素
            int pos = i; //插入位置，初始值为基准元素的下标值
            int j = i;
            //从基准元素的前一个元素开始比较

            while (j - 1 >= 0 && array[j - 1] > current) {
                array[j] = array[j - 1]; //往后移动一位
                j--;
                pos = j;
            }

//            for (int j = i - 1; j >= 0; j--) {
//
//                //基准元素小于被比较元素的时候，代表还不能插入
//                if (current < array[j]) {
//                    array[j + 1] = array[j]; //往后移动一位
//                    pos = j;
//                } else { //当基准元素大于或等于被比较元素时，代表可以插入了，跳出循环
//                    break;
//                }
//            }

            //插入
            array[pos] = current;

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


    /**
     * 希尔排序
     *
     * @param
     * @return
     */
    public static int[] shellSort(int[] array) {

        int len = array.length;
        int temp;
        //当gap等于多少，相当于将原数组分为多少组，比如gap==2，就是将数组分为2组，然后分别对这两组进行插入排序
        int gap = len / 2;

        while (gap > 0) {

            //当gap==1的时候，就相当于一个插入排序
            for (int i = gap; i < len; i++) {
                temp = array[i];
                //插入位置的前gap位
                int preIndex = i - gap;

                while (preIndex >= 0 && array[preIndex] > temp) {
                    //移位
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                //进行插入
                array[preIndex + gap] = temp;
            }

            gap /= 2;
        }

        return array;
    }


    /**
     * @param array
     * @return
     */
    public static int[] shellSort2(int[] array) {

        //gap的初始值,此时数组分为array.length/2个分组
        int gap = array.length / 2;

        while (gap > 0) {

            int current; //基准元素
            int pos; //插入位置
            //
            for (int i = gap; i < array.length; i++) {
                //Log.d(TAG, "shellSort2: gap为="+gap);
                current = array[i];
                pos = i;
                int j = i; //当前位置插入位置

                while (j - gap >= 0 && array[j - gap] > current) {
                    //移动位置
                    array[j] = array[j - gap];
                    j -= gap;
                    pos = j;
                }

                //插入
                array[pos] = current;
            }

            gap /= 2;
        }

        return array;
    }

    /**
     * 希尔排序
     * <p>
     * 基本思想：通过将数组分组然后分别对每分组进行插入排序来简化排序的时间复杂度，分组数量依次减少，按照gap依次等于{n/2,(n/2)/2...1}的规律来决定分组的数量
     * 但是分组的元素不是连续的，而是分别抽取gap大小的间隔来分配分组的元素
     * <p>
     * 1.同样首先有个基准元素，因为gap就是数组的分组数，基准元素的初始值在逻辑上第一个分组的第二个元素
     * 2.在进行比较的时候，基准元素的前一个值在逻辑上是分组中的前一个值，而不是数组中的前一个值，因为分组元素在以数组来算的话它们是间隔gap大小的，所以基准元素
     * 在比较的时候应该以数组来算的话是跟前gap个元素进行比较
     * 3.此时就进入了插入排序的逻辑了
     * 4.当gap为0的时候结束排序
     *
     * @param array
     * @return
     */
    public static int[] shellSort3(int[] array) {

        //gap的初始值,此时数组分为array.length/2个分组
        int gap = array.length / 2;

        while (gap > 0) {
            int current; //基准元素
            int pos; //插入位置
            //
            for (int i = gap; i < array.length; i++) {
                current = array[i];
                pos = i;
                //分组的插入排序，j为分组中元素在数组中的下标值，因为分组元素下标其实是间隔gap大小的，所以每次的下一个分组元素的下标是j-gap
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (current < array[j]) { //移位
                        array[j + gap] = array[j];
                        pos = j;
                    } else { //可以插入，跳出
                        break;
                    }
                }
                //插入
                array[pos] = current;
            }

            gap /= 2;
        }

        return array;
    }

    /**
     * 归并排序
     * <p>
     * 基本思想：通过合并有序的两个数组的方式来进行排序，合并出来的就是有序的一个数组了。这里用到递归的思想，不断地将数组劈成两半，直到数组的大小小于2结束递归，
     * 返回的时候依次执行将两半的数组合并排序，这种递归用图来表示有点像满二叉树的感觉，从一个数组作为根数组出发，分为两个子数组，然后每个子数组又分为两个子数组，
     * 直到不能再分了，就开始执行合并函数，合并函数返回一个排好序的数组，跟它的另一个排好序的兄弟数组再合并，依次类推直到根数组
     * <p>
     * 合并两个数组的函数的逻辑：
     * 1.将左数组的元素跟右数组的元素进行比较，然后比较出来的小的数组保存到result数组中，当左数组或右数组已经比较完毕的时候，就将剩下的另外一个数组的元素依次
     * 保存到result数组中，因为本来左数组和右数组都是有序的，所以这种合并出来的结果也是一个有序的数组
     *
     * @param array
     * @return
     */
    public static int[] mergeSort2(int[] array) {
        if (array.length < 2) return array;
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge2(mergeSort2(left),mergeSort2(right));
    }

    /**
     * 将两个有序的数组合并成一个有序的数组
     * 算法思路：
     * 1.
     *
     * @param left
     * @param right
     * @return
     */
    public static int[] merge2(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];

        int l = 0; //记录左数组被读到哪里
        int r = 0; //记录右数组被读到哪里
        int index = 0; //记录结果数组保存到哪里了
        //首先对比左右数组的大小，将小的元素复制到result中
        for (int i = 0, j = 0; i < left.length && j < right.length; ) {
            if (left[i] > right[j]) {
                result[index++] = right[j++];
                r++;
            } else {
                result[index++] = left[i++];
                l++;
            }
        }

        if (l == left.length ) { //剩下右数组
            while (index < result.length) {
                result[index++] = right[r++];
            }
        } else { //剩下左数组
            while (index < result.length) {
                result[index++] = left[l++];
            }
        }
        return result;

    }

    /**
     * 归并排序
     *
     * @param array
     * @return
     */
    public static int[] mergeSort(int[] array) {
        if (array.length < 2) return array;
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        //递归调用，每个参数又是一个递归，每次都把切割的左右数组再次切割进行递归，直到数组的长度小于2返回结束递归调用
        return merge(mergeSort(left), mergeSort(right));
    }

    /**
     * 归并排序——将两段排序好的数组结合成一个排序数组
     *
     * @param left
     * @param right
     * @return
     */
    public static int[] merge(int[] left, int[] right) {

        int[] result = new int[left.length + right.length];

        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length) {
                result[index] = right[j++];
            } else if (j >= right.length) {
                result[index] = left[i++];
            } else if (left[i] > right[j]) {
                result[index] = right[j++];
            } else {
                result[index] = left[i++];
            }

        }
        return result;
    }

}
