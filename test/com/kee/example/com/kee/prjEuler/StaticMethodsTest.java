package com.kee.example.com.kee.prjEuler;

import com.kee.prjEuler.P50_ConsecutivePrimeSum;
import junit.framework.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ramacke
 * Date: 27/5/13
 * Time: 7:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class StaticMethodsTest {
    @Test
    public void testP50_getPrimes(){
        List<Integer> primeList = P50_ConsecutivePrimeSum.getPrimes(1000);
        Assert.assertEquals(1000,primeList.size());
        Assert.assertEquals(547, (Object) primeList.get(100));

        List<Integer> cumulativeSum = P50_ConsecutivePrimeSum.getCumulativeSums(primeList);
        Assert.assertEquals(2, (Object) cumulativeSum.get(0));
        Assert.assertEquals(5, (Object) cumulativeSum.get(1));
        Assert.assertEquals(1720, (Object) cumulativeSum.get(30));
        Assert.assertEquals(3682913, (Object) cumulativeSum.get(999));


        /*int primeNo = P50_ConsecutivePrimeSum.computeSolution(42,P50_ConsecutivePrimeSum.getPrimes(42));
        Assert.assertEquals(41,primeNo);

        primeNo = P50_ConsecutivePrimeSum.computeSolution(1000,P50_ConsecutivePrimeSum.getPrimes(200));
        Assert.assertEquals(953,primeNo);*/

        //primeNo = P50_ConsecutivePrimeSum.computeSolution(1000000,P50_ConsecutivePrimeSum.getPrimes(1000));
        //Assert.assertEquals(953,primeNo);

        /*List<Integer> primesAsPartOfSums = P50_ConsecutivePrimeSum.
                getListOfPrimesAsSumOfPrimes(1000000,P50_ConsecutivePrimeSum.getPrimes(1000));
        Assert.assertEquals(11989,primesAsPartOfSums.size());*/
    }
}
