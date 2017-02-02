package com.github2013.algorithm.stack;

import com.github2013.algorithm.stack.impl.StackByArrayImpl;
import com.github2013.algorithm.stack.impl.StackByLinkedlistImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by drunk on 17-2-2.
 * Author : DRUNK
 * email :len1988.zhang@gmail.com
 */
public class IStackTest {

    //IStack stack= new StackByArrayImpl(10);
    IStack stack = new StackByLinkedlistImpl();

    @Before
    public void setUp() throws Exception {
        assertTrue(stack.isEmpty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
    }

    @Test
    public void getSize() throws Exception {
        assertEquals(5, stack.getSize());
    }

    @Test
    public void top() throws Exception {
        assertEquals(5, stack.pop());
    }

    @Test
    public void push() throws Exception {
        stack.push(6);
    }

    @Test
    public void pop() throws Exception {
        Object obj = stack.pop();
        assertEquals(5, obj);
    }

}