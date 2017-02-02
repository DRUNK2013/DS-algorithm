package com.github2013.algorithm;

import java.util.StringTokenizer;

/**
 * Created by drunk on 17-2-2.
 * Author : DRUNK
 * email :len1988.zhang@gmail.com
 */
public class Test {
    public static void main(String[] args) {
        String s = new String("The Java platform is the ideal platform for network computing");
        StringTokenizer st = new StringTokenizer(s);
        System.out.println("Token Total:" + st.countTokens());
        while (st.hasMoreElements()) {
            System.out.println(st.nextToken());
        }


        s = new String("The=Java=platform=is=the=ideal=platform=for=network=computing");
        st = new StringTokenizer(s, "=", true);
        System.out.println("Token Total:" + st.countTokens());
        while (st.hasMoreElements()) {
            System.out.println(st.nextToken());
        }

        s = new String("<h1>数据结构与算法</h1>");
        st = new StringTokenizer(s, "<> \t", true);
        System.out.println("Token Total:" + st.countTokens());
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }

    }
}
