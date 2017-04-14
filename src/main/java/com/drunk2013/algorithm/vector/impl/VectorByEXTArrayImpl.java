package com.drunk2013.algorithm.vector.impl;

import com.drunk2013.algorithm.vector.IVector;
import com.drunk2013.algorithm.DSException;

/**
 * Created by drunk on 17-2-6.
 * Author : DRUNK
 * email :len1988.zhang@gmail.com
 */

/**
 * 可扩充的数组向量
 * Java本身也提供了与向量ADT功能类似的两个类:java.util.ArrayList和java.util.Vector
 * 这两个类的标准实现都采用了此策略
 */
public class VectorByEXTArrayImpl implements IVector {
    private int N = 8;//数组的容量，可不断增加
    private int n = 0;//向量的实际容量
    private Object[] A;//对象数组

    public VectorByEXTArrayImpl() {
        A = new Object[N];
        n = 0;
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
     * 返回向量中元素个数
     *
     * @return
     */
    public int getSize() {
        return n;
    }

    /**
     * 判断向量是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return (0 == n) ? true : false;
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
        Object bak = A[r];
        A[r] = obj;
        return bak;
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
        if (r < 0 || r > n) {
            throw new DSException("秩越界！！");
        }
        if (n >= N) {//空间溢出的处理
            N *= 2;//数组的空间容量扩大一倍
            Object[] B = new Object[N];
            for (int i = 0; i < n; i++) {
                B[i] = A[i];
            }
            A = B;
        }
        for (int i = n; i > r; i--) {
            A[i] = A[i - 1];
        }
        A[r] = obj;
        n++;
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
            A[i] = A[i + 1]; //后续元素顺序前移
        }
        n--;//更新当前规模

        return bak;
    }
}
