class Solution {
    public int findLongestChain(int[][] arr) {

        Arrays.sort(arr, (a, b) -> a[1] - b[1]);

        int total = 1;
        int end = arr[0][1];

        for (int i = 1; i < arr.length; i++) {

            if (arr[i][0] > end) {
                end = arr[i][1];
                total++;
            }
        }

        return total;
    }
}