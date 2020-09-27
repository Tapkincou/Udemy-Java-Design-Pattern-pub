package SINGLETON;

import java.io.IOException;

public class StaticBlockSingleton {

    private static StaticBlockSingleton instance;

    static { // static block in order to try/catch our singleton instanciating
        try {
            instance = new StaticBlockSingleton();
        } catch (Exception e) {
            System.out.println("failed to create singleton");
        }
    }

    // private constructor (no instanciating is possible outside the class)
    private StaticBlockSingleton() throws IOException { // Our singleton throws an exception
    }

    public static StaticBlockSingleton getInstance() {
        return instance;
    }
}

class Demo2 {

    public static void main(String[] args) {

        StaticBlockSingleton.getInstance();


    }

}
