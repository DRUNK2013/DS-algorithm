package com.github2013.algorithm.tree;

/**
 * Created by drunk on 17-2-8.
 * Author : DRUNK
 * email :len1988.zhang@gmail.com
 */

import com.github2013.algorithm.tree.impl.TreeLinkedList;

/**
 * 数借口
 */
public interface ITree {
    /**
     * 获取当前节点存放的对象
     * @return
     */
    Object getElement();

    /**
     * 将对象obj存放在当前节点,并返回此前的内容
     * @param obj
     * @return
     */
    Object setElement(Object obj);

    /**
     * 返回当前节点的父节点
     * @return
     */
    TreeLinkedList getParent();

    /**
     * 返回当前节点最大长子
     * @return
     */
    TreeLinkedList getFirstChild();

    /**
     * 返回当前节点最大弟弟
     * @return
     */
    TreeLinkedList getNextSibling();

    /**
     * 返回当前节点后代元素的数目,即当前节点为根的子树的规模
     * @return
     */
    int getSize();

    /**
     * 返回当前节点的高度
     * @return
     */
    int getHeight();

    /**
     * 返回当前节点的深度
     * @return
     */
    int getDepth();

}
