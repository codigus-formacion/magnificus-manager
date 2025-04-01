package magnificus.menu;

import java.util.List;
import java.util.Optional;

import magnificus.units.Unit;
import utils.Console;
import utils.IterativeMenu;

public abstract class UnitMenu<T extends Unit> extends IterativeMenu<T> {

    private List<T> selecteds;

    protected UnitMenu(String title, T unit, List<T> selecteds) {
        super(title, unit);
        this.selecteds = selecteds;
    }

    @Override
    protected void showTitle() {
        super.showTitle();
        Console.instance().writeln("Seleccionadas:");
        this.selecteds().stream()
                .forEach(unit -> {
                    Console.instance().writeln(unit.pathKey());
                });
        Console.instance().writeln();
        Console.instance().writeln("Opciones:");
    }

    @Override
    protected void addOptions() {
        this.addChildsOptions();
        this.add("Consultar ", unit -> {
            Console.instance().writeln(
                    "\nTítulo:" + this.target().title() +
                            "\nClave:" + this.target().key() +
                            "\nAncestros:" + this.target().ancestors().stream()
                                    .map(domain -> domain.pathKey().toString())
                                    .reduce("", (partial, element) -> partial + "\n" + element)
                            +
                            "\nDescendientes:" + this.target().descendants(Optional.of(1)).stream()
                                    .map(domain -> domain.pathKey().toString())
                                    .reduce("", (partial, element) -> partial + "\n" + element));
        });
        this.add("Modificar", topic -> {
            topic.setTitle(Console.instance().readString("Título: "));
            // topic.key(topic.key().substring(0, "*d".length())
            // + Console.instance().readString("Clave: "));
        });
        this.add("Seleccionar", unit -> {
            this.selecteds.add(unit);
        });
        this.add("Deseleccionar", unit -> {
            if (this.selecteds.contains(unit)) {
                this.selecteds.remove(unit);
            }
        });
    }

    protected abstract void addChildsOptions();

    public List<T> selecteds() {
        return this.selecteds;
    }

}
