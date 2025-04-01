package magnificus.units;

import magnificus.units.hystory.Institution;
import magnificus.units.hystory.Institutions;
import magnificus.units.hystory.Person;
import magnificus.units.hystory.Persons;
import magnificus.units.hystory.Product;
import magnificus.units.hystory.Products;

public interface UnitVisitor {

    void visit(CompositeUnit compositeUnit);
    void visit(Topic topic);
    void visit(Context context);
    void visit(Domain domain);
    void visit(Application application);
    void visit(Products products);
    void visit(Product product);
    void visit(Institutions institutions);
    void visit(Institution institution);
    void visit(Persons persons);
    void visit(Person person);

}
