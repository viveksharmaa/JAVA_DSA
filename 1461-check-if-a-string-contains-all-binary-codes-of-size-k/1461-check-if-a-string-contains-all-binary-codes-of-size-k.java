class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<=s.length() - k; i++){
            String window = s.substring(i , i + k);
            set.add(window);
        }
        int totalCodes = 1<<k;
        return set.size() ==totalCodes;
    }
}