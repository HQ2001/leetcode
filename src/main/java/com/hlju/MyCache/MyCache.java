package com.hlju.MyCache;

import java.util.HashMap;
import java.util.Map;

public class MyCache <K, V> {

    private int capacity;
    private int size;
    private CacheNode head;
    private CacheNode tail;
    private Map<K, CacheNode<K, V>> cache;

    class CacheNode<K, V> {
        K key;
        V value;
        CacheNode prev;
        CacheNode next;
        CacheNode () {}
        CacheNode (K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    public MyCache (int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        this.size = 0;
        this.head = new CacheNode();
        this.tail = new CacheNode();
        head.next = tail;
        tail.prev = head;
    }

    public void put (K key, V value) {
        CacheNode<K, V> node = cache.get(key);
        if (node == null) {
            // 缓存中没有
            node = new CacheNode(key, value);
            if (size >= capacity) {
                removeHead();
            }
            addTail(node);
        } else {
            // 缓存中存在
            node.value = value;
            remove(node);
            addTail(node);
        }
    }

    public V get (K key) {
        CacheNode<K, V> node = cache.get(key);
        if (node == null) {
            return null;
        } else {
            remove(node);
            addTail(node);
            return node.value;
        }
    }

    public void removeLast () {
        cache.remove(tail.prev.key);
        tail.prev = tail.prev.prev;
        tail.prev.next = tail;
        -- size;
    }

    public void removeFirst () {
        removeHead();
    }

    private void remove(CacheNode<K, V> node) {
        cache.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        -- size;
    }

    private void addTail(CacheNode<K, V> node) {
        cache.put(node.key, node);
        tail.prev.next = node;
        node.prev = tail.prev;
        tail.prev = node;
        node.next = tail;
        ++ size;
    }

    private void removeHead() {
        cache.remove(head.next.key);
        head.next = head.next.next;
        head.next.prev = head;
        -- size;
    }

    public static void main(String[] args) {
        MyCache<Integer, Integer> myCache = new MyCache<>(3);
        myCache.put(1, 2);
        myCache.put(2, 4);
        myCache.put(3, 50);
        //myCache.removeFirst();
        myCache.removeLast();
        myCache.put(4, 20);

        System.out.println(myCache.get(1));
        System.out.println(myCache.get(2));
        System.out.println(myCache.get(3));
    }

}
