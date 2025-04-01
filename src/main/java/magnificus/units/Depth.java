package magnificus.units;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Depth {

    private final Optional<Integer> topDepth;
    private int currentDepth;

    public Depth() {
        this(Optional.empty(),0);
    }
    
    public Depth(int topDepth) {
        this(Optional.of(topDepth), 0);
    }

    private Depth(Optional<Integer> topDepth, int currentDepth) {
        this.topDepth = topDepth;
        this.currentDepth = currentDepth;
    }

    public Depth next() {
        assert !this.isBackground();

        return new Depth(this.topDepth, this.currentDepth + 1);
    }

    public boolean isBackground() {
        return this.topDepth.isPresent() && this.currentDepth == this.topDepth.get();
    }
    
    @Override
    public String toString() {
        return "\n" + IntStream.range(0, this.currentDepth * 2)
                .mapToObj(i -> " ")
                .collect(Collectors.joining());
    }

}
