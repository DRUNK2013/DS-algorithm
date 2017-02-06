package com.github2013.algorithm.vector.impl;

import com.github2013.algorithm.DSException;
import com.github2013.algorithm.vector.IVector;

/**
 * Created by drunk on 17-2-6.
 * Author : DRUNK
 * email :len1988.zhang@gmail.com
 */

/**
 * 基于数组的向量
 */
public class VectorByArrayImpl implements IVector {
    private final int N = 1024;//数组的容量
    private int n = 0;//向量的实际规模
    private Object[] A;//对象数组

    public VectorByArrayImpl() {
        A = new Object[N];
        n = 0;
    }

    /**
     * 返回向量中元素个数
     *
     * @return
     */
    public int getSize() {
        return this.n;
    }

    /**
     * 判断向量是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return (0 == n) ? true : false;
    }

    private void checkBoundaryViolation(int r) {
        if (r < 0 || r >= n) {
            throw new DSException("秩越界!!!");
        }
    }

    private void checkArrayOverFlow(int r) {
        if (r >= n) {
            throw new DSException("数组溢出!!");
        }
    }


    /**
     * 取秩为r的元素
     *
     * @param r
     * @return
     * @throws DSException
     */
    public Object getAtRank(int r) throws DSException {
        checkBoundaryViolation(r);
        return A[r];
    }

    /**
     * 将秩为r的元素替换为obj
     *
     * @param r
     * @param obj
     * @return
     * @throws DSException
     */
    public Object replaceAtRank(int r, Object obj) throws DSException {
        checkBoundaryViolation(r);
        Object o = A[r];
        A[r] = obj;
        return o;
    }

    /**
     * 插入obj，作为秩为r的元素，返回该元素
     *
     * @param r
     * @param obj
     * @return
     * @throws DSException
     */
    public Object insertAtRank(int r, Object obj) throws DSException {
        if (0 > r || r > n) {
            throw new DSException("秩越界！！！");
        }
        checkArrayOverFlow(r);
        for (int i = n; i > r; i--) {
            A[i] = A[i - 1];//后续元素向后移动
        }
        A[r] = obj; //插入元素
        n++;//更新当前规模
        return obj;
    }

    /**
     * 删除秩为r的元素
     *
     * @param r
     * @return
     * @throws DSException
     */
    public Object removeAtRank(int r) throws DSException {
        checkBoundaryViolation(r);
        Object bak = A[r];
        for (int i = r; i < n; i++) {
            A[i] = A[i + 1]; //后续元素前移
        }
        n--; //更新当前规模
        return bak;
    }
}
