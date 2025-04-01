package magnificus.units;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Objects;
import java.util.Queue;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PathKey {

    private Queue<Key> keys;

    public PathKey() {
        this.keys = new ArrayDeque<Key>();
    }

    public PathKey(Key key) {
        this();
        assert key != null;
        this.add(key);
    }

    public void add(Key key) {
        assert key != null;

        this.keys.offer(key);
    }

    public static PathKey toAppsPathKey(Topic topic) {
        return PathKey.of(topic.pathKey().toString()
            .replaceAll("/docs", "/docs/a3apps"));
    }

    public static PathKey toAppsPathKey(Topic topic, Domain domain) {
        String topicPathKey = topic.pathKey().toString().replaceAll("/docs", "/docs/a3apps");
        String domainPathKey = domain.pathKey().toString().replaceAll("/docs", "");
        return PathKey.of(topicPathKey + domainPathKey);
    }

    public static PathKey of(String string) {
        assert string != null && Pattern.compile("(/([a-zA-Z]\\d[a-zA-Z]+|docs))+")
                .matcher(string).matches() : "Fallo con " + string;

        PathKey pathKey = new PathKey();
        Arrays.asList(string.split("/")).stream()
                .skip(1)
                .forEach(key -> {
                    pathKey.add(new Key(key));
                });
        return pathKey;
    }

    public boolean isDescendant(PathKey pathKey) {
        assert pathKey != null;

        if (!this.head().equals(pathKey.head())) {
            return false;
        }
        if (pathKey.hasTail()) {
            return true;
        }
        if (!this.hasTail()) {
            return this.tail().isDescendant(pathKey.tail());
        }
        return false;
    }

    public Key head() {
        return this.keys.element();
    }

    public PathKey father() {
        PathKey fatherPathKey = new PathKey();
        this.keys.stream()
            .limit(this.keys.size() - 1)
            .forEach(fatherPathKey::add);
        return fatherPathKey;
    }

    public PathKey tail() {
        assert this.hasTail();

        PathKey tail = new PathKey();
        this.keys.stream()
                .skip(1)
                .forEach(key -> {
                    tail.add(key);
                });
        return tail;
    }

    public boolean hasTail() {
        return this.keys.size() > 1;
    }

    @Override
    public String toString() {
        return this.keys.stream()
                .map(key -> key.toString())
                .reduce("", (partial, element) -> partial + "/" + element);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        PathKey other = (PathKey) obj;
        return Objects.equals(
                this.keys.stream().collect(Collectors.toList()),
                other.keys.stream().collect(Collectors.toList()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((keys == null) ? 0 : keys.hashCode());
        return result;
    }

}
