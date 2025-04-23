package magnificus.readers;

public class FormattedLine {
    
    private static final String CHILD = ".";
    private static final String SEPARATOR = " - ";
    private static final String SEPARATOR_CONTEXT = " + ";
    private final String string;

    public FormattedLine(String string){
        assert string.contains(CHILD) && (string.contains(SEPARATOR) || string.contains(SEPARATOR_CONTEXT)) : "Fallo con: " + string;
        
        this.string = string;
    }

    public String title() {
        int endIndex = this.string.indexOf(SEPARATOR);
        if (endIndex == -1) {
            endIndex = this.string.indexOf(SEPARATOR_CONTEXT);
        }
        return this.string.substring(this.string.lastIndexOf(CHILD) + 1, endIndex).trim();
    }

    public String key() {
        int index = this.string.indexOf(SEPARATOR);
        if (index == -1) {
            index = this.string.indexOf(SEPARATOR_CONTEXT);
        }
        return this.string.substring(index + SEPARATOR.length()).trim();
    }

    public boolean isContextual() {
        return this.string.contains(SEPARATOR_CONTEXT);
    }

    public int depth() {
        return this.string.lastIndexOf(CHILD) - this.string.indexOf(CHILD) + 1;
    }
    
}
