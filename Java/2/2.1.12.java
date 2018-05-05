public static boolean doubleExpression(double a, double b, double c) {
    double e = 1E-4;
    return Math.abs(a+b-c) < e;
}
