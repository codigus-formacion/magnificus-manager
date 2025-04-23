package magnificus.units;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class Unit {

    private String title;
    private Key key;
    private Optional<Unit> father;
    private List<Unit> childs;

    protected Unit(String title, String key) {
        assert title != null && !title.isBlank();

        this.title = title.trim();
        this.key = new Key(key.trim());
        this.father = null;
        this.childs = new ArrayList<Unit>();
    }

    protected abstract String preffix();

    protected void setFather() {
        assert !this.isChild();

        this.father = Optional.empty();
    }

    protected boolean isChild() {
        return this.father != null;
    }

    public void setFather(Unit father) {
        assert father != null;
        assert !this.isChild();

        this.father = Optional.of(father);
        this.father.get().setChild(this);
        this.key.setPreffix(this.initial(), this.position());
    }

    protected String initial() {
        return "" + Character.toLowerCase(this.preffix().charAt(0));
    }

    protected int position() {
        return this.father.map(father -> father.childs().size()).orElse(0);
    }

    protected void setChild(Unit unit) {
        assert unit != null;

        this.childs().add(unit);
    }

    public List<Unit> childs() {
        return this.childs;
    }

    public List<Unit> ancestors() {
        return this.father
                .map(father -> {
                    List<Unit> ancestors = father.ancestors();
                    ancestors.add(father);
                    return ancestors;
                })
                .orElse(new ArrayList<Unit>());
    }

    public List<Unit> ancestorsOrSelf() {
        List<Unit> ancestorsOrSelf = this.ancestors();
        ancestorsOrSelf.add(this);
        return ancestorsOrSelf;
    }

    public List<Unit> descendants() {
        return this.descendants(Optional.empty());
    }

    public List<Unit> descendants(Optional<Integer> depth) {
        List<Unit> untis = this.descendantsOrSelf(depth);
        untis.remove(this);
        return untis;
    }

    public List<Unit> descendantsOrSelf() {
        return this.descendantsOrSelf(Optional.empty());
    }

    public List<Unit> descendantsOrSelf(Optional<Integer> depth) {
        List<Unit> descendantsOrSelf = new ArrayList<>();
        descendantsOrSelf.add(this);
        if (depth.isPresent() && depth.get() == 0) {
            return descendantsOrSelf;
        }
        this.childs().stream().forEach(unit -> {
            descendantsOrSelf.addAll(unit.descendantsOrSelf(depth.map(nextDepth -> nextDepth - 1)));
        });
        return descendantsOrSelf;
    }

    public PathKey pathKey() {
        assert this.isChild();

        PathKey pathKey = new PathKey();
        this.ancestorsOrSelf().stream()
                .forEach(ancestor -> {
                    pathKey.add(ancestor.key());
                });
        return pathKey;
    }

    public Unit findByPathKey(PathKey pathKey) {
        assert isChild();

        if (this.pathKey().equals(pathKey)) {
            return this;
        }
        for (Unit child : this.childs()) {
            Unit found = child.findByPathKey(pathKey);
            if (found != null) {
                return found;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        assert this.isChild();

        return this.toString(new Depth());
    }

    public String toString(Depth depth) {
        return depth + this.dataToString() + this.childsToString(depth);
    }

    protected String dataToString() {
        return this.preffix() + " [Title='" + title() + "'; Key='" + this.key.toString() + "'; PathKey='"
                + this.pathKey() + "']";
    }

    protected String childsToString(Depth depth) {
        assert this.isChild();

        if (depth.isBackground()) {
            return "";
        }
        return this.childs().stream()
                .map(unit -> unit.toString(depth.next()))
                .reduce("", (partial, element) -> partial + element);
    }

    public Unit father() {
        assert this.father.isPresent();
        
        return this.father.get();
    }

    public Key key() {
        return this.key;
    }

    public void setKey(String key) {
        this.key.set(key);
    }

    public String title() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public abstract void accept(UnitVisitor UnitVisitor);

}

