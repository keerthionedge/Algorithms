package com.kee.example.com.kee.prjEuler;

import com.kee.prjEuler.DistinctPrimeFactors;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: ramacke
 * Date: 27/5/13
 * Time: 4:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class DistinctPrimeFactorsTest {
    @Test
    public void testPrimes(){
        /**
         * Prime Numbers
         * 2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,
         * 59,61,67,71,73,79,83,89,97,101,103,107,109,
         * 113,127,131,137,139,149,151,157,163,167,173,
         * 179,181,191,193,197,199,211,223,227,229,233,
         * 239,241,251,257,263,269,271,277,281,283,293,
         * 307,311,313,317,331,337,347,349,353,359,367,373,379,383,389,397.............
         */
        Integer[] integers = DistinctPrimeFactors.getPrimes(5);
        Assert.assertEquals(2, (Object) integers[0]);
        Assert.assertEquals(3,integers.length);

        integers = DistinctPrimeFactors.getPrimes(31);
        Assert.assertEquals(11,integers.length);
        Assert.assertEquals(31,(Object)integers[10]);

        integers = DistinctPrimeFactors.getPrimes(400);
        Assert.assertEquals(78,integers.length);
        Assert.assertEquals(389,(Object)integers[76]);
    }

    @Test
    public void testSolution(){
        int i = DistinctPrimeFactors.computeSolution(2,DistinctPrimeFactors.getPrimes(20));
        Assert.assertEquals(14,i);

    }
}
