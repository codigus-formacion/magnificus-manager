package magnificus.writers.mkdocs;

import java.util.Arrays;

import magnificus.Codigus;
import magnificus.writers.Writer;
import magnificus.units.Unit;
import utils.Console;

public class MKDocsWriter extends Writer {

    public MKDocsWriter(String rootPath) {
        super(rootPath);
        this.directory().createDirectory();
        this.directory().createFile("/mkdocs.yml",
                "site_name: codigus\n"
                        + "nav:\n"
                        + "  - Software: ./t1software/index.md\n"
                        + "  - Dominios: ./d2domains/index.md\n"
                        + "  - Aplicaciones: ./a3applications/index.md\n");
    }

    public void visit(Unit unit) {
        String path = unit.pathKey().toString();
        this.directory().createSubdirectory(path);
        Arrays.asList("/x0images", "/x0uml").stream()
                .forEach(subdirectory -> {
                    this.directory().createSubdirectory(path + subdirectory);
                });
        Arrays.asList(
            new DataYMLFileWriter(this.directory()), 
            new ContentMDFileWriter(this.directory()),
            new IndexMDFileWriter(this.directory())).stream()
                .forEach(writer -> {
                    unit.accept(writer);
                    writer.create(unit);
                });
    }

    public static void main(String[] args) {
        try {
            Codigus codigus = new Codigus();
            MKDocsWriter mkDocsWriter = new MKDocsWriter("../magnificus-mkdocs");
            codigus.accept(null);
            // mkDocsWriter.create(codigus);
            Console.instance().writeln("testCase");
            Console.close("testCase");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

// table:
// width: 50,50
// colums:
// - - -@concept software @la información que @r@suministra el desarrollador a
// la computadora@ para alsjk alsdjf ñlaksçfasdfasdfkja sdf
// añsldjf a
// --@comment as dlfka ñlsjkdfkajs dñfkja ñskdjf ñllakjjsd fkjja sdkfja
// aasñldfj ñakksjdj fllkja sñdllkfjjasdf
// - @image software
// - - @code github//sskas/asfsl//App.java
// - @comment añjlajsd ffñaklsd ñf añskdf ñk

// - - |
// - |

// Alonzo Church, formalizó el Cálculo Lambda siendo equivalente a la Máquina de
// Turing

// Alfred Horn, formalizó las clausulas lógicas como disyunción de literales con
// uno positvio como máxmio que también es equivalente a las Máquina de Turing

// …​ el Juego de la Vida de Conway, Computación de Membranas de Paun, …​

// - @width: 70, 30
// @row:
// - |
// -@concept Modelo de Computación @un modelo que estudia qué se puede calcular,
// saber, conocer, computar (latín putare, pensar)
// --@comment Origen @refPerson Euclides@ short@ @ref @refPerson Al-Khwarizmi@
// short@@
// ---@concept Algoritmo@ conjunto ordenado y finito de operaciones que permite
// hallar la solución de un problema en un tiempo finito
// -@comment @refConcept logig@ born@: @refPerson Aritóteles@, Leibniz, …​,
// Hilbert, Russel, Gödel, Wittgenstein, …​
// -@comment @refPerson Turin@ , formalizó el concepto de algoritmo y
// computación: Maquina Universal de Turing, origen de la computadora actual,
// capaz de computar todo lo computable
// - |
// -@example @domain d3collections/d5graph@ @version
// t1foundations/u3dataLanguages/u3yaml@
// -@example @domain d3collections/d5graph@ @version
// t1foundations/u3dataLanguages/u3yaml@
// -@example @domain d3collections/d5graph@ @version
// t1foundations/u3dataLanguages/u3yaml@
// -@example @domain d3collections/d5graph@ @version
// t1foundations/u3dataLanguages/u3yaml@

// - @width: 70, 30
// @rows:
// - - |
// -@concept Modelo de Computación @un modelo que estudia qué se puede calcular,
// saber, conocer, computar (latín putare, pensar)
// --@comment Origen @refPerson Euclides@ short@ @ref @refPerson Al-Khwarizmi@
// short@@
// ---@concept Algoritmo@ conjunto ordenado y finito de operaciones que permite
// hallar la solución de un problema en un tiempo finito
// -@comment @refConcept logig@ born@: @refPerson Aritóteles@, Leibniz, …​,
// Hilbert, Russel, Gödel, Wittgenstein, …​
// -@comment @refPerson Turin@ , formalizó el concepto de algoritmo y
// computación: Maquina Universal de Turing, origen de la computadora actual,
// capaz de computar todo lo computable
// - |
// -@example @domain d3collections/d5graph@ @version
// t1foundations/u3dataLanguages/u3yaml@
// -@example @domain d3collections/d5graph@ @version
// t1foundations/u3dataLanguages/u3yaml@
// -@example @domain d3collections/d5graph@ @version
// t1foundations/u3dataLanguages/u3yaml@
// -@example @domain d3collections/d5graph@ @version
// t1foundations/u3dataLanguages/u3yaml@
// - - |
// -@concept Modelo de Computación @un modelo que estudia qué se puede calcular,
// saber, conocer, computar (latín putare, pensar)
// --@comment Origen @refPerson Euclides@ short@ @ref @refPerson Al-Khwarizmi@
// short@@
// ---@concept Algoritmo@ conjunto ordenado y finito de operaciones que permite
// hallar la solución de un problema en un tiempo finito
// -@comment @refConcept logig@ born@: @refPerson Aritóteles@, Leibniz, …​,
// Hilbert, Russel, Gödel, Wittgenstein, …​
// -@comment @refPerson Turin@ , formalizó el concepto de algoritmo y
// computación: Maquina Universal de Turing, origen de la computadora actual,
// capaz de computar todo lo computable
// - |
// -@example @domain d3collections/d5graph@ @version
// t1foundations/u3dataLanguages/u3yaml@
// -@example @domain d3collections/d5graph@ @version
// t1foundations/u3dataLanguages/u3yaml@
// -@example @domain d3collections/d5graph@ @version
// t1foundations/u3dataLanguages/u3yaml@
// -@example @domain d3collections/d5graph@ @version
// t1foundations/u3dataLanguages/u3yaml@
