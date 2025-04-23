package magnificus.units;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import magnificus.units.concepts.Concept;
import utils.Pair;

public class Topic extends Unit {

    private Optional<List<Context>> contexts;
    private List<Concept> concepts;

    public Topic(String title, String key, boolean hasContext) {
        super(title, key);
        this.contexts = hasContext ? Optional.of(new ArrayList<>()) : Optional.empty();
        if (hasContext) {
            List<Pair<String, String>> CONTEXTS = Arrays.asList(
                    new Pair<String, String>("¿Por qué?", "why"),
                    new Pair<String, String>("¿Qué?", "what"),
                    new Pair<String, String>("¿Para qué?", "whatFor"),
                    new Pair<String, String>("¿Cómo?", "how"));
            IntStream.range(0, CONTEXTS.size())
                    .forEach(i -> {
                        Context context = new Context(CONTEXTS.get(i).getKey(), CONTEXTS.get(i).getValue());
                        context.setFather();
                        context.setPosition(i + 1);
                        this.contexts.get().add(context);
                    });
        }
    }

    @Override
    protected String preffix() {
        return "Topic";
    }

    @Override
    public Unit findByPathKey(PathKey pathKey) {
        assert pathKey != null;
        Unit unit = null;
        if (!this.contexts().isEmpty()) {
            unit = this.contexts.get().stream()
                    .filter(context -> context.findByPathKey(pathKey) != null)
                    .findFirst()
                    .orElse(null);
        }
        if (unit != null) {
            return unit;
        }
        return super.findByPathKey(pathKey);
    }    

    @Override
    protected String childsToString(Depth depth) {
        StringBuilder string = new StringBuilder();
        if (!depth.isBackground()) {
            this.contexts.ifPresent(contexts -> contexts
                    .forEach(unit -> string.append(unit.toString(depth.next()))));
        }
        return string.append(super.childsToString(depth)).toString();
    }

    public Optional<List<Context>> contexts() {
        return this.contexts;
    }

    public void add(Concept concept) {
        this.concepts.add(concept);
    }

    @Override
    public void accept(UnitVisitor unitVisitor) {
        unitVisitor.visit(this);
    }

}
