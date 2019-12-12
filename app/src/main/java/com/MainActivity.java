package com;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.datastructuredemo.R;

import math.Sort;
import linklist.single.SinglyLinkedlist;

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

}
