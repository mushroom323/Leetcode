package Java;

class Solution {
    public int mySqrt(int x) {
        int l = 0, r = x / 2 + 1, mid = (l + r) / 2;
        while (l <= r) {
            mid = (l + r) / 2;
            if (((long)mid * mid) <= x && ((long)(mid + 1) * (mid + 1)) > x) {
                return mid;
            } else if (((long)mid * mid) > x) {
                r = mid - 1;
            } else l = mid + 1;
        }
        return mid;
    }
}