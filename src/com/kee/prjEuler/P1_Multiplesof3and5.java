package com.kee.prjEuler;

import java.util.HashSet;
import java.util.Set;

/**
 * This Class P1_MultiplesOf3And5 todo ramacke
 *
 * @author <a href="mailto:keerthi.ramachandran@navis.com">Keerthi Ramachandran</a>
 * @since 2.6. / 02-08-2013
 */
public class P1_MultiplesOf3And5 {
    public static Set<Integer> getMultiples(int inLimit) {
        boolean break3Condition = false;
        boolean break5Condition = false;
        boolean doNotBreakLoop = false;
        Set<Integer> integers = new HashSet<Integer>(100);
        for (int i = 1; !doNotBreakLoop; ) {

            if (i * 3 > inLimit)
                break3Condition = true;
            if (!break3Condition) {
                integers.add(i * 3);
            }

            if (i * 5 > inLimit)
                break5Condition = true;
            if (!break5Condition) {
                integers.add(i * 5);
            }
            doNotBreakLoop = break3Condition && break5Condition;
            ++i;
        }
        return integers;
    }

    public static int getSum(Set<Integer> inIntegerSet) {
        int sum = 0;
        for (int i : inIntegerSet) {
            sum += i;
        }
        return sum;
    }

    public static int getMultiplesSum(int inLimit) {
        int sum = 0;
        for (int i = 1; i < 1000; ) {
            if (i % 3 == 0 || i % 5 == 0)
                sum += i;
            ++i;
        }
        return sum;
    }
}
