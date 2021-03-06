package com.drunk2013.algorithm.List;

import com.drunk2013.algorithm.DSException;
import com.drunk2013.algorithm.link.Position;

import java.util.Iterator;

/**
 * Created by drunk on 17-2-6.
 * Author : DRUNK
 * email :len1988.zhang@gmail.com
 */
public interface IList {
    /**
     * 查询列表当前的规模
     *
     * @return
     */
    int getSize();

    /**
     * 判断列表是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 返回第一个元素
     *
     * @return
     */
    Position first() throws DSException;

    /**
     * 返回最后一个元素
     *
     * @return
     */
    Position last() throws DSException;

    /**
     * 返回紧跟给定位置之后的元素（的位置）
     *
     * @param p
     * @return
     * @throws DSException
     */
    Position getNext(Position p) throws DSException;

    /**
     * 返回紧跟给定位置之钱的元素（的位置）
     *
     * @param p
     * @return
     * @throws DSException
     */
    Position getPrev(Position p) throws DSException;

    /**
     * 在列表中，在首位置插入元素
     *
     * @param e
     * @return
     */
    Position insertFirst(Object e) throws DSException;

    /**
     * 在列表中，在末位置插入元素
     *
     * @param e
     * @return
     */
    Position insertLast(Object e) throws DSException;

    /**
     * 在跟定的元素元素位置，后面插入新元素e
     *
     * @param p
     * @param e
     * @return
     * @throws DSException
     */
    Position insertAfter(Position p, Object e) throws DSException;

    /**
     * 在给定元素的位置，之前插入新元素e
     *
     * @param p
     * @param e
     * @return
     * @throws DSException
     */
    Position insertBefore(Position p, Object e) throws DSException;

    /**
     * 移除位置p的元素
     *
     * @param p
     * @return
     * @throws DSException
     */
    Object remove(Position p) throws DSException;

    /**
     * 移除首元素
     *
     * @return
     */
    Object removeFirst() throws DSException;

    /**
     * 移除末元素
     *
     * @return
     */
    Object removeLast() throws DSException;

    /**
     * 在给定位置，替换新元素
     *
     * @param p
     * @param e
     * @return
     * @throws DSException
     */
    Object replace(Position p, Object e) throws DSException;

    /**
     * 迭代出位置的集合
     *
     * @return
     */
    Iterator positions();

    /**
     * 元素值的迭代
     *
     * @return
     */
    Iterator elements();
}
