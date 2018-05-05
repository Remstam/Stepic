public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
    Set<T> result = new HashSet<T>();
    result.addAll(set1);
    result.addAll(set2);
    
    Iterator<T> it = result.iterator();
    while(it.hasNext()) {
        T element = it.next();
        if (set1.contains(element) && set2.contains(element)) {
            it.remove();
        }
    }
    
    return result;
}
