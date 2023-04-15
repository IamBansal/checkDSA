package leetcode_linked_list;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Leetcode146 {

    /*
    146. LRU Cache

    Design a data structure that follows the constraints of the Least Recently Used (LRU) cache.
    Implement the LRUCache class:
    - LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
    - int get(int key) Return the value of the key if the key exists, otherwise return -1.
    - void put(int key, int value) Update the value of the key if the key exists.
      Otherwise, add the key-value pair to the cache.
      If the number of keys exceeds the capacity from this operation, evict the least recently used key.

    The functions get and put must each run in O(1) average time complexity.
     */

    class LRUCache {
        Node head = new Node(0, 0), tail = new Node(0, 0);
        Map < Integer, Node > map = new HashMap();
        int capacity;

        public LRUCache(int _capacity) {
            capacity = _capacity;
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                remove(node);
                insert(node);
                return node.value;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                remove(map.get(key));
            }
            if (map.size() == capacity) {
                remove(tail.prev);
            }
            insert(new Node(key, value));
        }

        private void remove(Node node) {
            map.remove(node.key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void insert(Node node) {
            map.put(node.key, node);
            node.next = head.next;
            node.next.prev = node;
            head.next = node;
            node.prev = head;
        }

        class Node {
            Node prev, next;
            int key, value;
            Node(int _key, int _value) {
                key = _key;
                value = _value;
            }
        }
    }

    //This solution use LinkedHashmap - kind of inbuilt solution
    static class LRUCacheBetter{
        private final LinkedHashMap<Integer, Integer> map;
        private final int CAPACITY;

        public LRUCacheBetter(int capacity) {
            CAPACITY = capacity;
            map = new LinkedHashMap<>(capacity, 0.75f, true) {
                protected boolean removeEldestEntry(Map.Entry eldest) {
                    return size() > CAPACITY;
                }
            };
        }

        public int get(int key) {
            return map.getOrDefault(key, -1);
        }
        public void put(int key, int value) {
            map.put(key, value);
        }
    }

}
