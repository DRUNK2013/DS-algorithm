package com.github2013.algorithm.link;

/**
 * Created by drunk on 17-2-2.
 * Author : DRUNK
 * email :len1988.zhang@gmail.com
 */
public class DLNode implements Position {
    private Object element;//数据对象
    private DLNode prev;//指向前驱节点
    private DLNode next;//指向后继节点

    public DLNode() {
        this(null, null, null);
    }

    public DLNode(Object obj, DLNode p, DLNode n) {
        this.element = obj;
        this.prev = p;
        this.next = n;
    }

    /**
     * 返回位于该位置的元素
     *
     * @return
     */
    public Object getElement() {
        return element;
    }

    /**
     * 将给定的元素存放于该位置，返回此前存放的元素
     *
     * @param obj
     * @return
     */
    public Object setElement(Object obj) {
        Object oldEle = element;
        element = obj;
        return oldEle;
    }

    public DLNode getNext() {
        return next;
    }

    public DLNode getPrev() {
        return prev;
    }

    public void setPrev(DLNode newPre) {
        this.prev = newPre;
    }

    public void setNext(DLNode newNext) {
        this.next = newNext;
    }
}
