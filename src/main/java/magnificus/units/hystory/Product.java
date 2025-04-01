package magnificus.units.hystory;

import magnificus.units.Unit;
import magnificus.units.UnitVisitor;

public class Product extends Unit {

    public Product(String title, String key) {
        super(title, key);
    }

    @Override
    protected String preffix() {
        return "Product";
    }

    @Override
    public void accept(UnitVisitor unitVisitor) {
        unitVisitor.visit(this);
    }
        
}
