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
            MyNode<K, V> curr = root;
            int i = key.compareTo(curr.key);
            if (i < 0) {
                if (curr.left == null)  {
                    curr.left = newNode;
                } else {
                    int j = key.compareTo(curr.left.key);
                    if (j < 0) {
                        curr.left.left = newNode;
                    } else if (j > 0) {
                        curr.left.right = newNode;
                    } else {
                        curr.value = value;
                    }
                }
            } else if (i > 0) {
                curr.right = newNode;
            } else {
                curr.value = value;
            }
        }
    }

    boolean contains(K key) {
        MyNode<K, V> curr = root;
        return containsFromNode(curr, key);
    }

    private boolean containsFromNode(MyNode<K, V> curr, K key) {
        if (curr == null) return false;
        if (curr.key.equals(key)) return true;
        if (key.compareTo(curr.key) < 0) {
            return containsFromNode(curr.left, key);
        } else {
            return containsFromNode(curr.right, key);
        }
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
