package com.drunk2013.algorithm.link;

/**
 * Created by drunk on 17-2-2.
 * Author : DRUNK
 * email :len1988.zhang@gmail.com
 */

/**
 * 链表节点的数据结构，和获取、设置节点操作
 */
public class Node implements Position {
    private Object element;//数据对象
    private Node next;//指向后继节点

    public Node() {
        this(null, null);
    }

    public Node(Object e, Node n) {
        this.element = e;
        this.next = n;
    }

    public Object getElement() {
        return element;
    }

    /**
     * 设置新元素，并返回老元素
     *
     * @param e
     * @return 老元素
     */
    public Object setElement(Object e) {
        Object oldEle = element;
        element = e;
        return oldEle;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node newNext) {
        next = newNext;
    }
}
