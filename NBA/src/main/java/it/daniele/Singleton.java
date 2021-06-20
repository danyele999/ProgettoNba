package it.daniele;

public class Singleton {

    private static Singleton s1; // step 1

    private Singleton() { // step 2
    }

    public static synchronized Singleton getInstance() { // step 3
        if (s1 == null) {
            s1 = new Singleton();
        }
        return s1;
    }

}
