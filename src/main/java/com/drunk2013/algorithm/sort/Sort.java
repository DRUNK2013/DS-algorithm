package com.drunk2013.algorithm.sort;

/**
 * Created by shuangfu on 17-4-13.
 * Author : DRUNK
 * email :len1988.zhang@gmail.com
 */


public class Sort {

    /**
     * 冒泡排序
     */
    public static void bubble(int[] a) {
        int length = a.length;
        int tmp = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < length - i; j++) {
                if (a[j - 1] > a[j]) {
                    tmp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = tmp;
                }
            }
        }
    }

    /**
     * 优化的冒泡排序，若某趟遍历，未发生交换，则说明已排序完成
     */
    public static void bubble2(int[] a) {
        int length = a.length;
        int tmp = 0;
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int j = 1; j < length; j++) {
                if (a[j - 1] > a[j]) {
                    tmp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = tmp;
                    flag = true;
                }
            }
        }
    }

    /**
     * 快速排序
     *
     * @param a
     * @param from 数组排序的开始位置
     * @param to   数组排序的介绍位置
     */
    public static void quick(int[] a, int from, int to) {
        if (from > to) {
            return;
        }

        int pivot = a[from];//参照值
        int i = from - 1;
        int j = to + 1;
        while (i < j) {

        }

        // 把较小的数先移到新数组中


    }

    private static int partition() {
        return 1;
    }


}
