abstract class KeywordAnalyzer implements TextAnalyzer {
    protected abstract String[] getKeywords();
    protected abstract Label getLabel();
    
    @Override
    public Label processText(String text) {
        String[] keywords = getKeywords();
        
        for (String keyword: keywords) {
            if (text.contains(keyword)) {
                return getLabel();
            }
        }
        
        return Label.OK;
    }
}

class SpamAnalyzer extends KeywordAnalyzer implements TextAnalyzer {
    private String[] keywords;
    
    public SpamAnalyzer(String[] keywords) {
        this.keywords = keywords;
    }
    
    @Override
    protected String[] getKeywords() {
        return keywords;
    }
    
    @Override
    protected Label getLabel() {
        return Label.SPAM;
    }
}

class NegativeTextAnalyzer extends KeywordAnalyzer implements TextAnalyzer {
    private final String[] keywords = {":(", "=(", ":|"};
    
    @Override
    protected String[] getKeywords() {
        return keywords;
    }
    
    @Override
    protected Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }
}

class TooLongTextAnalyzer implements TextAnalyzer {
    private int maxLength;
    
    public TooLongTextAnalyzer(int length) {
        maxLength = length;
    }
    
    @Override
    public Label processText(String text) {
        return text.length() > maxLength ? Label.TOO_LONG : Label.OK;
    }
}

public Label checkLabels(TextAnalyzer[] analyzers, String text) {
    for (TextAnalyzer analyzer: analyzers) {
        Label lb = analyzer.processText(text);
        if (lb != Label.OK)
            return lb;
    }
    
    return Label.OK;
}
