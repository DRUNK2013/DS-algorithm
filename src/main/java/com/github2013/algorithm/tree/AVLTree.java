package com.github2013.algorithm.tree;

/**
 * Created by len on 17-3-12.
 */

/**
 * 平衡二叉树,
 * 定义:平衡二叉树是一个特殊的二叉排序树,其左子树和右子树都是平衡二叉树.
 * 且左子树和右子树的深度之差,不超过1
 * 平衡因子:可以定义为左子树的深度减去右子树的深度.
 * 平衡二叉树是对二叉树的优化,二叉树在极端的情况下,是一个单链表.
 * 平衡二叉树查找元素的次数不超过树的深度,时间复杂度为:logN
 *
 * @param <E>
 */
public class AVLTree<E> {
    //定义左右子树之间深度差,1:左侧高,0:等高,-1:右侧高
    enum Balance {
        LH(1), EH(0), RH(-1);
        private final int value;

        Balance(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    //定义平衡二叉树的节点信息
    private class TreeNode<E> {
        private E element;
        private TreeNode<E> parent;
        private TreeNode<E> left;
        private TreeNode<E> right;
        private int balance = Balance.EH.getValue();

        public TreeNode(E element, TreeNode<E> parent) {
            this.element = element;
            this.parent = parent;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public TreeNode<E> getParent() {
            return parent;
        }

        public void setParent(TreeNode<E> parent) {
            this.parent = parent;
        }

        public TreeNode<E> getLeft() {
            return left;
        }

        public void setLeft(TreeNode<E> left) {
            this.left = left;
        }

        public TreeNode<E> getRight() {
            return right;
        }

        public void setRight(TreeNode<E> right) {
            this.right = right;
        }

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }

        @Override
        public String toString() {
            return String.format("%s,Balance=%d", element.toString(), balance);
        }
    }

    //根节点
    private TreeNode<E> root = null;

    //树中元素个数
    private int size;

    public AVLTree() {
        this.size = 0;
    }

    public int getSize() {
        return size;
    }
}
