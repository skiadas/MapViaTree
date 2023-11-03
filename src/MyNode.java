public class MyNode<K extends Comparable<K>, V> {
    final K key;
    V value;
    MyNode<K, V> left = null;
    MyNode<K, V> right = null;

    public MyNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    boolean contains(K key) {
        if (this.key.equals(key)) return true;
        if (key.compareTo(this.key) < 0) {
            if (this.left == null) return false;
            return this.left.contains(key);
        } else {
            if (this.right == null) return false;
            return this.right.contains(key);
        }
    }
}
