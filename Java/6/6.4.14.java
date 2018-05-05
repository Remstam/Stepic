public static interface Sendable<T> {
    String getFrom();
    String getTo();
    T getContent();
}

public static class Storage<T> implements Sendable<T> {
    private String from;
    private String to;
    private T content;
    
    public Storage(String from, String to, T content) {
        this.from = from;
        this.to = to;
        this.content = content;
    }
    
    @Override
    public String getFrom() {
        return from;
    }
    
    @Override
    public String getTo() {
        return to;
    }
    
    @Override
    public T getContent() {
        return content;
    }
}

public static class MailMessage extends Storage<String> {
    public MailMessage(String from, String to, String content) {
        super(from, to, content);
    }
}

public static class Salary extends Storage<Integer> {
    public Salary(String from, String to, Integer content) {
        super(from, to, content);
    }
}

public static class MailService<T> implements Consumer<Storage<T>> {
    private Map<String, List<T>> contentMap = new HashMap<String, List<T>>() {
        @Override
        public List<T> get(Object key) {
            if (this.containsKey(key)) {
                return super.get(key); // up to default
            } else {
                return Collections.emptyList(); // somewhat difficulty there, very iffy/unsure
            }
        }
    };
    
    @Override
    public void accept(Storage<T> storage) {
        String to = storage.getTo();
        List<T> content = contentMap.get(to);
        
        if (content.size() == 0) {
            content = new ArrayList<T>();
        }
        
        T storageContent = storage.getContent();
        content.add(storageContent);
        
        contentMap.put(to, content);
    }
    
    public Map<String, List<T>> getMailBox() {
        return contentMap;
    }
}
