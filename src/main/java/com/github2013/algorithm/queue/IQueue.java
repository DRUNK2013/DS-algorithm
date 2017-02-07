package com.github2013.algorithm.queue;

import com.github2013.algorithm.DSException;

/**
 * Created by drunk on 17-2-2.
 * Author : DRUNK
 * email :len1988.zhang@gmail.com
 */
public interface IQueue {
    /**
     * 返回队列中元素个数
     *
     * @return
     */
    int getSize();

    /**
     * 判断队列是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 获取队首元素
     *
     * @return
     * @throws DSException
     */
    Object front() throws DSException;

    /**
     * 入队
     *
     * @param obj
     * @throws DSException
     */
    void enqueue(Object obj) throws DSException;

    /**
     * 出队
     *
     * @return
     * @throws DSException
     */
    Object dequeue() throws DSException;

    /**
     * 获取队列，并返回数组,不属于ADT
     *
     * @return
     */
    Object[] getQueue();

}
