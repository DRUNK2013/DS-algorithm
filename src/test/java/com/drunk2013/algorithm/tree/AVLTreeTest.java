package com.drunk2013.algorithm.tree;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

/**
 * Created by shuangfu on 17-4-13.
 * Author : DRUNK
 * email :len1988.zhang@gmail.com
 */
public class AVLTreeTest {

    AVLTree<Integer> tree;

    @Before
    public void setUp() throws Exception {
        tree = new AVLTree<Integer>();
    }

    @Test
    public void test() {
        System.out.println("------添加------");
        tree.add(50);
        System.out.print(50 + " ");
        tree.add(66);
        System.out.print(66 + " ");
        for (int i = 0; i < 10; i++) {
            int ran = (int) (Math.random() * 100);
            System.out.print(ran + " ");
            tree.add(ran);
        }
        System.out.println("------删除------");
        tree.remove(50);
        tree.remove(66);

        System.out.println();
        Iterator<Integer> it = tree.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }

    }

}