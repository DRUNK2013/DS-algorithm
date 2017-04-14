package com.drunk2013.algorithm.queue;

/**
 * Created by drunk on 17-2-2.
 * Author : DRUNK
 * email :len1988.zhang@gmail.com
 */

import com.drunk2013.algorithm.queue.impl.QueueByLinkedlistImpl;

import java.util.Arrays;

/**
 * “烫手山芋”游戏:一群小孩围成一圈,有一个刚出锅的山芋在他们之间
 * 传递。其中一个孩子负责数数,每数一次,拿着山芋的孩子就把山芋转交给右边的邻居。一旦数到
 * 某个特定的数,拿着山芋的孩子就必须退出,然后重新数数。如此不断,最后剩下的那个孩子就是
 * 幸运者。
 */

//利用队列结构模拟Josophus环
public class Josephus {
    public Object findChild(IQueue Q, int k) {
        if (Q.isEmpty()) {
            return null;
        }
        while (Q.getSize() > 1) {
            System.out.print("还剩孩子：" + Arrays.toString(Q.getQueue()));
            for (int i = 0; i < k; i++) {//山芋向后传递k次
                Q.enqueue(Q.dequeue());
            }
            Object e = Q.dequeue(); //拿着山芋的孩子退出
            System.out.println("\n[" + e + "],退出！");
        }
        return Q.dequeue(); //剩下的最后的孩子
    }

    //对一组孩子组成队列
    public IQueue buildQueue(Object[] children) {
//        IQueue queue = new QueueByArrayImpl();
        IQueue queue = new QueueByLinkedlistImpl();
        for (int i = 0; i < children.length; i++) {
            queue.enqueue(children[i]);
        }
        return queue;
    }

}
