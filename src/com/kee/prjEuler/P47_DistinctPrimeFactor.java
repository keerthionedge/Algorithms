package com.kee.prjEuler;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: ramacke
 * Date: 27/5/13
 * Time: 6:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class P47_DistinctPrimeFactor {
    public static void main(String[] args) {
        ArrayList<Integer> primes = new ArrayList<Integer>();

        primes.add(2);
        primes.add(3);
        primes.add(5);
        primes.add(7);

        int i = 7, countFour = 0;

        do {
            i++;
            int distinctPrimeFactors = 0;

            if (isPrimes(i, primes)) {
                primes.add(i);
            } else {
                distinctPrimeFactors = countFactors(i, primes);
            }

            if (distinctPrimeFactors == 4) {
                countFour++;
            } else {
                countFour = 0;
            }
        } while (countFour < 4);
        System.out.println("primes.size() = " + primes.size());
        System.out.println(i - 3);
    }
    private static boolean isPrimes(int number, ArrayList<Integer> primes) {
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
    private static int countFactors(int number, ArrayList<Integer> primes) {
        int i = 0;
        int count = 0;

        while (number > 1) {
            if (number % primes.get(i) == 0) {
                count++;

                while (number % primes.get(i) == 0) {
                    number /= primes.get(i);
                }
            }

            i++;
        }

        return count;
    }
}
