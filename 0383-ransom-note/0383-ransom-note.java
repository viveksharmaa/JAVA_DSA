class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        int[] freq = new int[26];

        // magazine ke char count karo
        for (char ch : magazine.toCharArray()) {
            freq[ch - 'a']++;
        }

        // ransomNote ke char use karo
        for (char ch : ransomNote.toCharArray()) {

            freq[ch - 'a']--;

            if (freq[ch - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}