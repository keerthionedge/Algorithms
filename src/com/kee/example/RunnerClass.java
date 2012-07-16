package com.kee.example;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class RunnerClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LOGGER.setLevel(Level.ALL);
		PropertyConfigurator.configure("log4j.properties");
		printAnArray();
		int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] a1 = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126,127,128,129,130,131,132,133,134,135,136,137,138,139,140,141,142,143,144,145,146,147,148,149,150,151,152,153,154,155,156,157,158,159,160,161,162,163,164,165,166,167,168,169,170,171,172,173,174,175,176,177,178,179,180,181,182,183,184,185,186,187,188,189,190,191,192,193,194,195,196,197,198,199,200,201,202,203,204,205,206,207,208,209,210,211,212,213,214,215,216,217,218,219,220,221,222,223,224,225,226,227,228,229,230,231,232,233,234,235,236,237,238,239,240,241,242,243,244,245,246,247,248,249,250,251,252,253,254,255,256,257,258,259,260,261,262,263,264,265,266,267,268,269,270,271,272,273,274,275,276,277,278,279,280,281,282,283,284,285,286,287,288,289,290,291,292,293,294,295,296,297,298,299,300,301,302,303,304,305,306,307,308,309,310,311,312,313,314,315,316,317,318,319,320,321,322,323,324,325,326,327,328,329,330,331,332,333,334,335,336,337,338,339,340,341,342,343,344,345,346,347,348,349,350,351,352,353,354,355,356,357,358,359,360,361,362,363,364,365,366,367,368,369,370,371,372,373,374,375,376,377,378,379,380,381,382,383,384,385,386,387,388,389,390,391,392,393,394,395,396,397,398,399,400,401,402,403,404,405,406,407,408,409,410,411,412,413,414,415,416,417,418,419,420,421,422,423,424,425,426,427,428,429,430,431,432,433,434,435,436,437,438,439,440,441,442,443,444,445,446,447,448,449,450,451,452,453,454,455,456,457,458,459,460,461,462,463,464,465,466,467,468,469,470,471,472,473,474,475,476,477,478,479,480,481,482,483,484,485,486,487,488,489,490,491,492,493,494,495,496,497,498,499,500};
        int[] a2 = {10,20,26,27,28,44,48,51,65,74,74,90,104,106,112,113,115,117,118,125,137,153,158,169,185,201,213,221,231,243,251,267,270,270,280,290,292,305,317,324,336,352,353,368,377,391,400,402,404,420,424,436,442,458,467,479,480,494,509,525,538,542,553,556,567,572,575,575,575,582,585,593,604,620,635,640,648,662,663,673,687,700,708,718,731,738,750,758,763,778,779,781,797,807,813,815,815,821,823,825,841,852,853,859,872,878,878,893,897,909,922,932,947,950,950,964,966,976,987,994,994,1009,1015,1019,1019,1033,1039,1041,1050,1057,1062,1064,1069,1074,1090,1103,1108,1114,1124,1139,1151,1152,1157,1171,1174,1175,1188,1190,1205,1215,1229,1242,1258,1259,1265,1270,1278,1284,1299,1304,1319,1323,1325,1333,1346,1347,1352,1363,1369,1383,1397,1404,1407,1421,1436,1450,1450,1460,1469,1477,1479,1483,1491,1491,1491,1491,1500,1512,1513,1521,1525,1538,1554,1566,1571,1579,1590,1595,1607,1610,1613,1622,1638,1653,1663,1679,1691,1697,1712,1714,1724,1735,1740,1747,1763,1768,1778,1791,1801,1810,1826,1841,1847,1850,1857,1858,1859,1868,1875,1882,1887,1897,1906,1914,1920,1925,1937,1937,1938,1942,1951,1963,1964,1975,1984,1998,2014,2016,2018,2023,2030,2037,2038,2039,2041,2053,2055,2062,2068,2076,2089,2092,2094,2094,2097,2099,2104,2116,2124,2130,2138,2140,2142,2151,2159,2164,2165,2171,2180,2189,2205,2205,2208,2215,2225,2237,2246,2259,2262,2272,2284,2284,2297,2310,2319,2327,2331,2339,2339,2354,2366,2372,2376,2389,2402,2415,2423,2430,2434,2439,2441,2442,2444,2454,2461,2471,2482,2497,2507,2519,2533,2545,2559,2570,2585,2589,2601,2611,2623,2638,2643,2659,2660,2660,2660,2665,2666,2679,2691,2700,2700,2714,2723,2732,2732,2739,2752,2755,2768,2769,2780,2781,2796,2808,2822,2836,2836,2842,2853,2866,2875,2881,2883,2883,2887,2898,2911,2914,2920,2923,2925,2932,2946,2947,2962,2971,2981,2989,3001,3013,3026,3034,3050,3060,3065,3075,3086,3091,3094,3103,3110,3115,3127,3129,3138,3138,3145,3145,3149,3165,3175,3184,3192,3208,3217,3217,3217,3226,3231,3241,3251,3263,3271,3274,3285,3286,3288,3294,3304,3313,3324,3338,3340,3347,3356,3361,3372,3385,3400,3410,3426,3430,3433,3438,3439,3450,3462,3465,3476,3480,3480,3493,3493,3497,3508,3513,3521,3535,3541,3552,3555,3565,3571,3571,3575,3589,3600,3614,3624,3638,3639,3655,3661,3673,3679,3692,3704,3718,3719,3730,3740,3755,3761,3771,3773,3776,3792,3805,3816,3821,3833,3834,3838,3844,3852,3859,3869,3870,3878,3880,3890,3897,3908,3924,3932,3936,3944,3950,3965,3975,3978,3989,3997,3998,4006,4017,4031,4035,4037,4046,4061,4071,4080,4094,4101,4116,4121,4136,4145,4154,4166,4167,4170,4186,4186,4190,4194,4194,4194,4197,4203,4209,4220,4236,4238,4251,4257,4257,4265,4279,4295,4298,4311,4325,4333,4334,4342,4354,4363,4367,4374,4384,4393,4395,4401,4414,4430,4431,4431,4444,4460,4462,4477,4487,4490,4503,4519,4528,4532,4535,4540,4548,4556,4572,4576,4580,4593,4595,4606,4622,4627,4630,4646,4660,4670,4673,4675,4690,4700,4706,4706,4710,4724,4732,4734,4749,4754,4754,4755,4756,4767,4771,4771,4787,4799,4811,4819,4835,4842,4852,4854,4860,4865,4878,4885,4899,4904,4919,4932,4938,4949,4949,4961,4974,4982,4994,4994,5009};
        LOGGER.info("binarySearch(a,5)  " + binarySearch(a, 5));
        LOGGER.info("binarySearch(a,9)  " + binarySearch(a, 9));
        LOGGER.info("binarySearch(a,2)  " + binarySearch(a, 2));
        LOGGER.info("binarySearch(a,0)  " + binarySearch(a, 0));
        LOGGER.info("interpolationSearch(a1,374)"+interpolationSearch(a1,374));
        LOGGER.info("interpolationSearch(a1,2076)"+interpolationSearch(a1,2076));
        LOGGER.info("interpolationSearch(a2,2076)"+interpolationSearch(a2,2076));
        LOGGER.info("interpolationSearch(a2,3935)"+interpolationSearch(a2,3935));
        printAnArray();
	}
	
	/**
     * Returns index of the search String
     * <p>returns -1 in case if not found</p>
     *
     * @param inSearchArray  int[]
     * @param inSearchVariable var x
     * @return index(int)
     */
    public static int binarySearch(int[] inSearchArray, int inSearchVariable) {
        LOGGER.setLevel(Level.DEBUG);
        LOGGER.debug("Searching for " + inSearchVariable + " in " + getAsString(inSearchArray));
        int startPosition = 0;
        int endPosition = inSearchArray.length;
        LOGGER.debug("The Search (Sorted) array length is " + endPosition);
        while (startPosition < endPosition) {
            int middlePosition = (startPosition + endPosition) / 2;
            LOGGER.debug("Looking for value at position " + middlePosition + " in the array of length " + inSearchArray.length);
            if (inSearchArray[middlePosition] == inSearchVariable) {
                LOGGER.debug("The search Variable is found at position " + middlePosition);
                return middlePosition;
            } else if (inSearchArray[middlePosition] < inSearchVariable) {
                LOGGER.debug("Validate: is Value at Position " + middlePosition + " (" + inSearchArray[middlePosition] + ") is < " + inSearchVariable);
                LOGGER.debug(" its True, so the value has to be in right of the position " + middlePosition +
                        " Started iterating from position " + (middlePosition + 1) + " to " + endPosition);
                startPosition = middlePosition + 1;
            } else {
                LOGGER.debug("Validate: is Value at Position " + middlePosition + " (" + inSearchArray[middlePosition] + ") is < " + inSearchVariable);
                LOGGER.debug("and found it to be false, so the value has to be in left of the position " + middlePosition +
                        "Started iterating from position " + startPosition + " to " + middlePosition);
                endPosition = middlePosition;
            }

        }
        return -1;
    }

    /**
     * Static Method to print the array as comma seperated values
     * @param inSearchArray  an int[]
     * @return  string
     */
    public static String getAsString(int[] inSearchArray) {
        StringBuilder returnString = new StringBuilder(50);
        int formatFlagCnt = inSearchArray.length - 1;
        for (Integer integer : inSearchArray) {
            returnString.append(integer.toString());
            if (formatFlagCnt > 0) {
                returnString.append(" , ");
                --formatFlagCnt;
            }
        }
        return returnString.toString();
    }

    public static int interpolationSearch(int[] inSortedArray, int inVarToFind){
        // Returns index of inVarToFind in inSortedArray, or -1 if not found
        int beginIndex = 0;
        int endIndex = inSortedArray.length - 1;
        int middleIndex;

        while (inSortedArray[beginIndex] <= inVarToFind && inSortedArray[endIndex] >= inVarToFind) {
        	LOGGER.debug("inSortedArray["+beginIndex+"] <= "+inVarToFind+"&&inSortedArray["+endIndex+"] >= "+inVarToFind);
        	LOGGER.debug("Approximating Middle Index as Below");
        	LOGGER.debug("beginIndex + ((inVarToFind - inSortedArray[beginIndex]) * (endIndex - beginIndex)) /(inSortedArray[endIndex] - inSortedArray[beginIndex])");
        	LOGGER.debug(beginIndex+" + (( "+ inVarToFind +"-inSortedArray["+beginIndex+"]) * ("+endIndex +"- "+beginIndex+")) /(inSortedArray["+endIndex+"] - inSortedArray["+beginIndex+"])");
            middleIndex = beginIndex +
                    ((inVarToFind - inSortedArray[beginIndex]) * (endIndex - beginIndex)) /
                            (inSortedArray[endIndex] - inSortedArray[beginIndex]);  //out of range is possible  here
            LOGGER.debug("middleIndex	:"+middleIndex);
            LOGGER.debug("Element at index "+middleIndex+" is "+inSortedArray[middleIndex]);
            if (inSortedArray[middleIndex] < inVarToFind){
            	LOGGER.debug("inSortedArray[middleIndex] < inVarToFind 	: so setting beginIndex as "+middleIndex);
                beginIndex = middleIndex + 1;}
            else if (inSortedArray[middleIndex] > inVarToFind){
                // Repetition of the comparison code is forced by syntax limitations.
                endIndex = middleIndex - 1;
                LOGGER.debug("inSortedArray[middleIndex] > inVarToFind 	: so setting endIndex as "+middleIndex);
            }
            else
                return middleIndex;
        }
        LOGGER.debug("Not satisfied: inSortedArray["+beginIndex+"] <= "+inVarToFind+"&&inSortedArray["+endIndex+"] >= "+inVarToFind);
        if (inSortedArray[beginIndex] == inVarToFind)
            return beginIndex;
        else
            return -1; // Not found
    }
	public static void printAnArray(){
        StringBuilder returnString = new StringBuilder(50);
        for(int i =0 ; i<5000 ; ){
        	i = i+(int)(Math.random()*17);
            returnString.append(i);
            if(i<5000){
                returnString.append(",");
            }
        }
        LOGGER.info(returnString.toString());
    }
	public static final Logger LOGGER = Logger.getLogger(RunnerClass.class);
}
