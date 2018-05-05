class Pair<T, V> {
    private T t;
    private V v;
    
    private Pair() {
        t = null;
        v = null;
    }
    
    private Pair(T t, V v) {
        this.t = t;
        this.v = v;
    }
    
    public static<T, V> Pair<T, V> of(T t, V v) {
        return new Pair<T, V>(t, v);
    }
    
    public T getFirst() {
        return t;
    }
    
    public V getSecond() {
        return v;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        
        if (obj == null)
            return false;
        
        Pair<T, V> pair = (Pair<T, V>)obj;
        T pairT = pair.getFirst();
        V pairV = pair.getSecond();
        
        if (t != null) {
            if (!t.equals(pairT))
                return false;
        } else if (pairT != null)
            return false;
        
        if (v != null) {
            if (!v.equals(pairV))
                return false;
        } else if (pairV != null)
            return false;
        
        return true;
    }
    
    @Override
    public int hashCode() {
        return t.hashCode() * v.hashCode();
    }
}
