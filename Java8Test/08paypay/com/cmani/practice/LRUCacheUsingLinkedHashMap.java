package com.cmani.practice;

import java.util.*;
import java.util.stream.Collectors;

//Least Recently used cache
//Hash and ArrayList
public class LRUCacheUsingLinkedHashMap {
// 1-> 2-> 3-> 4->1
//    1
    private Map<Integer,Integer> cache;
    private static final int CAPACITY = 5;
    LRUCacheUsingLinkedHashMap(){
        cache = new LinkedHashMap<>(CAPACITY);
    }

    public void putToCache(int key, int value){
        if (cache.size() >= CAPACITY) {
            cache.remove(cache.entrySet().iterator().next().getKey());
        }
        cache.put(key,value);
    }

    public int getFromCache(int key){
        if (!cache.containsKey(key))
            return key;
        Integer value = cache.remove(key);
        cache.put(key,value);
        return value;
    }

    public void display(){
        List<Integer> keys = new ArrayList(cache.keySet());
        Collections.reverse(keys);
        Iterator it = keys.iterator();
        while (it.hasNext()){
            System.out.println(cache.get(it.next()));
        }
       /* cache.forEach((key,value)->{
            System.out.println(value +" ");
        });*/
    }

    public static void main(String[] args) {
        LRUCacheUsingLinkedHashMap lru = new LRUCacheUsingLinkedHashMap();
        lru.putToCache(1,1);
        lru.putToCache(2,2);
        lru.putToCache(3,3);
        lru.putToCache(4,4);
        lru.putToCache(5,5);
        lru.putToCache(6,6);
        //lru.putToCache(1,1);
        System.out.println("------FIRST DISPLAY-------");
        lru.display();
        lru.getFromCache(2);
        System.out.println("------SECOND DISPLAY-------");
        lru.display();
        lru.putToCache(1,1);
        System.out.println("------THIRD DISPLAY-------");
        lru.display();


    }

}
