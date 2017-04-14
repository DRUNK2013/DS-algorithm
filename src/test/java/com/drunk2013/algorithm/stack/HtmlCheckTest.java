package com.drunk2013.algorithm.stack;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by drunk on 17-2-2.
 * Author : DRUNK
 * email :len1988.zhang@gmail.com
 */
public class HtmlCheckTest {
    HtmlCheck htmlCheck;

    @Before
    public void setUp() throws Exception {
        htmlCheck = new HtmlCheck();
    }

    @Test
    public void isMatched() throws Exception {
        ArrayList<String> htmlList = new ArrayList<String>();
        htmlList.add("<body>");
        htmlList.add("<left>");
        htmlList.add("<h1>数据结构与算法</h1>");
        htmlList.add("<p>");
        htmlList.add("程序=数据结构+算法");
        htmlList.add("</p>");
        htmlList.add("<ol>");
        htmlList.add("<li>线性结构</li>");
        htmlList.add("<li>半线性结构</li>");
        htmlList.add("<li>非线性结构</li>");
        htmlList.add("</ol>");
        htmlList.add("</left>");
        htmlList.add("</body>");
        assertTrue(htmlCheck.isMatched(htmlCheck.parseHTML(htmlList)));
    }

}