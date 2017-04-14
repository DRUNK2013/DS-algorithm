package com.drunk2013.algorithm.sequence;

/**
 * Created by drunk on 17-2-7.
 * Author : DRUNK
 * email :len1988.zhang@gmail.com
 */

import com.drunk2013.algorithm.vector.IVector;
import com.drunk2013.algorithm.DSException;
import com.drunk2013.algorithm.List.IList;
import com.drunk2013.algorithm.link.Position;

/**
 * 序列的接口
 */
public interface ISequence extends IVector, IList {
    /**
     * 返回秩为r的元素所在的位置
     *
     * @param r
     * @return
     * @throws DSException
     */
    Position rank2Pos(int r) throws DSException;

    /**
     * 返回位置p处的秩
     *
     * @param p
     * @return
     * @throws DSException
     */
    int pos2Rank(Position p) throws DSException;


}
