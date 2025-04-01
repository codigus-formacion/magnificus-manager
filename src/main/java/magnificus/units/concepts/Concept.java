package magnificus.units.concepts;

public class Concept {
    
    // private String key;
    // private String name;
    // private List<String> synonyms;
    // private List<Concept> antonyms;
    // private String definition;

    // List<Concept> compositions = new ArrayList<Concept>();
    // List<Concept> agregations = new ArrayList<Concept>();
    // List<Concept> associations = new ArrayList<Concept>();
    // List<Concept> uses = new ArrayList<Concept>();

    // public Concept(String name, String key) {
    //     this.name = name;
    //     this.key = key;
    // }
    
    // public String filter() {
    //     // List<String> conceptWords = 
    //     //     this.includeds
    //     List<String> insignificantes = Arrays.asList(
    //         ""
    //     );
    //     return Arrays.asList(definition.split(" ,.;:")).stream()
    //         .map(word -> insignificantes.contains(word) ? "" : word)
    //         .reduce("", (partial, element) -> partial + " " + element);
    // }
}

// - name: conjunto
//   definition: una colección desordenada de elementos

// - name: conjunto por extensión
//   definition: un conjunto cuyo criterio de pertenencia se resuelve con la presencia o no del elemento en 
//   un colección determinada de elementos
//   inherits: 
//     - conjunto

// - name: conjunto por comprensión
//   definition: un conjunto cuyo criterio de pertenencia se resuelve con la evaluación de una expresión lógica
//   basada en sus características
//   inherits: 
//     - conjunto

// - name: sistema
//   definition: un conjunto de elementos que colaboran entre sí con un objetivo en común

// - name: complejidad
//   definition: la propiedad de aquellos sistemas que exceden los límites de la capacidad humana
//   antonym:
//     - sencillez
