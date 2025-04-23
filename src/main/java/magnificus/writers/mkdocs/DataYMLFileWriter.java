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

public class DataYMLFileWriter extends FileWriter {

    protected DataYMLFileWriter(Directory directory) {
        super(directory);
    }

    @Override
    protected String fileName() {
        return "/data.yml";
    }

    @Override
    public void visit(CompositeUnit mixedUnit) {
        this.add("concepts: "
                + "\ntopics :"
                + "\ntime :"
                + "\ndifficulty :"
                + "\ntoDos :"
                + "\n");
    }

    @Override
    public void visit(Topic topic) {
        this.add("concepts: "
                + "\ntopics :"
                + "\ntime :"
                + "\ndifficulty :"
                + "\ntoDos :"
                + "\n");
    }

    @Override
    public void visit(Context context) {
        this.add("concepts: "
                + "\ntopics :"
                + "\ntime :"
                + "\ndifficulty :"
                + "\ntoDos :"
                + "\n");
    }

    @Override
    public void visit(Domain domain) {
        this.add("time :"
                + "\ndifficulty :"
                + "\ntoDos :"
                + "\n");
    }

    @Override
    public void visit(Application application) {
        this.add("topic: "
                + "\ndomain :"
                + "\nevaluation :"
                + "\ntime :"
                + "\ndifficulty :"
                + "\nforbiden: " // keywords posteriores!!!
                + "\ntoDos :"
                + "\n");
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
