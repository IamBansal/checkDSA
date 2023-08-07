package leetcode_problems.sheet_arsh.stacks_queues;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    /*
    146. LRU Cache
    Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
    Implement the LRUCache class:
    - LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
    - int get(int key) Return the value of the key if the key exists, otherwise return -1.
    - void put(int key, int value) Update the value of the key if the key exists.
      Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity
      from this operation, evict the least recently used key.

    The functions get and put must each run in O(1) average time complexity.
     */

    DoubleNode head, tail;
    Map<Integer, DoubleNode> map;
    int cap;

    LRUCache(int capacity){
        cap = capacity;
        head = new DoubleNode(0, 0);
        tail = new DoubleNode(0, 0);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }

    public int get(int key){
        if (map.containsKey(key)) {
            DoubleNode node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        } else return -1;
    }

    public void put(int key, int value){
        if (map.containsKey(key)) remove(map.get(key));
        if (map.size() == cap) {
            remove(tail.prev);
        }
        insert(new DoubleNode(key, value));
    }

    private void remove(DoubleNode node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(DoubleNode node) {
        map.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    class DoubleNode{
        DoubleNode prev, next;
        int key, value;
        DoubleNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
}
