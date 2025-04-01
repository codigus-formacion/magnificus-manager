package magnificus.menu;

import java.util.ArrayList;
import java.util.List;

import magnificus.units.Topic;

public class TopicMenu extends UnitMenu<Topic> {

    private static List<Topic> selecteds = new ArrayList<>();

    public static TopicMenu of(Topic topic){
        return new TopicMenu(topic);
    }

    private TopicMenu(Topic topic) {
        super("Topico: " + topic.pathKey(), topic, TopicMenu.selecteds);
    }

    @Override
    protected void addChildsOptions() {
        this.target().childs().stream()
                .map(child -> (Topic) child)
                .forEach(subtopic -> {
                    this.add("Abrir " + subtopic.pathKey(), (Topic topic) -> {
                        new TopicMenu(subtopic).interact();
                    });
                });
    }

}

// /*
// *
// * Topic
// * - Abrir: subtopic
// * - Consulta:
// * - Modificación:
// * - Alta: subtopic
// * - Alta: Version con subdomain
// * - Baja Version con subdomain
// * - Baja:
// * - Cerrar
// *
// */
