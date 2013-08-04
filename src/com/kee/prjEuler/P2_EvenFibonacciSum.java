package com.kee.prjEuler;/**
 * Created with IntelliJ IDEA.
 * User: ramacke
 * Date: 2/8/13
 * Time: 11:01 PM
 * To change this template use File | Settings | File Templates.
 */

/**
 * This Class P2_EvenFibonacciSum todo ramacke
 *
 * @author <a href="mailto:keerthi.ramachandran@navis.com">Keerthi Ramachandran</a>
 * @since 2.6. / 02-08-2013
 */
public class P2_EvenFibonacciSum {
    /**
     * 1,2,3,5,8,13,21,34,55,89,144,233,377,610,987,1597,2584,4181,6765,10946,17711,28657,46368,75025,121393,196418,317811,514229,832040,1346269,2178309,3524578
     * 2,8,34 sum is 44 (for 100 as limit)
     * 2,8,34,144 sum is 188 (for 200 as limit)
     * 2,8,34,144,610 sum is 798 (for 1000 as limit)
     * 2,8,34,144,610,2584,10946,46368,196418,832040,3524578
     *
     * @param inLimit
     * @return
     */
    public static int getEvenSumOfFibonacci(int inLimit) {
        int no1 = 1;
        int no2 = 2;
        boolean flag1 = false;      //no1 is odd
        boolean flag2 = true;       //no2 is even
        int sum = 0;
        while (no2 < inLimit) {
            int swap = no1;
            boolean flagSwap = flag1;
            no1 = no2;
            flag1 = flag2;
            no2 = swap + no2;
            flag2 = !flagSwap && !flag2;
            if (flag1)
                sum += no1;

        }
        return sum;
    }
}
