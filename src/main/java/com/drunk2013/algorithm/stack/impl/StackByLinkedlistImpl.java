package com.drunk2013.algorithm.stack.impl;

/**
 * Created by drunk on 17-2-2.
 * Author : DRUNK
 * email :len1988.zhang@gmail.com
 */

import com.drunk2013.algorithm.link.Node;
import com.drunk2013.algorithm.stack.IStack;
import com.drunk2013.algorithm.DSException;

/**
 * 基于链表的结构，实现栈操作
 */
public class StackByLinkedlistImpl implements IStack {
    protected Node top;//指向栈顶元素
    protected int size;//栈中元素数目

    public StackByLinkedlistImpl() {
        this(null, 0);
    }

    public StackByLinkedlistImpl(Node top, int size) {
        this.top = top;
        this.size = size;
    }

    /**
     * 返回栈中元素的数目
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断栈是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return (top == null) ? true : false;
    }

    /**
     * 取栈顶元素，但不删除
     *
     * @return
     * @throws DSException
     */
    public Object top() throws DSException {
        if (isEmpty()) {
            throw new DSException("栈为空！！");
        }
        return top.getElement();
    }

    /**
     * 入栈
     *
     * @param ele
     */
    public void push(Object ele) {
        Node node = new Node(ele, top);
        top = node; //更新首节点引用
        size++; //更新链表长度
    }

    /**
     * 出站
     *
     * @return
     * @throws DSException
     */
    public Object pop() throws DSException {
        if (isEmpty()) {
            throw new DSException("栈为空");
        }
        Object temp = top.getElement();
        top = top.getNext(); // 把首节点，指向下一个节点
        size--;
        return temp;
    }

    /**
     * 栈反转
     *
     * @return
     * @throws DSException
     */
    public Object[] reverse() throws DSException {
        StackByLinkedlistImpl temp = this;
        Object[] objects = new Object[getSize()];
        int size = getSize();
        for (int i = 0; i < size; i++) {
            objects[i] = temp.pop();
        }
        return objects;
    }
}
