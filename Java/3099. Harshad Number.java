package Java;

class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int sum = 0;
        for (int tmp = x; tmp > 0; tmp /= 10) {
            sum += tmp % 10;
        }
        return x % sum == 0 ? sum : -1;
    }
}