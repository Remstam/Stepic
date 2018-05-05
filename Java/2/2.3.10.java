/**
 * Checks if given <code>text</code> is a palindrome.
 *
 * @param text any string
 * @return <code>true</code> when <code>text</code> is a palindrome, <code>false</code> otherwise
 */
public static boolean isPalindrome(String text) {
    String ans = text.replaceAll("[^a-zA-Z0-9]", "");
    ans = ans.toLowerCase();
    
    int len = ans.length();
    for (int i = 0, j = len - 1; i <= j; i++, j--)
    {
        if (ans.charAt(i) != ans.charAt(j))
            return false;
    }
    
    return true; // your implementation here
}
