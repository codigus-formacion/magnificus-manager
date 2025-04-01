package magnificus.codigus;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import magnificus.units.Application;
import magnificus.units.Domain;
import magnificus.units.PathKey;
import magnificus.units.Topic;
import magnificus.units.Unit;
import utils.Directory;

public class AppsFileReader {

    private List<String> strings;
    private Topic software;
    private Domain domain;

    public AppsFileReader(String rootPath, String fileName, Topic software, Domain domain) {
        this.strings = new Directory(rootPath).readFile(fileName);
        this.software = software;
        this.domain = domain;
    }

    public Application create(Unit father) {
        Application application = new Application("Aplicaciones", "apps");
        application.setFather(father);
        this.createTopicApplications(application, this.software);
        this.createDomainApplications(application);
        return application;
    }

    private void createTopicApplications(Application father, Topic topic) {
        Application child = new Application(topic);
        child.setFather(father);
        child.key().set(topic.key().toString());
        topic.childs().stream()
                .forEach(topicChild -> {
                    this.createTopicApplications(child, (Topic) topicChild);
                });
    }

    private void createDomainApplications(Application application) {
        this.createTopicDomainsMap()
                .forEach((topic, domains) -> domains
                        .forEach(domain -> domain.ancestors().stream()
                                .skip(1)
                                .map(unit -> (Domain) unit)
                                .filter(domainAncestor -> application
                                        .findByPathKey(PathKey.toAppsPathKey(topic, domainAncestor)) == null)
                                .forEach(domainAncestor -> new Application(domainAncestor)
                                        .setFather(application
                                                .findByPathKey(
                                                        PathKey.toAppsPathKey(topic, domainAncestor).father())))));
    }

    public Map<Topic, List<Domain>> createTopicDomainsMap() {
        List<Unit> topics = this.software.descendantsOrSelf();
        return IntStream.range(0, topics.size())
                .mapToObj(i -> {
                    Topic topic = (Topic) topics.get(i);
                    int beginIndex = this.strings.indexOf(topic.pathKey().toString()) + 1;
                    int endIndex = (i != topics.size() - 1)
                            ? this.strings.indexOf(topics.get(i + 1).pathKey().toString())
                            : this.strings.size();
                    List<Domain> domains = (beginIndex < endIndex) ? this.strings.subList(beginIndex, endIndex).stream()
                            .map(string -> (Domain) this.domain.findByPathKey(PathKey.of(string)))
                            .collect(Collectors.toList())
                            : new ArrayList<>();
                    return new AbstractMap.SimpleEntry<>(topic, domains);
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

}
