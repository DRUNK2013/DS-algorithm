package com.drunk2013.algorithm.stack;

import com.drunk2013.algorithm.DSException;

/**
 * Created by drunk on 17-2-2.
 * Author : DRUNK
 * email :len1988.zhang@gmail.com
 */
public interface IStack {
    /**
     *  返回栈中元素的数目
     * @return
     */
     int getSize();

    /**
     * 判断栈是否为空
     * @return
     */
     boolean isEmpty();

    /**
     * 取栈顶元素，但不删除
     * @return
     * @throws DSException
     */
     Object top() throws DSException;

    /**
     * 入栈
     * @param ele
     */
     void push(Object ele);

    /**
     * 出站
     * @return
     * @throws DSException
     */
     Object pop() throws DSException;

}
