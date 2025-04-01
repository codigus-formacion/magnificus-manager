package magnificus.units.hystory;

import magnificus.units.CompositeUnit;

public class HistoryUnit extends CompositeUnit {

    public HistoryUnit(String title, String key) {
        super("Historia", "history");
        try {
            this.createPersons().setFather(this);
            this.createInstitutions().setFather(this);
            this.createProducts().setFather(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected String preffix() {
        return "History ";
    }

    private Persons createPersons() {
        Persons persons = new Persons("Personas", "persons");
        new Person("Luis Fernández", "setillo").setFather(persons);
        return persons;
    }

    private Institutions createInstitutions() {
        Institutions institutions = new Institutions("Instituciones", "institutions");
        new Institution("UPM", "upm").setFather(institutions);
        return institutions;
    }

    private Products createProducts() {
        Products products = new Products("Productos", "products");
        new Institution("PIIPOO", "piipoo").setFather(products);
        return products;
    }

}
