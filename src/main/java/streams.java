
import java.util.AbstractMap.SimpleEntry;
import java.util.List;
import java.util.stream.Stream;

public class streams {
    
    public static void main(String[] args){


//         List<String> nameList;
// Stream<Integer> indices = intRange(1, names.length).boxed();
// nameList = zip(indices, stream(names), SimpleEntry::new)
//         .filter(e -> e.getValue().length() <= e.getKey())
//         .map(Entry::getValue)
//         .collect(toList());


        // fatherUnit.map(value -> value.childUnits.size()).orElse(0);

 

                // String[] nuevoArray = Arrays.stream([originalArray])
        // .map((str, index) -> str + "-" + index)
        // .toArray(String[]::new);


                // final String[] noUnits = { "data.yml", "index.md", "images" };
        // this.childUnits = Arrays.stream(this.file.listFiles())
        //         .filter(childFile -> Arrays.stream(noUnits)
        //                 .noneMatch(noUnit -> noUnit.equals(childFile.getName())))
        //         .map(childfile -> UnitFactory.create(this, childfile.getAbsolutePath()))
        //         .toList();

            //     if (level > 0) {
            // IntStream.range(1, this.ancestors().size())
            //         .forEach(index -> {
            //             String string = "[" + this.ancestors().get(this.ancestors().size() - index - 1).title() + "](";
            //             string += IntStream.range(0, index)
            //                     .mapToObj(i -> "../")
            //                     .collect(Collectors.joining());
            //             Console.instance().writeln(string + "index.md)");
            //         });
            // Console.instance().writeln();

            // f (level < 2) {
            //     this.childUnits.stream()
            //             .forEach(childUnit -> {
            //                 Console.instance().writeln(
            //                         "* [<h4>" + childUnit.title() + "</h4>]"
            //                                 + "(./" + childUnit.name() + "/index.md)");
            //                 ((CompositeUnit) childUnit).childUnits.stream()
            //                         .forEach(grandchildUnit -> Console.instance().writeln(
            //                                 "    * [<h3>" + grandchildUnit.title() + "</h3>]"
            //                                         + "(./" + childUnit.name() + "/" + grandchildUnit.name()
            //                                         + "/index.md)"));
            //                 Console.instance().writeln();
            //             });
            //     this.childUnits.stream().forEach(
            //             childUnit -> childUnit.toIndex(level + 1));
            }

}
