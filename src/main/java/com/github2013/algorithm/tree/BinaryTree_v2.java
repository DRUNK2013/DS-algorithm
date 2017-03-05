package com.github2013.algorithm.tree;

//定义数据结构节点
public class TreeNode{
    //左节点
    private TreeNode leftNode;
    
    //右节点
    private TreeNode rightNode;

    //数据节点
    private Object value;

    private boolean isDelete;
    
    public TreeNode getLeftNode(){
        return this.leftNode;
    }
    public void setLeftNode(TreeNode leftNode){
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode(){
        return this.rightNode;
    }
    public void SetRihtNode(TreeNode rightNode){
        this.rightNode = rightNode;
    }

    public Object getValue(){
        return this.value;
    }
    public void setValue(Object value){
        this.value = value;
    }

    public boolean GetIsDelete(){
         return this.isDelete;
    }
    public void setIsDelete(boolean isDelete){
        this.isDelete = isDelete;
    }

    public TreeNode(){
        super();
    }

    public TreeNode(Object value){
        this(null,null,value,false);
    }
    public TreeNode(TreeNode leftNode,TreeNode rightNode,Object value,boolean isDelete){
        super();
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.value = value;
        this.isDelete = isDelete;
    }
    
    @Override
    public String toString(){
        return "lleftNode:"+this.leftNode+
               "\nrightNode:"+this.rightNode +
               "\nvalue:"+this.value;
    }
}

public class BinaryTree_v2{


}
