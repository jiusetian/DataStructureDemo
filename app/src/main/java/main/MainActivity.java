package main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.datastructuredemo.R;

import java.util.Random;

import linklist.singlelink.SingleLinkedList;
import queue.SimplePriorityQueue;

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

                // SearchTest.insertSearch();

                //优先队列自然排序
//                SimplePriorityQueue<Integer> integerQueue = new SimplePriorityQueue<>();
//                integerQueue.add(new Integer(2));
//                integerQueue.add(new Integer(5));
//                integerQueue.add(new Integer(8));
//                integerQueue.add(new Integer(44));
//                integerQueue.add(new Integer(11));
//                integerQueue.add(new Integer(555));
//                //LogUtils.d("数组="+integerQueue.);
//                for (int i = 0; i < 10; i++) {
//                    LogUtils.d("优先队列的整数输出=" + integerQueue.dequeue());
//                }

                SimplePriorityQueue<Customer> simplePriorityQueue=new SimplePriorityQueue<>(10);
                addDataToQueue(simplePriorityQueue);
                pollDataFromQueue(simplePriorityQueue);
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

    //用于往队列增加数据的通用方法
    private static void addDataToQueue(SimplePriorityQueue<Customer> customerPriorityQueue) {
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            int id = rand.nextInt(1000);
            customerPriorityQueue.add(new Customer(id, "刘兴荣" + id));
            LogUtils.d("存入的刘兴荣id=" + id);
        }
    }

    //用于从队列取数据的通用方法
    private static void pollDataFromQueue(SimplePriorityQueue<Customer> customerpriorityQueue) {
        while (true) {
            Customer ctm = customerpriorityQueue.dequeue();
            if (ctm == null)
                break;
            System.out.println("取出的刘兴荣id =" + ctm.getId());
        }
    }


    private static class Customer implements Comparable<Customer>{

        private int id;
        private String name;

        public Customer(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public int compareTo(@NonNull Customer o) {
            return this.getId()-o.getId();
        }
    }

}
