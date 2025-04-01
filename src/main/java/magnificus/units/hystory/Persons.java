package magnificus.units.hystory;

import magnificus.units.Unit;
import magnificus.units.UnitVisitor;

public class Persons extends Unit {

    protected Persons(String title, String key) {
        super(title, key);
    }

    @Override
    protected String preffix() {
        return "Person";
    }

    @Override
    public void accept(UnitVisitor unitVisitor) {
        unitVisitor.visit(this);
    }
    
}
