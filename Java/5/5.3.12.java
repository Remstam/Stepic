public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
    Reader r = new InputStreamReader(inputStream, charset);
    int b;
    StringBuilder sb = new StringBuilder();
    
    while ((b = r.read()) != - 1) {
        sb.append((char)b);
    }
        
    return sb.toString();   
}
