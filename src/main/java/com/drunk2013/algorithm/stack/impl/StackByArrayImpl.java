package com.drunk2013.algorithm.stack.impl;

import com.drunk2013.algorithm.DSException;
import com.drunk2013.algorithm.stack.IStack;

/**
 * Created by drunk on 17-2-2.
 * Author : DRUNK
 * email :len1988.zhang@gmail.com
 */
public class StackByArrayImpl implements IStack {
    public static final int CAPACITY = 1024; //数组的默认容量
    protected int capacity; //数组的实际容量
    protected Object[] S;//数组对象
    protected int top = -1;//栈顶元素的位置

    public StackByArrayImpl() {
        this(CAPACITY);
    }

    public StackByArrayImpl(int cap) {
        this.capacity = cap;
        S = new Object[capacity];
    }

    public int getSize() {
        return this.top + 1;
    }

    public boolean isEmpty() {
        return this.top < 0;
    }

    public Object top() throws DSException {
        if (isEmpty()) {
            throw new DSException("栈为空");
        }
        return S[top];
    }

    public void push(Object obj) throws DSException {
        if (getSize() == capacity) {
            throw new DSException("栈溢出！");
        }
        top++;
        S[top] = obj;

    }

    public Object pop() throws DSException {
        Object elem;
        if (isEmpty()) {
            throw new DSException("栈空！");
        }
        elem = S[top];
        S[top] = null;
        top--;
        return elem;
    }

    //把栈内的元素反转（不含null元素）
    public Object[] reverse() throws DSException {
        int size = getSize();
        StackByArrayImpl stackByArrayImpl = new StackByArrayImpl(size);
        Object[] retObjs = new Object[size];
        for (int i = 0; i < size; i++) {
            stackByArrayImpl.push(S[i]); //所有元素顺序入栈
        }

        for (int i = 0; i < size; i++) {
            retObjs[i] = stackByArrayImpl.pop(); //逆序退栈
        }
        return retObjs;
    }
}
