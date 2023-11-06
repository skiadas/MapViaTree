import java.util.function.BiConsumer;

public interface MyNode<K extends Comparable<K>, V> {
    MyNode<K, V> put(K key, V value);
    boolean contains(K key);
    V getFromNode(K key);
    int size();
    void forEach(BiConsumer<K, V> f);
}
