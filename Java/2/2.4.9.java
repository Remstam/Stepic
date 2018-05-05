/**
 * Merges two given sorted arrays into one
 *
 * @param a1 first sorted array
 * @param a2 second sorted array
 * @return new array containing all elements from a1 and a2, sorted
 */
public static int[] mergeArrays(int[] a1, int[] a2) {
    int[] result = new int[a1.length + a2.length];
    int i = 0;
    int j = 0;
    
    for (int k = 0; k < result.length; k++)
    {
        if (i == a1.length)
        {
            result[k] = a2[j++];
            continue;
        }
        
        if (j == a2.length)
        {
            result[k] = a1[i++];
            continue;
        }
        
        if (a1[i] < a2[j])
            result[k] = a1[i++];
        else
            result[k] = a2[j++];
    }
    
    return result; // your implementation here
}
