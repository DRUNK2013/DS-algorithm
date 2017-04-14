package com.drunk2013.algorithm.queue.impl;

import com.drunk2013.algorithm.DSException;
import com.drunk2013.algorithm.queue.IQueue;

/**
 * Created by drunk on 17-2-2.
 * Author : DRUNK
 * email :len1988.zhang@gmail.com
 */

public class QueueByArrayImpl implements IQueue {
    public static final int CAPACITY = 1000; //数组的默认容量
    protected int capacity;//数组的实际容量
    protected Object[] Q;//对象数组
    protected int f = 0; //队首元素的位置
    protected int r = 0;//队尾元素的位置

    public QueueByArrayImpl() {
        this(CAPACITY);
    }

    public QueueByArrayImpl(int cap) {
        this.capacity = cap;
        Q = new Object[this.capacity];
    }

    /**
     * 返回队列中元素个数
     *
     * @return
     */
    public int getSize() {
        return (capacity + r - f) % capacity;
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return r == f;
    }

    /**
     * 获取队首元素
     *
     * @return
     * @throws DSException
     */
    public Object front() throws DSException {
        if (isEmpty()) {
            throw new DSException("队列为空！");
        }
        return Q[f];
    }

    /**
     * 入队
     *
     * @param obj
     * @throws DSException
     */
    public void enqueue(Object obj) throws DSException {
        if (getSize() == capacity - 1) {
            throw new DSException("队列溢出！！");
        }
        Q[r] = obj;
        r = (r + 1) % capacity;
    }

    /**
     * 出队
     *
     * @return
     * @throws DSException
     */
    public Object dequeue() throws DSException {
        Object elem;
        if (isEmpty()) {
            throw new DSException("队列为空！");
        }
        elem = Q[f];
        Q[f] = null;
        f = (f + 1) % capacity;
        return elem;
    }

    /**
     * 获取队列，并返回数组
     *
     * @return
     */
    public Object[] getQueue() {
        int rear = r;
        if (f > rear) {
            rear = r + capacity;
        }
        Object[] retObj = new Object[getSize()];
        for (int i = f; i < rear; i++) {
            retObj[i - f] = Q[i];
        }
        return retObj;
    }
}
