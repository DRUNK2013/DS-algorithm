import com.github2013.algorithm.tree;

//构建一个二叉树,普通二叉树，不是平衡二叉树
public class BinaryTree{

    private Node root; //根节点
    
    //内部节点类
    private class Node{
        private Node left;
        private Node right;
        private int data;
        public Node(int data){
            this.left = null;
            this.right = null;
            this.data = data;
        }
    }


    public BinaryTree(){
        root = null;
    }

    //递归创建二叉树
    public void buildTree(Node node,int data){
        if(null == root){
             root = new Node(data);
        }else{
            if(data < node.data){
                 if(null == node.left){
                     node.left = new Node(data); 
                 }else{
                      buildTree(node.left,data);
                 }
            }else{
                 if(null == node.right){
                       node.right = new Node(data);
                  }else{
                       buildTree(node.right,data);
                  }
            }

        }
    }

   //前序遍历
   public void preOrder(Node node){
      if(null != node){
          System.out.println(node.data);
          preOrder(node.left);
          preOrder(node.right);
      }

   }

   //中序遍历
   public void inOrder(Node node){
      if(null != node){
         inOrder(node.left);
         System.out.println(node.data);
         inOrder(node.right);
      }
   }

   //后续遍历
   public void postOrder(Node node){
      if(null != node){
          postOrder(node.left);
          postOrder(node.rihgt);
          system.out.println(node.data);
      }
   }


}
