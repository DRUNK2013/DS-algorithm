package com.drunk2013.algorithm.iterator.impl;

import com.drunk2013.algorithm.DSException;
import com.drunk2013.algorithm.List.IList;
import com.drunk2013.algorithm.iterator.IIterator;
import com.drunk2013.algorithm.link.Position;

/**
 * Created by drunk on 17-2-7.
 * Author : DRUNK
 * email :len1988.zhang@gmail.com
 */
public class IteratorElement implements IIterator {
    private IList list;//列表
    private Position nextPosition; //当前下一个位置

    public IteratorElement() {
        list = null;
    }

    public IteratorElement(IList list) {
        this.list = list;
        if (list.isEmpty()) {
            nextPosition = null;
        } else {
            nextPosition = list.first();
        }
    }

    /**
     * 检查迭代器中,是否还有元素
     *
     * @return
     */
    public boolean hasNext() {
        return (null != nextPosition);
    }

    /**
     * 迭代器中的下一个元素
     *
     * @return
     */
    public Object getNext() {
        if (!hasNext()) {
            throw new DSException("没有下一个元素!!!");
        }
        Position currentPosition = nextPosition;
        if (currentPosition == list.last()) {
            nextPosition = null;
        } else {
            nextPosition = list.getNext(currentPosition);
        }
        return currentPosition.getElement();
    }
}
