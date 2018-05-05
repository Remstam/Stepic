public static double integrate(DoubleUnaryOperator f, double a, double b) {
    final double EPS = 10E-7;
    double aa = a;
    double res = 0;
    
    while (b - aa > EPS)
    {
        res += f.applyAsDouble(aa) * EPS;
        aa += EPS;
    }
    
    return res;
}
