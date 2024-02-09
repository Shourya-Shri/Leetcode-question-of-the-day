/*Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:

answer[i] % answer[j] == 0, or
answer[j] % answer[i] == 0
If there are multiple solutions, return any of them.*/

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {

        Arrays.sort(nums);
        int n=nums.length;

        int groupSize[] = new int[n];
        int prevElement[]=new int[n];

        int maxIndex=0;

        for(int i=0;i<n;i++){
            groupSize[i]=1;
            prevElement[i]=-1;

            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0){
                    if(groupSize[i]<1+groupSize[j]){
                        groupSize[i]=1+groupSize[j];
                        prevElement[i]=j;
                    }
                }
            }
            if(groupSize[i]>groupSize[maxIndex]){
                maxIndex=i;
            }
        }
        List<Integer> result=new ArrayList<>();
        while(maxIndex!=-1){
            result.add(0,nums[maxIndex]);
            maxIndex=prevElement[maxIndex];
        }
        return result;
    }
}
