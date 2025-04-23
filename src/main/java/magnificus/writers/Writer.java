package magnificus.writers;

import magnificus.units.Application;
import magnificus.units.CompositeUnit;
import magnificus.units.Context;
import magnificus.units.Domain;
import magnificus.units.Topic;
import magnificus.units.Unit;
import magnificus.units.UnitVisitor;
import magnificus.units.hystory.Institution;
import magnificus.units.hystory.Institutions;
import magnificus.units.hystory.Person;
import magnificus.units.hystory.Persons;
import magnificus.units.hystory.Product;
import magnificus.units.hystory.Products;
import utils.Directory;

public abstract class Writer implements UnitVisitor {

    private Directory directory;

    protected Writer(Directory directory) {
        assert directory != null;

        this.directory = directory;
    }

    protected Writer(String rootPath) {
        this.directory = new Directory(rootPath);
    }

    public void generate(Unit unit) {
        unit.accept(this);
        unit.childs().stream()
                .forEach(child -> {
                    this.generate(child);
                });
    }

    @Override
    public void visit(CompositeUnit mixedUnit) {
    }

    @Override
    public void visit(Topic topic) {
    }

    @Override
    public void visit(Context context) {
    }

    @Override
    public void visit(Domain domain) {
    }

    @Override
    public void visit(Application application) {
    }

    @Override
    public void visit(Products products) {
    }

    @Override
    public void visit(Product product) {
    }

    @Override
    public void visit(Institutions institutions) {
    }

    @Override
    public void visit(Institution institution) {
    }

    @Override
    public void visit(Persons persons) {
    }

    @Override
    public void visit(Person person) {
    }

    protected Directory directory() {
        return this.directory;
    }

}
