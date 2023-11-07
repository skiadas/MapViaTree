import java.util.Optional;
import java.util.function.BiConsumer;

public interface MyNode<K extends Comparable<K>, V> {
    MyNode<K, V> put(K key, V value);
    boolean contains(K key);
    Optional<V> get(K key);
    int size();
    void forEach(BiConsumer<? super K, ? super V> f);
}
