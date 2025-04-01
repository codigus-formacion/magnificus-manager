package magnificus.controllers.apps;

import magnificus.controllers.FileWriter;
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

public class ReadmeMDFileWriter extends FileWriter {

    public ReadmeMDFileWriter(Directory directory) {
        super(directory);
    }

    @Override
    protected String fileName() {
        return "README.md";
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
        // indice de enunciados anteriores y siguientes 
        //   cada uno con todas sus aplicaciones
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

    public void generate(Topic topic, Domain domain, Topic subtopic) {
        assert topic.descendants().contains(subtopic);

        // String x = topic.pathKey().replaceAll("/", ".").substring(".".length());
        // String pathName = domain.pathKey().substring("/t1software".length())
        //         + subtopic.pathKey().substring(topic.pathKey().length());
        // this.directory().createDirectory( "/" + x + "/" + pathName);
        // this.add("<a href=\"http://codigus-dev.com\"><h1>codigus</h1></a>" +
        //         "\n[Youtube](www.youtube.com/codigus-dev) - " +
        //         "[Spotify](www.spotify.com/codigus-dev) - " +
        //         "[Blogger](www.blogger.com/codigus-dev/t1software)\n" +
        //         "\n* [Enunciado](http://codigus-dev.com" + pathName + ")" +
        //         "\n* Solución" +
        //         "\n   * [Código](http://github/codigus-dev.com" + pathName + "/src/main/java/App.java)" +
        //         "\n   * [Video](www.youtube.com/codigus-dev/t1software" + pathName + ")" +
        //         "\n   * [Audio](www.spotify.com/codigus-dev/t1software" + pathName + ")" +
        //         "\n   * [Texto](www.blogger.com/codigus-dev/t1software" + pathName + ")" +
        //         "\n   * [Texto](www.blogger.com/codigus-dev/t1software" + pathName + ")" +
        //         "\n* Otras Soluciones");
    }

}

