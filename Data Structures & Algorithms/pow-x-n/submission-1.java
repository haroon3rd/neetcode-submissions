class Solution {
    public double myPow(double x, int n) {

        if (n < 0)
            return 1 / (x * myPow(x, -(n + 1)));

        if (n == 0)
            return 1.0;

        if (n == 1)
            return x;

        if (n % 2 == 0) {
            double r = myPow(x, n / 2);
            return r * r;
        } else {
            double r = myPow(x, n / 2);
            return x * r * r;
        }
    }
}