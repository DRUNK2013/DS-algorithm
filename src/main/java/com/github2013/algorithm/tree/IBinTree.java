package com.github2013.algorithm.tree;

/**
 * Created by drunk on 17-2-11.
 * Author : DRUNK
 * email :len1988.zhang@gmail.com
 */

import com.github2013.algorithm.iterator.IIterator;

/**
 * 二叉树接口
 */
public interface IBinTree {

    /**
     * 返回根节点
     * @return
     */
    BinTreePosition getRoot();

    /**
     * 判断是否树空
     * @return
     */
    boolean isEmpty();

    /**
     * 返回树的规模(即树根的后代数目)
     * @return
     */
    int getSize();

    /**
     * 返回树(根)的高度
     * @return
     */
    int getHeight();

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
