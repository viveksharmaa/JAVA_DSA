class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int p1 = intervals[0][1] - 1;
        int p2 = intervals[0][1];
        int cnt = 2;
        for(int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end   = intervals[i][1];
            if(p2 < start) {
                p1 = end - 1;
                p2 = end;
                cnt += 2;
            }
            else if(p1<start) {
                if(end == p2) {
                    p1 = end - 1;
                }else {
                    p1 = end;
                }
                if(p1>p2) {
                    int t = p1;
                    p1 = p2;
                    p2 = t;
                }
                cnt+=1;
            }
        }
        return cnt;
    }
}