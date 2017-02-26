package com.github2013.algorithm.tree;

/**
 * Created by len on 17-2-26.
 * Author : DRUNK
 * email :len1988.zhang@gmail.com
 */


import java.util.LinkedList;
import java.util.List;

/**
 * 把一个数据转换成平衡二叉树,并
 */
public class BinTreeTraverse {
    private int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    private static List<Node> nodeList = null;

    private static class Node {
        Node leftChild;
        Node rightChild;
        int data;

        public Node(int data) {
            leftChild = null;
            rightChild = null;
            this.data = data;
        }
    }

    public void createBinTree() {
        nodeList = new LinkedList<Node>();
        //将数组中的元素依次加入到Node节点中
        for (int i = 0; i < array.length; i++) {
            nodeList.add(new Node(array[i]));
        }

        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
            //左孩子
            nodeList.get(parentIndex).leftChild = nodeList.get(parentIndex * 2 + 1);
            //右孩子
            nodeList.get(parentIndex).rightChild = nodeList.get(parentIndex * 2 + 2);
        }

        int lastParentIndex = array.length / 2 - 1;
        nodeList.get(lastParentIndex).leftChild = nodeList.get(lastParentIndex * 2 + 2);

        if (array.length % 2 == 1) {
            nodeList.get(lastParentIndex).rightChild = nodeList.get(lastParentIndex * 2 + 2);
        }

    }

    /**
     * 先序遍历
     *
     * 这三种不同的遍历结构都是一样的，只是先后顺序不一样而已
     *
     * @param node
     *            遍历的节点
     */
    public static void preOrderTraverse(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrderTraverse(node.leftChild);
        preOrderTraverse(node.rightChild);
    }

    /**
     * 中序遍历
     *
     * 这三种不同的遍历结构都是一样的，只是先后顺序不一样而已
     *
     * @param node
     *            遍历的节点
     */
    public static void inOrderTraverse(Node node) {
        if (node == null)
            return;
        inOrderTraverse(node.leftChild);
        System.out.print(node.data + " ");
        inOrderTraverse(node.rightChild);
    }

    /**
     * 后序遍历
     *
     * 这三种不同的遍历结构都是一样的，只是先后顺序不一样而已
     *
     * @param node
     *            遍历的节点
     */
    public static void postOrderTraverse(Node node) {
        if (node == null)
            return;
        postOrderTraverse(node.leftChild);
        postOrderTraverse(node.rightChild);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        BinTreeTraverse binTree = new BinTreeTraverse();
        binTree.createBinTree();
        // nodeList中第0个索引处的值即为根节点
        Node root = nodeList.get(0);

        System.out.println("先序遍历：");
        preOrderTraverse(root);
        System.out.println();

        System.out.println("中序遍历：");
        inOrderTraverse(root);
        System.out.println();

        System.out.println("后序遍历：");
        postOrderTraverse(root);
    }
}
