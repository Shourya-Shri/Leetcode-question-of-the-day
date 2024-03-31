/*
You are given a binary string s that contains at least one '1'.

You have to rearrange the bits in such a way that the resulting binary number is the maximum odd binary number that can be created from this combination.

Return a string representing the maximum odd binary number that can be created from the given combination.

Note that the resulting string can have leading zeros.
*/

class Solution {
    public String maximumOddBinaryNumber(String s) {
        int cnt1 = 0, cnt0 = 0;
        for (char a : s.toCharArray()) {
            if (a == '1') cnt1++;
            else if (a == '0') cnt0++;
        }
        StringBuilder ans = new StringBuilder();
        ans.append("1".repeat(cnt1 - 1));
        ans.append("0".repeat(cnt0));
        ans.append("1");
        return ans.toString();
    }
}
