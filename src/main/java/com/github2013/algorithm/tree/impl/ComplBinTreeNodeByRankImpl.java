package com.github2013.algorithm.tree.impl;

import com.github2013.algorithm.iterator.IIterator;
import com.github2013.algorithm.tree.BinTreePosition;
import com.github2013.algorithm.tree.IBinTree;
import com.github2013.algorithm.tree.IComplBinTree;
import com.github2013.algorithm.vector.IVector;
import com.github2013.algorithm.vector.impl.VectorByArrayImpl;

/**
 * Created by len on 17-2-26.
 * Author : DRUNK
 * email :len1988.zhang@gmail.com
 */
public class ComplBinTreeNodeByRankImpl implements BinTreePosition, IComplBinTree {
    private IVector T;//所属的树
    private int rank;//在所属树中的秩
    private Object element;//存放的对象

    public ComplBinTreeNodeByRankImpl(IVector t, Object element) {
        T = t;
        this.element = element;
        rank = T.getSize();
        T.insertAtRank(rank, this);
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
        Object bak = element;
        element = obj;
        return bak;
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
        return element == null ? true : false;
    }

    /**
     * 生成并返回一个存放e的外部节点,该节点成为新的末节点
     *
     * @param e
     * @return
     */
    public BinTreePosition addList(Object e) {
        return null;
    }

    /**
     * 删除末节点,并返回其中存放的位置
     *
     * @return
     */
    public Object delLast() {
        return null;
    }

    /**
     * 返回按照层次遍历编号为i的节点位置,0<=i<size()
     *
     * @param i
     * @return
     */
    public BinTreePosition posOfNode(int i) {
        return null;
    }

    /**
     * 判断是否有父节点
     *
     * @return
     */
    public boolean hasParent() {
        return (0 != rank) ? true : false;
    }

    /**
     * 获取当前节点的父节点
     *
     * @return
     */
    public BinTreePosition getParent() {
        return hasParent() ? (BinTreePosition) T.getAtRank((rank - 1) / 2) : null;
    }

    /**
     * 设置当前节点的父节点
     *
     * @param p
     */
    public void setParent(BinTreePosition p) {

    }

    /**
     * 判断是否为叶子
     *
     * @return
     */
    public boolean isLeaf() {
        return false;
    }

    /**
     * 判断是否为左侧孩子
     *
     * @return
     */
    public boolean isLChild() {
        return false;
    }

    /**
     * 判断是否有左侧孩子
     *
     * @return
     */
    public boolean hasLChild() {
        return (1 + rank * 2 < T.getSize()) ? true : false;
    }

    /**
     * 返回当前节点的左孩子
     *
     * @return
     */
    public BinTreePosition getLChild() {
        return hasLChild() ? (BinTreePosition) (T.getAtRank(1 + rank * 2)) : null;
    }

    /**
     * 设置当前节点的左孩子
     *
     * @param leftChild
     */
    public void setLChild(BinTreePosition leftChild) {

    }

    /**
     * 判断是否为右孩子
     *
     * @return
     */
    public boolean isRChild() {
        return false;
    }

    /**
     * 判断是否有右孩子
     *
     * @return
     */
    public boolean hasRChild() {
        return (2 + rank * 2 < T.getSize() ? true : false);
    }

    /**
     * 获取当前节点的右孩子
     *
     * @return
     */
    public BinTreePosition getRChild() {
        return hasRChild() ? (BinTreePosition) (T.getAtRank(2 + rank * 2)) : null;
    }

    /**
     * 设置当前节点的右孩子(注意:this.rChild和c.parent都不一定为空)
     *
     * @param rChild
     */
    public void setRChild(BinTreeNodeImpl rChild) {

    }

    /**
     * 获取当前节点后代元素的数目
     *
     * @return
     */
    public int getSize() {
        int size = 1;
        if (hasLChild()) size += getLChild().getSize();
        if (hasRChild()) size += getRChild().getSize();

        return size;
    }

    /**
     * 在孩子发生变化后,更新当前节点及其祖先的规模
     */
    public void updateSize() {

    }

    /**
     * 返回当前节点的高度
     *
     * @return
     */
    public int getHeight() {
        int hL = hasLChild() ? getLChild().getHeight() : -1;
        int hR = hasRChild() ? getRChild().getHeight() : -1;
        return 1 + Math.max(hL, hR);
    }

    /**
     * 在孩子发生变化后,更新当前节点及其祖先的高度
     */
    public void updateHeight() {

    }

    /**
     * 返回当前节点的深度
     *
     * @return
     */
    public int getDepth() {
        return hasParent() ? 1 + getParent().getDepth() : 0;
    }

    /**
     * 在父亲发生变化后,更新当前节点及其后代的深度
     */
    public void updateDepth() {

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
