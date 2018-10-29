package com.datastructuredemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.arith.Sort;

import linklist.SinglyLinkedlist;

public class MainActivity extends AppCompatActivity {
    private String TAG = getClass().getSimpleName();
    private SinglyLinkedlist list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: 翻转字符串="+Sort.reversalCharsForStack("liuxingrong"));
            }
        });

//        list = new SinglyLinkedlist(); //创建一个链表
//        list.addNode(new Node(0));
//        list.addNode(new Node(1));
//        list.addNodeByIndex(3, new Node(5));
//        list.removeNodeByIndex(4);
//        for (int i = 0; i < list.length(); i++) {
//            Node node = list.get(i);
//            Log.d("tag", "打印出=" + node.data);
//        }
//
//        //单链表反转测试
//        LinkReverseTest linkReverseTest =new LinkReverseTest();
//        linkReverseTest.reverse();

    }

    //冒泡排序
    private void bubbleTest() {
        Log.d(TAG, "bubbleTest: 进行排序");
        int[] array = new int[]{2, 54, 23, 6, 23, 1, 7, 34, 4};
        int[] sort = Sort.bubbleSort(array);
        for (int i : sort) {
            Log.d(TAG, "bubbleTest: 排序后的数据="+i);
        }
    }

    //选择排序
    private void selectTest(){
        Log.d(TAG, "bubbleTest: 进行排序");
        int[] array = new int[]{2, 54, 23, 6, 23, 1, 7, 34, 4};
        int[] sort = Sort.selectSort(array);
        for (int i : sort) {
            Log.d(TAG, "bubbleTest: 排序后的数据="+i);
        }
    }

    private void insertTest(){
        Log.d(TAG, "bubbleTest: 进行排序");
        int[] array = new int[]{2, 54, 23, 6, 23, 1, 7, 34, 4};
        int[] sort = Sort.insertSort(array);
        for (int i : sort) {
            Log.d(TAG, "bubbleTest: 排序后的数据="+i);
        }
    }
}
