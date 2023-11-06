public class MyNode<K extends Comparable<K>, V> {
    final K key;
    V value;
    MyNode<K, V> left = null;
    MyNode<K, V> right = null;

    public MyNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    MyNode<K, V> put(K key, V value) {
        int i = key.compareTo(this.key);
        if (i < 0) {
            if (this.left == null) this.left = new MyNode<>(key, value);
            else this.left = this.left.put(key, value);
        } else if (i > 0) {
            if (this.right == null) this.right = new MyNode<>(key, value);
            else this.right = this.right.put(key, value);
        } else {
            this.value = value;
        }
        return this;
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

    V getFromNode(K key) {
        if (this.key.equals(key)) return this.value;
        if (key.compareTo(this.key) < 0) {
            if (this.left == null) return null;
            return this.left.getFromNode(key);
        } else {
            if (this.right == null) return null;
            return this.right.getFromNode(key);
        }
    }

    int size() {
        int count = 1;
        if (this.left != null) count += this.left.size();
        if (this.right != null) count += this.right.size();
        return count;
    }
}
