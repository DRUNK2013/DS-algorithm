package com.drunk2013.algorithm.stack;

import com.drunk2013.algorithm.stack.impl.StackByLinkedlistImpl;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * HTML 文档标识匹配算法
 * 通过队列结构，检查HTML括号匹配
 * Created by drunk on 17-2-2.
 * Author : DRUNK
 * email :len1988.zhang@gmail.com
 */
public class HtmlCheck {
    public final static int CAPATITY = 1000;

    //嵌套类，存放HTML标识
    public static class Tag {
        String name;//标识名
        boolean opening;//起始标识

        public Tag() {
            this("", false);
        }

        public Tag(String name, boolean type) {
            this.name = name;
            this.opening = type;
        }

        public boolean isOpening() {
            return this.opening;
        }

        public String getName() {
            return this.name;
        }

    }

    //通过缩略显示匹配的层级
    private void indent(int level) {
        for (int k = 0; k < level; k++) {
            System.out.print("\t|");
        }
    }

    public boolean isMatched(Tag[] tag) {
        int level = 0;//标识的层次
//        IStack stack = new StackByArrayImpl(100); //存放标识的栈
        IStack stack = new StackByLinkedlistImpl();
        for (int i = 0; (i < tag.length) && (tag[i] != null); i++) { //逐一检查各个标识
            if (tag[i].isOpening()) {
                stack.push(tag[i].getName());
                indent(level++);
                System.out.println("\t " + tag[i].getName());
            } else {//结束当前标识
                if (stack.isEmpty()) {
                    return false;
                }
                if (!((String) stack.pop()).equals(tag[i].getName())) {
                    return false;
                }
                indent(--level);
                System.out.println("\t " + tag[i].getName());
            }
        }
        //扫描整个文档
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    //解析HTML文档，提取标识，以此存入数组中
    public Tag[] parseHTML(ArrayList<String> htmlList) {
        boolean inTag = false;//标识，当前是否扫描到标识
        Tag[] tag = new Tag[CAPATITY];
        int count = 0;

        for (String line : htmlList) {
            StringTokenizer st = new StringTokenizer(line, "<> \t", true);//标识的特征为尖括号
            while (st.hasMoreTokens()) {
                String token = (String) st.nextToken();
                if (token.equals("<")) {//若扫描到'<',说明遇到了下一标志,故
                    inTag = true;//将当前状态设为"正在扫描标志"
                } else if (token.equals(">")) {//若扫描到'>',说明上一标志扫描完毕,故
                    inTag = false;
                } else if (inTag) {////若正在扫描一个标志
                    if ((token.length() == 0) || (token.charAt(0) != '/')) {
                        tag[count++] = new Tag(token, true);//起始标识，<>也算起始标识
                    } else {
                        tag[count++] = new Tag(token.substring(1), false); //加入一个结束标识，并去掉'/'
                    }

                }

            }

        }
        return tag;
    }


}
