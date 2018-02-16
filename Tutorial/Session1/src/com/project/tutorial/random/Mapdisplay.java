package com.project.tutorial.random;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Mapdisplay {
    public Mapdisplay() {
        super();
    }

    public static void main(String[] args) {
        Map<Integer, String> m = new HashMap<Integer, String>();
        m.put(1, "Shlok");
        m.put(2, "Andy");
        m.put(3, "Terry");
        m.put(4, "Fenny");

        Set<Map.Entry<Integer, String>> s = m.entrySet();

        Iterator<Map.Entry<Integer, String>> i = s.iterator();

        while (i.hasNext()) {
            Map.Entry<Integer, String> me = i.next();
            System.out.println("Key= " + me.getKey());
            System.out.println("Value = " + me.getValue());

        }
    }
}
