package com.kee.example.com.kee.prjEuler;

import com.kee.prjEuler.*;
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

    @Test
    public void testP51_PrimePatterns(){
        int digit = 7;
        int lowerLimit = P51_PrimePatterns.padNines(7);
        int upperLimit = P51_PrimePatterns.padZeros(7);
        Assert.assertEquals(9999999,lowerLimit);
        Assert.assertEquals(100000000,upperLimit);

        int eightDigitNo = 45454541;
        List<Integer> replacements = P51_PrimePatterns.getPossibleIntsWithOneReplacements(eightDigitNo);
        System.out.println(replacements);
        Assert.assertEquals(63,replacements.size());  // 7*9 =63 replacements
    }

    @Test
    public void testP1_MultiplesOf3And5(){
        Assert.assertEquals(233168, P1_MultiplesOf3And5.getSum(P1_MultiplesOf3And5.getMultiples(999))); // ensure  only
        Assert.assertEquals(233168, P1_MultiplesOf3And5.getMultiplesSum(1000)); //actual
    }

    @Test
    public void testP2_EvenFibonacciSum(){
        Assert.assertEquals(44, P2_EvenFibonacciSum.getEvenSumOfFibonacci(100));
        Assert.assertEquals(188, P2_EvenFibonacciSum.getEvenSumOfFibonacci(200));
        Assert.assertEquals(798, P2_EvenFibonacciSum.getEvenSumOfFibonacci(1000));
        Assert.assertEquals(4613732, P2_EvenFibonacciSum.getEvenSumOfFibonacci(4000000));

    }

    @Test
    public void testP3_LargestPrimeFactor(){
        Assert.assertEquals(29,P3_LargestPrimeFactor.largestPrimeFactor(13195));
        Assert.assertEquals(5,P3_LargestPrimeFactor.largestPrimeFactor(1200));
        Assert.assertEquals(6857,P3_LargestPrimeFactor.largestPrimeFactor(600851475143l));
    }

    @Test
    public void testP4_PalindromeNumber(){
        Assert.assertEquals(true,P4_PalindromeNumber.isNoPalindrome(9009));
        Assert.assertEquals(true,P4_PalindromeNumber.isNoPalindrome(990099));
        Assert.assertEquals(true,P4_PalindromeNumber.isNoPalindrome(808));
        Assert.assertEquals(true,P4_PalindromeNumber.isNoPalindrome(808808));
        Assert.assertEquals(true,P4_PalindromeNumber.isNoPalindrome(808808));

        Assert.assertEquals(9009,P4_PalindromeNumber.getPalindromeNo(99));
        Assert.assertEquals(906609,P4_PalindromeNumber.getPalindromeNo(999));

    }
    @Test
    public void testP5_SmallestMultiple(){
        Assert.assertEquals(210,P5_SmallestMultiple.getProduct(P5_SmallestMultiple.getPrimes(10)));
        Assert.assertEquals(9699690,P5_SmallestMultiple.getProduct(P5_SmallestMultiple.getPrimes(20)));
        Assert.assertEquals(17280,P5_SmallestMultiple.getProduct(P5_SmallestMultiple.getNonPrimes(10)));
        Assert.assertEquals(250822656000l,P5_SmallestMultiple.getProduct(P5_SmallestMultiple.getNonPrimes(20)));

        Assert.assertEquals(2520,P5_SmallestMultiple.getSmallestMultiple(10));
        Assert.assertEquals(232792560,P5_SmallestMultiple.getSmallestMultiple(20));
    }

    @Test
    public void testP6_SumSquareDiff(){
        Assert.assertEquals(385,P6_SumSquareDiff.getSquaredSum(10));
        Assert.assertEquals(3025,P6_SumSquareDiff.getSummedSquare(10));
        Assert.assertEquals(2640,P6_SumSquareDiff.getDiff(10));
        Assert.assertEquals(338350,P6_SumSquareDiff.getSquaredSum(100));
        Assert.assertEquals(25502500,P6_SumSquareDiff.getSummedSquare(100));
        Assert.assertEquals(25164150,P6_SumSquareDiff.getDiff(100));
    }
}
