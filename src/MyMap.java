public class MyMap<K extends Comparable<K>, V> {
    MyNode<K, V> root = null;
    int size() {
        if (root == null) return 0;
        return root.size();
    }

    void put(K key, V value) {
        if (root == null) root = new MyNode<>(key, value);
        else root = root.put(key, value);
    }

    boolean contains(K key) {
        if (root == null) return false;
        return root.contains(key);
    }

    V get(K key) {
        if (root == null) return null;
        return root.getFromNode(key);
    }
}
