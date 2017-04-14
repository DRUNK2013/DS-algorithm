package com.drunk2013.algorithm.queue.impl;

import com.drunk2013.algorithm.DSException;
import com.drunk2013.algorithm.link.DLNode;
import com.drunk2013.algorithm.queue.IDeque;

/**
 * Created by drunk on 17-2-2.
 * Author : DRUNK
 * email :len1988.zhang@gmail.com
 */
public class DeQueImpl implements IDeque {
    protected DLNode header;//指向头节点（哨兵）
    protected DLNode trailer;//指向未节点（哨兵）
    protected int size; //队列中元素数目

    public DeQueImpl() {
        header = new DLNode();
        trailer = new DLNode();
        header.setNext(trailer);
        trailer.setPrev(header);
        size = 0;
    }

    /**
     * 返回队列中元素数目
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return (0 == size) ? true : false;
    }

    /**
     * 取首元素（但不删除）
     *
     * @return
     * @throws DSException
     */
    public Object first() throws DSException {
        if (isEmpty()) {
            throw new DSException("双端对垒为空！！");
        }
        return header.getNext().getElement();
    }

    /**
     * 取末元素（但不删除）
     *
     * @return
     * @throws DSException
     */
    public Object last() throws DSException {
        if (isEmpty()) {
            throw new DSException("双端对垒为空！！");
        }
        return trailer.getPrev().getElement();
    }

    /**
     * 将新元素作为首元素插入
     *
     * @param obj
     */
    public void insertFirst(Object obj) {
        DLNode second = header.getNext();
        DLNode first = new DLNode(obj, header, second);
        second.setPrev(first);
        header.setNext(first);
        size++;
    }

    /**
     * 将新元素作为末元素插入
     *
     * @param obj
     */
    public void insertLast(Object obj) {
        DLNode second = trailer.getPrev();
        DLNode first = new DLNode(obj, second, trailer);
        second.setNext(first);
        second.setPrev(first);
        size++;
    }

    /**
     * 删除首元素
     *
     * @throws DSException
     */
    public void removeFirst() throws DSException {

    }

    /**
     * 删除末元素
     *
     * @throws DSException
     */
    public void removeLast() throws DSException {


    }

    /**
     * 获取队列，并返回数组,不属于ADT
     *
     * @return
     */
    public Object[] getQueue() {
        return new Object[0];
    }
}
