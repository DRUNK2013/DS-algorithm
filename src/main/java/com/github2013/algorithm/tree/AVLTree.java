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
    private class Node<E> {
        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;
        private int balance = Balance.EH.getValue();

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getParent() {
            return parent;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> right) {
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
    private Node<E> root = null;

    //树中元素个数
    private int size;

    public AVLTree() {
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    /**
     * 左旋转
     *
     * @param p 节点p向左旋转
     *          向左旋转之后p移到p的左子树处，p的右子树r变为此最小子树根节点，
     *          r的左子树变为p的右子树:
     *          |       p                    r
     *          |        ╲     p左旋转       ╱ ╲
     *          |         r     ---->      p   BR
     *          |        ╱ ╲                ╲
     *          |       BL  BR              BL
     *          旋转之后树的深度之差不超过1
     */
    public void rotateLeft(Node<E> p) {
        System.out.println("绕" + p.element + "向左侧旋转");
        if (null != p) {
            Node<E> r = p.right;
            p.right = r.left;//把P右子树左节点(即节点A) 嫁接到P的右节点上
            if (null != r.left) { //如果r的左节点不为空,把BL节点设为p
                r.left.parent = p;
            }
            r.parent = p.parent;  //p的父节点设为a的父节点
            if (null == p.parent) {  //判断p是否为根节点
                root = r;
            } else if (p.parent.left == p) { //更新p的父节点的子节点为r,
                p.parent.left = r;           //需要判断p是左子树,还是右子树
            } else {
                p.parent.right = r;
            }

            r.left = p;     //更新r的左侧节点
            p.parent = r;   //跟新p节点的父节点
        }

    }


    /**
     * 右旋转
     *
     * @param p 节点p向右旋转
     *          向右旋转之后p移到p的右子树处，p的左子树l变为此最小子树根节点，
     *          l的右子树变为p的左子树:
     *          |           p                    l
     *          |          ╱      p左旋转        ╱ ╲
     *          |         l     ---->          BL  p
     *          |        ╱ ╲                      ╱
     *          |       BL  BR                   BR
     *          旋转之后树的深度之差不超过1
     */
    public void rotateRight(Node<E> p) {
        System.out.println("绕" + p.element + "向右旋转");
        if (null != p) {
            Node<E> l = p.left;
            p.left = l.right; //把l的右子树变为p
            if (null != l.right) { //如果BR不为空,设置BR的父节点为p
                l.right.parent = p;
            }
            l.parent = p.parent;//把p的父节点设置为l的父节点
            if (null == p.parent) { //如果p为根节点,把根节点转接给l
                root = l;
            } else if (p.parent.left == p) {  //更新p的父节点的子节点为l,
                p.parent.left = l;            //需要判断p是左子树,还是右子树
            } else {
                p.parent.right = l;
            }
            l.right = p; //更新l的右侧子树
            p.parent = l; //更新p的父节点
        }
    }

    /**
     * 添加数据节点
     * 基本原理为:
     * 1.根据二叉树的特性,从根节点开始向下查找比较,查找出数插入的位置.
     * 2.节点插入后,需要d对插入的节点自下而上回溯,需改其父节点的平衡因子.
     *   如此节点的值小于父节点,说明插入的节点是在左树,则需要把父节点的平衡因子+1.
     *   否则是右侧节点(说明:平衡二叉树,没有相等值),则需要把父节点的平衡因子-1操作.
     *   若平衡因子为0,则终止回溯,说明子树平衡.
     *   若此节点的平衡因子为2或-2,则需要调整树的结构.
     * @param element
     * @return
     */
    public boolean add(E element) {
        Node<E> t = this.root;
        if (null == t) {
            this.root = new Node<E>(element, null);
            this.size = 1;
            return true;
        }

        int cmp;//元素比较的临时结果
        Node<E> parent;
        Comparable<? super E> e = (Comparable<? super E>) element;

        //从根节点向下搜索,找到插入的位置
        do {
            parent = t;
            cmp = e.compareTo(t.element);
            if (cmp < 0) {
                t = t.left;
            } else if (cmp > 0) {
                t = t.right;
            } else {
                return false; //元素不能相同
            }
        } while (null != t);

        Node<E> child = new Node<E>(element, parent);
        if (cmp < 0) {
            parent.left = child;
        } else {
            parent.right = child;
        }

        //从当前节点向上回溯,查找最近不平衡的节点
        while (null != parent) {
            cmp = e.compareTo(parent.element);
            if (cmp < 0) {//插入左节点中
                parent.balance++;
            } else { //插入右节点中
                parent.balance--;
            }
            if (parent.balance == 0) { //整课树已平衡,退出
                break;
            }

            if (Math.abs(parent.balance) == 2) {//找到最小不平衡子树根节点
                fixAfterInsertion(parent);
                break;
            }
            parent = parent.parent;
        }
        size++;
        return true;
    }

    /**
     * 对当前节点的树进行平衡.
     * 若平衡因子为2,则说明左侧子树高,需要左侧平衡
     * @param p
     */
    private void fixAfterInsertion(Node<E> p){
        if(p.balance==2){
            leftBalance(p);
        }
        if(p.balance==-2){
            rightBalance(p);
        }
    }
    private boolean leftBalance(Node<E> p){
        return true;
    }

    private boolean rightBalance(Node<E> p){
        return true;
    }
}
