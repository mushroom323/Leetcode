package Java;

class Solution {
    public int findLUSlength(String a, String b) {
        if (a.compareTo(b) == 0) return -1;
        else return a.length() > b.length() ? a.length() : b.length();
    }
}