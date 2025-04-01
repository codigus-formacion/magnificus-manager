package magnificus.units.hystory;

import magnificus.units.Unit;
import magnificus.units.UnitVisitor;

public class Products extends Unit {

    protected Products(String title, String key) {
        super(title, key);
    }

    @Override
    protected String preffix() {
        return "Products";
    }

    @Override
    public void accept(UnitVisitor unitVisitor) {
        unitVisitor.visit(this);
    }
    
}