class Solution {
    public double myPow(double x, int n) {

        long pow = n;

        if (pow < 0) {
            x = 1 / x;
            pow = -pow;
        }

        return solved(x, pow);
    }

    public double solved(double x, long n) {

        if (n == 0)
            return 1;

        double half = solved(x, n / 2);

        if (n % 2 == 0)
            return half * half;

        return x * half * half;
    }
}