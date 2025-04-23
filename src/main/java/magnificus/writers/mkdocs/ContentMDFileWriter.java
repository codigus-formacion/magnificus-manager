package magnificus.writers.mkdocs;

import magnificus.writers.FileWriter;
import magnificus.units.Application;
import magnificus.units.CompositeUnit;
import magnificus.units.Context;
import magnificus.units.Domain;
import magnificus.units.Topic;
import magnificus.units.hystory.Institution;
import magnificus.units.hystory.Institutions;
import magnificus.units.hystory.Person;
import magnificus.units.hystory.Persons;
import magnificus.units.hystory.Product;
import magnificus.units.hystory.Products;
import utils.Directory;

public class ContentMDFileWriter extends FileWriter {

    protected ContentMDFileWriter(Directory directory) {
        super(directory);
    }

    @Override
    protected String fileName() {
        return "/content.md";
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
        String execution = "\n\n\n´´´´\n\n´´´´";
        this.add("<h2>Requisitos</h2>\n\n"
                + "<h3>Interfaz de Usuario</h3>\n"
                // leer src/main/java/resources/logs/inputOutput-***.log
                + execution + "\n" + execution + "\n" + execution + "\n\n");
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

}
