class Solution {
    public int[] findXSum(int[] nums, int k, int x) {

        int n = nums.length;
        int[] ans = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {

            int[] freq = new int[51];

            for (int j = i; j < i + k; j++) {
                freq[nums[j]]++;
            }

            int sum = 0;

            for (int count = 0; count < x; count++) {

                int best = -1;

                for (int value = 1; value <= 50; value++) {
                    if (freq[value] > 0) {

                        if (best == -1 ||
                            freq[value] > freq[best] ||
                            (freq[value] == freq[best] && value > best)) {

                            best = value;
                        }
                    }
                }

                if (best == -1) {
                    break;
                }

                sum += best * freq[best];
                freq[best] = 0;
            }

            ans[i] = sum;
        }

        return ans;
    }
}
