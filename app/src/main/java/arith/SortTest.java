package arith;

import android.util.Log;

/**
 * Created by XR_liu on 2018/11/16.
 */
public class SortTest {

    String TAG="tag";
    //冒泡排序
    public void bubbleTest() {
        Log.d(TAG, "bubbleTest: 进行排序");
        int[] array = new int[]{2, 54, 23, 6, 23, 1, 7, 34, 4};
        int[] sort = Sort.bubbleSort(array);
        for (int i : sort) {
            Log.d(TAG, "bubbleTest: 排序后的数据="+i);
        }
    }

    //选择排序
    public void selectTest(){
        Log.d(TAG, "bubbleTest: 进行排序");
        int[] array = new int[]{2, 54, 23, 6, 23, 1, 7, 34, 4};
        int[] sort = Sort.selectSort(array);
        for (int i : sort) {
            Log.d(TAG, "bubbleTest: 排序后的数据="+i);
        }
    }

    //插入排序
    public void insertTest(){
        Log.d(TAG, "bubbleTest: 进行排序");
        int[] array = new int[]{2, 54, 23, 6, 23, 1, 7, 34, 4};
        int[] sort = Sort.insertSort(array);
        for (int i : sort) {
            Log.d(TAG, "bubbleTest: 排序后的数据="+i);
        }
    }
}
