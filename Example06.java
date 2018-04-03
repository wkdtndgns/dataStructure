package lec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

public class Example06 {
    
    static void printCollection(Collection<String> c) {
        String[] a = c.toArray(new String[0]);
        System.out.println(Arrays.toString(a));
    }
    
    public static void main(String[] args) {
        Collection<String> c1 = new LinkedList<String>();
        Collection<String> c2 = new ArrayList<String>();
        Collection<String> c3 = new ArrayList<String>();
        
        c1.add("one");
        c1.add("two");
        
        c2.addAll(c1);
        c2.add("three");
        c2.add("four");
        
        printCollection(c1);
        printCollection(c2);
        
        c3.addAll(c2);
        
        for (String s : c2) {     
            if (c1.contains(s) == false)
                c2.remove(s);
           
        }
        
        
        printCollection(c2);
    }
}

