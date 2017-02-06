package com.github2013.algorithm.link;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by drunk on 17-2-6.
 * Author : DRUNK
 * email :len1988.zhang@gmail.com
 */
public class PositionTest {
    Position p;

    @Before
    public void setUp() throws Exception {
        p = new Position() {

            public Object getElement() {
                return null;
            }

            public Object setElement(Object obj) {
                return null;
            }
        };
        p.setElement("test");
        System.out.println(p.getElement());
    }

    @Test
    public void getElement() throws Exception {
//        assertEquals("test", p.getElement());
    }


}