package com.github2013.algorithm.tree.impl;

import com.github2013.algorithm.iterator.IIterator;
import com.github2013.algorithm.tree.BinTreePosition;
import com.github2013.algorithm.tree.IBinTree;

/**
 * Created by drunk on 17-2-11.
 * Author : DRUNK
 * email :len1988.zhang@gmail.com
 */
public class BinTreeNodeImpl implements IBinTree {
    protected Object element;//该节点存放的对象
    protected BinTreePosition parent;//父亲
    protected BinTreePosition lChild;//左孩子
    protected BinTreePosition rChild;//右孩子
    protected int size; //后代数目
    protected int height; //高度
    protected int depth; //深度

    /**
     * 返回根节点
     *
     * @return
     */
    public BinTreePosition getRoot() {
        return null;
    }

    /**
     * 判断是否树空
     *
     * @return
     */
    public boolean isEmpty() {
        return false;
    }

    /**
     * 返回树的规模(即树根的后代数目)
     *
     * @return
     */
    public int getSize() {
        return 0;
    }

    /**
     * 返回树(根)的高度
     *
     * @return
     */
    public int getHeight() {
        return 0;
    }

    /**
     * 前序遍历
     *
     * @return
     */
    public IIterator elementsPreorder() {
        return null;
    }

    /**
     * 中序遍历
     *
     * @return
     */
    public IIterator elementsInorder() {
        return null;
    }

    /**
     * 后续遍历
     *
     * @return
     */
    public IIterator elementsPostorder() {
        return null;
    }

    /**
     * 层次遍历
     *
     * @return
     */
    public IIterator elementsLevelorder() {
        return null;
    }
}
