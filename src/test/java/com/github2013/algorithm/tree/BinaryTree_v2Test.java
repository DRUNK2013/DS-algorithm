package com.github2013.algorithm.tree;


import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by lsen on 17-3-6.
 */
public class BinaryTree_v2Test {
    @Test
    public void testMain() {
        BinaryTree_v2 tree = new BinaryTree_v2();
        tree.add(10);
        tree.add(40);
        tree.add(20);
        tree.add(3);
        tree.add(49);
        tree.add(13);
        tree.add(23);

        System.out.println("root=" + tree.getRoot().getValue());


        assertEquals(tree.getRoot().getValue().toString(), "10");
        TreeNode node = tree.find(13);
        assertEquals(13, node.getValue());
        TreeNode node2 = tree.find2(14,tree.getRoot());
        assertEquals(null,node2);
        System.out.println("============find2============");
        System.out.println(node2);

        System.out.println("中序遍历，即从小到大排序：");
        tree.inOrder(tree.getRoot());
    }

}