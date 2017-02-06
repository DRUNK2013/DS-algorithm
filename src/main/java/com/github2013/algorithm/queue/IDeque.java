package com.github2013.algorithm.queue;

import com.github2013.algorithm.DSException;

/**
 * Created by drunk on 17-2-2.
 * Author : DRUNK
 * email :len1988.zhang@gmail.com
 */
public interface IDeque {
    /**
     * 返回队列中元素数目
     *
     * @return
     */
    public int getSize();

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty();

    /**
     * 取首元素（但不删除）
     *
     * @return
     * @throws DSException
     */
    public Object first() throws DSException;

    /**
     * 取末元素（但不删除）
     *
     * @return
     * @throws DSException
     */
    public Object last() throws DSException;

    /**
     * 将新元素作为首元素插入
     *
     * @param obj
     */
    public void insertFirst(Object obj);

    /**
     * 将新元素作为末元素插入
     *
     * @param obj
     */
    public void insertLast(Object obj);

    /**
     * 删除首元素
     * @throws DSException
     */
    public void removeFirst() throws DSException;

    /**
     * 删除末元素
     * @throws DSException
     */
    public void removeLast() throws DSException;

    /**
     * 获取队列，并返回数组,不属于ADT
     *
     * @return
     */
    public Object[] getQueue();
}
