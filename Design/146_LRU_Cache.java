import java.util.HashMap;
import java.util.Map;

class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;

    private Map<Integer, Node> map;

    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;

        map = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        remove(node);
        insert(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {

            Node node = map.get(key);

            remove(node);

            node.value = value;

            insert(node);

        } else {

            Node node = new Node(key, value);

            map.put(key, node);

            insert(node);

            if (map.size() > capacity) {

                Node lru = head.next;

                remove(lru);

                map.remove(lru.key);
            }
        }
    }

    private void remove(Node node) {

        Node previous = node.prev;
        Node next = node.next;

        previous.next = next;
        next.prev = previous;
    }

    private void insert(Node node) {

        Node previous = tail.prev;

        previous.next = node;
        node.prev = previous;

        node.next = tail;
        tail.prev = node;
    }
}