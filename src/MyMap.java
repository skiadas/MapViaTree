import java.util.Optional;
import java.util.function.BiConsumer;

public class MyMap<K extends Comparable<K>, V> {
    MyNode<K, V> root =  EmptyNode.empty;
    int size() {
        return root.size();
    }

    void put(K key, V value) {
        root = root.put(key, value);
    }

    boolean contains(K key) {
        return root.contains(key);
    }

    Optional<V> get(K key) {
        return root.get(key);
    }

    void forEach(BiConsumer<K, V> f) {
        root.forEach(f);
    }
}
