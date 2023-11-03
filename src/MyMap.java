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
        root = putUnderNode(key, value, root);
    }

    private MyNode<K, V> putUnderNode(K key, V value, MyNode<K, V> curr) {
        if (curr == null) return new MyNode<>(key, value);
        int i = key.compareTo(curr.key);
        if (i < 0) {
            curr.left = putUnderNode(key, value, curr.left);
        } else if (i > 0) {
            curr.right = putUnderNode(key, value, curr.right);
        } else {
            curr.value = value;
        }
        return curr;
    }

    boolean contains(K key) {
        if (root == null) return false;
        return root.contains(key);
    }

    V get(K key) {
        return getFromNode(root, key);
    }

    private V getFromNode(MyNode<K, V> curr, K key) {
        if (curr == null) return null;
        if (curr.key.equals(key)) return curr.value;
        if (key.compareTo(curr.key) < 0) {
            return getFromNode(curr.left, key);
        } else {
            return getFromNode(curr.right, key);
        }
    }
}
