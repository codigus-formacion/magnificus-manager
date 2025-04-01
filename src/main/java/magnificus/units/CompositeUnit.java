package magnificus.units;

public abstract class CompositeUnit extends Unit {

    public CompositeUnit(String title, String key) {
        super(title, key);
    }

    @Override
    public void accept(UnitVisitor unitVisitor) {
        unitVisitor.visit(this);
    }

}
