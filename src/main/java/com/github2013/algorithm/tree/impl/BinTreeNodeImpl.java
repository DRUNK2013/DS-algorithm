package com.github2013.algorithm.tree.impl;

import com.github2013.algorithm.iterator.IIterator;
import com.github2013.algorithm.tree.BinTreePosition;
import com.github2013.algorithm.tree.IBinTree;

/**
 * Created by drunk on 17-2-11.
 * Author : DRUNK
 * email :len1988.zhang@gmail.com
 */
public class BinTreeNodeImpl implements BinTreePosition {
    protected Object element;//该节点存放的对象
    protected BinTreePosition parent;//父亲
    protected BinTreePosition lChild;//左孩子
    protected BinTreePosition rChild;//右孩子
    protected int size; //后代数目
    protected int height; //高度
    protected int depth; //深度

    public BinTreeNodeImpl(
            Object e,
            BinTreePosition p,
            BinTreePosition l,
            BinTreePosition r,
            boolean asLChild
    ) {
        size = 1;
        height = depth = 0;
        this.element = e;
        parent = lChild = rChild = null;
        if (null != p) {//建立与父亲的联系
            if (asLChild) {
                p.attachL(this);
            } else {
                p.attachR(this);
            }
        }

        //建立与孩子的联系
        if (null != l) {
            attachL(l);
        }
        if (null != r) {
            attachR(r);
        }
    }

    /**********************************Positon接口***********************************/

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
        Object back = element;
        element = obj;
        return back;
    }

    /*************************BinTreePositon接口******************************/
    /**
     * 判断是否有父节点
     *
     * @return
     */
    public boolean hasParent() {
        return (null != parent);
    }

    /**
     * 获取当前节点的父节点
     *
     * @return
     */
    public BinTreePosition getParent() {
        return parent;
    }

    /**
     * 设置当前节点的父节点
     *
     * @param p
     */
    public void setParent(BinTreePosition p) {
        this.parent = p;
    }

    /**
     * 判断是否为叶子
     *
     * @return
     */
    public boolean isLeaf() {
        return (!hasLChild() && !hasRChild());
    }

    /**
     * 判断是否为左侧孩子
     *
     * @return
     */
    public boolean isLChild() {
        return (hasParent() && this == getParent() ? true : false);
    }

    /**
     * 判断是否有左侧孩子
     *
     * @return
     */
    public boolean hasLChild() {
        return (null != lChild);
    }

    /**
     * 返回当前节点的左孩子
     *
     * @return
     */
    public BinTreePosition getLChild() {
        return lChild;
    }

    /**
     * 设置当前节点的左孩子
     *
     * @param leftChild
     */
    public void setLChild(BinTreePosition leftChild) {
        lChild = leftChild;
    }

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
        return (null == element);
    }


    /**
     * 判断是否为右孩子
     *
     * @return
     */
    public boolean isRChild() {
        return (hasParent() && this == getParent().getRChild() ? true : false);
    }

    /**
     * 判断是否有右孩子
     *
     * @return
     */
    public boolean hasRChild() {
        return null == rChild;
    }

    /**
     * 获取当前节点的右孩子
     *
     * @return
     */
    public BinTreePosition getRChild() {
        return rChild;
    }

    /**
     * 设置当前节点的右孩子(注意:this.rChild和c.parent都不一定为空)
     *
     * @param rChild
     */
    public void setRChild(BinTreeNodeImpl rChild) {

        rChild = rChild;
    }

    /**
     * 返回树的规模(即树根的后代数目)
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 在孩子发生变化后,更新当前节点及其祖先的规模
     */
    public void updateSize() {
        size = 1;//当前节点
        if (hasLChild()) {
            size += getLChild().getSize();//左子树的规模
        }
        if (hasRChild()) {
            size += getRChild().getSize(); //右子树的规模
        }

        if (hasParent()) {
            getParent().updateSize();
        }
    }

    /**
     * 返回树(根)的高度
     *
     * @return
     */
    public int getHeight() {
        return height;
    }

    /**
     * 在孩子发生变化后,更新当前节点及其祖先的高度
     */
    public void updateHeight() {
        height = 0;//先假设没有左右孩子
        if (hasLChild()) height = Math.max(height, 1 + getLChild().getHeight());
        if (hasRChild()) height = Math.max(height, 1 + getRChild().getHeight());
        if (hasParent()) getParent().updateHeight();
    }

    /**
     * 返回当前节点的深度
     *
     * @return
     */
    public int getDepth() {
        return depth;
    }

    /**
     * 在父亲发生变化后,更新当前节点及其后代的深度
     */
    public void updateDepth() {
        depth = hasParent() ? getParent().getDepth() + 1 : 0;//更新当前节点的depth
        if (hasLChild()) getLChild().updateDepth();
        if (hasRChild()) getRChild().updateDepth();
    }

    /**
     * 按照中序遍历的次序,找到当前节点的直接前驱
     *
     * @return
     */
    public BinTreePosition getPrev() {
        
        return null;
    }

    /**
     * 按照中序遍历的次序,找到当前节点的直接后继
     *
     * @return
     */
    public BinTreePosition getSucc() {
        return null;
    }

    /**
     * 返回当前节点
     *
     * @return
     */
    public BinTreePosition secede() {
        return null;
    }

    /**
     * 将节点c 作为当前节点的左孩子
     *
     * @param c
     * @return
     */
    public BinTreePosition attachL(BinTreePosition c) {
        return null;
    }

    /**
     * 将节点c 作为当前节点的右孩子
     *
     * @param c
     * @return
     */
    public BinTreePosition attachR(BinTreePosition c) {
        return null;
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
