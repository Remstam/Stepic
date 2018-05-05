/**
 * Checks if given <code>value</code> is a power of two.
 *
 * @param value any number
 * @return <code>true</code> when <code>value</code> is power of two, <code>false</code> otherwise
 */
public static boolean isPowerOfTwo(int value) {
    value = Math.abs(value);
    return value == 0 ? false : (value & (value - 1)) == 0;
}
