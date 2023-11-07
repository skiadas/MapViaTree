import java.util.Optional;
import java.util.function.BiConsumer;

public class EmptyNode<K extends Comparable<K>, V> implements MyNode<K, V> {
    private final static EmptyNode<?, ?> instance = new EmptyNode<>();
    @SuppressWarnings("unchecked")
    static <K extends Comparable<K>, V> MyNode<K, V> getInstance() {
        return (MyNode<K, V>) instance;
    }
    // singleton pattern
    private EmptyNode() {
        System.out.println("Making empty");
    }

    public MyNode<K, V> put(K key, V value) {
        return new ActualNode<>(key, value);
    }

    public boolean contains(K key) {
        return false;
    }

    public Optional<V> get(K key) {
        return Optional.empty();
    }

    public int size() {
        return 0;
    }

    public void forEach(BiConsumer<? super K, ? super V> f) {

    }
}
