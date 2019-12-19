package arith;

import android.util.Log;

/**
 * Author：Alex
 * Date：2019/12/20
 * Note：
 */
public class SearchTest {

    static String TAG="tag";
    static int[] array = new int[]{3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

    public static void binarySearch(){
        Log.d(TAG, "binarySearch: 被点击");
        int i=Search.binarySearch2(array,5);
        Log.d(TAG, "binarySearch: 查找位置="+i);
    }

    public static void insertSearch(){
        int i=Search.insertSearch2(array,6);
        Log.d(TAG, "insertSearch: 位置="+i);
    }

}
