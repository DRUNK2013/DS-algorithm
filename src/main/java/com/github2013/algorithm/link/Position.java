package com.github2013.algorithm.link;

/**
 * Created by drunk on 17-2-2.
 * Author : DRUNK
 * email :len1988.zhang@gmail.com
 */
public interface Position {
    /**
     * 返回位于该位置的元素
     * @return
     */
    Object getElement();

    /**
     * 将给定的元素存放于该位置，返回此前存放的元素
     * @param obj
     * @return
     */
    Object setElement(Object obj);
}
