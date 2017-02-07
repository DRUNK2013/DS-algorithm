package com.github2013.algorithm.iterator;

/**
 * Created by drunk on 17-2-7.
 * Author : DRUNK
 * email :len1988.zhang@gmail.com
 */
public interface IIterator {

    /**
     * 检查迭代器中,是否还有元素
     *
     * @return
     */
    boolean hasNext();

    /**
     * 迭代器中的下一个元素
     *
     * @return
     */
    Object getNext();
}
