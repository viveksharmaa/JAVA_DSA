class Solution {
    public int maxSubArray(int[] nums) {
        int crrsum=0;
       int maxsum = Integer.MIN_VALUE;
       for(int i=0; i<nums.length;i++){
        crrsum+=nums[i];
        if(crrsum>maxsum){
            maxsum=crrsum ;

        }
        if (crrsum<0){
            crrsum=0;
        }
    }
    return maxsum;
    }
 
}