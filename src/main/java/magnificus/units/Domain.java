package magnificus.units;

public class Domain extends Unit {

    public Domain(String title, String key) {
        super(title, key);
    }

    @Override
    protected String preffix() {
        return "Domain";
    }

    @Override
    public void accept(UnitVisitor unitVisitor) {
        unitVisitor.visit(this);
    }

}
