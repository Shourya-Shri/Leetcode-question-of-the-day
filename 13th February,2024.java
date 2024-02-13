/*Given an array of strings words, return the first palindromic string in the array. If there is no such string, return an empty string "".

A string is palindromic if it reads the same forward and backward.*/

class Solution {
    public static String firstPalindrome(String[] words) {
        for (String word : words) {
            StringBuilder reversed = new StringBuilder(word).reverse();
            if (word.equals(reversed.toString())) {
                return word;
            }
        }
        return "";
    }
}
