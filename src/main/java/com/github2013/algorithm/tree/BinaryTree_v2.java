package com.github2013.algorithm.tree;

//http://www.cnblogs.com/lzq198754/p/5857597.html
//定义数据结构节点
class TreeNode {
    //左节点
    private TreeNode leftNode;

    //右节点
    private TreeNode rightNode;

    //数据节点
    private Object value;

    private boolean isDelete;

    public TreeNode getLeftNode() {
        return this.leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return this.rightNode;
    }

    public void setRihtNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public Object getValue() {
        return this.value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public boolean GetIsDelete() {
        return this.isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public TreeNode() {
        super();
    }

    public TreeNode(Object value) {
        this(null, null, value, false);
    }

    public TreeNode(TreeNode leftNode, TreeNode rightNode, Object value, boolean isDelete) {
        super();
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.value = value;
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "lleftNode:" + this.leftNode +
                "\nrightNode:" + this.rightNode +
                "\nvalue:" + this.value;
    }
}

public class BinaryTree_v2 {

    //根节点
    private TreeNode root;

    public TreeNode getRoot() {
        return this.root;
    }

    public void add(Object value) {
        TreeNode node = new TreeNode(value);

        if (null == root) {
            root = node;
            root.setLeftNode(null);
            root.setRihtNode(null);
            root.setValue(value);
        } else {
            TreeNode currentNode = root;
            TreeNode parentNode;
            while (true) {
                parentNode = currentNode;
                if (Integer.valueOf(node.getValue().toString()) > Integer.valueOf(currentNode.getValue().toString())) {
                    currentNode = currentNode.getRightNode();
                    if (null == currentNode) {
                        parentNode.setRihtNode(node);
                        return;
                    }
                } else {
                    currentNode = currentNode.getLeftNode();
                    if (null == currentNode) {
                        parentNode.setLeftNode(node);
                        return;
                    }
                }
            }
        }
    }

    //查找
    public TreeNode find(int key) {
        TreeNode currentNode = root;
        if (null != currentNode) {
            while (Integer.valueOf(currentNode.getValue().toString()) != key) {
                if (Integer.valueOf(currentNode.getValue().toString()) > key) {
                    currentNode = currentNode.getLeftNode();
                } else {
                    currentNode = currentNode.getRightNode();
                }
                if (currentNode == null) {
                    return null;
                }
            }
            return currentNode;
        } else {
            return null;
        }
    }

    //中序遍历
    public void inOrder(TreeNode tree) {
        if (null != tree) {
            inOrder(tree.getLeftNode());
            System.out.println(tree.getValue());
            inOrder(tree.getRightNode());
        }

    }

}
