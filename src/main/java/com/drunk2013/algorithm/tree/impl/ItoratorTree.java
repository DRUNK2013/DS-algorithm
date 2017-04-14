package com.drunk2013.algorithm.tree.impl;

import com.drunk2013.algorithm.iterator.IIterator;
import com.drunk2013.algorithm.DSException;
import com.drunk2013.algorithm.List.IList;
import com.drunk2013.algorithm.link.Position;
import com.drunk2013.algorithm.queue.impl.QueueByLinkedlistImpl;

/**
 * Created by drunk on 17-2-11.
 * Author : DRUNK
 * email :len1988.zhang@gmail.com
 */
public class ItoratorTree implements IIterator {
    private IList list;//列表
    private Position nextPosition;//当前(下一个)元素的位置

    public ItoratorTree() {
        list = null;
    }

    /**
     * 前序遍历
     *
     * @param T
     */
    public void elementsPreorderIterator(TreeLinkedList T) {
        if (null == T) {
            return; //递归基
        }

        list.insertLast(T);

        TreeLinkedList subTree = T.getFirstChild();//从当前节点的长子开始
        while (null != subTree) {
            this.elementsPreorderIterator(subTree);
            subTree = subTree.getNextSibling();
        }
    }

    /**
     * 后序遍历
     *
     * @param T
     */
    public void elementPostorderIterator(TreeLinkedList T) {
        if (null == T) {
            return;
        }

        TreeLinkedList subtree = T.getFirstChild();//获取当前节点长子开始
        while (null != subtree) {//依次对当前节点的各个孩子
            this.elementsPreorderIterator(subtree); //做后续遍历
            subtree = subtree.getNextSibling();
        }
        list.insertLast(T);//当所有后代都访问后,最后才访问当前节点

    }

    public void levelTraversalIterator(TreeLinkedList T) {
        if (null == T) {
            return;
        }
        QueueByLinkedlistImpl Q = new QueueByLinkedlistImpl(); //空队
        Q.enqueue(T); //根节点入队
        while (Q.isEmpty()) {
            TreeLinkedList tree = (TreeLinkedList) (Q.dequeue()); //取出队列首节点
            list.insertLast(tree);//将新出对的节点接入迭代器中
            TreeLinkedList subtree = tree.getFirstChild();//从tree的第一个孩子起
            while (null != subtree) {//依次找出所有孩子,并
                Q.enqueue(subtree);//将其加入队列中
                subtree = subtree.getNextSibling();
            }
        }
    }

    /**
     * 检查迭代器中,是否还有元素
     *
     * @return
     */
    public boolean hasNext() {
        return (null != nextPosition);
    }

    /**
     * 迭代器中的下一个元素
     *
     * @return
     */
    public Object getNext() throws DSException {
        if (!hasNext()) {
            throw new DSException("No next position");
        }
        Position currentPosition = nextPosition;
        if (currentPosition == list.last()) {//若已达到未元素,则
            nextPosition = null;
        } else {
            nextPosition = list.getNext(currentPosition);
        }
        return currentPosition.getElement();
    }
}
