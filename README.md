#DS-algorithm 数据结构与算法练习（java && python）
参考书籍:http://www.chinastor.org/upload/2013-12/13121914552984.pdf
        https://dsa.cs.tsinghua.edu.cn/~deng/ds/dsaj/dsaj.pdf
可视化动画演示:http://coolshell.cn/articles/4671.html

# 1.stack
栈是存放对象的一种特殊容器，在插入与删除对象时，这种结构遵循后进先出（Last-in-first-out，LIFO）的原则⎯⎯也就是说，对象可以任意插入栈中，但每次取出的都是此前插入的最后一个对象。
比如一摞椅子（如 图二.1 所示），只能将最顶端的椅子移出，也只能将新椅子放到最顶端⎯⎯这两种操作分别称作入栈（Push）和退栈（Pop）。
# 2.树结构体操作
树结构,大量使用了递归函数.
递归函数:是一个栈操作,先进后出的逻辑,把函数,参数等压入栈中,参阅:http://www.cnblogs.com/ITgaozy/p/5162889.html
每一个递归,都必有一个终止条件,即函数引用的地址.
前序遍历和后续遍历,不同之处在于:输出节点的位置.前序遍历先输出节点.后续遍历,在所有的sibling节点遍历后,才输出节点.
java 不支持函数指针,因此需要通过迭代器模式,进行数据遍历.
提示:尾递归,可以通过迭代完成.
