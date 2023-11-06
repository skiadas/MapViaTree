public class MyMap<K extends Comparable<K>, V> {
    MyNode<K, V> root = null;
    int size() {
        int count = 0;
        if (root == null) return 0;
        if (root.left != null) count += 1;
        if (root.right != null) count += 1;
        return count + 1;
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
