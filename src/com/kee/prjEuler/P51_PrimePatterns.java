package com.kee.prjEuler;

/**
 * Created with IntelliJ IDEA.
 * User: ramacke
 * Date: 28/5/13
 * Time: 9:12 PM
 * To change this template use File | Settings | File Templates.
 */

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * By replacing the 1st digit of the 2-digit number *3, it turns out that six of the nine possible values:
 * 13, 23, 43, 53, 73, and 83, are all prime.
 * <p/>
 * By replacing the 3rd and 4th digits of 56**3 with the same digit, this 5-digit number is the first example having
 * seven primes among the ten generated numbers, yielding the family: 56003, 56113, 56333, 56443, 56663, 56773,
 * and 56993. Consequently 56003, being the first member of this family, is the smallest prime with this property.
 * <p/>
 * Find the smallest prime which, by replacing part of the number (not necessarily adjacent digits)
 * with the same digit, is part of an eight prime value family.
 */
public class P51_PrimePatterns {
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
        } while (i < inLimit);
        return primesList;
    }

    /**
     * 1. generate all 7 digit primes (i.e, primes upto   9 999 999  (using it)
     * 2. generate all 8 digit primes (i.e, primes upto 100 000 000
     * 3. get all primes between 10 000 000 & 100 000 000 (5096876 nos)
     * 4.
     */
    public static List<Integer> getPrimesOfNDigitFamily(int inNDigit) {
        int lowerLimit = 0;
        int upperLimit = 0;
        if (inNDigit <= 0) {
            return Collections.EMPTY_LIST;
        } else {
            lowerLimit = padNines(inNDigit);
            upperLimit = padZeros(inNDigit);
        }
        LOGGER.info("LowerLimit\t" + lowerLimit + "\t UpperLimit\t" + upperLimit);
        List<Integer> lowerLimitedPrime = getPrimes(lowerLimit);
        LOGGER.info("Number Of Primes upto\t" + lowerLimit + "\tis\t" + lowerLimitedPrime.size());
        List<Integer> upperLimitedPrime = getPrimes(upperLimit);
        LOGGER.info("Number Of Primes upto\t" + upperLimit + "\tis\t" + upperLimitedPrime.size());
        List<Integer> returnablePrime = new ArrayList<Integer>(upperLimitedPrime.size() - lowerLimitedPrime.size());
        for (int i = lowerLimitedPrime.size(); i < upperLimitedPrime.size(); i++) {
            returnablePrime.add(upperLimitedPrime.get(i));
        }
        LOGGER.info("Number Of Primes between\t" + lowerLimit + "\tand\t" + upperLimit + "\tis\t" + returnablePrime.size());
        return returnablePrime;

    }

    public static int padZeros(int inNDigit) {
        String paddedString = "10";
        for (int i = 0; i < inNDigit; i++) {
            paddedString = paddedString + "0";
        }
        return Integer.parseInt(paddedString);
    }

    public static int padNines(int inNDigit) {
        String paddedString = "";
        for (int i = 0; i < inNDigit; i++) {
            paddedString = paddedString + "9";
        }
        return Integer.parseInt(paddedString);
    }


    public static void main(String[] args) {
        LOGGER.setLevel(Level.INFO);
        PropertyConfigurator.configure("log4j.properties");
        List<Integer> possibleNos = getTheNumber(getPrimesOfNDigitFamily(7));
    }

    public static List<Integer> getTheNumber(List<Integer> inPrimes) {
        List<Integer> primes = inPrimes;
        List<Integer> possiblePrimes = new ArrayList<Integer>();
        int lowestPossiblePrime = 0;
        int breadth = inPrimes.size();
        for (int i = 0; i < breadth; ) {
            int temp = primes.get(i);
            List<Integer> comparatorDigits = getPossibleIntsWithOneReplacements(temp);
            int counter = 0;
            for (Integer integer : comparatorDigits) {
                if (temp != integer && primes.remove(integer)) {  // to avoid concurrent modificationexception
                    LOGGER.info("");
                    ++counter;
                    LOGGER.info(counter + "\t prime is in the list with flag" + inPrimes.contains(integer) + "\t" + integer);
                    if (counter == 7) {
                        LOGGER.info("8 Matches found for \t" + temp);
                        possiblePrimes.add(temp);
                    }
                }
            }
            ++i;
        }

        return possiblePrimes;
    }

    public static List<Integer> getPossibleIntsWithOneReplacements(Integer inPrimes) {
        List<Integer> returnArray = new ArrayList<Integer>();
        String nubmer = String.valueOf(inPrimes);
        int numberOfDigits = nubmer.length() - 1;
        for (int i = numberOfDigits; i > 0; i--) {
            for (int j = 1; j < 10; ) {
                if (i == numberOfDigits) {
                    String temp = nubmer.substring(0, i) + String.valueOf(j);
                    returnArray.add(Integer.parseInt(temp));
                } else {
                    String temp = nubmer.substring(0, i) + String.valueOf(j) + nubmer.substring(i + 1);
                    returnArray.add(Integer.parseInt(temp));

                }
                ++j;
            }
        }
        return returnArray;
    }


    public static final Logger LOGGER = Logger.getLogger(P51_PrimePatterns.class);
}
