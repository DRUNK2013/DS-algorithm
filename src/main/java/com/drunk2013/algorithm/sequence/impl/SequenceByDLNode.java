package com.drunk2013.algorithm.sequence.impl;

import com.drunk2013.algorithm.List.impl.ListByDLNodeImpl;
import com.drunk2013.algorithm.sequence.ISequence;
import com.drunk2013.algorithm.DSException;
import com.drunk2013.algorithm.link.DLNode;
import com.drunk2013.algorithm.link.Position;

/**
 * Created by drunk on 17-2-7.
 * Author : DRUNK
 * email :len1988.zhang@gmail.com
 */
public class SequenceByDLNode extends ListByDLNodeImpl implements ISequence {
    ///辅助方法
    public void checkRank(int r, int n) throws DSException {
        if (r < 0 || r >= n) {
            throw new DSException("非法的秩[" + r + "],秩的范围应该在[0," + n + ")");
        }
    }

    /**
     * 取秩为r的元素
     *
     * @param r
     * @return
     * @throws DSException
     */
    public Object getAtRank(int r) throws DSException {
        checkRank(r, getSize());
        return rank2Pos(r).getElement();
    }

    /**
     * 将秩为r的元素替换为obj
     *
     * @param r
     * @param obj
     * @return
     * @throws DSException
     */
    public Object replaceAtRank(int r, Object obj) throws DSException {
        checkRank(r, getSize());
        return replace(rank2Pos(r), obj);
    }

    /**
     * 插入obj，作为秩为r的元素，返回该元素
     *
     * @param r
     * @param obj
     * @return
     * @throws DSException
     */
    public Object insertAtRank(int r, Object obj) throws DSException {
        checkRank(r, getSize() + 1);
        if (getSize() == r) {
            insertLast(obj);
        } else {
            insertBefore(rank2Pos(r), obj);
        }
        return null;
    }

    /**
     * 删除秩为r的元素
     *
     * @param r
     * @return
     * @throws DSException
     */
    public Object removeAtRank(int r) throws DSException {
        checkRank(r, getSize());
        return remove(rank2Pos(r));
    }

    /**
     * 返回秩为r的元素所在的位置
     *
     * @param r
     * @return
     * @throws DSException
     */
    public Position rank2Pos(int r) throws DSException {
        DLNode node;
        checkRank(r, getSize());
        if (r <= getSize() / 2) {//若秩较小
            node = header.getNext();//从前端开始
            for (int i = 0; i < r; i++) {
                node = node.getNext();
            }
        } else {//若秩较大
            node = trailer.getPrev();
            for (int i = 1; i < getSize() - r; i++) {
                node = node.getPrev();
            }
        }
        return node;
    }

    /**
     * 返回位置p处的秩
     *
     * @param p
     * @return
     * @throws DSException
     */
    public int pos2Rank(Position p) throws DSException {
        DLNode node = header.getNext();
        int r = 0;
        while (node != trailer) {
            if (node == p) {
                return r;
            }
            node = node.getNext();
            r++;
        }
        throw new DSException("序列中,不存在此位置!!!");
    }

}
