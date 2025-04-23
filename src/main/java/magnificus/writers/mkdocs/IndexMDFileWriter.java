package magnificus.writers.mkdocs;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import magnificus.writers.FileWriter;
import magnificus.units.Application;
import magnificus.units.CompositeUnit;
import magnificus.units.Context;
import magnificus.units.Domain;
import magnificus.units.Topic;
import magnificus.units.Unit;
import magnificus.units.hystory.Institution;
import magnificus.units.hystory.Institutions;
import magnificus.units.hystory.Person;
import magnificus.units.hystory.Persons;
import magnificus.units.hystory.Product;
import magnificus.units.hystory.Products;
import utils.Directory;

public class IndexMDFileWriter extends FileWriter {

    private static Optional<Integer> SHORT_DEPTH = Optional.of(2);

    protected IndexMDFileWriter(Directory directory) {
        super(directory);
    }

    @Override
    protected String fileName() {
        return "/index.md";
    }

    @Override
    public void visit(CompositeUnit mixedUnit) {
        this.addTitle(mixedUnit);
        this.addAncestorsIndex(mixedUnit);
        this.add("\n\n@Content\n\n");
        this.addDescendantsIndex(mixedUnit, SHORT_DEPTH);
        this.addAncestorsIndex(mixedUnit);
        this.addDomainsIndex(mixedUnit);
    }

    @Override
    public void visit(Topic topic) {
        this.addTitle(topic);
        this.addAncestorsIndex(topic);
        this.add("\n\n@Content\n\n");
        this.addDescendantsIndex(topic, SHORT_DEPTH);
        this.addAncestorsIndex(topic);
        this.addDomainsIndex(topic);
    }

    @Override
    public void visit(Context context) {
        this.addTitle(context);
        this.addAncestorsIndex(context);
        this.add("\n\n@Content\n\n");
        this.addAncestorsIndex(context);
    }

    @Override
    public void visit(Domain domain) {
        this.addTitle(domain);
        this.addAncestorsIndex(domain);
        this.add("\n\n@Content\n\n"); // sacar de inputOutput.log!!!!!!!!!!
        this.addDescendantsIndex(domain, SHORT_DEPTH);
        this.addAncestorsIndex(domain);
        this.addTopicsIndex(domain);
    }

    @Override
    public void visit(Application application) {
    }

    @Override
    public void visit(Products products) {
        
    }

    @Override
    public void visit(Product product) {
        
    }

    @Override
    public void visit(Institutions institutions) {
        
    }

    @Override
    public void visit(Institution institution) {
        
    }

    @Override
    public void visit(Persons persons) {
        
    }

    @Override
    public void visit(Person person) {
        
    }

    protected void addAncestorsIndex(Unit unit) {
        if (!unit.ancestors().isEmpty()) {
            this.add(IntStream.range(0, unit.ancestors().size())
                    .mapToObj(value -> " - [" + unit.ancestors().get(value).title() + "]("
                            + this.ancestorPath(unit.ancestors().size() - value - 1) + "../index.md)")
                    .reduce("", (partial, element) -> partial + element)
                    .substring(unit.ancestors().isEmpty() ? 0 : " - ".length()));
        }
    }

    protected String ancestorPath(int value) {
        return IntStream.range(0, value)
                .mapToObj(depth -> "../")
                .reduce("", (partial, element) -> partial + element);
    }

    protected void addDescendantsIndex(Unit unit, Optional<Integer> depth) {
        List<Unit> topicDescendants = unit.descendants(depth);
        topicDescendants.stream()
                .filter(descendant -> !(descendant instanceof Domain))
                .toList();
        if (depth.isPresent()) {
            if (depth.get() == 0 || topicDescendants.isEmpty()) {
                return;
            }
        }

        this.add(IntStream.range(0, topicDescendants.size())
                .mapToObj(i -> this.margin(this.depth(topicDescendants.get(i)) - this.depth(unit) - 1)
                        + "[" + topicDescendants.get(i).title() + "]("
                        + "./" + topicDescendants.get(i).pathKey().toString()
                                .substring(unit.pathKey().toString().length() + 1)
                        + "/index.md)"
                        + " - " + topicDescendants.get(i).descendantsOrSelf().size())
                .reduce("", (partial, element) -> partial + element)
                + "\n\n");
    }

    private void addDomainsIndex(Unit unit) {

    }

    private void addTopicsIndex(Unit unit) {

    }

}
