package magnificus.codigus;

import magnificus.controllers.Writer;
import magnificus.units.PathKey;
import magnificus.units.Topic;
import magnificus.units.Unit;
import utils.Console;
import utils.Directory;

public class SrcWriter extends Writer {

    public SrcWriter(String rootPath) {
        super(rootPath);
        Directory directory = new Directory(rootPath);
        directory.createDirectory();
    }
    
    @Override
    public void visit(Topic topic) {
        this.directory()
                .createSubdirectory(topic.pathKey().toString()+"/v0");
    }

    public static void main(String[] args) {
        Codigus codigus = new Codigus();
        // codigus.descendants().stream()
        // .forEach(descendant -> Console.instance().writeln(descendant.pathKey()));
        Unit java = codigus.findByPathKey(PathKey.of("/docs/t1software/t2quality/t4javaTechnologies/t1java"));
        new SrcWriter("../magnificus-apps/src").generate(java);
        Console.close("testCase");
    }

}

//
/// /tN.../tYoutput/dN.../dXhello/v0
/// /tN.../tYoutput/dN.../dXhello/v1
///
/// /tN.../tYoutput/dN.../dXhello/dXhelloBye/v0
/// /tN.../tYoutput/dN.../dXhello/dXhelloBye/v1
/// /tN.../tYoutput/dN.../dXhello/dXhelloBye/v2
///
/// /tN.../tYinput/dN.../dXhelloYou/v0
///
/// /tN.../tYvar/dN.../dXhelloYou/v0
/// /tN.../tYvar/dN.../dXhelloYou/dXhelloByeYou/v0
///
/// /tN.../tYfor/dN.../dXinterval/dXincluded/v0
/// /tN.../tYstatic/dN.../dXinterval/dXstatistics/v0
/// /tN.../tYextends/dN.../dXinterval/dXstatistics/v0
/// /tN.../tYlambda/dN.../dXinterval/dXstatistics/v0
///
/// /tN.../tYfiles/dN.../dXmastermind/.../dXpersistence/v1
///
/// /tN.../tYsimplification/dN.../dXhello/v0
/// /tN.../tYsimplification/dN.../dXhello/v1
/// /tN.../tYsimplification/dN.../dXhello/dXhelloBye/v0
/// /tN.../tYsimplification/dN.../dXhello/dXhelloBye/v1
/// /tN.../tYsimplification/dN.../dXhello/dXhelloBye/v2
/// /tN.../tYsimplification/dN.../dXhelloYou/dXhelloByeYou/v0
/// /tN.../tYsimplification/dN.../dXhelloYou/dXhelloByeYou/v1
///
/// /tN.../tYdecoupling/dN.../dXmastermind/.../dXpersistence/v1
///