package com.kee.prjEuler;

/**
 * Created with IntelliJ IDEA.
 * User: ramacke
 * Date: 27/5/13
 * Time: 4:25 PM
 * To change this template use File | Settings | File Templates.
 */

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *

 The first two consecutive numbers to have two distinct prime factors are:

 14 = 2 × 7
 15 = 3 × 5

 The first three consecutive numbers to have three distinct prime factors are:

 644 = 2² × 7 × 23
 645 = 3 × 5 × 43
 646 = 2 × 17 × 19.

 Find the first four consecutive integers to have four distinct prime factors. What is the first of these numbers?

 */

/**
 * Steps:
 * Take an Even Number & find How many Factors it possess
 */
public class DistinctPrimeFactors {
    public static void main(String[] args) {
        LOGGER.setLevel(Level.INFO);
        PropertyConfigurator.configure("log4j.properties");
        computeSolution(4,getPrimes(200000));
    }
    private static int getNextEven(int inEvenNumber){ //no check for even here
        return inEvenNumber+2;
    }
    private static int getNextEven(int inEvenNumber, boolean inCheckRequired){
        if(inCheckRequired){
            if(inEvenNumber%2==0){
                return getNextEven(inEvenNumber);
            } else{
                return inEvenNumber+1;
            }
        }
        return getNextEven(inEvenNumber);
    }
    public static Integer[] getPrimes(int inLimit){
        List<Integer> primesList = new ArrayList<Integer>(1);
        boolean addFlag = true;
        primesList.add(2);
        for(int i =3; i<=inLimit;){
            for(Integer integer: primesList){
                if(i%integer == 0){
                    addFlag = false;
                    break;
                }
            }
            if(addFlag){
                primesList.add(i);
            }
             i=i+2;
            addFlag = true;
        }
        return primesList.toArray(new Integer[primesList.size()]);
    }

    public static int computeSolution(int inLength, Integer[] inPrimes) {
        int noOfEvenToSelect = getNoOfEvenToSelect(inLength);
        int result = 0;
        int startingEven = 134043;
        boolean conditionFlag = false;
        boolean useNextOdd = false;
        Set<Integer> primeFactors = getNewPrimeFactors();
        int productFactor = 2;
        int consecutives = 0;
        int previous = 0;

        for (int start = startingEven; start <= 200000; ) {
            LOGGER.debug("Computation Starting at :\t" + start);
            if (!conditionFlag) {
                for (Integer integer : inPrimes) {
                    LOGGER.debug("\t\t\t\t\t Product of Divisible Primes\t" + productFactor);
                    LOGGER.debug("\t\t\t\t\t Divisible Primes           \t" + primeFactors);
                    if (productFactor <= start) {
                        if (start % integer == 0) {
                            LOGGER.debug("\t\t\t\t\t " + start + "%" + integer + " =" + (start % integer == 0));
                            if (!primeFactors.contains(integer)) {
                                primeFactors.add(integer);
                                productFactor = productFactor * integer;
                            }
                            if (primeFactors.size() == inLength) {
                                LOGGER.debug("\t\t\t\t\t"+inLength+"\t Prime factors found for "+start+"\t are"+primeFactors);
                                if (previous + 1 == start){
                                    ++consecutives;
                                    LOGGER.debug("\t\t\t\t\t Number Of consecutives are "+consecutives+"for "+start);
                                    //if(consecutives >=3)
                                        LOGGER.info("\t\t\t\t\t the Factors are"+primeFactors+"for "+start);
                                }
                                else  {
                                    consecutives =1;
                                    LOGGER.debug("\t\t\t\t\t First Item having Factor Found "+consecutives);
                                    LOGGER.info("\t\t\t\t\t the Factors are"+primeFactors+"for "+start);
                                }
                                if (consecutives == inLength) {
                                    return start;
                                }
                                useNextOdd = true;
                                previous = start;
                            }
                            //break;
                        } else {
                            if (primeFactors.contains(integer))
                                primeFactors.remove(integer);
                        }
                    } else {
                        break;
                    }
                }
                if (useNextOdd) {
                    start = start + 1;
                    productFactor = 2;
                    primeFactors = getNewPrimeFactors();
                } else {
                    start = getNextEven(start);
                    productFactor = 2;
                    primeFactors = getNewPrimeFactors();
                }
            }
        }

        return result;
    }

    private static Set<Integer> getNewPrimeFactors() {
        Set<Integer> integers = new HashSet<Integer>(1);
        integers.add(2);
        return integers;
    }

    private static int getNoOfEvenToSelect(int inLength) {
        if(inLength%2==1){
            return (inLength/2)+(inLength%2);
        }else
            return inLength/2;
    }

    public static final Logger LOGGER = Logger.getLogger(DistinctPrimeFactors.class);

}
