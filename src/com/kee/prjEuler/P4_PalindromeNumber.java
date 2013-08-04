package com.kee.prjEuler;

/**
 * This Class P4_PalindromeNumber todo ramacke
 *
 * @author <a href="mailto:keerthi.ramachandran@outlook.com">Keerthi Ramachandran</a>
 * @since 2.6. / 04-08-2013
 */
public class P4_PalindromeNumber {
    public static boolean isNoPalindrome(int inNumber) {
        char[] numberAsArray = (String.valueOf(inNumber)).toCharArray();
        int startPos = numberAsArray.length - 1;
        for (char number : numberAsArray) {
            if (!(number == numberAsArray[startPos])) {
                return false;
            }
            --startPos;
        }
        return true;
    }

    public static int getPalindromeNo(int inMaxLimit) {
        int maxProd = 0;
        for (int i = inMaxLimit; i >= 1; ) {
            for (int j = inMaxLimit; j >= 1; ) {
                if (i != j) {
                    if (isNoPalindrome((i * j))) {
                        if ((i * j) > maxProd) {
                            maxProd = (i * j);
                        }
                    }

                }
                --j;
            }
            --i;
        }
        return maxProd;
    }
}
