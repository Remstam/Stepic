public static IntStream pseudoRandomStream(int seed) {
    return IntStream.iterate(seed, x -> {
        String s = String.valueOf(x * x);
        int len = s.length();
        int end = len < 1 ? 0 : len - 1;
        int start = len < 4 ? 0 : end - 3;
        
        return (end - start == 0) ? 0 : Integer.parseInt(s.substring(start, end));
    });
}
