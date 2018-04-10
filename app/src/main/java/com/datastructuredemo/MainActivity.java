package com.datastructuredemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import linklist.LinkReverseTest;
import linklist.Node;
import linklist.SinglyLinkedlist;

public class MainActivity extends AppCompatActivity {

    private SinglyLinkedlist list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        list = new SinglyLinkedlist(); //创建一个链表
        list.addNode(new Node(0));
        list.addNode(new Node(1));
        list.addNodeByIndex(3, new Node(5));
        list.removeNodeByIndex(4);
        for (int i = 0; i < list.length(); i++) {
            Node node = list.get(i);
            Log.d("tag", "打印出=" + node.data);
        }

        //单链表反转测试
        LinkReverseTest linkReverseTest =new LinkReverseTest();
        linkReverseTest.reverse();

    }
}
