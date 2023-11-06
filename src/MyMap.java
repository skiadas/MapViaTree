public class MyMap<K extends Comparable<K>, V> {
    MyNode<K, V> root = new EmptyNode<>();
    int size() {
        return root.size();
    }

    void put(K key, V value) {
        root = root.put(key, value);
    }

    boolean contains(K key) {
        return root.contains(key);
    }

    V get(K key) {
        return root.getFromNode(key);
    }
}
