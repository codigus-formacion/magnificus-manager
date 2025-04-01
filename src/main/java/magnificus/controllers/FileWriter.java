package magnificus.controllers;

import java.util.regex.Pattern;
import java.util.stream.IntStream;

import magnificus.units.Unit;
import utils.Directory;

public abstract class FileWriter extends Writer  {

    private String content;

    protected FileWriter(Directory directory) {
        super(directory);
        this.content = "";
    }

    public void create(Unit unit) {
        this.directory().createFile(unit.pathKey() + this.fileName(), this.content);
    }

    protected abstract String fileName();

    protected void add(String string) {
        this.content += string;
    }

    protected void addTitle(Unit unit) {
        this.add("<h1>" + unit.title() + "</h1>\n\n");
    }

    protected int depth(Unit unit) {
        return (int) Pattern.compile(Pattern.quote("/")).matcher(unit.pathKey().toString()).results().count();
    }

    protected String margin(int depth) {
        return "\n"
                + IntStream.range(0, depth)
                        .mapToObj(i -> "\t")
                        .reduce("", (partial, element) -> partial + element)
                + "* ";
    }

}
