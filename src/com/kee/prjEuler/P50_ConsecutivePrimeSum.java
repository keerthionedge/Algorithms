package com.kee.prjEuler;

/**
 * Created with IntelliJ IDEA.
 * User: ramacke
 * Date: 27/5/13
 * Time: 7:17 PM
 * To change this template use File | Settings | File Templates.
 */
/**
 *
 The prime 41, can be written as the sum of six consecutive primes:
 41 = 2 + 3 + 5 + 7 + 11 + 13

 This is the longest sum of consecutive primes that adds to a prime below one-hundred.

 The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.

 Which prime, below one-million, can be written as the sum of the most consecutive primes?

 */

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.*;

/**
 * Iterate In Reverse
 * <p/>
 * 1. start at one Million 1000000
 * 2. Reduce the counter  by 1 & verify if the number prime
 * <p/>
 * sqrt(1 000 000) = 1000 , compute only first 1000 primes computing among them would be
 */

public class P50_ConsecutivePrimeSum {
    public static List<Integer> getPrimes(int inLimit) {
        List<Integer> primesList = new ArrayList<Integer>(1000);
        primesList.add(2);
        primesList.add(3);
        primesList.add(5);
        primesList.add(7);
        int i = 7;
        do {
            ++i;
            if (isPrimes(i, primesList)) {
                primesList.add(i);
            }
        } while (primesList.size() < inLimit);
        return primesList;
    }

    public static List<Integer> getCumulativeSums(List<Integer> inPrimesList) {
        List<Integer> cumulativeSum = new ArrayList<Integer>(1000);
        int localVar = 0;
        for (Integer integer : inPrimesList) {
            localVar += integer;
            cumulativeSum.add(localVar);
        }
        LOGGER.info("Sum of Primes computation ended @\t" + Calendar.getInstance().getTime());
        return cumulativeSum;
    }

    /**
     * The algorithm is as below
     * the primes are 2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101,103,107,109
     * consider the following
     * - start summing the number from 2 (i)- infinity(limit) & check if the number is a prime & <1000000
     * - if true, compute the number and number of primitives sum it takes
     * - change the starting point from 2, to 3 (i+1) , repeat the process, till we get required solution
     */
    public static Map<String, Integer> getPrimeWithoutSum(List<Integer> inPrimes) {
        Map<String, Integer> resultant = new HashMap<String, Integer>(2);
        int maximumPrime = 0;
        int maximumLength = 0;
        for (int i = 0; i < inPrimes.size(); i++) {
            int startingSum = inPrimes.get(i);
            for (int j = i + 1; j < inPrimes.size() && startingSum < 1000000; j++) {
                startingSum += inPrimes.get(j);
                if (inPrimes.contains(startingSum)) {
                    int length = (j - i + 1);
                    if (length >= maximumLength && startingSum <= 1000000) {
                        System.out.println("\t" + startingSum + "\t with length \t" + length);
                        System.out.println("The Prime Numbers between the range makes maximum sum is\t" + inPrimes.get(i) + "\t" + inPrimes.get(j));
                        maximumLength = length;
                        maximumPrime = startingSum;
                    }
                }
            }
        }
        resultant.put("maximumPrime", maximumPrime);
        resultant.put("maximumLength", maximumLength);
        return resultant;
    }

