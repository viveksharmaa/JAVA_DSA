class Solution {
    public int findNumberOfLIS(int[] nums) {

        int n = nums.length;

        int[] T = new int[n];
        int[] count = new int[n];

        for (int i = 0; i < n; i++) {
            T[i] = 1;
            count[i] = 1;
        }

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < i; j++) {

                if (nums[i] > nums[j]) {

                    if (T[j] + 1 > T[i]) {
                        T[i] = T[j] + 1;
                        count[i] = count[j];
                    }

                    else if (T[j] + 1 == T[i]) {
                        count[i] += count[j];
                    }
                }
            }
        }

        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            maxLength = Math.max(maxLength, T[i]);
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (T[i] == maxLength) {
                answer += count[i];
            }
        }

        return answer;
    }
}