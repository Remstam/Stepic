public static boolean booleanExpression(boolean a, boolean b, boolean c, boolean d) {
    return ((a == b) & (c == d) & ((a & b) ^ (c & d))) |
           ((a == c) & (b == d) & ((a & c) ^ (b & d))) |
           ((a == d) & (b == c) & ((a & d) ^ (b & c)));
}