    public static void getPrimeSum(List<Integer> inPrimes,
                                   List<Integer> inCumulativeSum,
                                   int inLimit) {

        int numberOfPrimes = 0;
        int primeNumber = 0;
        for (int i = numberOfPrimes; i < inCumulativeSum.size(); i++) {
            for (int j = i - (numberOfPrimes + 1); j >= 0; j--) {
                if (inCumulativeSum.get(i) - inCumulativeSum.get(j) > inLimit) {
                    LOGGER.debug("Cumulative sum of items at " + i + "\t-\t" + j + "\tis\t" + (inCumulativeSum.get(i) - inCumulativeSum.get(j)));
                    break;
                }

                if (inPrimes.contains(inCumulativeSum.get(i) - inCumulativeSum.get(j))) {
                    numberOfPrimes = i - j;
                    primeNumber = inCumulativeSum.get(i) - inCumulativeSum.get(j);
                    LOGGER.info("Now numberOfPrimes is\t" + numberOfPrimes + "\t and no is \t" + primeNumber);
                }
            }
        }
        LOGGER.debug("Prime Number is \t" + primeNumber + "\tLength is\t" + numberOfPrimes);

        /*for (int i = 0; i < inPrimes.size(); i++) {
            for (int j = cumlativeSum.size() - 1; j > i; j--) {
                LOGGER.debug("Comparing    " + cumlativeSum.get(j) + "-" + cumlativeSum.get(i) + ">" + inLimit);
                if (cumlativeSum.get(j) - cumlativeSum.get(i) < inLimit) {
                    if (primes.contains(cumlativeSum.get(j) - cumlativeSum.get(i))) {
                        LOGGER.debug("Prime is available with maxLength of \t" + (j - i));
                        if ((j - i) > maxLength) {
                            LOGGER.info("the difference between numbers is \t"+(j-i)+"\t no is "+(cumlativeSum.get(j) - cumlativeSum.get(i)));
                            maxLength = j - i;
                            primeNumber = cumlativeSum.get(j) - cumlativeSum.get(i);
                        }
                    }
                }
            }
        }
        LOGGER.info("The Prime Number is \t"+primeNumber+"\tLength is \t"+maxLength);*/

    }

    private static boolean isPrimes(int number, List<Integer> primes) {
        int sqrt = (int) Math.sqrt(number);
        int i = 0;

        while (primes.get(i) <= sqrt) {
            if (number % primes.get(i) == 0) {
                return false;
            }

            i++;
        }

        return true;
    }

    public static int computeSolution(int inLimit, List<Integer> inPrimes) {
        int localCounter = inLimit + 1;
        int returnValue = 0;
        boolean solutionComputed = false;
        do {
            --localCounter;
            if (isPrimes(localCounter, inPrimes)) {
                if (isFactorsOfPrime(localCounter, inPrimes)) {
                    LOGGER.info("The Possible Primes are \t" + localCounter);
                    //return localCounter;
                }
            }

        } while (localCounter > 800000);
        return returnValue;
    }

    private static boolean isFactorsOfPrime(int inPrimeNo, List<Integer> inPrimes) {
        boolean returnValue = false;
        int localVar = inPrimeNo;
        int i = 0;
        while (localVar > inPrimes.get(i)) {
            localVar -= inPrimes.get(i);
            ++i;
        }
        if (inPrimes.contains(localVar)) {
            return true;
        }
        return returnValue;
    }

    public static List<Integer> getListOfPrimesAsSumOfPrimes(int inLimit, List<Integer> inPrimes) {
        int localCounter = inLimit + 1;
        List<Integer> integers = new ArrayList<Integer>(100);
        boolean solutionComputed = false;
        do {
            --localCounter;
            if (isPrimes(localCounter, inPrimes)) {
                if (isFactorsOfPrime(localCounter, inPrimes)) {
                    integers.add(localCounter);
                    LOGGER.info(integers.size() + "\tElement is\t" + localCounter);
                }
            }
            if (localCounter == 2)
                solutionComputed = true;
        } while (!solutionComputed);
        return integers;
    }

    public static void main(String[] args) {
        LOGGER.setLevel(Level.INFO);
        PropertyConfigurator.configure("log4j.properties");
        //computeSolution(1000000,P50_ConsecutivePrimeSum.getPrimes(1000));
        LOGGER.info("Computation Started @\t" + Calendar.getInstance().getTime());
        Date timeAtStart = Calendar.getInstance().getTime();
        List<Integer> primes = getPrimes(1000000);
        LOGGER.info("Primes computation ended @\t" + Calendar.getInstance().getTime());
        getPrimeWithoutSum(primes);
        LOGGER.info("computation ended @\t" + Calendar.getInstance().getTime());
        // getPrimeSum(primes, getCumulativeSums(primes), 1000000);
    }

    public static final Logger LOGGER = Logger.getLogger(P50_ConsecutivePrimeSum.class);
}
