package magnificus.codigus;

import magnificus.controllers.apps.SrcWriter;
import magnificus.controllers.mkdocs.MKDocsWriter;
import magnificus.units.Application;
import magnificus.units.CompositeUnit;
import magnificus.units.Domain;
import magnificus.units.PathKey;
import magnificus.units.Topic;
import utils.Console;

public class Codigus extends CompositeUnit {

    private final String POPULATION = "./src/main/resources/population";
    private final String EXTENSION = ".gus";

    public Codigus() {
        super("codigus", "docs");
        this.setFather();
        this.createSoftware();
        this.createDomain();
        // this.createApps();
    }

    @Override
    protected String preffix() {
        return this.title();
    }

    public Topic createSoftware() {
        return new UnitTreeFileReader<Topic>(POPULATION, "/software" + EXTENSION, (String string) -> {
            FormattedLine line = new FormattedLine(string);
            return new Topic(line.title(), line.key(), line.isContextual());
        }).create(this);
    }

    public Domain createDomain() {
        return new UnitTreeFileReader<Domain>(POPULATION, "/domains" + EXTENSION, (String string) -> {
            FormattedLine line = new FormattedLine(string);
            return new Domain(line.title(), line.key());
        }).create(this);
    }

    public Application createApps() {
        return new AppsFileReader(POPULATION, "/apps" + EXTENSION,
                (Topic) this.findByPathKey(PathKey.of("/docs/t1software")),
                (Domain) this.findByPathKey(PathKey.of("/docs/d2domains")))
                .create(this);
    }

    public static void main(String[] args) {
        Codigus codigus = new Codigus();
        codigus.descendantsOrSelf().stream()
                .forEach(unit -> Console.instance().writeln(unit.pathKey()));
                codigus.accept(new MKDocsWriter("../magnificus-mkdocs"));
                codigus.accept(new SrcWriter("./magnificus-apps"));
        Console.close("testCase");
    }

}