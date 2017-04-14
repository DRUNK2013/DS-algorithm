package com.drunk2013.algorithm.List.impl;

/**
 * Created by drunk on 17-2-6.
 * Author : DRUNK
 * email :len1988.zhang@gmail.com
 */

import com.drunk2013.algorithm.DSException;
import com.drunk2013.algorithm.List.IList;
import com.drunk2013.algorithm.link.DLNode;
import com.drunk2013.algorithm.link.Position;

import java.util.Iterator;

/**
 * 基于双链表实现的列表
 */
public class ListByDLNodeImpl implements IList {
    protected int numElem;//列表的实际规模
    protected DLNode header, trailer;//哨兵：首节点+末节点

    public ListByDLNodeImpl() {
        numElem = 0;
        header = new DLNode(null, null, null);
        trailer = new DLNode(null, header, null);
        header.setNext(trailer);
    }

    /**
     * 辅助方法，作为检测使用
     *
     * @param p
     * @return
     * @throws DSException
     */
    private DLNode checkPosition(Position p) throws DSException {
        if (null == p) {
            throw new DSException("传递给ListByDLNode的位置是null!!!!");
        }
        if (header == p) {
            throw new DSException("头节点哨兵非法！！！");
        }
        if (trailer == p) {
            throw new DSException("未节点哨兵非法！！！");
        }
        DLNode node = (DLNode) p;
        return node;
    }


    /**
     * 查询列表当前的规模
     *
     * @return
     */
    public int getSize() {
        return numElem;
    }

    /**
     * 判断列表是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return (0 == numElem);
    }

    /**
     * 返回第一个元素
     *
     * @return
     */
    public Position first() throws DSException {
        if (isEmpty()) {
            throw new DSException("列表为空！！！");
        }
        return header.getNext();
    }

    /**
     * 返回最后一个元素
     *
     * @return
     */
    public Position last() throws DSException {
        if (isEmpty()) {
            throw new DSException("列表为空！！！");
        }
        return trailer.getPrev();
    }

    /**
     * 返回紧跟给定位置之后的元素（的位置）
     *
     * @param p
     * @return
     * @throws DSException
     */
    public Position getNext(Position p) throws DSException {
        DLNode node = checkPosition(p);
        DLNode prev = node.getPrev();
        if (prev == header) {
            throw new DSException("企图越过列表前端！！");
        }
        return prev;
    }

    /**
     * 返回紧跟给定位置之钱的元素（的位置）
     *
     * @param p
     * @return
     * @throws DSException
     */
    public Position getPrev(Position p) throws DSException {
        DLNode node = checkPosition(p);
        DLNode next = node.getNext();
        if (next == trailer) {
            throw new DSException("企图越过列表后端！！！");
        }

        return next;
    }

    /**
     * 在列表中，在首位置插入元素
     *
     * @param e
     * @return
     */
    public Position insertFirst(Object e) {
        numElem++;
        DLNode newNode = new DLNode(e, header, header.getNext());
        header.getNext().setPrev(newNode);
        header.setNext(newNode);
        return newNode;
    }

    /**
     * 在列表中，在末位置插入元素
     *
     * @param e
     * @return
     */
    public Position insertLast(Object e) {
        numElem++;
        DLNode newNode = new DLNode(e, trailer.getPrev(), trailer);
        trailer.getPrev().setNext(newNode);
        trailer.setPrev(newNode);
        return newNode;
    }

    /**
     * 在跟定的元素元素位置，后面插入新元素e
     *
     * @param p
     * @param e
     * @return
     * @throws DSException
     */
    public Position insertAfter(Position p, Object e) throws DSException {
        DLNode node= checkPosition(p);
        numElem++;
        DLNode newNode=new DLNode(e,node,node.getNext());
        node.getNext().setPrev(newNode);
        node.setNext(newNode);
        return newNode;
    }

    /**
     * 在给定元素的位置，之前插入新元素e
     *
     * @param p
     * @param e
     * @return
     * @throws DSException
     */
    public Position insertBefore(Position p, Object e) throws DSException {
        DLNode node = checkPosition(p);
        numElem++;
        DLNode newNode = new DLNode(e,node.getPrev(),node);
        node.getPrev().setNext(newNode);
        node.setPrev(newNode);
        return newNode;
    }

    /**
     * 移除位置p的元素
     *
     * @param p
     * @return
     * @throws DSException
     */
    public Object remove(Position p) throws DSException {
        DLNode node = checkPosition(p);
        numElem--;
        DLNode prevNode = node.getPrev();
        DLNode nextNode = node.getNext();
        prevNode.setNext(nextNode);
        nextNode.setPrev(prevNode);
        Object elem = node.getElement();
        //将该位置(节点)从列表中移除,以便GC回收
        node.setPrev(null);
        node.setNext(null);
        return elem;
    }

    /**
     * 移除首元素
     *
     * @return
     */
    public Object removeFirst() {
        return remove(header.getNext());
    }

    /**
     * 移除末元素
     *
     * @return
     */
    public Object removeLast() {
        return remove(trailer.getPrev());
    }

    /**
     * 在给定位置，替换新元素
     *
     * @param p
     * @param e
     * @return
     * @throws DSException
     */
    public Object replace(Position p, Object e) throws DSException {
        DLNode node= checkPosition(p);
        Object oldElem = node.getElement();
        node.setElement(e);
        return oldElem;
    }

    /**
     * 迭代出位置的集合
     *
     * @return
     */
    public Iterator positions() {

        return null;
    }

    /**
     * 元素值的迭代
     *
     * @return
     */
    public Iterator elements() {

        return null;
    }
}
