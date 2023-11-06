import java.util.function.BiConsumer;

public class EmptyNode<K extends Comparable<K>, V> implements MyNode<K, V> {
    public MyNode<K, V> put(K key, V value) {
        return new ActualNode<>(key, value);
    }

    public boolean contains(K key) {
        return false;
    }

    public V getFromNode(K key) {
        return null;
    }

    public int size() {
        return 0;
    }

    public void forEach(BiConsumer<K, V> f) {

    }
}
