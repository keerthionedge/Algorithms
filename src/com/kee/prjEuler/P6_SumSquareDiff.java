package com.kee.prjEuler;

/**
 * This Class P6_SumSquareDiff
 * The sum of squares of n natural numbers could be expressed as product of (n/3)(n+1)((2n+1)/2)
 * and sum of n natural numbers could be expressed as (n(n+1)/2)
 *
 * @author <a href="mailto:keerthi.ramachandran@outlook.com">Keerthi Ramachandran</a>
 * @since 2.6. / 04-08-2013
 */
public class P6_SumSquareDiff {

    public static long getDiff(int inLimit) {
        return (getSummedSquare(inLimit) - getSquaredSum(inLimit));
    }

    public static long getSquaredSum(int inLimit) {
        return ((inLimit * (inLimit + 1) * ((2 * inLimit) + 1)) / 6);
    }

    public static long getSummedSquare(int inLimit) {
        int i = ((inLimit) * (inLimit + 1)) / 2;
        return i * i;
    }

}
