public static int checkSumOfStream(InputStream inputStream) throws IOException {
    int b;
    int sum = 0;
    
    try {
        while ((b = inputStream.read()) != -1) {
            sum = Integer.rotateLeft(sum, 1) ^ b;
        }
    } catch(IOException e) {
        throw new IOException();
    }
    
    return sum;
}
