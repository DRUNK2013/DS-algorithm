package com.drunk2013.algorithm.tree;

import org.junit.Test;

/**
 * Created by len on 17-3-6.
 */
public class BinaryTreeTest {
    @Test
    public void testMain() {
        int a[] = {2, 4, 12, 45, 21, 6, 111};
        BinaryTree tree = new BinaryTree();
        for (int i = 0; i < a.length; i++) {
            tree.buildTree(tree.root, a[i]);
        }

        tree.preOrder(tree.root);
        tree.inOrder(tree.root);
        tree.postOrder(tree.root);
    }

}