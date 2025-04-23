package magnificus.readers;

import java.util.List;
import java.util.Stack;
import java.util.function.Function;
import java.util.stream.IntStream;

import magnificus.units.Unit;
import utils.Console;
import utils.Directory;

public class UnitTreeFileReader<T extends Unit> {

    private List<String> formattedLines;
    private Stack<T> branch;
    private int previousDepth;
    private Function<String, T> untiCreator;

    public UnitTreeFileReader(String rootPath, String fileName, Function<String, T> unitCreator) {
        this.formattedLines = new Directory(rootPath).readFile(fileName);
        this.untiCreator = unitCreator;
        this.branch = new Stack<>();
        this.previousDepth = 0;
    }

    public T create(Unit father) {
        this.formattedLines.stream()
                .forEach((string -> {
                    FormattedLine line = new FormattedLine(string);
                    if (line.depth() - this.previousDepth > 1) {
                        Console.instance().writeln(
                                "Fallo!!! Defecto: varios saltos!! Error:...!");
                        System.exit(0);
                    }
                    if (line.depth() <= this.previousDepth) {
                        IntStream.range(0,
                                this.previousDepth - line.depth() + 1)
                                .forEach(i -> 
                                    this.branch.pop());
                    }
                    T unit = this.untiCreator.apply(string);
                    if (!this.branch.empty()) {
                        unit.setFather(this.branch.peek());
                    }
                    this.branch.push(unit);
                    this.previousDepth = line.depth();
                }));
        T unit = this.branch.get(0);
        unit.setFather(father);
        return unit;
    }

}
