import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        OutputStream out = new BufferedOutputStream(System.out);
        
        ArrayList<Byte> bytes = new ArrayList<Byte>();
        int b;
        Byte t;
        
        while ((b = in.read()) != -1) {
            bytes.add((byte)b);
        }
        
        for (int i = 0; i < bytes.size(); i++) {
            t = bytes.get(i);
            if (t == 13) {
                if (i != bytes.size() - 1 && bytes.get(i + 1) == 10) {
                    continue;
                } else {
                    out.write(t);
                }
            } else {
                out.write(t);
            }
        }
        
        out.flush();
        out.close();
    }
}
