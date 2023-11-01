public class MyNode<K, V> {
    final K key;
    V value;
    MyNode<K, V> left = null;
    MyNode<K, V> right = null;

    public MyNode(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
