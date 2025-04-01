package magnificus.units;

public class Context extends Unit {

    public Context(String title, String key) {
        super(title, key);
    }

    @Override
    protected String preffix() {
        return "Context";
    }

    // @Override
    // public PathKey pathKey(){
    //     PathKey pathKey = this.father().pathKey();
    //     pathKey.add(this.key());
    //     return pathKey;
    // }

    public void setPosition(int position) {
        this.setKey(this.initial() + position + this.key());
    }

    @Override
    public void accept(UnitVisitor unitVisitor) {
        unitVisitor.visit(this);
    }

}
