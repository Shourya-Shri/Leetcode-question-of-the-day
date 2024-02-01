/*You are given an integer array nums of size n and a positive integer k.

Divide the array into one or more arrays of size 3 satisfying the following conditions:

Each element of nums should be in exactly one array.
The difference between any two elements in one array is less than or equal to k.
Return a 2D array containing all the arrays. If it is impossible to satisfy the conditions, return an empty array. And if there are multiple answers, return any of them.

*/

class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        List<int[]> res = new ArrayList<>();
        for (int i = 2; i < nums.length; i += 3) {
            if (nums[i] - nums[i - 2] > k) return new int[][]{};
            res.add(new int[]{nums[i - 2], nums[i - 1], nums[i]});
        }
        return res.toArray(new int[res.size()][]);
    }
}
public class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int[][] result = new int[0][0];
        
        for (int i = 0; i + 2 < nums.length; ++i) {
            if (i % 3 == 0) {
                if (nums[i + 2] - nums[i] <= k) {
                    int[] triplet = {nums[i], nums[i + 1], nums[i + 2]};
                    result = Arrays.copyOf(result, result.length + 1);
                    result[result.length - 1] = triplet;
                } else {
                    return new int[0][0];
                }
            }
        }
        return result;
    }
}
