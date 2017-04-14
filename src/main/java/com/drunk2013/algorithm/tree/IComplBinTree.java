package com.drunk2013.algorithm.tree;

/**
 * Created by len on 17-2-26.
 * Author : DRUNK
 * email :len1988.zhang@gmail.com
 */

/**
 * 完全二叉树
 */
public interface IComplBinTree extends IBinTree {
    /**
     * 生成并返回一个存放e的外部节点,该节点成为新的末节点
     * @param e
     * @return
     */
    public BinTreePosition addList(Object e);

    /**
     * 删除末节点,并返回其中存放的位置
     * @return
     */
    public Object delLast();

    /**
     * 返回按照层次遍历编号为i的节点位置,0<=i<size()
     * @param i
     * @return
     */
    public BinTreePosition posOfNode(int i);
}
