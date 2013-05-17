package com.kee.example;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: keerthi
 * Date: 5/16/13
 * Time: 2:14 PM
 * To change this template use File | Settings | File Templates.
 */

public class pentagonalNumbersTest {
    @Test
    public void testGenNumbers(){
        int[] generatedNumbers = PentagonalNumbers.getPentagonalList(10);
        Assert.assertEquals(11, generatedNumbers.length);
        Assert.assertEquals(1,generatedNumbers[1]);
        Assert.assertEquals(5,generatedNumbers[2]);
        int[] expectedArray = {0,1,5,12, 22, 35, 51, 70, 92, 117, 145};
        org.junit.Assert.assertArrayEquals(expectedArray,generatedNumbers);
    }

    @Test
    public void testLogic(){
        int[] ints = PentagonalNumbers.getPentagonalList(10);
        int bound = PentagonalNumbers.getBounds(ints);
        Assert.assertEquals(0,bound);
    }
}
