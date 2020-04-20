package 面试题;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 面试题59-II. 队列的最大值
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 *
 * offer 追加元素
 * offerFirst 队首加元素
 * offerLast 队尾加元素
 * poll  从队首取出元素并删除
 * peek 从队首取出元素但是不删除
 *
 */
public class MaxQueue {
    private Queue<Integer> queue;
    private Deque<Integer> deque;

    public MaxQueue() {
        queue = new LinkedList<>();//队列
        deque = new LinkedList<>();//辅助队列，用来存储最大值,队首即为max
    }

    //返回deque队列首元素
    public int max_value() {
        return deque.size()>0?deque.peek():-1;
    }

    //元素进入队列
    public void push_back(int value) {
        queue.offer(value);
        //与辅助队列的末尾元素比较，如果value比较大，则将原末尾元素移除，将value加到辅助队列末尾
        while(deque.size()>0 && deque.peekLast()<value){
            deque.pollLast();
        }
        deque.offerLast(value);
    }
    //元素出队列
    public int pop_front() {
        int temp;
        if(queue.size()>0){
            temp = queue.poll();
        }else temp=-1;
        //如果出队列的元素是辅助队列中队首，则同时要将辅助队列队首移除
        if(deque.size()>0 && temp == deque.peek()){
            deque.pollFirst();
        }
        return temp;
    }
}
