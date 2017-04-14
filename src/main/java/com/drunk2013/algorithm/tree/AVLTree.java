package com.drunk2013.algorithm.tree;

/**
 * Created by len on 17-3-12.
 */

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

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
    private static final int LH = 1;    //左高
    private static final int EH = 0;    //等高
    private static final int RH = -1;   //右高

    //定义平衡二叉树的节点信息
    private class Node<E> {
        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;
        private int balance = EH;

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
     *          (注：BL和BR只能有一个存在，不能同时存在),r的左子树变为p的右子树:
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
     *          (注：BL和BR只能有一个存在，不能同时存在),l的右子树变为p的左子树:
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
     * 如此节点的值小于父节点,说明插入的节点是在左树,则需要把父节点的平衡因子+1.
     * 否则是右侧节点(说明:平衡二叉树,没有相等值),则需要把父节点的平衡因子-1操作.
     * 若平衡因子为0,则终止回溯,说明子树平衡.
     * 若此节点的平衡因子为2或-2,则需要调整树的结构.
     *
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

        //从当前节点向上回溯,查找最近不平衡的节点,判断插入的节点是在左子树里，还是右子树里.
        while (null != parent) {
            cmp = e.compareTo(parent.element);
            if (cmp < 0) {//插入在左子树
                parent.balance++;
            } else { //插入在右子树
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
     * 1.若左子树的根(以下简称R)平衡因子为2,则说明左侧子树高,需要左侧平衡
     * 如果R的左子树的根节点的BF为1时,做右旋
     * 如果R的右子树的根节点的BF为-1时,先左旋再右旋
     * <p>
     * 2.R为-2时,即右子树高于左子树.
     * 如果R的右子树的根节点为1时,先右旋再左旋
     * 如果R的右子树的根节点为-1时,做左旋.
     *
     * @param p
     */
    private void fixAfterInsertion(Node<E> p) {
        if (p.balance == 2) {
            leftBalance(p);
        }
        if (p.balance == -2) {
            rightBalance(p);
        }
    }

    /**
     * 做左平衡处理
     * |  平衡因子的调整如图:
     * |  情况1:(rd的BF为0),在删除tr子节点的情况下存在此种情况
     * |             p                       rd
     * |           /   \                   /    \
     * |          l    tr   左旋后右旋    l      p
     * |        /   \       ------->    /  \    /  \
     * |      ll    rd                ll   rdl rdr  tr
     * |           /   \
     * |         rdl  rdr
     * |
     * |
     * |
     * |  情况2:(rd的BF为1)
     * |             p                       rd
     * |           /   \                   /    \
     * |          l    tr   左旋后右旋    l      p
     * |        /   \       ------->    /  \      \
     * |      ll    rd                ll   rdl     tr
     * |           /
     * |         rdl
     * |
     * |
     * |
     * |  情况3:(rd的BF为-1)
     * |             p                       rd
     * |           /   \                   /    \
     * |          l    tr   左旋后右旋    l      p
     * |        /   \       ------->    /      /  \
     * |      ll    rd                 ll     rdr  tr
     * |            \
     * |           rdr
     * |
     * |
     * |
     * |  情况4:(L等高)
     * |      1、插入后现此情况：则rl和rd只能有一个存在
     * |      2、删除后现此情况：则必是删除t的右节点
     * |
     * |            p                          l
     * |           /       右旋处理           /  \
     * |          l        ------>          rl   p
     * |        /   \                           /
     * |       rl   rd                        rd
     *
     * @param p
     * @return
     */
    private boolean leftBalance(Node<E> p) {
        boolean heightLower = true;
        Node<E> l = p.left;
        switch (l.balance) {
            case LH:
                p.balance = l.balance = EH;
                rotateRight(p);
                break;
            case RH:
                Node<E> rd = l.right;
                switch (rd.balance) {
                    case LH://情况1
                        p.balance = RH;
                        l.balance = EH;
                        break;
                    case EH://情况2
                        p.balance = l.balance = EH;
                    case RH://情况3
                        p.balance = EH;
                        l.balance = LH;
                        break;
                }
                rd.balance = EH;
                rotateLeft(p.left);
                rotateRight(p);
                break;
            case EH:
                l.balance = RH;
                p.balance = LH;
                rotateRight(p);
                heightLower = false;
                break;
        }
        return heightLower;
    }

    /**
     * 做右平衡处理
     * 平衡因子的调整如图：
     * |      情况1:(ld的BF为0)
     * |          p                               ld
     * |       /     \                          /    \
     * |     tl       r       先右旋再左旋      p       r
     * |            /   \     -------->      /  \       \
     * |          ld    rr                 tl   ldl      rr
     * |         /
     * |      ldl
     * <p>
     * |      情况2:(ld的BF为1)
     * |         p                              ld
     * |       /   \                          /    \
     * |     tl     r       先右旋再左旋      p      r
     * |           /  \     -------->      /  \    /  \
     * |         ld   rr                 tl   ldl ldr rr
     * |        /  \
     * |     ldl  ldr
     * <p>
     * |      情况3:(ld的BF为-1)
     * |          p                               ld
     * |       /     \                          /    \
     * |     tl       r       先右旋再左旋      p      r
     * |            /   \     -------->      /      /  \
     * |          ld    rr                 tl     ldr  rr
     * |            \
     * |            ldr
     * <p>
     * |     情况4:(r的BF为0)
     * |           p                                r
     * |            \          左旋                /   \
     * |             r        ------->           p     rr
     * |           /   \                          \
     * |          ld   rr                         ld
     */
    private boolean rightBalance(Node<E> p) {
        boolean heightLower = true;
        Node<E> r = p.right;
        switch (r.balance) {
            case LH: //左高，分情况调整
                Node<E> ld = r.left;
                switch (ld.balance) {//调整各个节点的BF
                    case LH://情况1
                        p.balance = EH;
                        r.balance = RH;
                        break;
                    case EH://情况2
                        p.balance = r.balance = EH;
                        break;
                    case RH://情况3
                        p.balance = LH;
                        r.balance = EH;
                        break;
                }
                ld.balance = EH;
                rotateRight(p.right);
                rotateLeft(p);
                break;
            case RH://右高，左旋调整
                p.balance = r.balance = EH;
                rotateLeft(p);
                break;
            case EH: //特殊情况4
                r.balance = LH;
                p.balance = RH;
                rotateLeft(p);
                heightLower = false;
                break;
        }
        return heightLower;
    }

    /**
     * @param element
     * @return 查找指定元素，如果找到返回其Entry对象，否则返回null
     */
    private Node<E> getNode(Object element) {
        Node<E> tmp = root;
        Comparable<? super E> e = (Comparable<? super E>) element;
        int c;
        while (tmp != null) {
            c = e.compareTo(tmp.element);
            if (c == 0) {
                return tmp;
            } else if (c < 0) {
                tmp = tmp.left;
            } else {
                tmp = tmp.right;
            }
        }
        return null;
    }

    private void deleteNode(Node<E> p) {
        size--;
        //如果p左右子树都不为空，找到其直接后继，替换p，之后p指向s，删除p其实是删除s
        //所有的删除左右子树不为空的节点都可以调整为删除左右子树有其一不为空，或都为空的情况。
        if (p.left != null && p.right != null) {
            Node<E> s = successor(p);
            p.element = s.element;
            p = s;
        }
        Node<E> replacement = (p.left != null ? p.left : p.right);
        if (replacement != null) {//如果其左右子树有其一不为空
            replacement.parent = p.parent;
            if (p.parent == null) {//如果p为root节点
                root = replacement;
            } else if (p == p.parent.left) {//如果p是左孩子
                p.parent.left = replacement;
            } else {//如果p是右孩子
                p.parent.right = replacement;
            }

            p.left = p.right = p.parent = null;
            //这里更改了replacement的父节点，所以可以直接从它开始向上回溯
            fixAfterDeletion(replacement);
        } else if (null == p.parent) {// 如果全树只有一个节点
            root = null;
        } else {//左右子树都为空
            fixAfterDeletion(p);//这里从p开始回溯
            if (null != p.parent) {
                if (p == p.parent.left) {
                    p.parent.left = null;
                } else if (p == p.parent.right) {
                    p.parent.right = null;
                }
                p.parent = null;
            }


        }
    }

    private void fixAfterDeletion(Node<E> p) {
        boolean heightLower = true; //看最小子树调整后，它的高度是否发生变化，如果减小，继续回溯
        Node<E> t = p.parent;
        Comparable<? super E> e = (Comparable<? super E>) p.element;
        int cmp;
        //自下向上回溯，查找不平衡的节点进行调整
        while (null != t && heightLower) {
            cmp = e.compareTo(t.element);
            /**
             * 删除的节点是右子树，等于的话，必然是删除的某个节点的左右子树不为空的情况
             * 例如：     10
             *          /    \
             *         5     15
             *       /   \
             *      3    6
             * 这里删除5，是把6的值赋给5，然后删除6，这里6是p，p的父节点的值也是6。
             * 而这也是右子树的一种
             */
            if (cmp >= 0) {
                t.balance++;
            } else {
                t.balance--;
            }
            if (Math.abs(t.balance) == 1) { //父节点经过调整平衡因子后，如果为1或-1，说明调整之前是0，停止回溯。
                break;
            }
            Node<E> r = t;
            //这里的调整跟插入一样
            if (t.balance == 2) {
                heightLower = leftBalance(r);
            } else if (t.balance == -2) {
                heightLower = rightBalance(r);
            }
            t = t.parent;
        }
    }

    public boolean remove(Object element) {
        Node<E> e = getNode(element);
        if (null != e) {
            deleteNode(e);
            return true;
        }
        return false;
    }

    /**
     * 返回中序遍历此树的迭代器,返回的是一个有序列表
     */
    private class BinarySortIterator implements Iterator<E> {
        Node<E> next;
        Node<E> lastReturned;

        public BinarySortIterator() {
            Node<E> s = root;
            if (null != s) {//找到中序遍历的第一个元素
                while (s.left != null) {
                    s = s.left;
                }
            }
            next = s;
        }

        public boolean hasNext() {
            return next != null;
        }

        public E next() {
            Node<E> e = next;
            if (null == e) {
                throw new NoSuchElementException();
            }
            next = successor(e);
            lastReturned = e;
            return e.element;
        }

        public void remove() {
            if (null == lastReturned) {
                throw new IllegalStateException();
            }
            if (lastReturned.left != null && lastReturned.right != null) {
                next = lastReturned;
            }
            deleteNode(lastReturned);
            lastReturned = null;
        }
    }

    public Iterator<E> iterator() {
        return new BinarySortIterator();
    }

    private int treeHeight(Node<E> p) {
        if (null == p) {
            return -1;
        }
        return 1 + Math.max(treeHeight(p.left), treeHeight(p.right));
    }

    /**
     * 返回以中序遍历方式遍历树时，t的直接后继
     *
     * @param t
     * @return
     */
    private Node<E> successor(Node<E> t) {
        if (null == t) {
            return null;
        } else if (null != t.right) {//往右，然后向左直到尽头
            Node<E> p = t.right;
            while (p.left != null) {
                p = p.left;
            }
            return p;
        } else {//right为空，如果t是p的左子树，则p为t的直接后继
            Node<E> p = t.parent;
            Node<E> ch = t;
            while (p != null && ch == p.right) {//如果t是p的右子树，则继续向上搜索其直接后继
                ch = p;
                p = p.parent;
            }
            return p;
        }
    }
}
