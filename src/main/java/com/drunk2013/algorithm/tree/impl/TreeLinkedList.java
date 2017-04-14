package com.drunk2013.algorithm.tree.impl;

import com.drunk2013.algorithm.tree.ITree;

/**
 * Created by drunk on 17-2-8.
 * Author : DRUNK
 * email :len1988.zhang@gmail.com
 */

/**
 * m叉树树
 */
public class TreeLinkedList implements ITree {
    private Object element;//树根节点
    private TreeLinkedList parent, firstChild, nextSibing;//父亲,长子及最大的弟弟


    public TreeLinkedList() {
        this(null, null, null, null);
    }

    public TreeLinkedList(Object element, TreeLinkedList parent, TreeLinkedList firstChild, TreeLinkedList nextSibing) {
        this.element = element;
        this.parent = parent;
        this.firstChild = firstChild;
        this.nextSibing = nextSibing;
    }

    /**
     * 获取当前节点存放的对象
     *
     * @return
     */
    public Object getElement() {
        return element;
    }

    /**
     * 将对象obj存放在当前节点,并返回此前的内容
     *
     * @param obj
     * @return
     */
    public Object setElement(Object obj) {
        Object objBack = element;
        element = obj;
        return objBack;
    }

    /**
     * 返回当前节点的父节点
     *
     * @return
     */
    public TreeLinkedList getParent() {
        return parent;
    }

    /**
     * 返回当前节点最大长子
     *
     * @return
     */
    public TreeLinkedList getFirstChild() {
        return firstChild;
    }

    /**
     * 返回当前节点最大弟弟
     *
     * @return
     */
    public TreeLinkedList getNextSibling() {
        return nextSibing;
    }

    /**
     * 返回当前节点后代元素的数目,即当前节点为根的子树的规模
     *
     * @return
     */
    public int getSize() {
        int size = 1;//当前节点,也是自己的后代
        TreeLinkedList subtree = firstChild;//从长子开始
        while (null != subtree) {
            size += subtree.getSize();
            subtree = subtree.getNextSibling();
        }
        return size;
    }

    /**
     * 返回当前节点的高度
     *
     * @return
     */
    public int getHeight() {
        int height = -1;
        TreeLinkedList subtree = firstChild;
        while (null != subtree) {
            height = Math.max(height, subtree.getHeight());
            subtree = subtree.getNextSibling();
        }
        return height + 1;
    }

    /**
     *
     * 返回当前节点的深度
     *
     * @return
     */
    public int getDepth() {
        int depth = 0;
        TreeLinkedList p = parent;//从父亲开始
        while (null != p) {
            depth++;
            p = p.getParent();
        }
        return depth;
    }
}
