public final class ComplexNumber {
    private final double EPS = 10E-8;
    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }
    
    @Override
    public boolean equals(Object object)
    {
        if (this == object)
            return true;
        
        if (object == null)
            return false;
        
        if ((object instanceof ComplexNumber) == false)
            return false;
        
        ComplexNumber cn = (ComplexNumber)object;
        return Math.abs(this.getRe() - cn.getRe()) < EPS && Math.abs(this.getIm() - cn.getIm()) < EPS;
    }
    
    @Override
    public int hashCode()
    {
        long rePre = Double.doubleToLongBits(this.getRe());
        long imPre = Double.doubleToLongBits(this.getIm());
        
        int reHash = (int)(rePre^(rePre>>>32));
        int imHash = (int)(imPre^(imPre>>>32));
        
        return reHash + imHash;
    }
}
