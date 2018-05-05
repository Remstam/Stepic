/**
 * Calculates factorial of given <code>value</code>.
 *
 * @param value positive number
 * @return factorial of <code>value</code>
 */
public static BigInteger factorial(int value) {
    if (value == 0) return BigInteger.valueOf(1);
    return BigInteger.valueOf(value).multiply(factorial(value - 1)); // your implementation here
}
