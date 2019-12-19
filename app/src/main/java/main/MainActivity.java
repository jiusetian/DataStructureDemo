package main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.datastructuredemo.R;

import arith.SearchTest;
import linklist.singlelink.SingleLinkedList;

public class MainActivity extends AppCompatActivity {

    private String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.d(TAG, "onClick: 翻转字符串=" + Sort.reversalCharsForStack("liuxingrong"));
                //BinaryTree.binaryTreeTest();
              // new SortTest().insertTest();
              // new SortTest().mergeSort();
//                SortTest sortTest=new SortTest();
//                for (int i=0;i<10000;i++){
//                    sortTest.bubbleTest();
//                }
               // SearchTest.binarySearch();

                SearchTest.insertSearch();
            }
        });


        findViewById(R.id.test2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.d(TAG, "onClick: 翻转字符串=" + Sort.reversalCharsForStack("liuxingrong"));
                //BinaryTree.binaryTreeTest();
                // new SortTest().insertTest();
                //new SortTest().mergeSort();
//                SortTest sortTest=new SortTest();
//                for (int i=0;i<10000;i++){
//                    sortTest.bubbleTest2();
//                }
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
//        LinkReverse linkReverse = new LinkReverse();
//        linkReverse.reverseLink();

        SingleLinkedList linkedList = new SingleLinkedList();
        for (int i = 0; i < 10; i++) {
            linkedList.addHeader(i);
        }
        //反转前
        linkedList.display();
        //反转
        linkedList.reverse();

        linkedList.display();
    }

}
