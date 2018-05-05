public class AsciiCharSequence implements CharSequence {
    private byte[] data;
    
    public AsciiCharSequence(byte[] data) {
        this.data = data;
    }
    
    @Override
    public char charAt(int index) {
        return (char)data[index];
    }
    
    @Override
    public int length() {
        return data.length;
    }
    
    @Override
    public CharSequence subSequence(int start, int end) {
        int len = end - start;
        byte[] res = new byte[len];
        
        for (int i = 0, j = start; i < len; ++i, ++j) {
            res[i] = data[j];
        }
        
        return new AsciiCharSequence(res);
    }
    
    @Override
    public String toString() {
        return new String(data);
    }
}
