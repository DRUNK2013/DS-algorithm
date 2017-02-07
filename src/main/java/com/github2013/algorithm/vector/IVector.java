package com.github2013.algorithm.vector;

import com.github2013.algorithm.DSException;

/**
 * Created by drunk on 17-2-6.
 * Author : DRUNK
 * email :len1988.zhang@gmail.com
 */
public interface IVector {

    /**
     * 返回向量中元素个数
     *
     * @return
     */
    int getSize();

    /**
     * 判断向量是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 取秩为r的元素
     *
     * @param r
     * @return
     * @throws DSException
     */
    Object getAtRank(int r) throws DSException;

    /**
     * 将秩为r的元素替换为obj
     *
     * @param r
     * @param obj
     * @return
     * @throws DSException
     */
    Object replaceAtRank(int r, Object obj) throws DSException;

    /**
     * 插入obj，作为秩为r的元素，返回该元素
     *
     * @param r
     * @param obj
     * @return
     * @throws DSException
     */
    Object insertAtRank(int r, Object obj) throws DSException;

    /**
     * 删除秩为r的元素
     *
     * @param r
     * @return
     * @throws DSException
     */
    Object removeAtRank(int r) throws DSException;


}
