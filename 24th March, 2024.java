/*Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.*/

class Solution {
    public int findDuplicate(int[] nums) {
        int ans=0;
        int arr[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[nums[i]]++;
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]>1){
                ans= i;
                break;
            }
        }
        return ans;
    }
}
