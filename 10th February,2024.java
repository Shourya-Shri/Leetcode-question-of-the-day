/*Given a string s, return the number of palindromic substrings in it.

A string is a palindrome when it reads the same backward as forward.

A substring is a contiguous sequence of characters within the string.*/

class Solution {
    int count=0;
    public int countSubstrings(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        for(int i=0;i<s.length();i++){  // i is the mid point
            extendPalindrome(s, i, i); // odd length;
            extendPalindrome(s, i, i + 1); // even length
        }
        return count;
    }
    private void extendPalindrome(String s, int left, int right){
        while(left>=0 && right <s.length() && s.charAt(left)==s.charAt(right)){
            count++; left--; right++;
        }
    }
}
