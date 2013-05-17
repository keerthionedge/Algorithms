package com.kee.example;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: keerthi
 * Date: 5/16/13
 * Time: 2:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class PentagonalNumbers {
    public static void main(String[] args) {
        LOGGER.setLevel(Level.ALL);
        PropertyConfigurator.configure("log4j.properties");
        printArray(getPentagonalList(200));
        int[] ints = getPentagonalList(4000);
        int ix = getBounds(ints);
        LOGGER.warn(ix);
    }

    public static int[] getPentagonalList(int inLimit) {
        if (inLimit <= 0)
            return emptyArray;
        int[] pentagonalNumbers = new int[inLimit + 1];
        int counter = 1;
        while (counter <= inLimit) {
            pentagonalNumbers[counter] = (counter * (3 * counter - 1)) / 2;
            ++counter;
        }
        return pentagonalNumbers;
    }

    public static int getBounds(int[] inNumbers) {
        LOGGER.setLevel(Level.DEBUG);
        int inLimit = inNumbers.length;
        List<Integer> integerList = new ArrayList<Integer>(inNumbers.length);
        for (int i : inNumbers) {
            integerList.add(i);
        }


        // logic
        /**
         * consider the following numbers
         * 1, 5, 12, 22, 35, 51, 70, 92, 117, 145
         * start at position 1
         * 1+5      <12 (true), so skip 1, no use of computing
         * 5+12     <22 (true), so skip 5, no use of computing
         * 12+22    <35 (true), so skip 12, no use of computing
         * 22+35    <51 (false), so compute  till the condition become false (increase the right one)
         *                       22+51<70 (false)
         *                       22+70<92 (true), bound and stop here
         *                       check 22+70 == 92
         *                       & check 70 -22 is an element of the array
         *                       (if both satisfies, return) else
         *                       increment the left bound & right bound as leftbound+1 & iterate
         *
         */
        for(int startPos=1;startPos<(inLimit-2);){
            for(int endPos = (startPos+1); endPos <(inLimit-1);){
                if(integerList.contains(inNumbers[startPos]+inNumbers[endPos])){
                    if(integerList.contains((inNumbers[endPos] - inNumbers[startPos]))){
                        LOGGER.warn("Second Condition:  "+"P"+startPos+"  + P"+endPos+"  is available");
                        return inNumbers[endPos] - inNumbers[startPos];
                    }
                }
                ++endPos;
            }
            ++startPos;

        }
        /*while(isStartPositionValid){
            LOGGER.debug("Check for "+inNumbers[startPos] +"+"+ inNumbers[endPos]+" <"+ inNumbers[endPos + 1]);
            if((startPos<inLimit)&&((endPos+1)<inLimit)&&
                    ((inNumbers[startPos] + inNumbers[endPos]) < inNumbers[endPos + 1])){
                LOGGER.debug("(True)");
                if(isIncrementValid(startPos,inLimit)){
                    //do nothing, let the check continues on next run,
                    // incrementing the pos for next run is out of the loop
                } else
                {
                    return 0;
                }
            } else{
                boolean loopingCondition = true;
                // do nothing about incrementing startPos, only increment endPos
                while(loopingCondition){
                    if(isIncrementValid(endPos,inLimit)){
                        endPos = endPos+1;
                        loopingCondition = (startPos<inLimit)&&((endPos+1)<inLimit)&&
                                ((inNumbers[startPos] + inNumbers[endPos]) >= inNumbers[endPos + 1]);
                        if(loopingCondition){
                            //perform 2 checks
                            if ((inNumbers[startPos] + inNumbers[endPos]) == inNumbers[endPos + 1]) {
                                LOGGER.warn("Condition  1   :   " + inNumbers[startPos] + "+" + inNumbers[endPos] + "==" + inNumbers[endPos + 1]);
                                if(integerList.contains((inNumbers[endPos] - inNumbers[startPos]))){
                                    return (inNumbers[endPos] - inNumbers[startPos]);
                                }
                            }
                        }
                    }else{
                        loopingCondition = false;
                    }
                }

            }

            startPos = safeIncreasePos(startPos, inLimit);
            endPos = startPos+1;
            isStartPositionValid = isIncrementValid(startPos,inLimit);
        }*/
        /*while (startPos != inNumbers.length) {
//             LOGGER.debug(inNumbers[startPos]+"+"+inNumbers[endPos]+"<"+inNumbers[endPos+1]);
            if ((startPos < inLimit) && ((endPos + 1) < inLimit) && ((inNumbers[startPos] + inNumbers[endPos]) < inNumbers[endPos + 1])) {
                if (startPos == inLimit)
                    return 0;
                ++startPos;
                endPos = startPos + 1;
//                 LOGGER.debug("(true), so skip, now start at "+inNumbers[startPos]);
            } else {
//                 LOGGER.debug("(false), so other checks follow");
//                 LOGGER.debug(inNumbers[startPos]+"+"+inNumbers[endPos]+"<" +inNumbers[endPos+1]);
                if(endPos<startPos)
                endPos = startPos+1;
                while (((endPos + 1) < inLimit) && (inNumbers[startPos] + inNumbers[endPos]) > inNumbers[endPos + 1]) {
//                    LOGGER.debug("(false), so add "+inNumbers[startPos]+"+"+inNumbers[endPos+1]+"as next check");
                    if (endPos == inLimit)
                        break;
                    ++endPos;
                }
//                 LOGGER.debug("Check if"+inNumbers[startPos]+" + "+inNumbers[endPos]+"=="+inNumbers[endPos+1]);
                if ((endPos + 1) < inLimit) {
                    if ((inNumbers[startPos] + inNumbers[endPos]) == inNumbers[endPos + 1]) {
//                     LOGGER.debug("(true) & check if if the array contains"+(inNumbers[endPos]-inNumbers[startPos]));
                        LOGGER.warn("One Condition is True" + (inNumbers[startPos] + "+" + inNumbers[endPos]) + "==" + inNumbers[endPos + 1]);
                        if (integerList.contains((inNumbers[endPos] - inNumbers[startPos]))) {
//                         LOGGER.debug("(true) then return the value as "+(inNumbers[endPos]-inNumbers[startPos]));
                            return (inNumbers[endPos] - inNumbers[startPos]);
                        }
                    }
                }
                if (startPos == inLimit)
                    return 0;
                ++startPos;
                endPos = startPos + 1;
//                 LOGGER.debug("Now start at "+inNumbers[startPos]);
            }

        }*/
        return 0;

    }

    private static int safeIncreasePos(int startPos, int inLimit) {
        int returnPos =startPos;
        if(inLimit>startPos)
            returnPos=startPos+1;
        else if (inLimit==startPos)
            returnPos = startPos+1;//change it
        return returnPos;
    }

    private static boolean isIncrementValid(int startPos, int inLimit) {
       if(startPos+1 <inLimit)
           return true;
        return false;
    }

    private static int safeIncrease(int start, int limit) {
        if ((start + 1) <= limit)
            return ++start;
        else
            return start;
    }

    public static void printArray(int[] inArray) {
        if (inArray.length > 0) {
            StringBuilder returnString = new StringBuilder(50);
            for (int i : inArray) {
                returnString.append(i + ",");
            }
            LOGGER.warn(returnString.toString());
        }
    }

    private static int[] emptyArray = {0};
    public static final Logger LOGGER = Logger.getLogger(PentagonalNumbers.class);


}
