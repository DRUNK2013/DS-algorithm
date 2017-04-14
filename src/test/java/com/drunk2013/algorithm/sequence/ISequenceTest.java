package com.drunk2013.algorithm.sequence;

import com.drunk2013.algorithm.link.DLNode;
import com.drunk2013.algorithm.link.Position;
import com.drunk2013.algorithm.sequence.impl.SequenceByDLNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by drunk on 17-2-7.
 * Author : DRUNK
 * email :len1988.zhang@gmail.com
 */
public class ISequenceTest {
    ISequence sequence;

    @Before
    public void setUp() throws Exception {
        sequence = new SequenceByDLNode();
        sequence.insertFirst("node_1");
        sequence.insertLast("node_2");
        sequence.insertLast("node_3");
        sequence.insertLast("node_4");
    }

    @Test
    public void rank2Pos() throws Exception {
        Position position = sequence.rank2Pos(1);
        System.out.println(position.getElement());
        assertEquals(position.getElement(), "node_2");
    }

    @Test
    public void pos2Rank() throws Exception {
        DLNode node = new DLNode();
        node.setElement("node_3");
    }

}