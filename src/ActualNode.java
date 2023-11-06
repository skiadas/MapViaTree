import java.util.function.BiConsumer;

public class ActualNode<K extends Comparable<K>, V> implements MyNode<K, V> {
    final K key;
    V value;
    MyNode<K, V> left = new EmptyNode<>();
    MyNode<K, V> right = new EmptyNode<>();

    public ActualNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public MyNode<K, V> put(K key, V value) {
        int i = key.compareTo(this.key);
        if (i < 0) {
            this.left = this.left.put(key, value);
        } else if (i > 0) {
            this.right = this.right.put(key, value);
        } else {
            this.value = value;
        }
        return this;
    }

    public boolean contains(K key) {
        if (this.key.equals(key)) return true;
        if (key.compareTo(this.key) < 0) {
            return this.left.contains(key);
        } else {
            return this.right.contains(key);
        }
    }

    public V getFromNode(K key) {
        if (this.key.equals(key)) return this.value;
        if (key.compareTo(this.key) < 0) {
            return this.left.getFromNode(key);
        } else {
            return this.right.getFromNode(key);
        }
    }

    public int size() {
        return this.left.size() + this.right.size() + 1;
    }

    // Tree traversals:
    // in-order    left - node - right
    // pre-order   node - left - right
    // post-order  left - right - node

    public void forEach(BiConsumer<K, V> f) {
        this.left.forEach(f);
        f.accept(key, value);
        this.right.forEach(f);
    }
}
