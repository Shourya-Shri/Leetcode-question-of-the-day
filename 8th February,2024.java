/*Given an integer n, return the least number of perfect square numbers that sum to n.

A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.*/

class Solution {
    public int numSquares(int n) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i<=n;++i){
            int min_val=Integer.MAX_VALUE;
            for(int j=1;j*j<=i;j++){
                min_val=Math.min(min_val,dp[i-j*j]+1);
            }
            dp[i]=min_val;
        }
        return dp[n];
    }
}
