package com.github2013.algorithm.tree;

import com.github2013.algorithm.iterator.IIterator;
import com.github2013.algorithm.link.Position;

/**
 * Created by drunk on 17-2-11.
 * Author : DRUNK
 * email :len1988.zhang@gmail.com
 */
public interface BinTreePosition extends Position {
    /**
     * 判断是否有父节点
     * @return
     */
    boolean hasParent();

    /**
     * 获取当前节点的父节点
     * @return
     */
    BinTreePosition getParent();

    /**
     * 设置当前节点的父节点
     * @param p
     */
    void setParent(BinTreePosition p);

    /**
     * 判断是否为叶子
     * @return
     */
    boolean isLeaf();

    /**
     * 判断是否为左侧孩子
     * @return
     */
    boolean isLChild();

    /**
     * 判断是否有左侧孩子
     * @return
     */
    boolean hasLChild();

    /**
     * 返回当前节点的左孩子
     * @return
     */
    BinTreePosition getLChild();

    /**
     * 设置当前节点的左孩子
     * @param leftChild
     */
    void setLChild(BinTreePosition leftChild);

    /**
     * 判断是否为右孩子
     * @return
     */
    boolean isRChild();

    /**
     * 判断是否有右孩子
     * @return
     */
    boolean hasRChild();

    /**
     * 获取当前节点的右孩子
     * @return
     */
    BinTreePosition getRChild();

    /**
     * 设置当前节点的右孩子(注意:this.rChild和c.parent都不一定为空)
     */
    void setRChild();

    /**
     * 获取当前节点后代元素的数目
     * @return
     */
    int getSize();

    /**
     * 返回当前节点的高度
     * @return
     */
    int getHeight();


    /**
     * 在孩子发生变化后,更新当前节点及其祖先的高度
     */
    void updateHeight();

    /**
     * 返回当前节点的深度
     * @return
     */
    int getDepth();

    /**
     * 在父亲发生变化后,更新当前节点及其后代的深度
     */
    void  updateDepth();

    /**
     * 按照中序遍历的次序,找到当前节点的直接前驱
     * @return
     */
    BinTreePosition getPrev();

    /**
     * 按照中序遍历的次序,找到当前节点的直接后继
     * @return
     */
    BinTreePosition getSucc();

    //断绝当前节点与其父亲的父子关系
    /**
     *返回当前节点
     * @return
     */
    BinTreePosition secede();

    /**
     * 将节点c 作为当前节点的左孩子
     * @param c
     * @return
     */
    BinTreePosition attachL(BinTreePosition c);

    /**
     * 将节点c 作为当前节点的右孩子
     * @param c
     * @return
     */
    BinTreePosition attachR(BinTreePosition c);

    /**
     * 前序遍历
     * @return
     */
    IIterator elementsPreorder();

    /**
     * 中序遍历
     * @return
     */
    IIterator elementsInorder();

    /**
     * 后续遍历
     * @return
     */
    IIterator elementsPostorder();

    /**
     * 层次遍历
     * @return
     */
    IIterator elementsLevelorder();

}
