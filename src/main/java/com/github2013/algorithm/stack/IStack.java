package com.github2013.algorithm.stack;

/**
 * Created by drunk on 17-2-2.
 */
public interface IStack {
    public int getSize(); //返回栈中元素的数目

    public boolean isEmpty(); //判断栈是否为空

    public Object top() throws ExceptionStackEmpty; //取栈顶元素，但不删除

    public void push(Object ele); //入栈

    public Object pop() throws ExceptionStackEmpty; //出站

    public Object[] reverse(Object[] objs) throws ExceptionStackEmpty; //栈反转

}
