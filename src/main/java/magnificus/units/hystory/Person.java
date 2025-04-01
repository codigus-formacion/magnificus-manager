package magnificus.units.hystory;

import magnificus.units.UnitVisitor;

public class Person extends ContextUnit {

    public Person(String title, String key) {
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
