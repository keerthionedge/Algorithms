package com.kee.prjEuler;/**
 * Created with IntelliJ IDEA.
 * User: ramacke
 * Date: 2/8/13
 * Time: 11:45 PM
 * To change this template use File | Settings | File Templates.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * This Class P3_LargestPrimeFactor todo ramacke
 *
 * @author <a href="mailto:keerthi.ramachandran@navis.com">Keerthi Ramachandran</a>
 * @since 2.6. / 02-08-2013
 */
public class P3_LargestPrimeFactor {
    /**
     * The prime factors of 13195 are 5, 7, 13 and 29.
     * What is the largest prime factor of the number 600851475143
     * Logic 13195 is squared of ~114.87, so the largest possible factor is below 115
     * start traversing backward from prime <=115, and get the first possible divisor, which is our answer
     * 1,2,3,5,7,11,13,17,19,23,27,29,31,37,41,43.....
     * if 5,7 is a factor then the largest possible prime factor
     *
     * @param inPrimeNumber
     * @return
     */
    public static int getLargestPrime(double inPrimeNumber) {
        int upperLimit = (int) Math.sqrt(inPrimeNumber);
        List<Integer> primes = getPrimes(upperLimit);
        while (true) {
            if (primes.contains(upperLimit)) {
                if (inPrimeNumber % upperLimit == 0) {
                    return upperLimit;
                }
            }
            --upperLimit;
        }
    }

    public static List<Integer> getPrimes(int inLimit) {
        List<Integer> integers = new ArrayList();
        integers.add(2);
        integers.add(3);
        integers.add(5);
        integers.add(7);
        int varSwap = 8;

        while (varSwap <= inLimit) {
            boolean addFlag = true;
            for (int integer : integers) {
                if (varSwap % integer == 0) {
                    addFlag = false;
                    break;
                }

            }
            if (addFlag)
                integers.add(varSwap);
            ++varSwap;
        }
        return integers;

    }

    public static boolean isPrime(long n) {
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        long sqrtN = (long) Math.sqrt(n) + 1;
        for (long i = 6L; i <= sqrtN; i += 6) {
            if (n % (i - 1) == 0 || n % (i + 1) == 0) return false;
        }
        return true;
    }

    /**
     * The Largest PrimeFactor is either sqrt(number) or less than it
     * the (prime) factors of 13195 are 5,7,13,...
     * so start with
     * 13195/5 = 2639 is not prime
     * 13195/(5*7) = 377 is not prime
     * 13195/ (5*7*13)
     * ie., 13195/455 = 29 , the largest possible primeFactor
     */
    public static long largestPrimeFactor(long inNumber) {
        if (isPrime(inNumber))
            return inNumber; //if the number itself is prime, don't bother computing
        int i = 2;
        while (i < inNumber) {
            while (inNumber % i == 0) {
                inNumber /= i;
                if (isPrime(inNumber)) {
                    return inNumber;
                }
            }
            ++i;
        }
        return 1;
    }
}
