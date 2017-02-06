package com.github2013.algorithm.queue.impl;

import com.github2013.algorithm.DSException;
import com.github2013.algorithm.link.Node;
import com.github2013.algorithm.queue.IQueue;

/**
 * Created by drunk on 17-2-2.
 * Author : DRUNK
 * email :len1988.zhang@gmail.com
 */
public class QueueByLinkedlistImpl implements IQueue {
    protected Node head;//指向表首元素
    protected Node tail; //指向表尾元素
    protected int size;//队列中元素数目

    public QueueByLinkedlistImpl() {
        head = tail = null;
        size = 0;
    }

    /**
     * 返回队列中元素个数
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
     * 获取队首元素
     *
     * @return
     * @throws DSException
     */
    public Object front() throws DSException {
        if (isEmpty()) {
            throw new DSException("队列为空！！");
        }
        return head.getElement();
    }

    /**
     * 入队
     *
     * @param obj
     * @throws DSException
     */
    public void enqueue(Object obj) throws DSException {
        Node node = new Node();
        node.setElement(obj);
        node.setNext(null);

        if (0 == size) { //若队列为空，则首节点指向此节点
            head = node;
        } else {
            tail.setNext(node); //否则，队列的末节点的下一个节点指向新节点
        }
        tail = node;
        size++;
    }

    /**
     * 出队
     *
     * @return
     * @throws DSException
     */
    public Object dequeue() throws DSException {
        if (0 == getSize()) {
            throw new DSException("队列为空!!");
        }
        Object obj = head.getElement();
        head = head.getNext();
        size--;
        if (0 == size) {
            tail = null;
        }
        return obj;
    }

    /**
     * 获取队列，并返回数组
     *
     * @return
     */
    public Object[] getQueue() {
        Object[] objects = new Object[getSize()];
        Node newIndex = head;
        int i = 0;
        while (newIndex != null) {
            objects[i++] = newIndex.getElement();
            newIndex = newIndex.getNext();
        }
        return objects;
    }
}
