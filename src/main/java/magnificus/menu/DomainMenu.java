package magnificus.menu;

import java.util.ArrayList;
import java.util.List;

import magnificus.units.Domain;

public class DomainMenu extends UnitMenu<Domain> {

    private static List<Domain> selecteds = new ArrayList<>();

    public static DomainMenu of(Domain domain){
        return new DomainMenu(domain);
    }

    public DomainMenu(Domain domain) {
        super("Dominio: " + domain.pathKey(), domain, DomainMenu.selecteds);
    }

    @Override
    protected void addChildsOptions() {
        this.target().childs().stream()
                .map(child -> (Domain) child)
                .forEach(subdomain -> {
                    this.add("Abrir " + subdomain.pathKey(), (Domain domain) -> {
                        new DomainMenu(subdomain).interact();
                    });
                });
    }

}

/*
 * 
 * Domain
 * - Abrir: subdomain
 * - Consulta:
 * - Modificación:
 * - Alta: subdomain
 * - Alta: Version con topic, subtopic
 * - Baja Version con topic, subtopic
 * - Baja:
 * - Cerrar
 * 
 */
