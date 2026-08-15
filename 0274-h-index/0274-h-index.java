class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int c = citations.length-1;
        int h=0;
        while (c >= 0 && citations[c] >= h + 1) {
            h++;
            c--;
        }
        return h;
    }
}