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
        MyNode<K, V> newNode = new MyNode<>(key, value);
        if (root == null) root = newNode;
        else {
            int i = key.compareTo(root.key);
            if (i < 0) {
                root.left = newNode;
            } else if (i > 0) {
                root.right = newNode;
            } else {
                root.value = value;
            }
        }
    }

    boolean contains(K key) {
        if (root == null) return false;
        if (root.key.equals(key)) return true;
        if (key.compareTo(root.key) < 0) {
            if (root.left.key.equals(key)) return true;
            return false;
        } else {
            if (root.right.key.equals(key)) return true;
            return false;
        }
    }

    V get(K key) {
        if (root == null) return null;
        if (root.key.equals(key)) return root.value;
        if (key.compareTo(root.key) < 0) {
            if (root.left.key.equals(key)) return root.left.value;
        } else {
            if (root.right.key.equals(key)) return root.right.value;
        }
        return null;
    }
}
