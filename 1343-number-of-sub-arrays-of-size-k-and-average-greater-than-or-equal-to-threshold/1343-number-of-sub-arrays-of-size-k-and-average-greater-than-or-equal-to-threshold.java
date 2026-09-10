class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;
        int count = 0;

        for(int i=0; i<k; i++){
            sum += arr[i];
        }

        int required_sum = k*threshold;

        if(sum >= required_sum){
            count++;
        }
        for(int i=k; i<arr.length; i++){
            sum = sum + arr[i];
            sum = sum - arr[i - k];

                if(sum >= required_sum){
                count++;
            }
        }
        return count;
    }
}