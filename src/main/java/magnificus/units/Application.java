package magnificus.units;

public class Application extends Unit {

    // private Optional<String> version;

    public Application(String title, String key) {
        super(title, key);
        // this.version = Optional.empty(); //Optional.of("1.1.0");
    }

    public Application(Domain domain) {
        super("Enunciado: " + domain.title(), domain.key().toString());
    }

    public Application(Topic topic) {
        super("Solución: " + topic.title(), topic.key().toString());
    }

    @Override
    protected String preffix() {
        return "Application";
    }

    @Override
    public void setFather(Unit father) {
        super.setFather(father);
        if (!this.key().toString().equals("a3apps")) {
            this.key().set(this.key().toString().substring("ld".length()));
        }
    }

    @Override
    public void accept(UnitVisitor unitVisitor) {
        unitVisitor.visit(this);
    }

}
