package com.kee.prjEuler;/**
 * Created with IntelliJ IDEA.
 * User: ramacke
 * Date: 4/8/13
 * Time: 12:19 PM
 * To change this template use File | Settings | File Templates.
 */

import java.util.HashSet;
import java.util.Set;

/**
 * This Class P5_SmallestMultiple todo ramacke
 *
 * @author <a href="mailto:keerthi.ramachandran@navis.com">Keerthi Ramachandran</a>
 * @since 2.6. / 04-08-2013
 */
public class P5_SmallestMultiple {
    public static Set<Integer> getPrimes(int inLimit) {
        int i = 1;
        Set<Integer> integers = new HashSet<Integer>(5);
        while (i <= inLimit) {
            if (MyUtils.isPrime(i))
                integers.add(i);
            ++i;
        }
        return integers;
    }

    public static long getProduct(Set<Integer> inPrimesSet) {
        long product = 1;
        for (int i : inPrimesSet) {
            product *= i;
        }
        return product;
    }

    public static Set<Integer> getNonPrimes(int inLimit) {
        int i = 1;
        Set<Integer> integers = new HashSet<Integer>(5);
        while (i <= inLimit) {
            if (!MyUtils.isPrime(i))
                integers.add(i);
            ++i;
        }
        return integers;
    }

    public static long getSmallestMultiple(int inNumberUpTo) {
        long primeProduct = getProduct(getPrimes(inNumberUpTo));
        int startPos = 1;
        while (true) {
            boolean flag = true;
            for (int i : getNonPrimes(inNumberUpTo)) {
                if (flag) {
                    if (!((startPos * primeProduct) % i == 0)) {
                        flag = false;
                    }
                }
            }
            if (flag) {
                return primeProduct * startPos;
            }
            ++startPos;
        }
    }


}
