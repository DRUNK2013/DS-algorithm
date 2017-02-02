package com.github2013.algorithm.queue;

import com.github2013.algorithm.queue.impl.QueueByArrayImpl;
import com.github2013.algorithm.queue.impl.QueueByLinkedlistImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by drunk on 17-2-2.
 * Author : DRUNK
 * email :len1988.zhang@gmail.com
 */
public class IQueueTest {
    //    IQueue queue = new QueueByArrayImpl(10);
    IQueue queue = new QueueByLinkedlistImpl();

    @Before
    public void setUp() throws Exception {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
    }

    @Test
    public void getSize() throws Exception {
        assertEquals(5, queue.getSize());

    }

    @Test
    public void isEmpty() throws Exception {
        assertTrue(!queue.isEmpty());
    }

    @Test
    public void front() throws Exception {
        assertEquals(1, queue.front());
    }

    @Test
    public void enqueue() throws Exception {
        queue.enqueue(6);
    }

    @Test
    public void dequeue() throws Exception {
        Object obj = queue.dequeue();
        assertEquals(obj, 1);
    }

    @Test
    public void getQueue() throws Exception {
        assertArrayEquals(new Object[]{1, 2, 3, 4, 5}, queue.getQueue());
    }

}