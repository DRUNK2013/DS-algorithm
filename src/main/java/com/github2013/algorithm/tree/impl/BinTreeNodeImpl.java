package com.github2013.algorithm.tree.impl;

import com.github2013.algorithm.List.IList;
import com.github2013.algorithm.iterator.IIterator;
import com.github2013.algorithm.queue.impl.QueueByLinkedlistImpl;
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
        //如左子树非空,则其中的最大者即为当前节点的直接前驱
        if (hasLChild()) {
            return findMaxDescendant(getLChild());
        }
        //至此当前节点没有左孩子
        //若当前节点是有孩子,则父亲即为其直接前驱
        if (isRChild()) {
            return getPrev();
        }
        //至此当前节点没有左孩子,而且此节点是左孩子

        BinTreePosition v = this;//从当前节点出发
        while (v.isLChild()) {
            v = v.getParent();//沿着左孩子链一直上升
        }
        return v.getParent();
    }

    /**
     * 按照中序遍历的次序,找到当前节点的直接后继
     *
     * @return
     */
    public BinTreePosition getSucc() {
        //若右子树非空,则其中的最小者即为当前节点的直接后继
        if (hasRChild()) {
            return findMinDescendant(getRChild());
        }
        //至此,当前节点没有右侧孩子
        //若当前节点是左侧孩子,则父亲即为其直接后继
        if (isLChild()) {
            return getParent();
        }
        //至此,当前节点没有右孩子,而且此节点是右孩子
        BinTreePosition v = this;
        while (v.isRChild()) {
            v = v.getParent();
        }
        //至此,v或者没有父亲,或者父亲的左侧孩子
        return v.getParent();
    }

    /**
     * 返回当前节点
     *
     * @return
     */
    public BinTreePosition secede() {
        if(null !=parent){
            if(isLChild()){
                parent.setLChild(null);
            }else {
                parent.setRChild(null);
            }
            parent.updateSize();
            parent.updateHeight();
            parent = null;
            updateDepth();
        }
        return this;
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

    /*****************辅助方法************************/
    /**
     * 在v的后代中,找出最小者
     *
     * @param v
     * @return
     */
    protected static BinTreePosition findMinDescendant(BinTreePosition v) {
        if (null != v) {//从v出发,沿左孩子链一直下降
            while (v.hasLChild()) {
                v = v.getLChild();
            }
        }//至此,v为空,或者没有左侧孩子
        return v;
    }


    /**
     * 在v的后代中,找出最大者
     *
     * @param v
     * @return
     */
    protected static BinTreePosition findMaxDescendant(BinTreePosition v) {
        if (null != v) {//从v出发,沿着右侧孩子链一直下降
            while (v.hasRChild()) {
                v = v.getRChild();
            }
        }//至此,v为空,或者没有右侧孩子
        return v;
    }

    /**
     * 前序遍历,以v给根的(子)树
     *
     * @param list
     * @param v
     */
    protected static void preorder(IList list, BinTreePosition v) {
        if (null == v) {
            return;//递归基,空树
        }
        list.insertLast(v);//访问v
        preorder(list, v.getLChild());//遍历左子树
        preorder(list, v.getRChild());//遍历右子树
    }

    /**
     * 中序遍历,以v为根的(子)树
     *
     * @param list
     * @param v
     */
    protected static void inorder(IList list, BinTreePosition v) {
        if (null == v) {
            return; //递归基:空树
        }
        inorder(list, v.getLChild());
        list.insertLast(v);
        inorder(list, v.getRChild());
    }

    /***
     * 后续遍历,以v为根的(子)树
     * @param list
     * @param v
     */
    protected static void postorder(IList list, BinTreePosition v) {
        if (null == v) {
            return;//递归基:空树
        }
        postorder(list, v.getLChild());//遍历左子树
        postorder(list, v.getRChild());//遍历右子树
        list.insertLast(v);//访问v
    }

    /**
     * 层次遍历,以v为根节点的(子)树
     *
     * @param list
     * @param v
     */
    protected static void leverorder(IList list, BinTreePosition v) {
        QueueByLinkedlistImpl Q = new QueueByLinkedlistImpl();//控队
        Q.enqueue(v);//根节点入队
        while (!Q.isEmpty()) {
            BinTreePosition u = (BinTreePosition) Q.dequeue(); //出队
            list.insertLast(u);//访问v
            if (u.hasLChild()) {
                Q.enqueue(u.getLChild());
            }
            if (u.hasRChild()) {
                Q.enqueue(u.getRChild());
            }
        }

    }
}
