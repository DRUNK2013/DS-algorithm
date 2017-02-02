package com.github2013.algorithm.stack.impl;

import com.github2013.algorithm.stack.ExceptionStackEmpty;
import com.github2013.algorithm.stack.IStack;

/**
 * Created by drunk on 17-2-2.
 */
public class StackByArray implements IStack {
    public static final int CAPACITY = 1024; //数组的默认容量
    protected int capacity; //数组的实际容量
    protected Object[] S;//数组对象
    protected int top = -1;//栈顶元素的位置

    public StackByArray() {
        this(CAPACITY);
    }

    public StackByArray(int cap) {
        this.capacity = cap;
        S = new Object[capacity];
    }

    public int getSize() {
        return this.top + 1;
    }

    public boolean isEmpty() {
        return this.top < 0;
    }

    public Object top() throws ExceptionStackEmpty {
        if (isEmpty()) {
            throw new ExceptionStackEmpty("栈为空");
        }
        return S[top];
    }

    public void push(Object obj) throws ExceptionStackEmpty {
        if (getSize() == capacity) {
            throw new ExceptionStackEmpty("栈溢出！");
        }
        top++;
        S[top] = obj;

    }

    public Object pop() throws ExceptionStackEmpty {
        Object elem;
        if (isEmpty()) {
            throw new ExceptionStackEmpty("栈空！");
        }
        elem = S[top];
        S[top] = null;
        top--;
        return elem;
    }

    public Object[] reverse(Object[] objs) throws ExceptionStackEmpty {
        StackByArray stackByArray = new StackByArray(objs.length);
        Object[] retObjs = new Object[objs.length];
        for (int i = 0; i < objs.length; i++) {
            stackByArray.push(objs[i]); //所有元素顺序入栈
        }

        for (int i = 0; i < objs.length; i++) {
            retObjs[i] = stackByArray.pop(); //逆序退栈
        }
        return retObjs;
    }
}
