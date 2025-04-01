package magnificus.units.hystory;

import magnificus.units.Unit;
import magnificus.units.UnitVisitor;

public class Institution extends Unit {

    public InstitutionType institutionType;

    protected Institution(String title, String key) {
        super(title, key);
    }

    @Override
    protected String preffix() {
        return "Institution";
    }

    @Override
    public void accept(UnitVisitor unitVisitor) {
        unitVisitor.visit(this);
    }

}
