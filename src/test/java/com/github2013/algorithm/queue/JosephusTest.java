package com.github2013.algorithm.queue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by drunk on 17-2-2.
 * Author : DRUNK
 * email :len1988.zhang@gmail.com
 */
public class JosephusTest {
    Josephus josephus;

    @Before
    public void setUp() throws Exception {
        josephus = new Josephus();
        String[] kid = {"Alice", "Bob",
                "Cindy",
                "Fred",
                "Gene",
                "Hope",
                "Kim",
                "Lance",
                "Mike",
                "Doug",
                "Irene",
                "Nancy",
                "Ed",
                "Jack",
                "Ollie"};
        System.out.println("最终的幸运者是" + josephus.findChild(josephus.buildQueue(kid), 5));
        assertEquals("Kim", josephus.findChild(josephus.buildQueue(kid), 5));
    }

    @Test
    public void findChild() throws Exception {

    }

}