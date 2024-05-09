package org.example;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapSple {

    public static void main(String[] args) {
        class Book11 {
            int id;
            String name, author, publisher;

            public Book11(int id, String name, String author, String publisher) {
                this.id = id;
                this.name = name;
                this.author = author;
                this.publisher = publisher;
            }
        }

        class LinkedHashMapDemo {
            public static void main(String[] args) {
                LinkedHashMap<Integer, String> hm = new LinkedHashMap<>();
                hm.put(100, "Amit");
                hm.put(102, "Vijay");
                hm.put(103, "Rahuk");
                Map<Integer, Book11> map = new LinkedHashMap<Integer, Book11>();

                Book11 b1 = new Book11(1, "j", "s", "sds");
                Book11 b2 = new Book11(1, "j", "a", "sds");
                Book11 b3 = new Book11(1, "j", "d", "sds");
                map.put(1, b1);
                map.put(3, b2);
                map.put(2, b3);
                for (Map.Entry<Integer, Book11> entry : map.entrySet()) {
                    int key = entry.getKey();
                    Book11 b = entry.getValue();
                    System.out.println(key + b.author);
                }

                for (Map.Entry m : hm.entrySet()) {
                    System.out.println(m.getKey() + " " + m.getValue());

                }
            }
        }
    }
}