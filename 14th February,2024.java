/*You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.

You should rearrange the elements of nums such that the modified array follows the given conditions:

Every consecutive pair of integers have opposite signs.
For all integers with the same sign, the order in which they were present in nums is preserved.
The rearranged array begins with a positive integer.
Return the modified array after rearranging the elements to satisfy the aforementioned conditions.*/

class Solution {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> v1=new ArrayList<>();
        List<Integer> v2=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();

        for(int num : nums){
            if(num>0){
                v1.add(num);
            }else{
                v2.add(num);
            }
        }
        int ind1=0,ind2=0;

        while(ind2<nums.length/2){
            ans.add(v1.get(ind1));
            ind1++;
            ans.add(v2.get(ind2));
            ind2++;
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}

//Approach-2

class Solution {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> pos = new ArrayList();
        List<Integer> neg = new ArrayList();
        
        for(int x: nums) {
            if(x >= 0) pos.add(x);
            else neg.add(x);
        }

        for(int i=0;i<nums.length;i++) {
            if(i%2 == 0) {
                nums[i] = pos.get(i/2);
            } else {
                nums[i] = neg.get(i/2);
            }
        }

        return nums;
    }
}
